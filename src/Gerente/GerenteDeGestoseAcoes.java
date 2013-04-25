package Gerente;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import Action.Action;
import Action.AcaoReal;
import Action.AcaoVirtual;
import Arduino.ControlePorta;
import Painel.MyscreenPanel;
import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;
import java.util.ArrayList;
import java.util.Vector;
import org.OpenNI.Point3D;

/**
 *
 * @author JB
 */
public class GerenteDeGestoseAcoes {

    public GerenteDeGestoseAcoes(MyscreenPanel msp) {
        this.msp = msp;
    }
    private ControlePorta cp = new ControlePorta();
    MyscreenPanel msp = null;
    private Hashtable hs = new Hashtable();
    private String objetoAExecutar = null;
    private String StringTest = null;
    private String StringTest2 = null;
    private boolean cont = false;
    private boolean leitura = false;
    private ArrayList<Gesture> Gestos = new ArrayList();

    public void addGestos(Gesture reconhecedor) {
        this.Gestos.add(reconhecedor);
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
        if (!leitura) {
            for (int i = 0; i < Gestos.size(); i++) {
                Gestos.get(i).startPoints(ponto1, ponto2, ponto3, ponto4, ponto5, ponto6);
            }
            leitura = true;
            objetoAExecutar = null;
            cont = false;
        } else {
            Gesture reconhecedor = null;
            int i = 0;
            StringTest = StringTest2;
            while (i < Gestos.size() && reconhecedor == null) {
                reconhecedor = Gestos.get(i);
                if (!reconhecedor.Aconteceu(ponto1, ponto2, ponto3, ponto4, ponto5, ponto6)) {
                    reconhecedor = null;
                } else {
                    objetoAExecutar = reconhecedor.getNameClass();
                }
                i++;
            }
            leitura = false;
            cont = true;
            StringTest2 = objetoAExecutar;
        }
        return objetoAExecutar;
    }

    public void ConcluindoAcao(Point3D ponto1, Point3D ponto2, Point3D ponto3, Point3D ponto4, Point3D ponto5, Point3D ponto6) {
        String chave = this.DetectandoGesto(ponto1, ponto2, ponto3, ponto4, ponto5, ponto6);
        if (chave != null && (StringTest2 == null ? StringTest != null : !StringTest2.equals(StringTest))) {
            Vector aAcao = ((Vector) hs.get(chave));
            for (int i = 0; i < aAcao.size(); i++) {
                Action a = (Action) aAcao.get(i);
                if (a.getIdentification() == 'r') {
                    AcaoReal ar = (AcaoReal) a;
                    if (ar.isRuning() && ar.isActionDouble()) {
                        ar.stopAction(cp, msp);
                        ((AcaoReal) aAcao.get(i)).setRuning(false);
                    } else if (!ar.isRuning() && ar.isActionDouble()) {
                        ar.runArduino(cp, msp);
                        ((AcaoReal) aAcao.get(i)).setRuning(true);
                    } else if (!ar.isRuning() && !ar.isActionDouble()) {
                        ar.runArduino(cp, msp);
                    } else if (ar.isRuning() && !ar.isActionDouble()) {
                        ar.runArduino(cp, msp);
                    }
                } else if (a.getIdentification() == 'v') {
                    AcaoVirtual av = (AcaoVirtual) a;
                    av.run(msp);
                } else {
                    System.out.println("Identificador não está correto");
                }
            }
        } else if ((StringTest2 == null ? StringTest != null : !StringTest2.equals(StringTest)) && cont) {
            StringTest2 = null;
        }
    }
}
