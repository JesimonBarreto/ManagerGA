package Manager.ManagerG;

import org.OpenNI.Point3D;

/**
 *
 * @author JB
 */
public abstract class Gesture {

    private Point3D[] point = new Point3D[6];
    private boolean runing = false;
    private String nameClass = null;
    private boolean StartingPoints = false;
    
    public boolean isStartingPoints() {
        return StartingPoints;
    }

    public void setStartingPoints(boolean StartingPoints) {
        this.StartingPoints = StartingPoints;
    }

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

    public Point3D getPoint(int i) {
        return point[i];
    }

    public void setPoint(Point3D point, int i) {
        this.point[i] = point;
    }

    public void startPoints(Point3D point1, Point3D point2, Point3D point3, Point3D point4, Point3D point5, Point3D point6) {
        point[0] = point1;
        point[1] = point2;
        point[2] = point3;
        point[3] = point4;
        point[4] = point5;
        point[5] = point6;

    }

    public abstract boolean happened(Point3D point1, Point3D point2, Point3D point3, Point3D point4, Point3D point5, Point3D point6);
}
