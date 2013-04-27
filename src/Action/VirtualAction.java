package Action;

import Panel.MyscreenPanel;
/**
 *
 * @author JB
 */
public abstract class VirtualAction extends Action {

    public abstract void run(MyscreenPanel sp);

    public VirtualAction() {
        this.setIdentification('v');
    }
}
