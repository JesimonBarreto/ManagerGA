package TTAirButton.Using.ExemploUso;

import TTAirManagers.Panel.NewShape;
import TTAirManagers.TTAirButton.ManagerButton;
import TTAirManagers.TTAirButton.TTAirButton;
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
//Necessário antes de usar: As três imagens que irão ser usadas no botão, uma para cada estado. 
//O nome das imagens deverão ter o seguinte formato: estado normal-"Nbaixo"; estado selecionado-"Sbaixo"; estado clicado-"Cbaixo".
//Depois compactar as três imagens pro formato ".zip" que deve ser renomeado com a palavra padrão em todas as imagens nesse caso "baixo". Deverá ser feito com todos os botões que deseja criar
//Após executar o programa a primeira vez será criado o diretorio "C:\\TTAirButton", antes da calibração copie os ".zip" para o diretorio.
//A não ser que o diretorio ou o arquivo.zip seja apagado por você não será mais necessário copiar.
public final class ScreenPanel1 extends TTAirManagers.Panel.MyscreenPanel {

    private Vector shapes = new Vector();
    private ManagerButton mi = new ManagerButton(this);
    private int handX, handY, handZ, neckX, neckY, neckZ;
    private Point3D hand3d, neck3d;

    public ScreenPanel1() throws Exception {
        super();
        this.SelectingImage();
    }

    @Override
    public void addLayerShape(ALayerShape shape) {
        this.shapes.add(shape);
    }

    @Override
    public void removerShape(int position) {
        this.shapes.remove(position);
    }

    @Override
    public void removeShape(String name) {
        for (int i = 0; i < shapes.size(); i++) {
            ALayerShape shape = (ALayerShape) shapes.get(i);
            if (shape instanceof NewShape) {
                NewShape nShape = (NewShape) shape;
                if (nShape.getName().equals(name)) {
                    this.removerShape(i);
                }
            }

        }
    }

    public void SelectingImage(){
        //Create a new object TTAirButtons
        TTAirButton ti = new TTAirButton();
        //Usa-se o método setPoint(int) para indicar os pontos do Botão, onde o primeiro parâmetro é o x, segundo y, terceiro indicação do ponto.
        //Se o terceiro parâmetro for 0 quer dizer que está iniciando os pontos iniciais do botão, e se for 1 indica pontos finais.
        ti.setPoint(50, 100, 0);
        ti.setPoint(250, 300, 1);
        //O método setIdentification(String) é usado para indicar o nome do botão, mesmo nome usado nas imagens e no arquivo .zip.
        ti.setIdentification("baixo");
        //Adiciona o botao criado ao managerButton.
        mi.addTTAirButton(ti);
        //Demonstração de Ações, podem ser adicionadas ações no botão tanto quando o estado for selecionado como clicado
        //Criação do objeto DisplayName que extende da classe VirtualAction, transfomando assim em uma classe apropriada para ser usada. 
        DisplayName sn = new DisplayName();
        //O método setStateAction(String) indica se a ação é para quando o estado do botao está selecionado(Selected) ou clicado(Clicked).
        sn.setStateAction("Selected");
        //Adicionando a ação ao managerButton, passando como parâmetro na primeira posição o objeto TTAirButton para que se destina a ação e na segunda posição o objeto ação.
        mi.addActionButton(ti, sn);
    }

    @Override
    public void paint(Graphics g) {
        if (!shapes.isEmpty()) {
            super.paint(g);
            for (int a = 0; a < this.shapes.size(); a++) {
                ALayerShape shape = (ALayerShape) shapes.get(a);
                shape.draw(g);
            }

            SkeletonBone sb;
            try {
                sb = KinectAccess.getSkeletonsBone();
                //Pegando Valores dos pontos da mão direita e do pescoço
                handX = (int) sb.getBone(EBone.RIGHT_FOREARM).getJ2().getX();
                handY = (int) sb.getBone(EBone.RIGHT_FOREARM).getJ2().getY();
                handZ = (int) sb.getBone(EBone.RIGHT_FOREARM).getJ2().getZ();
                neckX = (int) sb.getBone(EBone.NECK).getJ2().getX();
                neckY = (int) sb.getBone(EBone.NECK).getJ2().getY();
                neckZ = (int) sb.getBone(EBone.NECK).getJ2().getZ();
                //Unindo em somente uma variavel do tipo 3D
                hand3d = new Point3D(handX, handY, handZ);
                neck3d = new Point3D(neckX, neckY, neckZ);
                //Método Finalize usado para finalizar e é origatório que esteja no paint(Graphics), passando como parâmetro ponto da mao em 3D(esquerda ou direita) e do pescoço. 
                mi.Finalize(hand3d, neck3d, this);

            } catch (Exception ex) {
            }

        }
        this.repaint();

    }
}
