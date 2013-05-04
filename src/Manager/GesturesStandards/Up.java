package Manager.GesturesStandards;

import Manager.ManagerG.Gesture;
import org.OpenNI.Point3D;

/**
 *
 * @author JB
 */
public class Up extends Gesture {

    @Override
    public boolean happened(Point3D ponto1, Point3D ponto2, Point3D ponto3, Point3D ponto4, Point3D ponto5, Point3D ponto6) {
        boolean happened = false;
        if ((ponto1.getY() - getPoint(0).getY()) <= -25) {
            if ((ponto1.getX() - getPoint(0).getX()) < 5 && (ponto1.getX() - getPoint(0).getX()) > -5) {
                happened = true;
            }
        }
        return happened;
    }
}
