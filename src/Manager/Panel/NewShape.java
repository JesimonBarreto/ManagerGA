
package Manager.Panel;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import presentation.ALayerShape;

/**
 *
 * @author JB
 */
public class NewShape extends MyALayerShape {

    private ImageObserver imagemOb;
    private BufferedImage image = null;
    private int x1,x2,y1,y2;

    public NewShape(BufferedImage image, ImageObserver thi,int x1,int x2,int y1,int y2) throws Exception {
        this.imagemOb = thi;
        this.image = image;
        this.x1=x1;
        this.x2=x2;
        this.y1=y1;
        this.y2=y2;
    }

    @Override
    public void draw(Graphics grphcs) {
        grphcs.drawImage(image, x1, y1, x2, y2, imagemOb);
    }
}
