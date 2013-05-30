package Manager.Gesture.Action;

import Manager.Gesture.Man.ManagerGA;
import Manager.Gesture.Panel.MyscreenPanel;
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
