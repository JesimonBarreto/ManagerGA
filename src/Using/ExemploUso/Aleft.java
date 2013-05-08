/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Using.ExemploUso;

import Manager.Action.VirtualAction;
import Manager.ManagerG.ManagerGA;
import Manager.Panel.MyscreenPanel;

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
