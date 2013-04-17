/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExemploUso;

import Acao.AcaoReal;
import Arduino.ControlePorta;
import Painel.MyscreenPanel;

/**
 *
 * @author JB
 */
//Classe de Ação para trabalhar com ações no mundo real, ou seja, enviando string pela porta usb para que o arduino execute alguma ação. Para isso a classe 'AcaoEnviarArduino' deve extender da classe 'AcaoReal'
public class AcaoEnviarArduino extends AcaoReal {

    //O Método 'executeArduino' é o método em que se registra a ação usando o parâmetro 'cp' de 'ControlePorta' vc pode invocar o método 'enviaDados' e passa como parâmetro um valor tipo char.
    //Também como parâmetro um MyscreenPanel para facilitar alterações no painel
    @Override
    public void executeArduino(ControlePorta cp, MyscreenPanel sp) {
        //Enviar o numero 1 como char usando o método anteriormente citado
        cp.enviarDados('1');
    }

    //Método pararAcao é o método que pode ser usado para parar uma ação lançada anteriormente, por exemplo, Acender uma lâmpada é cadastrado um gesto, caso esse gesto seja feito duas vezes,
    //o segundo será chamado esse método que seria para apagar a lâmpada(Se não for usar deixe em branco para evitar erros na execução do programa). Lembrado que para ativar essa opção é preciso dar
    //Um setAcaoDupla passando true como parâmetro antes de adicionar ao gesto.
    @Override
    public void pararAcao(ControlePorta cp, MyscreenPanel sp) {
    }
}
