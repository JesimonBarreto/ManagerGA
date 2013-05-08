/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Using.ExemploUso;

import Manager.Action.VirtualAction;
import Manager.GesturesStandards.Center;
import Manager.GesturesStandards.Down;
import Manager.GesturesStandards.Left;
import Manager.GesturesStandards.Right;
import Manager.GesturesStandards.Up;
import Manager.ManagerG.ManagerGA;
import Manager.Panel.MyscreenPanel;

/**
 *
 * @author 20111lired0190
 */
public class AHandsBackwards extends VirtualAction {

    @Override
    public void run(MyscreenPanel sp, ManagerGA gerente) {
        System.out.println("hands backwards");
        Down d = new Down();
        gerente.addGestures(d);
        Adown ad = new Adown();
        gerente.addAction("Down", ad);
        Up u = new Up();
        gerente.addGestures(u);
        Aup au = new Aup();
        gerente.addAction("Up", au);
        Left l = new Left();
        gerente.addGestures(l);
        Aleft al = new Aleft();
        gerente.addAction("Left", al);
        Right r = new Right();
        gerente.addGestures(r);
        Aright ar = new Aright();
        gerente.addAction("Right", ar);
        Center c = new Center();
        gerente.addGestures(c);
        Acenter ac = new Acenter();
        gerente.addAction("Center", ac);
    }
}
