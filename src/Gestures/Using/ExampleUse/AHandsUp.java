/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Gestures.Using.ExampleUse;

import TTAirManagers.Action.VirtualAction;
import TTAirManagers.Gesture.Man.ManagerGA;
import TTAirManagers.Panel.MyscreenPanel;

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
