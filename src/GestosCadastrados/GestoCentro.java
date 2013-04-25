package GestosCadastrados;

import Gerente.Gesture;
import org.OpenNI.Point3D;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JB
 */
public class GestoCentro extends Gesture {

    @Override
    public boolean Aconteceu(Point3D ponto1, Point3D ponto2, Point3D ponto3, Point3D ponto4, Point3D ponto5, Point3D ponto6) {
        boolean aconteceu = false;
        if ((ponto1.getY() - getPonto(0).getY()) < 5 && (ponto1.getY() - getPonto(0).getY()) > -5) {
            if ((ponto1.getX() - getPonto(0).getX()) < 5 && (ponto1.getX() - getPonto(0).getX()) > -5) {
                aconteceu = true;
            }
        }
        return aconteceu;
    }
}
