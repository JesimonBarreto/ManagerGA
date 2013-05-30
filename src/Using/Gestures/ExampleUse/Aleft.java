/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Using.Gestures.ExampleUse;

import Using.ExemploUso.*;
import Manager.Gesture.Action.VirtualAction;
import Manager.Gestures.Man.ManagerGA;
import Manager.Gestures.Panel.MyscreenPanel;

/**
 *
 * @author 20111lired0190
 */
public class Aleft extends VirtualAction{

    @Override
    public void run(MyscreenPanel sp, ManagerGA gerente) {
      System.out.println("Left");
    }

}
