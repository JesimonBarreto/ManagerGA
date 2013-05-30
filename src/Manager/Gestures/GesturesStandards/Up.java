package Manager.Gestures.GesturesStandards;

import Manager.Gesture.Ges.Gesture;
import org.OpenNI.Point3D;

/**
 *
 * @author JB
 */
public class Up extends Gesture {

    public Up() {
        this.setNameClass("Up");
    }

    @Override
    public boolean happened(Point3D ponto1, Point3D ponto2, Point3D ponto3, Point3D ponto4, Point3D ponto5, Point3D ponto6) {
        boolean happened = false;
        int deadpoint = (int) (ponto1.getY() - ponto3.getY());
        if ((ponto1.getY() - getPoint(0).getY()) <= -20 && deadpoint < -5) {
            if ((ponto1.getX() - getPoint(0).getX()) < 5 && (ponto1.getX() - getPoint(0).getX()) > -5) {
                happened = true;
            }
        }
        return happened;
    }
}
