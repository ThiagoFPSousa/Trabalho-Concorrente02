/* ***************************************************************
* Autor............: Thiago Fernandes Pereira de Sousa
* Matricula........: 202210546
* Inicio...........: 25 de agosto de 2023.(25/08/2023)
* Ultima alteracao.: 06 de outubro de 2023.(06/10/2023)
* Nome.............: BRINQUE DE TREM
* Funcao...........: Uma simulacao de trens utilizando ferramentas de uma GUI.
Nela o usuario pode escolher as direcoes dos trens(podendo ser os dois superiores ou inferiores ou alternados).
Apos a confirmacao, o usuario pode alterar a velocidade de ambos os trens.
Existe tambem um botao para resetar a animacao (retornar ao ponto inicial e parados) e um botao para poder mudar as direcoes.
*************************************************************** */
package threads;// Declaracao do pacote 'threads' ao qual pertence a classe 'ThreadTrem1'.

//Importacoes Necessarias.
import controller.EscolhaDirecao;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class ThreadTrem1 extends Thread {
  private EscolhaDirecao controlador;
  private ImageView trem1;
  private Timeline timeline1;
  private Timeline timeline2;
  private Timeline timeline3;
  private Timeline timeline4;
  private Timeline timeline5;
  private double duracao = 0.0810810811;
  private int processo = 0;

  /* ***************************************************************
   * Metodo: ThreadTrem1.
   * Funcao: Controlador.
   * Parametros: EscolhaDirecao controlador, ImageView trem1
   * Retorno: nenhum.
   *************************************************************** */
  public ThreadTrem1(EscolhaDirecao controlador, ImageView trem1) {
    this.controlador = controlador;
    this.trem1 = trem1;
  }

  @Override
  /* ***************************************************************
   * Metodo: run
   * Funcao: Inicia a Thread. Utiliza um switch para escolher o caso de solucao para colisao.
   * Parametros: nenhum.
   * Retorno: nenhum (void).
   *************************************************************** */
  public void run() {
    while(true){
      switch (controlador.getOp()) {
        case 1:
          try {
            variavelDeTravamento();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          break;
        case 2:
          try {
            estritaAlternancia();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          break;
        case 3:
          try {
            solucaoDePeterson();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          break;
      }
    }
  }
  
//--------------------------------ANIMACAO PARA A PARTE SUPERIOR--------------------------------//
   /* ***************************************************************
   * Metodo: animacaoTrem1SuperiorTrilho01.
   * Funcao: Define uma parte da animacao do trem 1 seguindo um caminho superior.
   * Parametros: Nenhum.
   * Retorno: Nenhum (void).
   *************************************************************** */
  private void animacaoTrem1SuperiorTrilho01() throws InterruptedException {
    // Define as posições ao longo do tempo
    KeyFrame[] keyFrames = {
        new KeyFrame(Duration.seconds(0), e -> {// ponta 1
          trem1.setLayoutX(21);
          trem1.setLayoutY(0);
          trem1.setRotate(90);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 1)), e -> {// meio.2
          trem1.setLayoutX(21);
          trem1.setLayoutY(7.5);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 2)), e -> {// meio
          trem1.setLayoutX(21);
          trem1.setLayoutY(15);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 3)), e -> {// meio.2
          trem1.setLayoutX(21);
          trem1.setLayoutY(22.5);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 4)), e -> {// ponta 2
          trem1.setLayoutX(21);
          trem1.setLayoutY(30);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 5)), e -> {// meio.2
          trem1.setLayoutX(33.75);
          trem1.setLayoutY(41.25);
          trem1.setRotate(45);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 6)), e -> {// meio
          trem1.setLayoutX(46.5);
          trem1.setLayoutY(52.5);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 7)), e -> {// meio.2
          trem1.setLayoutX(59.25);
          trem1.setLayoutY(63.75);
        })
    };

    // Crie a Timeline com os KeyFrames
    timeline1 = new Timeline(keyFrames);
    timeline1.setCycleCount(1);
    timeline1.play();
  }

  /* ***************************************************************
   * Metodo: animacaoTrem1SuperiorRC1.
   * Funcao: Define uma parte da animacao do trem 1 seguindo um caminho superior.
   * Parametros: Nenhum.
   * Retorno: Nenhum (void).
   *************************************************************** */
  private void animacaoTrem1SuperiorRC1() throws InterruptedException {
    // Define as posições ao longo do tempo
    KeyFrame[] keyFrames = {
        new KeyFrame(Duration.seconds(0 + (duracao * 8)), e -> {// ponta 3 - INICIO RC1
          trem1.setLayoutX(72);
          trem1.setLayoutY(75);
          trem1.setRotate(90);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 9)), e -> {// meio.2
          trem1.setLayoutX(72);
          trem1.setLayoutY(92.5);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 10)), e -> {// meio
          trem1.setLayoutX(72);
          trem1.setLayoutY(110);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 11)), e -> {// meio.2
          trem1.setLayoutX(72);
          trem1.setLayoutY(127.5);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 12)), e -> {// ponta 4 - FIM RC1
          trem1.setLayoutX(72);
          trem1.setLayoutY(145);
          trem1.setRotate(45);
        })
    };

    // Crie a Timeline com os KeyFrames
    timeline2 = new Timeline(keyFrames);
    timeline2.setCycleCount(1);
    timeline2.play();
  }

  /* ***************************************************************
   * Metodo: animacaoTrem1SuperiorTilho02.
   * Funcao: Define uma parte da animacao do trem 1 seguindo um caminho superior.
   * Parametros: Nenhum.
   * Retorno: Nenhum (void).
   *************************************************************** */
  private void animacaoTrem1SuperiorTrilho02() throws InterruptedException {
    // Define as posições ao longo do tempo
    KeyFrame[] keyFrames = {
        new KeyFrame(Duration.seconds(0 + (duracao * 13)), e -> {// meio.2
          trem1.setLayoutX(84.5);
          trem1.setLayoutY(155);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 14)), e -> {// meio
          trem1.setLayoutX(97);
          trem1.setLayoutY(165);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 15)), e -> {// meio.2
          trem1.setLayoutX(109.5);
          trem1.setLayoutY(175);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 16)), e -> {// ponta 5
          trem1.setLayoutX(122);
          trem1.setLayoutY(185);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 17)), e -> {// meio.2
          trem1.setLayoutX(122);
          trem1.setLayoutY(197.5);
          trem1.setRotate(90);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 18)), e -> {// meio
          trem1.setLayoutX(122);
          trem1.setLayoutY(210);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 19)), e -> {// meio.2
          trem1.setLayoutX(122);
          trem1.setLayoutY(222.5);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 20)), e -> {// ponta 6
          trem1.setLayoutX(122);
          trem1.setLayoutY(235);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 21)), e -> {// meio.2
          trem1.setLayoutX(109.5);
          trem1.setLayoutY(245.25);
          trem1.setRotate(135);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 22)), e -> {// meio
          trem1.setLayoutX(97);
          trem1.setLayoutY(257.5);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 23)), e -> {// meio.2
          trem1.setLayoutX(84.5);
          trem1.setLayoutY(268.75);
        }),
    };

    // Crie a Timeline com os KeyFrames
    timeline3 = new Timeline(keyFrames);
    timeline3.setCycleCount(1);
    timeline3.play();
  }

  /* ***************************************************************
   * Metodo: animacaoTrem1SuperiorTrilhoRC2.
   * Funcao: Define uma parte da animacao do trem 1 seguindo um caminho superior.
   * Parametros: Nenhum.
   * Retorno: Nenhum (void).
   *************************************************************** */
  private void animacaoTrem1SuperiorRC2() throws InterruptedException {
    // Define as posições ao longo do tempo
    KeyFrame[] keyFrames = {
        new KeyFrame(Duration.seconds(0 + (duracao * 24)), e -> {// ponta 7 - INICIO RC2
          trem1.setLayoutX(72);
          trem1.setLayoutY(280);
          trem1.setRotate(90);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 25)), e -> {// meio.2
          trem1.setLayoutX(72);
          trem1.setLayoutY(291.25);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 26)), e -> {// meio
          trem1.setLayoutX(72);
          trem1.setLayoutY(302.5);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 27)), e -> {// meio.2
          trem1.setLayoutX(72);
          trem1.setLayoutY(313.75);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 28)), e -> {// ponta 8 - FIM RC2
          trem1.setLayoutX(72);
          trem1.setLayoutY(325);
          trem1.setRotate(135);
        }),
    };

    // Crie a Timeline com os KeyFrames
    timeline4 = new Timeline(keyFrames);
    timeline4.setCycleCount(1);
    timeline4.play();
  }

  /* ***************************************************************
   * Metodo: animacaoTrem1SuperiorTrilho03.
   * Funcao: Define uma parte da animacao do trem 1 seguindo um caminho superior.
   * Parametros: Nenhum.
   * Retorno: Nenhum (void).
   *************************************************************** */
  private void animacaoTrem1SuperiorTrilho03() throws InterruptedException {
    // Define as posições ao longo do tempo
    KeyFrame[] keyFrames = {
        new KeyFrame(Duration.seconds(0 + (duracao * 29)), e -> {// meio.2
          trem1.setLayoutX(59.25);
          trem1.setLayoutY(336.25);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 30)), e -> {// meio
          trem1.setLayoutX(46.5);
          trem1.setLayoutY(347.5);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 31)), e -> {// meio.2
          trem1.setLayoutX(33.75);
          trem1.setLayoutY(358.75);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 32)), e -> {// ponta 9
          trem1.setLayoutX(21);
          trem1.setLayoutY(370);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 33)), e -> {// meio.2
          trem1.setLayoutX(21);
          trem1.setLayoutY(380);
          trem1.setRotate(90);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 34)), e -> {// meio
          trem1.setLayoutX(21);
          trem1.setLayoutY(390);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 35)), e -> {// meio.2
          trem1.setLayoutX(21);
          trem1.setLayoutY(400);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 36)), e -> {// ponta 10
          trem1.setLayoutX(21);
          trem1.setLayoutY(410);
        }),
        new KeyFrame(Duration.seconds(3), e -> {// ponta 10
          trem1.setLayoutX(21);
          trem1.setLayoutY(410);
        })
    };

    // Crie a Timeline com os KeyFrames
    timeline5 = new Timeline(keyFrames);
    timeline5.setCycleCount(1);
    timeline5.play();
  }
  //--------------------------------------------------------------------------------------------------//


  //--------------------------------ANIMACAO PARA A PARTE INFERIOR--------------------------------//
  
   /* ***************************************************************
   * Metodo: animacaoTrem1InferiorTrilho01.
   * Funcao: Define uma parte da animacao do trem 1 seguindo um caminho inferior.
   * Parametros: Nenhum.
   * Retorno: Nenhum (void).
   *************************************************************** */
  private void animacaoTrem1InferiorTrilho01() throws InterruptedException {
    // Define as posições ao longo do tempo, em ordem inversa
    KeyFrame[] keyFrames = {
        new KeyFrame(Duration.seconds(0), e -> {// ponta 10
          trem1.setLayoutX(21);
          trem1.setLayoutY(410);
          trem1.setRotate(-90);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 1)), e -> {// meio.2
          trem1.setLayoutX(21);
          trem1.setLayoutY(400);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 2)), e -> {// meio
          trem1.setLayoutX(21);
          trem1.setLayoutY(390);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 3)), e -> {// meio.2
          trem1.setLayoutX(21);
          trem1.setLayoutY(380);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 4)), e -> {// ponta 9
          trem1.setLayoutX(21);
          trem1.setLayoutY(370);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 5)), e -> {// meio.2
          trem1.setLayoutX(33.75);
          trem1.setLayoutY(358.75);
          trem1.setRotate(-45);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 6)), e -> {// meio
          trem1.setLayoutX(46.5);
          trem1.setLayoutY(347.5);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 7)), e -> {// meio.2
          trem1.setLayoutX(59.25);
          trem1.setLayoutY(336.25);
        }),
    };

    // Crie a Timeline com os KeyFrames
    timeline1 = new Timeline(keyFrames);
    timeline1.setCycleCount(1);
    timeline1.play();
  }

  /* ***************************************************************
   * Metodo: animacaoTrem1InferiorRC2.
   * Funcao: Define uma parte da animacao do trem 1 seguindo um caminho inferior.
   * Parametros: Nenhum.
   * Retorno: Nenhum (void).
   *************************************************************** */
  private void animacaoTrem1InferiorRC2() throws InterruptedException {
    // Define as posições ao longo do tempo, em ordem inversa
    KeyFrame[] keyFrames = {
        new KeyFrame(Duration.seconds(0 + (duracao * 8)), e -> {// ponta 8 - INICIO RC2
          trem1.setLayoutX(72);
          trem1.setLayoutY(325);
          trem1.setRotate(-90);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 9)), e -> {// meio.2
          trem1.setLayoutX(72);
          trem1.setLayoutY(313.75);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 10)), e -> {// meio
          trem1.setLayoutX(72);
          trem1.setLayoutY(302.5);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 11)), e -> {// meio.2
          trem1.setLayoutX(72);
          trem1.setLayoutY(291.25);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 12)), e -> {// ponta 7 - FIM RC2
          trem1.setLayoutX(72);
          trem1.setLayoutY(280);
          trem1.setRotate(-45);
        }),
    };

    // Crie a Timeline com os KeyFrames
    timeline2 = new Timeline(keyFrames);
    timeline2.setCycleCount(1);
    timeline2.play();
  }

  /* ***************************************************************
   * Metodo: animacaoTrem1InferiorTrilho02.
   * Funcao: Define uma parte da animacao do trem 1 seguindo um caminho inferior.
   * Parametros: Nenhum.
   * Retorno: Nenhum (void).
   *************************************************************** */
  private void animacaoTrem1InferiorTrilho02() throws InterruptedException {
    // Define as posições ao longo do tempo, em ordem inversa
    KeyFrame[] keyFrames = {
        new KeyFrame(Duration.seconds(0 + (duracao * 13)), e -> {// meio.2
          trem1.setLayoutX(84.5);
          trem1.setLayoutY(268.75);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 14)), e -> {// meio
          trem1.setLayoutX(97);
          trem1.setLayoutY(257.5);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 15)), e -> {// meio.2
          trem1.setLayoutX(109.5);
          trem1.setLayoutY(245.25);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 16)), e -> {// ponta 6
          trem1.setLayoutX(122);
          trem1.setLayoutY(235);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 17)), e -> {// meio.2
          trem1.setLayoutX(122);
          trem1.setLayoutY(222.5);
          trem1.setRotate(-90);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 18)), e -> {// meio
          trem1.setLayoutX(122);
          trem1.setLayoutY(210);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 19)), e -> {// meio.2
          trem1.setLayoutX(122);
          trem1.setLayoutY(197.5);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 20)), e -> {// ponta 5
          trem1.setLayoutX(122);
          trem1.setLayoutY(185);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 21)), e -> {// meio.2
          trem1.setLayoutX(109.5);
          trem1.setLayoutY(175);
          trem1.setRotate(-135);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 22)), e -> {// meio
          trem1.setLayoutX(97);
          trem1.setLayoutY(165);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 23)), e -> {// meio.2
          trem1.setLayoutX(84.5);
          trem1.setLayoutY(155);
        }),
    };

    // Crie a Timeline com os KeyFrames
    timeline3 = new Timeline(keyFrames);
    timeline3.setCycleCount(1);
    timeline3.play();
  }

  /* ***************************************************************
   * Metodo: animacaoTrem1InferiorRC1.
   * Funcao: Define uma parte da animacao do trem 1 seguindo um caminho inferior.
   * Parametros: Nenhum.
   * Retorno: Nenhum (void).
   *************************************************************** */
  private void animacaoTrem1InferiorRC1() throws InterruptedException {
    // Define as posições ao longo do tempo, em ordem inversa
    KeyFrame[] keyFrames = {
        new KeyFrame(Duration.seconds(0 + (duracao * 24)), e -> {// ponta 4 - INICIO RC1
          trem1.setLayoutX(72);
          trem1.setLayoutY(145);
          trem1.setRotate(-90);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 25)), e -> {// meio.2
          trem1.setLayoutX(72);
          trem1.setLayoutY(127.5);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 26)), e -> {// meio
          trem1.setLayoutX(72);
          trem1.setLayoutY(110);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 27)), e -> {// meio.2
          trem1.setLayoutX(72);
          trem1.setLayoutY(92.5);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 28)), e -> {// ponta 3 - FIM RC1
          trem1.setLayoutX(72);
          trem1.setLayoutY(75);
          trem1.setRotate(-135);
        }),
    };

    // Crie a Timeline com os KeyFrames
    timeline4 = new Timeline(keyFrames);
    timeline4.setCycleCount(1);
    timeline4.play();
  }

  /* ***************************************************************
   * Metodo: animacaoTrem1InferiorTrilho03.
   * Funcao: Define uma parte da animacao do trem 1 seguindo um caminho inferior.
   * Parametros: Nenhum.
   * Retorno: Nenhum (void).
   *************************************************************** */
  private void animacaoTrem1InferiorTrilho03() throws InterruptedException {
    // Define as posições ao longo do tempo, em ordem inversa
    KeyFrame[] keyFrames = {
        new KeyFrame(Duration.seconds(0 + (duracao * 29)), e -> {// meio.2
          trem1.setLayoutX(59.25);
          trem1.setLayoutY(63.75);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 30)), e -> {// meio
          trem1.setLayoutX(46.5);
          trem1.setLayoutY(52.5);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 31)), e -> {// meio.2
          trem1.setLayoutX(33.75);
          trem1.setLayoutY(41.25);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 32)), e -> {// ponta 2
          trem1.setLayoutX(21);
          trem1.setLayoutY(30);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 33)), e -> {// meio.2
          trem1.setLayoutX(21);
          trem1.setLayoutY(22.5);
          trem1.setRotate(-90);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 34)), e -> {// meio
          trem1.setLayoutX(21);
          trem1.setLayoutY(15);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 35)), e -> {// meio.2
          trem1.setLayoutX(21);
          trem1.setLayoutY(7.5);
        }),
        new KeyFrame(Duration.seconds(0 + (duracao * 36)), e -> {// ponta 1
          trem1.setLayoutX(21);
          trem1.setLayoutY(0);
        }),
        new KeyFrame(Duration.seconds(3), e -> {// ponta 1
          trem1.setLayoutX(21);
          trem1.setLayoutY(0);
        })
    };

    // Crie a Timeline com os KeyFrames
    timeline5 = new Timeline(keyFrames);
    timeline5.setCycleCount(1);
    timeline5.play();
  }
  //--------------------------------------------------------------------------------------------------//

  //--------------------------------------------------------------------------------------------------//

  /* ***************************************************************
   * Metodo: pararTrem1.
   * Funcao: Parar Trem.
   * Parametros: Nenhum.
   * Retorno: nenhum (void).
   *************************************************************** */
  public void pararTrem1() {

  }

  /* ***************************************************************
   * Metodo: mudarVelocidadeTrem1.
   * Funcao: Mudar velocidade do Trem.
   * Parametros: double velocidade
   * Retorno: nenhum (void).
   *************************************************************** */
  public void mudarVelocidadeTrem1(double velocidade) {

  }

  /* ***************************************************************
   * Metodo: resetarTrem1.
   * Funcao: Resetar animacao com o trem parado.
   * Parametros: Nenhum.
   * Retorno: nenhum (void).
   *************************************************************** */
  public void resetarTrem1() {

  }
  //--------------------------------------------------------------------------------------------------//


  /*--------------------------Metodos para solucao de variavel de travamento--------------------------*/

  /* ***************************************************************
   * Metodo: variavelDeTravamento.
   * Funcao: Impedir colisao dos trens.
   * Parametros: Nenhum.
   * Retorno: nenhum (void).
   *************************************************************** */
  public void variavelDeTravamento() throws InterruptedException {
    if (controlador.btnSuperior.isSelected() || controlador.btnAlternadoI.isSelected()) {
      animacaoTrem1SuperiorTrilho01();

      verificaRC1();
      controlador.VT1 = 1;
      animacaoTrem1SuperiorRC1();
      controlador.VT1 = 0;

      animacaoTrem1SuperiorTrilho02();

      verificaRC2();
      controlador.VT2 = 1;
      animacaoTrem1SuperiorRC2();
      controlador.VT2 = 0;

      animacaoTrem1SuperiorTrilho03();
    } else if (controlador.btnInferior.isSelected() || controlador.btnAlternadoII.isSelected()) {
      animacaoTrem1InferiorTrilho01();

      verificaRC2();
      controlador.VT2 = 1;
      animacaoTrem1InferiorRC2();
      controlador.VT2 = 0;

      animacaoTrem1InferiorTrilho02();

      verificaRC1();
      controlador.VT1 = 1;
      animacaoTrem1InferiorRC1();
      controlador.VT1 = 0;

      animacaoTrem1InferiorTrilho03();
    }
    Thread.sleep(3000);
  }

  /* ***************************************************************
   * Metodo: verificaRC1.
   * Funcao: Verificar se RC1 pode ser acessado.
   * Parametros: Nenhum.
   * Retorno: nenhum (void).
   *************************************************************** */
  public void verificaRC1() {
    synchronized (controlador) {
      while (controlador.VT1 == 1) {
        try {
          controlador.wait(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  /* ***************************************************************
   * Metodo: verificaRC2.
   * Funcao: Verificar se RC2 pode ser acessado.
   * Parametros: 
   * Retorno: nenhum (void).
   *************************************************************** */
  public void verificaRC2() {
    synchronized (controlador) {
      while (controlador.VT2 == 1) {
        try {
          controlador.wait(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
  //--------------------------------------------------------------------------------------------------//

  /*--------------------------Metodos para solucao de estrita alternancia--------------------------*/

  /* ***************************************************************
   * Metodo: estritaAlternancia.
   * Funcao: Impedir colisao dos trens.
   * Parametros: Nenhum.
   * Retorno: nenhum (void).
   *************************************************************** */
  public void estritaAlternancia() throws InterruptedException {
    if (controlador.btnSuperior.isSelected() || controlador.btnAlternadoI.isSelected()) {
      animacaoTrem1SuperiorTrilho01();

      esperaVEZ1();
      animacaoTrem1SuperiorRC1();
      controlador.passarVEZ1(2);

      animacaoTrem1SuperiorTrilho02();

      esperaVEZ2();
      animacaoTrem1SuperiorRC2();
      controlador.passarVEZ2(2);

      animacaoTrem1SuperiorTrilho03();
    } else if (controlador.btnInferior.isSelected() || controlador.btnAlternadoII.isSelected()) {
      animacaoTrem1InferiorTrilho01();

      esperaVEZ1();
      animacaoTrem1InferiorRC2();
      controlador.passarVEZ1(2);

      animacaoTrem1InferiorTrilho02();

      esperaVEZ2();
      animacaoTrem1InferiorRC1();
      controlador.passarVEZ2(2);

      animacaoTrem1InferiorTrilho03();
    }
    Thread.sleep(3000);
  }

  /* ***************************************************************
   * Metodo: esperaVEZ1.
   * Funcao: Esperar ate a RC1 estiver liberado.
   * Parametros: Nenhum.
   * Retorno: nenhum (void).
   *************************************************************** */
  public synchronized void esperaVEZ1() {
    while (controlador.getVEZ1() != 1) {
      try {
        wait(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  /* ***************************************************************
   * Metodo: esperaVEZ2
   * Funcao: Esperar ate a RC2 estiver liberado.
   * Parametros: Nenhum.
   * Retorno: nenhum (void).
   *************************************************************** */
  public synchronized void esperaVEZ2() {
    while (controlador.getVEZ2() != 1) {
      try {
        wait(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
  //--------------------------------------------------------------------------------------------------//

  /*--------------------------Metodos para solucao de Peterson--------------------------*/

  /* ***************************************************************
   * Metodo: solucaoDePeterson.
   * Funcao: Impedir colisao dos trens.
   * Parametros: Nenhum.
   * Retorno: nenhum (void).
   *************************************************************** */
  public void solucaoDePeterson() throws InterruptedException {
    if (controlador.btnSuperior.isSelected() || controlador.btnAlternadoI.isSelected()) {
      animacaoTrem1SuperiorTrilho01();

      solucaoPeterson01();
      animacaoTrem1SuperiorRC1();
      sairRC1();

      animacaoTrem1SuperiorTrilho02();

      solucaoPeterson02();
      animacaoTrem1SuperiorRC2();
      sairRC2();

      animacaoTrem1SuperiorTrilho03();
    } else if (controlador.btnInferior.isSelected() || controlador.btnAlternadoII.isSelected()) {
      animacaoTrem1InferiorTrilho01();

      solucaoPeterson01();
      animacaoTrem1InferiorRC2();
      sairRC2();

      animacaoTrem1InferiorTrilho02();

      solucaoPeterson02();
      animacaoTrem1InferiorRC1();
      sairRC1();

      animacaoTrem1InferiorTrilho03();
    }
    Thread.sleep(3000);
  }

  /* ***************************************************************
   * Metodo: solucaoPeterson01.
   * Funcao: Esperar ate nao haver interesse na RC1.
   * Parametros: Nenhum.
   * Retorno: nenhum (void).
   *************************************************************** */
  public synchronized void solucaoPeterson01() {
    int outro;
    outro = 1 - processo;
    controlador.setInteressado01(processo, true);
    controlador.setTurno01(processo);
    while (controlador.getTurno01() == processo && controlador.getInteressado01(outro) == true) {
      try {
        wait(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  /* ***************************************************************
   * Metodo: solucaoPeterson02.
   * Funcao: Esperar ate nao haver interesse na RC2.
   * Parametros: Nenhum.
   * Retorno: nenhum (void).
   *************************************************************** */
  public synchronized void solucaoPeterson02() {
    int outro;
    outro = 1 - processo;
    controlador.setInteressado02(processo, true);
    controlador.setTurno02(processo);
    while (controlador.getTurno02() == processo && controlador.getInteressado02(outro) == true) {
      try {
        wait(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

 public void sairRC1() throws InterruptedException{
  controlador.setInteressado01(processo, false);
 }

 public void sairRC2() throws InterruptedException{
  controlador.setInteressado02(processo, false);
 }

}