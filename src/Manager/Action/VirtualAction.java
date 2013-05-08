package Manager.Action;

import Manager.ManagerG.ManagerGA;
import Manager.Panel.MyscreenPanel;
/**
 *
 * @author JB
 */
public abstract class VirtualAction extends Action {

    public abstract void run(MyscreenPanel sp,ManagerGA gerente);

    public VirtualAction() {
        this.setIdentification('v');
    }
}
