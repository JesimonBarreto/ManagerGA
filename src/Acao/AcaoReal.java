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
public abstract class AcaoReal extends Acao{

    private char identi = 'r';

    public abstract void executeArduino(ControlePorta cp,MyscreenPanel sp);
}
