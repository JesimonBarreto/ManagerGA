package Acao;

import Painel.MyscreenPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JB
 */
public abstract class AcaoVirtual extends Acao {

    public abstract void execute(MyscreenPanel sp);

    public AcaoVirtual() {
        this.setIdenti('v');
    }
}
