package GestosCadastrados;

import Manager.Gesture;
import org.OpenNI.Point3D;

/**
 *
 * @author JB
 */
public class GestoMaosJuntas extends Gesture {

    @Override
    public boolean Aconteceu(Point3D ponto1, Point3D ponto2, Point3D ponto3, Point3D ponto4, Point3D ponto5, Point3D ponto6) {
        boolean aconteceu = false;
        int gx = (int) (ponto1.getX() - ponto2.getX());
        int gy = (int) (ponto1.getY() - ponto2.getY());
        if (gx < 25 && gx > -25) {
            if (gy < 25 && gy > -25) {
                aconteceu = true;
            }
        }
        return aconteceu;
    }
}
