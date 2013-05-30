/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestures.Using.Gestures.ExampleUse;

import Manager.Gesture.Action.VirtualAction;
import Manager.Gestures.GesturesStandards.Center;
import Manager.Gestures.GesturesStandards.Down;
import Manager.Gestures.GesturesStandards.Left;
import Manager.Gestures.GesturesStandards.Right;
import Manager.Gestures.GesturesStandards.Up;
import Manager.Gestures.Man.ManagerGA;
import Manager.Gestures.Panel.MyscreenPanel;

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
