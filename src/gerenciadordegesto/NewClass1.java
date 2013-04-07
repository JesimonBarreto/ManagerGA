/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordegesto;

/**
 *
 * @author Geral
 */
public class NewClass1 extends Acao{

    @Override
    public void execute() {
        System.out.println("Aconteceu");
    }

    @Override
    public void executeArduino(ControlePorta cp) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
