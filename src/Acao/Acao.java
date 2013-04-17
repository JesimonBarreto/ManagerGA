/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Acao;

import Arduino.ControlePorta;
import Painel.MyscreenPanel;

/**
 *
 * @author JB
 */
public abstract class Acao {

    private char identi;

    public char getIdenti() {
        return identi;
    }

    public void setIdenti(char identi) {
        this.identi = identi;

    }

    public abstract void execute();

    public abstract void executeArduino(ControlePorta cp, MyscreenPanel sp);
}
