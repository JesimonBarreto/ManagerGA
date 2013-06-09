package TTAirManagers.Action;

import TTAirManagers.Gesture.Man.ManagerGA;
import TTAirManagers.Panel.MyscreenPanel;
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
