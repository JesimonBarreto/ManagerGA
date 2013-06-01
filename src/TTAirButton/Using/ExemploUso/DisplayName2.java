/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TTAirButton.Using.ExemploUso;

import Manager.Action.VirtualAction;
import Manager.Gesture.Man.ManagerGA;
import Manager.Panel.MyscreenPanel;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Geral
 */
public class DisplayName2 extends VirtualAction {

    @Override
    public void run(MyscreenPanel sp, ManagerGA gerente) {
        System.out.println("Cliked");
        Robot r;
        try {
            r = new Robot();
            r.keyPress(KeyEvent.VK_UP);
            r.keyRelease(KeyEvent.VK_UP);
        } catch (AWTException ex) {
            Logger.getLogger(DisplayName.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
