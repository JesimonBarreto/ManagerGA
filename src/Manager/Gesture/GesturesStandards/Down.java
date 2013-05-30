package Manager.Gesture.GesturesStandards;

import Manager.Gesture.Ges.Gesture;
import org.OpenNI.Point3D;

/**
 *
 * @author JB
 */
public class Down extends Gesture {

    public Down() {
        this.setNameClass("Down");
    }


    @Override
    public boolean happened(Point3D ponto1, Point3D ponto2, Point3D ponto3, Point3D ponto4, Point3D ponto5, Point3D ponto6) {
        boolean happened = false;
        int deadpoint = (int) (ponto1.getY()-ponto3.getY());
        if ((ponto1.getY() - this.getPoint(0).getY()) >= 20 && deadpoint>5) {
            if ((ponto1.getX() - this.getPoint(0).getX()) < 5 && (ponto1.getX() - this.getPoint(0).getX()) > -5) {
                happened = true;
            }
        }
        return happened;
    }
}
