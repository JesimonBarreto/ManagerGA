/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TTAirManagers.TTAirButton;

import TTAirManagers.Action.ActionReal;
import TTAirManagers.Action.Action;
import TTAirManagers.Action.VirtualAction;
import TTAirManagers.Arduino.PortControl;
import TTAirManagers.Gesture.Man.ManagerGA;
import TTAirManagers.Panel.MyscreenPanel;
import TTAirManagers.Panel.NewShape;
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
        Vector actions = new Vector();
        table.put(button.getIdentification(), actions);
    }

    public void addActionButton(TTAirButton button, Action action) {
        ((Vector) table.get(button.getIdentification())).add(action);
    }

    public void insertImage(String identification, int i) {
        try {
            files.extractZip(identification);
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
                TTAirButton button = (TTAirButton) buttons.get(i);
                if (!button.isInsertedPicture()) {
                    this.insertImage(button.getIdentification(), i);
                    NewShape ns = new NewShape(button.getImage('N'), msp, button.getPoint(0).x, button.getPoint(1).x, button.getPoint(0).y, button.getPoint(1).y, button.getIdentification());
                    msp.addLayerShape(ns);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: Add Image");
        }

    }

    public boolean Click(int handZ, int neckZ) {
        boolean click = false;
        if (neckZ - handZ > 400) {
            click = true;
        }
        return click;
    }

    public void Finalize(Point3D pHand, Point3D pRBody, MyscreenPanel scp) {
        this.addImages();
        boolean click = this.Click((int) pHand.getZ(), (int) pRBody.getZ());
        Point point = new Point((int) pHand.getX(), (int) pHand.getY());
        for (int i = 0; i < buttons.size(); i++) {
            TTAirButton imageT = (TTAirButton) buttons.get(i);
            if (imageT.Contain(point) && click) {
                if (imageT.getType() != 'C') {
                    this.Clicked(i, scp);
                }
            } else if (imageT.Contain(point) && !click) {
                if (imageT.getType() != 'S') {
                    this.Selected(i, scp);
                }
            } else if (!imageT.Contain(point) && !click) {
                if (imageT.getType() != 'N') {
                    this.backNormal(i, scp);
                }
            }

        }
    }

    private void run(Vector vAction, String state) {
        for (int i = 0; i < vAction.size(); i++) {
            Action a = (Action) vAction.get(i);
            if (a.getStateAction().equals(state)) {
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

    private void backNormal(int i, MyscreenPanel scp) {
        try {
            ((TTAirButton) buttons.get(i)).setType('N');
            TTAirButton button = ((TTAirButton) buttons.get(i));
            scp.removeShape(button.getIdentification());
            NewShape ns = new NewShape(button.getImage('N'), scp, (int) button.getPoint(0).getX(), (int) button.getPoint(1).getX(), (int) button.getPoint(0).getY(), (int) button.getPoint(1).getY(), button.getIdentification());
            scp.addLayerShape(ns);
        } catch (Exception e) {
            System.out.println("Error: BackNormal");
        }
    }

    private void Selected(int i, MyscreenPanel scp) {
        try {
            ((TTAirButton) buttons.get(i)).setType('S');
            TTAirButton button = ((TTAirButton) buttons.get(i));
            scp.removeShape(button.getIdentification());
            NewShape ns = new NewShape(button.getImage('S'), scp, (int) button.getPoint(0).getX(), (int) button.getPoint(1).getX(), (int) button.getPoint(0).getY(), (int) button.getPoint(1).getY(), button.getIdentification());
            scp.addLayerShape(ns);
            if (((Vector) table.get(button.getIdentification())).get(0) != null) {
                Vector actionS = (Vector) table.get(button.getIdentification());
                this.run(actionS, "Selected");
            }
        } catch (Exception e) {
            System.out.println("Error: Selected");
        }

    }

    private void Clicked(int i, MyscreenPanel scp) {
        try {
            ((TTAirButton) buttons.get(i)).setType('C');
            TTAirButton button = ((TTAirButton) buttons.get(i));
            scp.removeShape(button.getIdentification());
            NewShape ns = new NewShape(button.getImage('C'), scp, (int) button.getPoint(0).getX(), (int) button.getPoint(1).getX(), (int) button.getPoint(0).getY(), (int) button.getPoint(1).getY(), button.getIdentification());
            scp.addLayerShape(ns);
            if (((Vector) table.get(button.getIdentification())).get(0) != null) {
                Vector actionC = (Vector) table.get(button.getIdentification());
                this.run(actionC, "Clicked");
            }
        } catch (Exception e) {
            System.out.println("Error: Clicked");
        }

    }
}
