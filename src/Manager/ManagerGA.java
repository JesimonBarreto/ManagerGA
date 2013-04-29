package Manager;

import Action.ActionReal;
import Action.VirtualAction;
import Action.Action;
import Arduino.PortControl;
import Panel.MyscreenPanel;
import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;
import java.util.ArrayList;
import java.util.Vector;
import org.OpenNI.Point3D;

/**
 *
 * @author JB
 */
public class ManagerGA {

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

    public void addGestures(Gesture reconhecedor) {
        this.Gestures.add(reconhecedor);
        String nomeClasse = reconhecedor.getNameClass();
        Vector acoes = new Vector();
        hs.put(nomeClasse, acoes);
    }

    public void IniciaConexArduino() {
        cp.initSerial();
    }

    public void addAcao(String nomeClasse, Action acao) {
        ((Vector) hs.get(nomeClasse)).add(acao);
    }

    public String DetectandoGesto(Point3D ponto1, Point3D ponto2, Point3D ponto3, Point3D ponto4, Point3D ponto5, Point3D ponto6) {
        if (!reading) {
            for (int i = 0; i < Gestures.size(); i++) {
                Gestures.get(i).startPoints(ponto1, ponto2, ponto3, ponto4, ponto5, ponto6);
            }
            reading = true;
            objectExecute = null;
            decision = false;
        } else {
            Gesture reconhecedor = null;
            int i = 0;
            Stringshoot = Stringshoot2;
            while (i < Gestures.size() && reconhecedor == null) {
                reconhecedor = Gestures.get(i);
                if (!reconhecedor.happened(ponto1, ponto2, ponto3, ponto4, ponto5, ponto6)) {
                    reconhecedor = null;
                } else {
                    objectExecute = reconhecedor.getNameClass();
                }
                i++;
            }
            reading = false;
            decision = true;
            Stringshoot2 = objectExecute;
        }
        return objectExecute;
    }

    public void ConcluindoAcao(Point3D ponto1, Point3D ponto2, Point3D ponto3, Point3D ponto4, Point3D ponto5, Point3D ponto6) {
        String chave = this.DetectandoGesto(ponto1, ponto2, ponto3, ponto4, ponto5, ponto6);
        if (chave != null && (Stringshoot2 == null ? Stringshoot != null : !Stringshoot2.equals(Stringshoot))) {
            Vector aAcao = ((Vector) hs.get(chave));
            for (int i = 0; i < aAcao.size(); i++) {
                Action a = (Action) aAcao.get(i);
                if (a.getIdentification() == 'r') {
                    ActionReal ar = (ActionReal) a;
                    if (ar.isRuning() && ar.isActionDouble()) {
                        ar.stopAction(cp, msp);
                        ((ActionReal) aAcao.get(i)).setRuning(false);
                    } else if (!ar.isRuning() && ar.isActionDouble()) {
                        ar.runArduino(cp, msp);
                        ((ActionReal) aAcao.get(i)).setRuning(true);
                    } else if (!ar.isRuning() && !ar.isActionDouble()) {
                        ar.runArduino(cp, msp);
                    } else if (ar.isRuning() && !ar.isActionDouble()) {
                        ar.runArduino(cp, msp);
                    }
                } else if (a.getIdentification() == 'v') {
                    VirtualAction av = (VirtualAction) a;
                    av.run(msp);
                } else {
                    System.out.println("Identificador não está correto");
                }
            }
        } else if ((Stringshoot2 == null ? Stringshoot != null : !Stringshoot2.equals(Stringshoot)) && decision) {
            Stringshoot2 = null;
        }
    }
}
