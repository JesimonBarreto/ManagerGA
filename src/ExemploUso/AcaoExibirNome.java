/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExemploUso;

import Acao.AcaoVirtual;
import Painel.MyscreenPanel;

/**
 *
 * @author JB
 */
//Na classe 'AcaoExibirNome' como queremos que seja um objeto de ação virtual, então extendemos da classe 'AcaoVirtual'.  
public class AcaoExibirNome extends AcaoVirtual {

    //Método 'execute' é o método de ação, qualquer ação para ser feita no proprio computador, em java mesmo, como parametro é passado 'MyscreenPanel'
    //que é do tipo 'ScreenPanel', com objetivo de facilitar a alteração de algum shape no painel, com um método 'substituirShape'.
    @Override
    public void execute(MyscreenPanel sp) {
        //Vamos colocar como exemplo exibir 'JB'
        System.out.println("JB");
    }
}