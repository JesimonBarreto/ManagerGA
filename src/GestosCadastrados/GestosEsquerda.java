package GestosCadastrados;


import Manager.Gesture;
import org.OpenNI.Point3D;

/**
 *
 * @author JB
 */
public class GestosEsquerda extends Gesture {

    @Override
    public boolean Aconteceu(Point3D ponto1, Point3D ponto2, Point3D ponto3, Point3D ponto4, Point3D ponto5, Point3D ponto6) {
        boolean aconteceu = false;
        if ((ponto1.getX() - getPonto(0).getX())<=-25) {
            if ((ponto1.getY() - getPonto(0).getY()) < 5 && (ponto1.getY() - getPonto(0).getY()) > -5) {
                aconteceu = true;
            }
        }
        return aconteceu;
    }
}
