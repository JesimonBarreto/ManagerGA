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

    private Point3D[] ponto = new Point3D[6];
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

    public Point3D getPonto(int i) {
        return ponto[i];
    }

    public void setPonto(Point3D ponto, int i) {
        this.ponto[i] = ponto;
    }

    public void LeituraPontos(Point3D ponto1, Point3D ponto2, Point3D ponto3, Point3D ponto4, Point3D ponto5, Point3D ponto6) {
        this.setPonto(ponto1, 0);
        this.setPonto(ponto2, 1);
        this.setPonto(ponto3, 2);
        this.setPonto(ponto4, 3);
        this.setPonto(ponto5, 4);
        this.setPonto(ponto6, 5);
    }

    public abstract boolean Aconteceu(Point3D ponto1, Point3D ponto2, Point3D ponto3, Point3D ponto4, Point3D ponto5, Point3D ponto6);
}
