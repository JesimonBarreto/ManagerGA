/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Gestures.Using.ExampleUse;

import Manager.Action.VirtualAction;
import Manager.Gesture.Man.ManagerGA;
import Manager.Panel.MyscreenPanel;

/**
 *
 * @author 20111lired0190
 */
public class AHandsUp extends VirtualAction{

    @Override
    public void run(MyscreenPanel sp, ManagerGA gerente) {
        gerente.removerGesture("Down");
        gerente.removerGesture("Up");
        gerente.removerGesture("Right");
        gerente.removerGesture("Left");
        gerente.removerGesture("Center");
    }

}
