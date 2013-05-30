/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager.TTAirButton;

import Manager.Gesture.Panel.NewShape;
import TTAirButton.Using.ExemploUso.ScreenPanel1;
import java.awt.Point;
import java.util.*;
import org.OpenNI.Point3D;

/**
 *
 * @author JB
 */
public class ManagerImage {

    private Vector buttons = new Vector();
    private ConverterToBuffer converterTB = new ConverterToBuffer();
    private MyFile files = new MyFile();
    private String type = null;

    public Vector getImages() {
        return buttons;
    }

    public MyFile getFiles() {
        return files;
    }

    public ManagerImage() {
        if (!files.directoryExists()) {
            files.createDirectory();
        }
    }

    public void addTTAirButton(TTAirButton image) {
        buttons.add(image);
    }

    public void insertImage(String identification, int i) {
        try {
            ((TTAirButton) buttons.get(i)).setImage(converterTB.conversion(identification, files));
            ((TTAirButton) buttons.get(i)).setInsertedPicture(true);
        } catch (Exception erro) {
            System.out.println("error: Insert Image");
        }
    }

    public TTAirButton getImage(String iD) {
        TTAirButton imageReturn = null;
        for (int i = 0; i < buttons.size(); i++) {
            TTAirButton imageT = (TTAirButton) buttons.get(i);
            if (iD.equals(imageT.getIdentification())) {
                imageReturn = imageT;
            }
        }
        return imageReturn;
    }

    public void addImages() {
        try {
            for (int i = 0; i < buttons.size(); i++) {
                TTAirButton image = (TTAirButton) buttons.get(i);
                if (!image.isInsertedPicture() && this.getFiles().imageExist(image.getIdentification())) {
                    this.insertImage(image.getIdentification(), i);
                }
            }
        } catch (Exception e) {
            System.out.println("error: Add Image");
        }

    }

    public boolean Click(int handZ, int neckZ) {
        boolean click = false;
        if (neckZ - handZ > 450) {
            click = true;
        }
        return click;
    }

    private TTAirButton searchImage(Point3D pHand, Point3D pRBody) {
        boolean click = this.Click((int) pHand.getZ(), (int) pRBody.getZ());
        Point point = new Point((int) pHand.getX(), (int) pHand.getY());
        TTAirButton image = null;
        for (int i = 0; i < buttons.size(); i++) {
            TTAirButton imageT = (TTAirButton) buttons.get(i);
            if (imageT.Contain(point) && click) {
                image = imageT;
                type = "C";
            } else if (imageT.Contain(point) && !click) {
                image = imageT;
                type = "S";
            } else if (image == null && i == buttons.size() - 1) {
                image = imageT;
                type = "N";
            }
        }
        return image;
    }

    public void Finalize(Point3D pHand, Point3D pRBody, ScreenPanel1 scp) {
        TTAirButton img = this.searchImage(pHand, pRBody);
        scp.removeShape(img.getIdentification());
        try {
            NewShape ns = new NewShape(img.getImage(type), scp, (int) img.getPoint(0).getX(), (int) img.getPoint(1).getX(), (int) img.getPoint(0).getY(), (int) img.getPoint(1).getY(), img.getIdentification());
            scp.addLayerShape(ns);
        } catch (Exception ex) {
            System.out.println("error: Finalize");
        }
    }
}
