package TTAirButton.Using.ExemploUso;

import Manager.Panel.NewShape;
import Manager.TTAirButton.ManagerImage;
import Manager.TTAirButton.TTAirButton;
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
public final class ScreenPanel1 extends Manager.Panel.MyscreenPanel {

    private Vector shapes = new Vector();
    private ManagerImage mi = new ManagerImage(this);
    private int handX, handY, handZ, neckX, neckY, neckZ;
    private Point3D hand3d, neck3d;

    public ScreenPanel1() throws Exception {
        super();
        this.SelectingImage();
    }

    @Override
    public void addLayerShape(ALayerShape shape) {
        this.shapes.add(shape);
    }

    @Override
    public void removerShape(int position) {
        this.shapes.remove(position);
    }

    @Override
    public void removeShape(String name) {
        for (int i = 0; i < shapes.size(); i++) {
            ALayerShape shape = (ALayerShape) shapes.get(i);
            if (shape instanceof NewShape) {
                NewShape nShape = (NewShape) shape;
                if (nShape.getName().equals(name)) {
                    this.removerShape(i);
                }
            }

        }
    }

    public void SelectingImage() {
        TTAirButton ti = new TTAirButton();
        ti.setPoint(50, 100, 0);
        ti.setPoint(250, 300, 1);
        ti.setIdentification("baixo");
        mi.addTTAirButton(ti);
        DisplayName sn = new DisplayName();
        sn.setStateAction("Selected");
        mi.addActionButton(ti, sn);
        TTAirButton nti = new TTAirButton();
        nti.setPoint(350, 100, 0);
        nti.setPoint(550, 300, 1);
        nti.setIdentification("cima");
        mi.addTTAirButton(nti);
        DisplayName2 sn2 = new DisplayName2();
        sn2.setStateAction("Selected");
        mi.addActionButton(nti, sn2);
    }

    @Override
    public void paint(Graphics g) {
        if (!shapes.isEmpty()) {
            super.paint(g);
            for (int a = 0; a < this.shapes.size(); a++) {
                ALayerShape shape = (ALayerShape) shapes.get(a);
                shape.draw(g);
            }

            SkeletonBone sb;
            try {
                sb = KinectAccess.getSkeletonsBone();
                handX = (int) sb.getBone(EBone.RIGHT_FOREARM).getJ2().getX();
                handY = (int) sb.getBone(EBone.RIGHT_FOREARM).getJ2().getY();
                handZ = (int) sb.getBone(EBone.RIGHT_FOREARM).getJ2().getZ();
                neckX = (int) sb.getBone(EBone.NECK).getJ2().getX();
                neckY = (int) sb.getBone(EBone.NECK).getJ2().getY();
                neckZ = (int) sb.getBone(EBone.NECK).getJ2().getZ();

                hand3d = new Point3D(handX, handY, handZ);
                neck3d = new Point3D(neckX, neckY, neckZ);
                mi.Finalize(hand3d, neck3d, this);

            } catch (Exception ex) {
            }

        }
        this.repaint();

    }
}
