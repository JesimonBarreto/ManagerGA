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
 * @author JB
 */
// In the class 'AcaoExibirNome' as we want it to be an object of virtual action, so we extended the class 'VirtualAction'.
public class ActionShowsName extends VirtualAction {

    //Method 'run' is the method of action, any action to be done on own computer, even in java, is passed as parameter 'MyscreenPanel'
    //which is of type 'ScreenPanel', in order to facilitate change in some shape panel with a method 'replaceShape'.
    @Override
    public void run(MyscreenPanel sp, ManagerGA gerente) {
        //Let's put an example showing 'JB'
        System.out.println("JB");
    }
}
