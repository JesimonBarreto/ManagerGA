/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordegesto;

import java.util.ArrayList;

/**
 *
 * @author 20111lired0190
 */
public abstract class ReconhecendoGesto {

    private String nomeClasse=null;

    public String getNomeClasse() {
        return nomeClasse;
    }

    public void setNomeClasse(String nomeClass) {
        this.nomeClasse = nomeClass;
    }

    public abstract boolean Aconteceu(int maoDx, int maoDy, int maoDz, int maoEx, int maoEy, int maoEz, int necky,int neckz);
}
