package Manager.Action;

/**
 *
 * @author JB
 */
public abstract class Action {

    private char identification;
    private String imageAction;

    public String getImageAction() {
        return imageAction;
    }

    public void setImageAction(String imageAction) {
        this.imageAction = imageAction;
    }

    public char getIdentification() {
        return identification;
    }

    public void setIdentification(char identification) {
        this.identification = identification;
    }
}
