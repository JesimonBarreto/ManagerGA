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
public abstract class AcaoReal extends Acao {

    private boolean executando = false;
    private char identi = 'r';

    public boolean isExecutando() {
        return executando;
    }

    public void setExecutando(boolean executando) {
        this.executando = executando;
    }

    @Override
    public abstract void executeArduino(ControlePorta cp, MyscreenPanel sp);

    public abstract void pararAcao(ControlePorta cp);
}
