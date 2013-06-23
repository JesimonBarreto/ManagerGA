/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TTAirButton.Using.ExemploUso;

import TTAirManagers.Action.VirtualAction;
import TTAirManagers.Gesture.Man.ManagerGA;
import TTAirManagers.Panel.MyscreenPanel;

/**
 *
 * @author JB
 */
// In the class 'DisplayName' as we want it to be an object of virtual action, so we extended the class 'VirtualAction'.
public class DisplayName extends VirtualAction {
//Method 'run' is the method of action, any action to be done on own computer, even in java, is passed as parameter 'MyscreenPanel'
    //which is of type 'ScreenPanel', in order to facilitate change in some shape panel with a method 'replaceShape'.

    @Override
    public void run(MyscreenPanel sp, ManagerGA gerente) {
        //Let's put an example showing 'SELECTED'
        System.out.println("SELECTED 1");
    }
}
