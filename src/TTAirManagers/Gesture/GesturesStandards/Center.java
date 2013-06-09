package TTAirManagers.Gesture.GesturesStandards;

import TTAirManagers.Gesture.Ges.Gesture;
import org.OpenNI.Point3D;

/**
 *
 * @author JB
 */
public class Center extends Gesture {

    public Center() {
        this.setNameClass("Center");
    }

    @Override
    public boolean happened(Point3D ponto1, Point3D ponto2, Point3D ponto3, Point3D ponto4, Point3D ponto5, Point3D ponto6) {
        boolean happened = false;
        if (ponto2.getZ()-ponto1.getZ()>550) {
                happened = true;            
        }
        return happened;
    }
}
