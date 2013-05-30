/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager.Gestures.GesturesStandards;

import Manager.Gesture.Ges.Gesture;
import org.OpenNI.Point3D;

/**
 *
 * @author 20111lired0190
 */
public class HandsUp extends Gesture {

    public HandsUp() {
        this.setNameClass("HandsUp");
    }

    @Override
    public boolean happened(Point3D point1, Point3D point2, Point3D point3, Point3D point4, Point3D point5, Point3D point6) {
        boolean happened = false;
        if (point1.getY() < point2.getY()) {
            if (point4.getY() < point2.getY()) {
                happened = true;
            }

        }
        return happened;
    }
}
