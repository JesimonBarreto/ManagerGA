/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TTAirManagers.Gesture.GesturesStandards;

import TTAirManagers.Action.VirtualAction;
import TTAirManagers.Gesture.Ges.Gesture;
import TTAirManagers.Panel.MyscreenPanel;
import org.OpenNI.Point3D;


/**
 *
 * @author 20111lired0190
 */
public class HandsBackwards extends Gesture{

    public HandsBackwards() {
        this.setNameClass("HandsBackwards");
    }

    @Override
    public boolean happened(Point3D point1, Point3D point2, Point3D point3, Point3D point4, Point3D point5, Point3D point6) {
      boolean happened=false;
        if(point1.getZ()>point2.getZ()){
            if(point4.getZ()>point2.getZ()){
                happened=true;
            }

        }
        return happened;
    }

    
}
