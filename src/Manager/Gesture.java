package Manager;

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
        point[0] = ponto1;
        point[1] = ponto2;
        point[2] = ponto3;
        point[3] = ponto4;
        point[4] = ponto5;
        point[5] = ponto6;

    }

    public abstract boolean Aconteceu(Point3D ponto1, Point3D ponto2, Point3D ponto3, Point3D ponto4, Point3D ponto5, Point3D ponto6);
}
