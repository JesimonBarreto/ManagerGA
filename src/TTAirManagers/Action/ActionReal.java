package TTAirManagers.Action;

import TTAirManagers.Arduino.PortControl;
import TTAirManagers.Panel.MyscreenPanel;

/**
 *
 * @author JB
 */
public abstract class ActionReal extends Action {

    private boolean ActionDouble = false;
    private boolean runing = false;

    public ActionReal() {
        this.setIdentification('r');
    }

    public boolean isActionDouble() {
        return ActionDouble;
    }

    public void setActionDouble(boolean ActionDouble) {
        this.ActionDouble = ActionDouble;
    }

    public boolean isRuning() {
        return runing;
    }

    public void setRuning(boolean runing) {
        this.runing = runing;
    }

    public abstract void runArduino(PortControl cp, MyscreenPanel sp);

    public abstract void stopAction(PortControl cp, MyscreenPanel sp);
}
