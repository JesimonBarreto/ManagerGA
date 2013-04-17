/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExemploUso;

import Gerente.Gesto;
import org.OpenNI.Point3D;

/**
 *
 * @author JB
 */
//Para adicionar um novo gesto ao gerente basta extender da classe 'Gesto' e usar o método 'Aconteu' que é onde será feito todo o teste para que seu gesto seja reconhecido
public class GestoMaoParaCima extends Gesto {
    //Dentro da classe 'Gesto' tem um vetor de pontos 'ponto' de seis posições em 3D que é usado como pontos iniciais, automaticamente lidos pela biblioteca.
    //Os seis pontos em 3D passados como parâmetros no método são para possíveis testes com várias juntas. O método que vai inserir os valores de cada ponto e cada junta vai ser chamado no paint   

    @Override
    public boolean Aconteceu(Point3D ponto1, Point3D ponto2, Point3D ponto3, Point3D ponto4, Point3D ponto5, Point3D ponto6) {
        //Criando variável para retorno
        boolean aconteceu = false;
        //Condição para  que o seu gesto aconteça
        if (ponto1.getY() < ponto2.getY()) {
            aconteceu = true;
        }
        //retornando valor
        return aconteceu;
    }
}
