package Gerente;

import org.OpenNI.Point3D;

/**
 *
 * @author JB
 */
public abstract class Gesture {

    private Point3D[] point = new Point3D[6];
    private boolean runing = false;
    private String nameClass = null;

    public boolean isRuning() {
        return runing;
    }

    public void setRuning(boolean runing) {
        this.runing = runing;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public Point3D getPonto(int i) {
        return point[i];
    }

    public void setPonto(Point3D ponto, int i) {
        this.point[i] = ponto;
    }

    public void startPoints(Point3D ponto1, Point3D ponto2, Point3D ponto3, Point3D ponto4, Point3D ponto5, Point3D ponto6) {
        point[0].setPoint(ponto1.getX(), ponto1.getY(), ponto1.getZ());
        point[1].setPoint(ponto2.getX(), ponto2.getY(), ponto2.getZ());
        point[2].setPoint(ponto3.getX(), ponto3.getY(), ponto3.getZ());
        point[3].setPoint(ponto4.getX(), ponto4.getY(), ponto4.getZ());
        point[4].setPoint(ponto5.getX(), ponto5.getY(), ponto5.getZ());
        point[5].setPoint(ponto6.getX(), ponto6.getY(), ponto6.getZ());

    }

    public abstract boolean Aconteceu(Point3D ponto1, Point3D ponto2, Point3D ponto3, Point3D ponto4, Point3D ponto5, Point3D ponto6);
}
