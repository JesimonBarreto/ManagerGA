/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager.TTAirButton;

import Manager.Action.*;
import Manager.Arduino.PortControl;
import Manager.Gesture.Man.ManagerGA;
import Manager.Panel.MyscreenPanel;
import Manager.Panel.NewShape;
import TTAirButton.Using.ExemploUso.ScreenPanel1;
import java.awt.Point;
import java.util.*;
import org.OpenNI.Point3D;

/**
 *
 * @author JB
 */
public class ManagerImage {

    private PortControl cp = new PortControl();
    private MyscreenPanel msp = null;
    private Vector buttons = new Vector();
    private Hashtable table = new Hashtable();
    private ConverterToBuffer converterTB = new ConverterToBuffer();
    private MyFile files = new MyFile();
    private char type, testType;
    private ManagerGA managerGesture = new ManagerGA(msp);

    public Vector getImages() {
        return buttons;
    }

    public MyFile getFiles() {
        return files;
    }

    public ManagerImage(MyscreenPanel msp) {
        if (!files.directoryExists()) {
            files.createDirectory();
        }
        this.msp = msp;
    }

    public void addTTAirButton(TTAirButton button) {
        buttons.add(button);
        Vector action = new Vector();
        table.put(button.getIdentification(), action);
    }

    public void addActionButton(TTAirButton button, Action action) {
        ((Vector) table.get(button.getIdentification())).add(action);
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
                type = 'C';
            } else if (imageT.Contain(point) && !click) {
                image = imageT;
                type = 'S';
            } else if (image == null && i == buttons.size() - 1) {
                image = imageT;
                type = 'N';
            }
        }
        return image;
    }

    public void run(Vector vAction, String state) {
        for (int i = 0; i < vAction.size(); i++) {
            Action a = (Action) vAction.get(i);
            if (a.getImageAction().equals(state)) {
                if (a.getIdentification() == 'r') {
                    ActionReal ar = (ActionReal) a;
                    if (ar.isRuning() && ar.isActionDouble()) {
                        ar.stopAction(cp, msp);
                        ((ActionReal) vAction.get(i)).setRuning(false);
                    } else if (!ar.isRuning() && ar.isActionDouble()) {
                        ar.runArduino(cp, msp);
                        ((ActionReal) vAction.get(i)).setRuning(true);
                    } else if (!ar.isRuning() && !ar.isActionDouble()) {
                        ar.runArduino(cp, msp);
                    } else if (ar.isRuning() && !ar.isActionDouble()) {
                        ar.runArduino(cp, msp);
                    }
                } else if (a.getIdentification() == 'v') {
                    VirtualAction av = (VirtualAction) a;
                    av.run(msp, managerGesture);
                } else {
                    System.out.println("Problems in time to object identification");
                }
            }
        }
    }

    public void Finalize(Point3D pHand, Point3D pRBody, ScreenPanel1 scp) {
        TTAirButton img = this.searchImage(pHand, pRBody);
        scp.removeShape(img.getIdentification());
        try {
            NewShape ns = new NewShape(img.getImage(type), scp, (int) img.getPoint(0).getX(), (int) img.getPoint(1).getX(), (int) img.getPoint(0).getY(), (int) img.getPoint(1).getY(), img.getIdentification());
            scp.addLayerShape(ns);
            if (type != testType) {
                if (type == 'S') {
                    if (((Vector) table.get(img.getIdentification())).get(0) != null) {
                        Vector actionS = (Vector) table.get(img.getIdentification());
                        this.run(actionS, "Selected");
                    }
                } else if (type == 'C') {
                    if (((Vector) table.get(img.getIdentification())).get(0) != null) {
                        Vector actionC = (Vector) table.get(img.getIdentification());
                        this.run(actionC, "Clicked");
                    }
                } else if (type != 'N') {
                    System.out.println("Error: Run action");
                }
                testType = type;
            }
        } catch (Exception ex) {
            System.out.println("error: Finalize");
        }
    }
}
