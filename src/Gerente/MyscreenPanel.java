/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gerente;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Vector;
import javax.swing.text.Position;
import presentation.ALayerShape;
import presentation.impl.KinectMotionCapture.layers.ScreenPanel;

/**
 *
 * @author Geral
 */
public abstract class MyscreenPanel extends ScreenPanel {
    
    Vector shapes = new Vector();
    BufferedImage[] image = null;
    private int shapePositionv = 0;
    
    public int setShapePositionv(int shapePosition) {
        this.shapePositionv = shapePosition;
        return this.shapePositionv;
    }
    
    @Override
    public void addLayerShape(ALayerShape shape) {
        this.shapes.add(shape);
    }
    
    public void removerShape(int position) {
        this.shapes.remove(position);
    }

    public void substituirShape(int posicaoShapeRemover, ALayerShape shape) {
        this.removerShape(posicaoShapeRemover);
        this.addLayerShape(shape);
    }

    @Override
    public void paint(Graphics g) {
    }
}
