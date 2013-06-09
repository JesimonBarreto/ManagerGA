package TTAirManagers.Action;

/**
 *
 * @author JB
 */
public abstract class Action {

    private char identification;
    private String stateAction;

    public String getStateAction() {
        return stateAction;
    }

    public void setStateAction(String stateAction) {
        this.stateAction = stateAction;
    }

    public char getIdentification() {
        return identification;
    }

    public void setIdentification(char identification) {
        this.identification = identification;
    }
}
