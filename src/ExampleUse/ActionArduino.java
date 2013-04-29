package ExampleUse;

import Action.ActionReal;
import Arduino.PortControl;
import Panel.MyscreenPanel;

/**
 *
 * @author JB
 */
//Class Action for working with actions in the real world, ie, sending the string usb port for the arduino to take some action. For this class 'AcaoEnviarArduino' should extend class 'AcaoReal'.
public class ActionArduino extends ActionReal{
    //The Method 'executeArduino' is the method that records the action using the parameter 'cp' from 'ControlePorta'
    @Override
    public void runArduino(PortControl cp, MyscreenPanel sp) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void stopAction(PortControl cp, MyscreenPanel sp) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
