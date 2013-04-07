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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GerenteDeGestoseAcoes gerente=new GerenteDeGestoseAcoes();
        
        NewClass nc=new NewClass();
        nc.setNomeClasse("NewClass");
        gerente.addGestos(nc);
        
        NewClass1 nc1=new NewClass1();
        gerente.addAcao("NewClass", nc1);
        gerente.ConcluindoAcao(0, 0, 0, 0, 0, 0, 0, 0);
        gerente.ConcluindoAcao(0, 0, 0, 0, 0, 0, 0, 0);
        gerente.ConcluindoAcao(0, 0, 0, 0, 0, 0, 0, 0);
        gerente.ConcluindoAcao(0, 0, 0, 0, 0, 0, 0, 0);
    }

}
