/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TTAirButton.Using.ExemploUso;

import Manager.Action.VirtualAction;
import Manager.Gesture.Man.ManagerGA;
import Manager.Panel.MyscreenPanel;

/**
 *
 * @author JB
 */
public class DisplayName extends VirtualAction {
    
    @Override
    public void run(MyscreenPanel sp, ManagerGA gerente) {
        System.out.println("Selected");    
    }
}
