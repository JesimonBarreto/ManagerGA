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

    private boolean acaoDupla = false;
    private boolean executando = false;

    public AcaoReal() {
        this.setIdenti('r');
    }

    public boolean isAcaoDupla() {
        return acaoDupla;
    }

    public void setAcaoDupla(boolean acaoDupla) {
        this.acaoDupla = acaoDupla;
    }

    public boolean isExecutando() {
        return executando;
    }

    public void setExecutando(boolean executando) {
        this.executando = executando;
    }

    public abstract void executeArduino(ControlePorta cp, MyscreenPanel sp);

    public abstract void pararAcao(ControlePorta cp, MyscreenPanel sp);
}
