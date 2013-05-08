package Manager.ManagerG;

import Manager.Action.ActionReal;
import Manager.Action.VirtualAction;
import Manager.Action.Action;
import Manager.Arduino.PortControl;
import Manager.Panel.MyscreenPanel;
import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;
import java.util.ArrayList;
import java.util.Vector;
import org.OpenNI.Point3D;

/**
 *
 * @author JB
 */
public class ManagerGA {
//adicionar método removergesture

    public ManagerGA(MyscreenPanel msp) {
        this.msp = msp;
    }
    private PortControl cp = new PortControl();
    private MyscreenPanel msp = null;
    private Hashtable hs = new Hashtable();
    private String objectExecute = null;
    private String Stringshoot = null;
    private String Stringshoot2 = null;
    private boolean decision = false;
    private boolean reading = false;
    private ArrayList<Gesture> Gestures = new ArrayList();

    public void addGestures(Gesture recognizer) {
        this.Gestures.add(recognizer);
        String nameClass = recognizer.getNameClass();
        Vector actions = new Vector();
        hs.put(nameClass, actions);
    }

    public void StartConectionArduino() {
        cp.initSerial();
    }

    public void addAction(String nameClass, Action action) {
        ((Vector) hs.get(nameClass)).add(action);
    }

    public void removerGesture(String nomeClass) {
        hs.remove(nomeClass);
    }

    private String DetectingGesture(Point3D ponto1, Point3D ponto2, Point3D ponto3, Point3D ponto4, Point3D ponto5, Point3D ponto6) {
        if (!reading) {
            for (int i = 0; i < Gestures.size(); i++) {
                Gestures.get(i).startPoints(ponto1, ponto2, ponto3, ponto4, ponto5, ponto6);
            }
            reading = true;
            objectExecute = null;
            decision = false;
        } else {
            Gesture recognizer = null;
            int i = 0;
            Stringshoot = Stringshoot2;
            while (i < Gestures.size() && recognizer == null) {
                recognizer = Gestures.get(i);
                if (!recognizer.happened(ponto1, ponto2, ponto3, ponto4, ponto5, ponto6)) {
                    recognizer = null;
                } else {
                    objectExecute = recognizer.getNameClass();
                }
                i++;
            }
            reading = false;
            decision = true;
            Stringshoot2 = objectExecute;
        }
        return objectExecute;
    }

    public void Finalize(Point3D ponto1, Point3D ponto2, Point3D ponto3, Point3D ponto4, Point3D ponto5, Point3D ponto6) {
        String chave = this.DetectingGesture(ponto1, ponto2, ponto3, ponto4, ponto5, ponto6);
        if (chave != null && (Stringshoot2 == null ? Stringshoot != null : !Stringshoot2.equals(Stringshoot))) {
            Vector vAction = ((Vector) hs.get(chave));
            for (int i = 0; i < vAction.size(); i++) {
                Action a = (Action) vAction.get(i);
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
                    av.run(msp, this);
                } else {
                    System.out.println("Problems in time to object identification");
                }
            }
        } else if ((Stringshoot2 == null ? Stringshoot != null : !Stringshoot2.equals(Stringshoot)) && decision) {
            Stringshoot2 = null;
        }
    }
}
