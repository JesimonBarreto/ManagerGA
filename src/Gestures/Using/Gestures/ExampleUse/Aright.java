/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Gestures.Using.Gestures.ExampleUse;

import Manager.Gesture.Action.VirtualAction;
import Manager.Gestures.Man.ManagerGA;
import Manager.Gestures.Panel.MyscreenPanel;

/**
 *
 * @author 20111lired0190
 */
public class Aright extends VirtualAction{

    @Override
    public void run(MyscreenPanel sp, ManagerGA gerente) {
      System.out.println("Right");
    }

}
