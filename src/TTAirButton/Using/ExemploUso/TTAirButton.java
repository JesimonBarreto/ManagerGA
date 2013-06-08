/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TTAirButton.Using.ExemploUso;

import javax.swing.JFrame;
import presentation.ALayerShape;
import presentation.impl.KinectMotionCapture.KinectControl.KinectAccess;
import presentation.impl.KinectMotionCapture.layers.LayerRGB;

/**
 *
 * @author JB
 */
public class TTAirButton {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        ScreenPanel1 sp = new ScreenPanel1();
        ALayerShape rgb = null;
        try {
            rgb = new LayerRGB();
        } catch (Exception erro) {
            System.out.println("error: Add RGB");
        }
        sp.addLayerShape(rgb);
        JFrame frame = new JFrame();
        frame.setSize(KinectAccess.getPrefSize());
        frame.add(sp);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
