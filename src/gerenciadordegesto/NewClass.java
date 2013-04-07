/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordegesto;

/**
 *
 * @author Geral
 */
public class NewClass extends ReconhecendoGesto{

    @Override
    public boolean Aconteceu(int maoDx, int maoDy, int maoDz, int maoEx, int maoEy, int maoEz, int necky, int neckz) {
       boolean a=false;
        if(maoDx==0){
            a=true;
       }
        return a;
    }
    
}
