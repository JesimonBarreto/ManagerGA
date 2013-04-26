package Action;

import Panel.MyscreenPanel;
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
