package Manager.Panel;

import Manager.Gesture.Man.ManagerGA;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Vector;
import javax.imageio.ImageIO;
import presentation.ALayerShape;
import presentation.impl.KinectMotionCapture.layers.ScreenPanel;

/**
 *
 * @author JB
 */
public abstract class MyscreenPanel extends ScreenPanel {

    Vector shapes = new Vector();
    public BufferedImage image = null;
    private int shapePositionv = 0;
    public ManagerGA gerente;

    public int setShapePositionv(int shapePosition) {
        this.shapePositionv = shapePosition;
        return this.shapePositionv;
    }

    public void LoadImage(String fileName) {
        try {
            image = ImageIO.read(new File(fileName));
        } catch (Exception erro) {
            System.out.println("Erro Image");
        }
    }

    public BufferedImage getImage() {
        return this.image;
    }

    @Override
    public void addLayerShape(ALayerShape shape) {
        this.shapes.add(shape);
    }

    public void clear() {
        for (int i = 2; i < shapes.size(); i++) {
            this.shapes.remove(i);
        }
    }

    public void addMyLayerShape(NewShape myshape) {
        this.shapes.add(myshape);
    }

    public void removerShape(int position) {
        this.shapes.remove(position);
    }

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

    public void replaceShape(int posicaoShapeRemover, ALayerShape shape) {
        this.removerShape(posicaoShapeRemover);
        this.addLayerShape(shape);
    }
}
