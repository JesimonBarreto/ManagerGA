package TTAirManagers.Gesture.GesturesStandards;

import TTAirManagers.Gesture.Ges.Gesture;
import org.OpenNI.Point3D;

/**
 *
 * @author JB
 */
public class Left extends Gesture {

    public Left() {
        this.setNameClass("Left");
    }


    @Override
    public boolean happened(Point3D ponto1, Point3D ponto2, Point3D ponto3, Point3D ponto4, Point3D ponto5, Point3D ponto6) {
        boolean happened = false;
        int deadpoint = (int) (ponto1.getX() - ponto3.getX());
        if ((ponto1.getX() - getPoint(0).getX()) <= -20 && deadpoint < -5) {
            if ((ponto1.getY() - getPoint(0).getY()) < 5 && (ponto1.getY() - getPoint(0).getY()) > -5) {
                happened = true;
            }
        }
        return happened;
    }
}
