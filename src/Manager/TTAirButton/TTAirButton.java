/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager.TTAirButton;

import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 *
 * @author JB
 */
public class TTAirButton {

    private Point[] coordinate = new Point[2];
    private BufferedImage[] image = new BufferedImage[3];
    private String identification;
    private boolean insertedPicture = false;

    public boolean isInsertedPicture() {
        return insertedPicture;
    }

    public void setInsertedPicture(boolean imegeInsert) {
        this.insertedPicture = imegeInsert;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public void setPoint(int x, int y, int i) {
        coordinate[i] = new Point(x, y);

    }

    public Point getPoint(int i) {
        return coordinate[i];
    }

    public BufferedImage getImage(char iD) {
        int i;
        switch (iD) {
            case 'N':
                i = 0;
                break;
            case 'S':
                i = 1;
                break;
            case 'C':
                i = 2;
                break;
            default:
                System.out.println("Falha no Reconhecimento da Imagem");
                i = 3;
                break;
        }
        return image[i];
    }

    public void setImage(BufferedImage[] image) {
        this.image = image;
    }

    public boolean Contain(Point ponto) {
        boolean contem = false;

        if (ponto.getX() > this.getPoint(0).x && ponto.getY() > this.getPoint(0).y) {
            if (ponto.getX() < (this.getPoint(0).x + (this.getPoint(1).x - this.getPoint(0).x)) && ponto.getY() < (this.getPoint(0).y + (this.getPoint(1).y - this.getPoint(0).y))) {
                contem = true;
            }
        }
        return contem;
    }
}
