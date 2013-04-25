package Action;

import Painel.MyscreenPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JB
 */
public abstract class AcaoVirtual extends Action {

    public abstract void run(MyscreenPanel sp);

    public AcaoVirtual() {
        this.setIdentification('v');
    }
}
