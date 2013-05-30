/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestures.Using.Gestures.ExampleUse;

import Manager.Gestures.Man.ManagerGA;
import Manager.Gestures.Panel.MyscreenPanel;
import Manager.Gestures.Panel.NewShape;
import java.awt.Graphics;
import java.util.Vector;
import org.OpenNI.Point3D;
import presentation.ALayerShape;
import presentation.impl.KinectMotionCapture.KinectControl.EBone;
import presentation.impl.KinectMotionCapture.KinectControl.KinectAccess;
import presentation.impl.KinectMotionCapture.KinectControl.SkeletonBone;

/**
 *
 * @author JB
 */
//Creating Class 'MyScreenPanel' class which will be responsible for sending the data to the manager
public class MyScreenPanel extends MyscreenPanel {

    public MyScreenPanel() {
        //For the gestures and actions are added before execution
        inserindo();
    }
    Vector shapes = new Vector();
    private int maoX, maoY, maoZ, pescX, pescY, pescZ;
    Point3D mao, pesc;
    //Manager created, and passing as a parameter MyscreenPanel
    ManagerGA gerente = new ManagerGA(this);

    @Override
    public void addLayerShape(ALayerShape shape) {
        this.shapes.add(shape);
    }

    @Override
    public void addMyLayerShape(NewShape myshape) {
        this.shapes.add(myshape);
    }

    @Override
    public void removerShape(int position) {
        this.shapes.remove(position);
    }

    @Override
    public void replaceShape(int posicaoShapeRemover, ALayerShape shape) {
        this.removerShape(posicaoShapeRemover);
        this.addLayerShape(shape);
    }
    //Method responsible for inserting Gestures and Actions in the Manager

    public void inserindo() {

        NewGestureHandUp nghu = new NewGestureHandUp();
        //Method that will guadar the class name to store the actions together
        nghu.setNameClass("NewGestureHandUp");
        //Adding new gesture to the manager
        gerente.addGestures(nghu);
        // Creating object VirtualAction
        ActionShowsName aen = new ActionShowsName();
        //Adding to the manager. Doi will need values ​​for parameters, a string (class name gesture that will be associated with the action), the action object
       /* gerente.addAction("NewGestureHandUp", aen);
        //Creating object ActionReal
        ActionArduino aa = new ActionArduino();
        //To activate double acting
        aa.setActionDouble(true);
        //Adding to the manager
        gerente.addAction("NewGestureHandUp", aa);*/
        AHandsBackwards ah=new AHandsBackwards();
        gerente.addAction("NewGestureHandUp", ah);
    }

//Abstract class' MyscreenPanel'tem substituirShape a method, passing the position that has to be removed and the new shape makes the method as a parameter substitution.
//Paint method, method the panel responsible for drawing all shapes.   
    @Override
    public void paint(Graphics g) {
        if (!shapes.isEmpty()) {
            super.paint(g);
            for (int i = 0; i < shapes.size(); i++) {
                ALayerShape shape = (ALayerShape) shapes.get(i);
                shape.draw(g);
            }

            try {

                //As I only use two joints, the hand and the neck will enter only the two together

                SkeletonBone sb = KinectAccess.getSkeletonsBone();
                maoX = (int) sb.getBone(EBone.RIGHT_FOREARM).getJ2().getX();
                maoY = (int) sb.getBone(EBone.RIGHT_FOREARM).getJ2().getY();
                maoZ = (int) sb.getBone(EBone.RIGHT_FOREARM).getJ2().getZ();
                pescX = (int) sb.getBone(EBone.NECK).getJ2().getX();
                pescY = (int) sb.getBone(EBone.NECK).getJ2().getY();
                pescZ = (int) sb.getBone(EBone.NECK).getJ2().getZ();

                //Turning points in 3D

                mao = new Point3D(maoX, maoY, maoZ);
                pesc = new Point3D(pescX, pescY, pescZ);

                //Calling method responsible for passing values ​​to the manager
                gerente.Finalize(mao, pesc, null, null, null, null);
            } catch (Exception erro) {
            }


        }
        this.repaint();
    }
}
