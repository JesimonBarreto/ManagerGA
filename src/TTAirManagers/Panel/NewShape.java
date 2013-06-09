package TTAirManagers.Panel;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

/**
 *
 * @author JB
 */
public class NewShape extends MyALayerShape {

    private String name;
    private ImageObserver imagemOb;
    private BufferedImage image = null;
    private int x1, x2, y1, y2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NewShape(BufferedImage image, ImageObserver thi, int x1, int x2, int y1, int y2,String name) throws Exception {
        this.imagemOb = thi;
        this.image = image;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.name=name;
    }

    @Override
    public void draw(Graphics grphcs) {
        grphcs.drawImage(image, x1, y1, x2-x1,y2-y1, imagemOb);
    }
}
