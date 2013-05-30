/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager.Image;

import java.io.*;

/**
 *
 * @author JB
 */
public class MyFile {

    private File dir = new File("C:\\TTAirImage");

    public File getDir() {
        return dir;
    }

    public boolean createDirectory() {
        boolean statusdir = dir.mkdir();
        return statusdir;
    }

    public boolean directoryExists() {
        boolean exists = dir.exists();
        return exists;
    }

    public boolean imageExist(String nameI) {
        File dirI = new File(dir+"/N" + nameI + ".png");
        boolean existI = dirI.exists();
        return existI;
    }

    public boolean DeleteDirectory() {
        return dir.delete();
    }

}