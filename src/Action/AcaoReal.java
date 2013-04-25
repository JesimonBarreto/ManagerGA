package Action;

import Arduino.ControlePorta;
import Painel.MyscreenPanel;

/**
 *
 * @author JB
 */
public abstract class AcaoReal extends Action {

    private boolean ActionDouble = false;
    private boolean runing = false;

    public AcaoReal() {
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

    public abstract void runArduino(ControlePorta cp, MyscreenPanel sp);

    public abstract void stopAction(ControlePorta cp, MyscreenPanel sp);
}
