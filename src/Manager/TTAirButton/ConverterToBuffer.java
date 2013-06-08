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
            File file = new File(fileName);
            image[i] = ImageIO.read(file);
            file.deleteOnExit();
        } catch (Exception erro) {
            System.out.println("error: conversion");
        }
    }

    public BufferedImage[] conversion(String nameImage, MyFile files) {
        String newImage = files.getDir().getPath() + "/N" + nameImage + ".png";
        LoadImage(newImage, 0);
        newImage = files.getDir().getPath() + "/S" + nameImage + ".png";
        LoadImage(newImage, 1);
        newImage = files.getDir().getPath() + "/C" + nameImage + ".png";
        LoadImage(newImage, 2);

        return image;
    }
}
