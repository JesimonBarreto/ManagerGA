package Gerente;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import org.OpenNI.Point3D;

/**
 *
 * @author JB
 */
public abstract class Gesto {

    public Point3D[] ponto = new Point3D[6];
    private boolean executando = false;
    private String nomeClasse = null;

    public boolean isExecutando() {
        return executando;
    }

    public void setExecutando(boolean executando) {
        this.executando = executando;
    }

    public String getNomeClasse() {
        return nomeClasse;
    }

    public void setNomeClasse(String nomeClass) {
        this.nomeClasse = nomeClass;
    }

    public void LeituraPontos(Point3D ponto1, Point3D ponto2, Point3D ponto3, Point3D ponto4, Point3D ponto5, Point3D ponto6) {
        ponto[0] = ponto1;
        ponto[1] = ponto2;
        ponto[2] = ponto3;
        ponto[3] = ponto4;
        ponto[4] = ponto5;
        ponto[5] = ponto6;
    }

    public abstract boolean Aconteceu(Point3D ponto1, Point3D ponto2, Point3D ponto3, Point3D ponto4, Point3D ponto5, Point3D ponto6);
}
