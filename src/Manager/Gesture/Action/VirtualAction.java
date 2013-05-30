package Manager.Gesture.Action;

import Manager.Gestures.Man.ManagerGA;
import Manager.Gestures.Panel.MyscreenPanel;
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
