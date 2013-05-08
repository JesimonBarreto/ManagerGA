package Manager.Action;

import Manager.Man.ManagerGA;
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
