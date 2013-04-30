/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExampleUse;

import Action.VirtualAction;
import Panel.MyscreenPanel;

/**
 *
 * @author JB
 */
// In the class 'AcaoExibirNome' as we want it to be an object of virtual action, so we extended the class 'AcaoVirtual'.
public class ActionShowsName extends VirtualAction {

    //Method 'execute' is the method of action, any action to be done on own computer, even in java, is passed as parameter 'MyscreenPanel'
    //which is of type 'ScreenPanel', in order to facilitate change in some shape panel with a method 'replaceShape'.
    @Override
    public void run(MyscreenPanel sp) {
        //Let's put an example showing 'JB'
        System.out.println("JB");
    }
}
