/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WithUse.ExampleUse;

import Manager.Gesture;
import org.OpenNI.Point3D;

/**
 *
 * @author JB
 */
//To add a new gesture to the manager simply extend the class 'gesture' and use the method 'Aconteu' which is where all the test will be done for his gesture to be recognized
public class NewGestureHandUp extends Gesture {

    //Within the class 'Gesture' has a vector points 'point' six 3D positions is used as starting points automatically read by the library.
    //The six 3D points passed as parameters to the method are possible together with several tests. The method that will insert the values ​​of each point and each joint will be called the point
    @Override
    public boolean happened(Point3D point1, Point3D point2, Point3D point3, Point3D point4, Point3D point5, Point3D point6) {
        //Creating variable to return
        boolean aconteceu = false;
        //Condition for his gesture happen

        if (point1.getY() < point2.getY()) {
            aconteceu = true;
        }

        //returning value
        return aconteceu;
    }
}
