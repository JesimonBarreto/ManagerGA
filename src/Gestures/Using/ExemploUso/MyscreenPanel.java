package Gestures.Using.ExemploUso;

import TTAirManagers.Gesture.GesturesStandards.HandsBackwards;
import TTAirManagers.Gesture.GesturesStandards.HandsUp;
import TTAirManagers.Gesture.Man.ManagerGA;
import TTAirManagers.Panel.NewShape;
import java.awt.Graphics;
import java.util.Vector;
import org.OpenNI.Point3D;
import presentation.ALayerShape;
import presentation.impl.KinectMotionCapture.KinectControl.EBone;
import presentation.impl.KinectMotionCapture.KinectControl.KinectAccess;
import presentation.impl.KinectMotionCapture.KinectControl.SkeletonBone;

/**
 *
 * @author JB
 */
//Criando classe 'MyscreenPanel' classe onde vai ficar responsável por enviar os dados para o gerente
public final class MyscreenPanel extends TTAirManagers.Panel.MyscreenPanel {

    public MyscreenPanel() {
        //Para que os gestos e as ações sejam adicionadas antes da execução
        inserindo();
    }
    Vector shapes = new Vector();
    private int maoX, maoY, maoZ, pescX, pescY, pescZ, maoYJ1, maoXJ1, maoZJ1, maoLx, maoLy, maoLz;
    Point3D mao, pesc, maoJ1, maoL;
    //Gerente criado, e passando como parâmetro um MyscreenPanel
    ManagerGA gerente = new ManagerGA(this);

    @Override
    public void addLayerShape(ALayerShape shape) {
        this.shapes.add(shape);
    }

    @Override
    public void addMyLayerShape(NewShape myshape) {
        this.shapes.add(myshape);
    }

    @Override
    public void removerShape(int position) {
        this.shapes.remove(position);
    }

    @Override
    public void replaceShape(int posicaoShapeRemover, ALayerShape shape) {
        this.removerShape(posicaoShapeRemover);
        this.addLayerShape(shape);
    }
    //Método responsável por inserir Gestos e Ações no Gerente

    public void inserindo() {
        GestoMaoParaCima mpc = new GestoMaoParaCima();
        //Método que vai guadar o nome da classe para armazenar as ações em conjunto
        mpc.setNameClass("GestoMaoParaCima");
        //Adicionando novo gesto ao gerente
        gerente.addGestures(mpc);
        //Criando objeto VirtualAction
        AcaoExibirNome aen = new AcaoExibirNome();
        //Adicionando ao gerente. Vai precisar de doi valores para parâmetros, uma String(Nome da Classe do gesto a que a ação vai ser associada), o objeto ação
        gerente.addAction("GestoMaoParaCima", aen);
        //Criando objeto AcaoReal
        //AcaoEnviarArduino ea = new AcaoEnviarArduino();
        //Para ativar Acão dupla
        //ea.setAcaoDupla(true);
        //Adicionando ao gerente
        // gerente.addAcao("GestoMaoParaCima", ea);
    }

//A classe Abstrata 'MyscreenPanel'tem um método substituirShape, passando a posição do que tiver de ser removido e o novo shape como parâmetro o método faz a substituição.
//Método paint, método responsável por desenhar na painel todos os shapes.    
    @Override
    public void paint(Graphics g) {
        if (!shapes.isEmpty()) {
            super.paint(g);
            for (int i = 0; i < shapes.size(); i++) {
                ALayerShape shape = (ALayerShape) shapes.get(i);
                shape.draw(g);
            }

            try {

                //Como vou usar apenas duas juntas, o da mão e o do pescoço vou inserir apenas as duas juntas

                SkeletonBone sb = KinectAccess.getSkeletonsBone();
                maoX = (int) sb.getBone(EBone.RIGHT_FOREARM).getJ2().getX();
                maoY = (int) sb.getBone(EBone.RIGHT_FOREARM).getJ2().getY();
                maoZ = (int) sb.getBone(EBone.RIGHT_FOREARM).getJ2().getZ();
                maoXJ1 = (int) sb.getBone(EBone.RIGHT_FOREARM).getJ1().getX();
                maoYJ1 = (int) sb.getBone(EBone.RIGHT_FOREARM).getJ1().getY();
                maoZJ1 = (int) sb.getBone(EBone.RIGHT_FOREARM).getJ1().getZ();
                pescX = (int) sb.getBone(EBone.NECK).getJ2().getX();
                pescY = (int) sb.getBone(EBone.NECK).getJ2().getY();
                pescZ = (int) sb.getBone(EBone.NECK).getJ2().getZ();
                maoLx = (int) sb.getBone(EBone.LEFT_FOREARM).getJ2().getX();
                maoLy = (int) sb.getBone(EBone.LEFT_FOREARM).getJ2().getY();
                maoLz = (int) sb.getBone(EBone.LEFT_FOREARM).getJ2().getZ();
                //Transformando em pontos 3D
                mao = new Point3D(maoX, maoY, maoZ);
                maoJ1 = new Point3D(maoXJ1, maoYJ1, maoZJ1);
                pesc = new Point3D(pescX, pescY, pescZ);
                maoL = new Point3D(maoLx, maoLy, maoLz);
                //Chamando método responsável por passar os valores para o gerente
                gerente.Finalize(mao, pesc, null, null, null, null);

            } catch (Exception erro) {
            }


        }
        this.repaint();
    }
}
