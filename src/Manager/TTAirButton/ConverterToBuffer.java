/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager.TTAirButton;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author JB
 */
public class ConverterToBuffer {

    private BufferedImage[] image = new BufferedImage[3];

    private void LoadImage(String fileName, int i) {
        try {
            image[i] = ImageIO.read(new File(fileName));
        } catch (Exception erro) {
            System.out.println("error: conversion");
        }
    }

    public BufferedImage[] conversion(String nameImage, MyFile files) {
        String newimage = files.getDir().getPath() + "/N" + nameImage + ".png";
        LoadImage(newimage, 0);
        newimage = files.getDir().getPath() + "/S" + nameImage + ".png";
        LoadImage(newimage, 1);
        newimage = files.getDir().getPath() + "/C" + nameImage + ".png";
        LoadImage(newimage, 2);

        return image;
    }
}
