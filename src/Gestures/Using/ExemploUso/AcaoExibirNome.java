package Gestures.Using.ExemploUso;

import Manager.Action.VirtualAction;
import Manager.Gesture.Man.ManagerGA;
import Manager.Panel.MyscreenPanel;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

/**
 *
 * @author JB
 */
//Na classe 'AcaoExibirNome' como queremos que seja um objeto de ação virtual, então extendemos da classe 'AcaoVirtual'.  
public class AcaoExibirNome extends VirtualAction {

    //Método 'execute' é o método de ação, qualquer ação para ser feita no proprio computador, em java mesmo, como parametro é passado 'MyscreenPanel'
    //com objetivo de facilitar a alteração de algum shape no painel, também pode ser usado um método de substituição de desenho no painel,passando o int com o valor da posição do shape e o novo shape 'replaceShape'.
     @Override
    public void run(MyscreenPanel sp, ManagerGA gerente) {
       //Vamos colocar como exemplo exibir 'JB'
        System.out.println("JB");
    }
}
