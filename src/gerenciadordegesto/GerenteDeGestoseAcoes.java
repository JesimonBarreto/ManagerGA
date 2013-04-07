package gerenciadordegesto;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author 20111lired0190
 */
public class GerenteDeGestoseAcoes {
    
    Hashtable hs = new Hashtable();
    private ArrayList<Gesto> Gestos = new ArrayList();
    
    public void addGestos(Gesto reconhecedor) {
        this.Gestos.add(reconhecedor);
        String nomeClasse = reconhecedor.getNomeClasse();
        Vector acoes = new Vector();
        hs.put(nomeClasse, acoes);
    }
    
    public void addAcao(String nomeClasse, Acao acao) {
        ((Vector) hs.get(nomeClasse)).add(acao);
    }
    
    public String DetectandoGesto(int maoDx, int maoDy, int maoDz, int maoEx, int maoEy, int maoEz, int necky, int neckz) {
        Gesto reconhecedor = null;
        String objetoAExecutar = null;
        int i = 0;
        while (i < Gestos.size() && reconhecedor == null) {
            reconhecedor = Gestos.get(i);
            if (!reconhecedor.Aconteceu(maoDx, maoDy, maoDz, maoEx, maoEy, maoEz, necky, neckz) && reconhecedor.isExecutando()) {
                reconhecedor = null;
            } else {
                for (int j = 0; j < Gestos.size(); j++) {
                    Gestos.get(j).setExecutando(false);
                }
                objetoAExecutar = reconhecedor.getNomeClasse();
                Gestos.get(i).setExecutando(true);
            }
            i++;
        }
        return objetoAExecutar;
    }
    
    public void ConcluindoAcao(int maoDx, int maoDy, int maoDz, int maoEx, int maoEy, int maoEz, int necky, int neckz) {
        String chave = this.DetectandoGesto(maoDx, maoDy, maoDz, maoEx, maoEy, maoEz, necky, neckz);
        if (chave != null) {
            Vector aAcao = ((Vector) hs.get(chave));
            for (int i = 0; i < aAcao.size(); i++) {
                Acao a = (Acao) aAcao.get(i);
                a.execute();
            }
        }
    }
}
