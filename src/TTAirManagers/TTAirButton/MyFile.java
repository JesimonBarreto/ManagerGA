/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TTAirManagers.TTAirButton;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/**
 *
 * @author JB
 */
public class MyFile {

    private File dir = new File("C:\\TTAirButton");

    public File getDir() {
        return dir;
    }

    public File newFile(String path) {
        File newFile = new File(dir, path + ".zip");
        return newFile;
    }

    public boolean createDirectory() {
        boolean statusdir = dir.mkdir();
        return statusdir;
    }

    public File newFolder(String pathFolder) {
        File newFolder = new File(dir, pathFolder);
        newFolder.mkdir();
        newFolder.exists();
        return newFolder;
    }

    public void DeleteFile(File file) {
        file.delete();
    }

    public boolean directoryExists() {
        boolean exists = dir.exists();
        return exists;
    }

    public boolean imageExist(String nameI) {
        File dirI = new File(dir + "/N" + nameI + ".png");
        boolean existI = dirI.exists();
        return existI;
    }

    public boolean DeleteDirectory() {
        return dir.delete();
    }

    public void extractZip(String nameZip) throws ZipException, IOException {
        File arquivoZip = this.newFile(nameZip);
        ZipFile zip = null;
        File arquivo = null;
        InputStream is = null;
        OutputStream os = null;
        byte[] buffer = new byte[2048];
        try {
            //cria diretório informado, caso não exista  
            if (!this.directoryExists()) {
                dir.mkdirs();
            }
            if (!dir.exists() || !dir.isDirectory()) {
                throw new IOException("Enter a valid directory");
            }
            zip = new ZipFile(arquivoZip);
            Enumeration e = zip.entries();
            while (e.hasMoreElements()) {
                ZipEntry entrada = (ZipEntry) e.nextElement();
                arquivo = new File(dir, entrada.getName());
                //se for diretório inexistente, cria a estrutura   
                //e pula pra próxima entrada  
                if (entrada.isDirectory() && !arquivo.exists()) {
                    arquivo.mkdirs();
                    continue;
                }
                //se a estrutura de diretórios não existe, cria  
                if (!arquivo.getParentFile().exists()) {
                    arquivo.getParentFile().mkdirs();
                }
                try {
                    //lê o arquivo do zip e grava em disco  
                    is = zip.getInputStream(entrada);
                    os = new FileOutputStream(arquivo);
                    int bytesLidos = 0;
                    if (is == null) {
                        throw new ZipException("Erro ao ler a entrada do zip: " + entrada.getName());
                    }
                    while ((bytesLidos = is.read(buffer)) > 0) {
                        os.write(buffer, 0, bytesLidos);
                    }
                } finally {
                    if (is != null) {
                        try {
                            is.close();
                        } catch (Exception ex) {
                        }
                    }
                    if (os != null) {
                        try {
                            os.close();
                        } catch (Exception ex) {
                        }
                    }
                }
            }
        } finally {
            if (zip != null) {
                try {
                    zip.close();
                } catch (Exception e) {
                }
            }

        }
    }
}