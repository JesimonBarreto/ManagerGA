package Using.ExemploUso;

import Manager.Man.ManagerGA;
import javax.swing.JFrame;
import org.OpenNI.Point3D;
import presentation.ALayerShape;
import presentation.impl.KinectMotionCapture.KinectControl.EBone;
import presentation.impl.KinectMotionCapture.KinectControl.KinectAccess;
import presentation.impl.KinectMotionCapture.layers.LayerRGB;
import presentation.impl.KinectMotionCapture.layers.LayerSkeletonBone;

/**
 *
 * @author JB
 */
public class Executando {

    public static void main(String[] args) throws Exception {

        MyscreenPanel sp = new MyscreenPanel();

        ALayerShape rgb = null;
        LayerSkeletonBone sb = null;
        try {
            rgb = new LayerRGB();
            sb = new LayerSkeletonBone();
        } catch (Exception erro) {
            System.out.println("erro");
        }
        sp.addLayerShape(rgb);
        sp.addLayerShape(sb);

        JFrame frame = new JFrame();
        frame.setSize(KinectAccess.getPrefSize());
        frame.add(sp);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
