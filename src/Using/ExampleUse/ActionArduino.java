package Using.ExampleUse;

import Action.ActionReal;
import Arduino.PortControl;
import Panel.MyscreenPanel;

/**
 *
 * @author JB
 */
//Class Action for working with actions in the real world, ie, sending the string usb port for the arduino to take some action. For this class 'AcaoEnviarArduino' should extend class 'AcaoReal'.
public class ActionArduino extends ActionReal {
    //The Method 'executeArduino' is the method that records the action using the parameter 'cp' from 'ControlePorta'.
    // Also as a parameter MyscreenPanel to facilitate changes in the panel.

    @Override
    public void runArduino(PortControl cp, MyscreenPanel sp) {
        // Send the number 1 as char using the class method PortControl
        cp.enviarDados('1');
    }

    //StopAction method is the method that can be used to stop an action previously released, for example, light a lamp is registered a gesture, if this gesture is done twice,
    //this will be called the second method would be to turn off the lamp. Remembered that to enable this option you need to give
    //one setAcaoDupla passing true as a parameter before adding the gesture.
    @Override
    public void stopAction(PortControl cp, MyscreenPanel sp) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
