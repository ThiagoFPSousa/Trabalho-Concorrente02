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

package controller;// Declaracao do pacote 'controller' ao qual pertence a classe 'EscolhaDirecao'.

//Importacoes Necessarias.
import java.io.IOException;// Importacao necessaria para lidar com excecoes de entrada/saida (IO).
import java.net.URL;// Importacao necessaria para trabalhar com URLs, que podem ser uteis para carregar recursos ou interagir com a internet.
import java.util.ResourceBundle;// Importacao necessaria para trabalhar com pacotes de recursos (resource bundles), que sao usados para internacionalizar aplicativos.
import javafx.event.ActionEvent;// Importacao para a classe 'ActionEvent' do JavaFX, usada para lidar com eventos de açao, como cliques de botao.
import javafx.fxml.FXML;// Importacao para a anotacao 'FXML', usada para injetar elementos do arquivo FXML no codigo Java.
import javafx.fxml.Initializable;// Importacao para a interface 'Initializable', que requer a implementação de um metodo 'initialize'.
import javafx.scene.control.Button;// Importacao para a classe 'Button' do JavaFX, usada para criar botoes clicaveis.
import javafx.scene.control.RadioButton;// Importacao para a classe 'RadioButton' do JavaFX, usada para criar botaes de opcao.
import javafx.scene.control.ToggleGroup;// Importacao para a classe 'ToggleGroup' do JavaFX, usada para agrupar botoes de opcao, de modo que apenas um deles possa ser selecionado de cada vez.
import javafx.scene.control.Label;// Importacao para a classe 'Label' do JavaFX, usada para exibir texto ou rotulos em uma interface grafica.
import javafx.scene.image.ImageView;// Importacao para a classe 'ImageView' do JavaFX, usada para exibir imagens em uma interface grafica.
import javafx.scene.layout.AnchorPane;// Importacao para a classe 'AnchorPane' do JavaFX, que e um layout que permite ancorar elementos de interface em relacao a bordas ou outros elementos.
import threads.ThreadTrem1;// Importando a classe de thread ThreadTrem1.
import threads.ThreadTrem2;// Importando a classe de thread ThreadTrem2.

public class EscolhaDirecao implements Initializable {// Declaracao da classe "EscolhaDirecao" que implementa o metodo "initialize". Declaracao dos elementos da interface grafica mapeados a partir do arquivo FXML.

  // Paineis (AnchorPane).
  @FXML // Marcador FXML.
  private AnchorPane anchorPaneDirecao;// Escolha de Direcoes.
  @FXML // Marcador FXML.
  private AnchorPane anchorPanePrincipal;// Tela Principal.
  @FXML // Marcador FXML.
  private AnchorPane anchorPaneStatusTrens;// Status das velocidades dos trens.
  @FXML // Marcador FXML.
  private AnchorPane anchorPaneVelocidade;// Escolha das Velocidades dos trens.
  @FXML // Marcador FXML.
  private AnchorPane anchorPaneSolucao;// Escolha Solucao.

  // Imagens.
  @FXML // Marcador FXML.
  private ImageView background;// Background Principal.
  @FXML // Marcador FXML.
  private ImageView backgroundDirecao;// Background da escolha de Direcoes.
  @FXML // Marcador FXML.
  private ImageView trem1;// Trem 1.
  @FXML // Marcador FXML.
  private ImageView trem2;// Trem 2.
  @FXML // Marcador FXML.
  private ImageView trilho;// Trilho.

  // Rotulos (Labels)
  @FXML // Marcador FXML.
  private Label brinqueDeTrem;// Rotulo principal com nome do programa.
  @FXML // Marcador FXML.
  private Label direcaoDePartida;// Rotulo da direcao de partida.
  @FXML // Marcador FXML.
  private Label escolhaUmaSolucao; // Rotulo da escolha de solucao.
  @FXML // Marcador FXML.
  private Label status0Trem1;// Rotulo do status de 0Km/h do trem 1.
  @FXML // Marcador FXML.
  private Label status25Trem1;// Rotulo do status de 25Km/h do trem 1.
  @FXML // Marcador FXML.
  private Label status50Trem1;// Rotulo do status de 50Km/h do trem 1.
  @FXML // Marcador FXML.
  private Label status75Trem1;// Rotulo do status de 75Km/h do trem 1.
  @FXML // Marcador FXML.
  private Label status100Trem1;// Rotulo do status de 100Km/h do trem 1.
  @FXML // Marcador FXML.
  private Label status0Trem2;// Rotulo do status de 0Km/h do trem 2.
  @FXML // Marcador FXML.
  private Label status25Trem2;// Rotulo do status de 25Km/h do trem 2.
  @FXML // Marcador FXML.
  private Label status50Trem2;// Rotulo do status de 50Km/h do trem 2.
  @FXML // Marcador FXML.
  private Label status75Trem2;// Rotulo do status de 75Km/h do trem 2.
  @FXML // Marcador FXML.
  private Label status100Trem2;// Rotulo do status de 100Km/h do trem 2.
  @FXML // Marcador FXML.
  private Label velocidadeTrem1;// Rotulo de velocidade do trem 1.
  @FXML // Marcador FXML.
  private Label velocidadeTrem2;// Rotulo de velocidade do trem 2.

  // Grupos de alternancia (ToggleGroups) para os botoes de selecao.
  @FXML // Marcador FXML.
  private ToggleGroup toggleGroup;// Alternancia dos botoes de selecao de direcao.
  @FXML // Marcador FXML.
  private ToggleGroup toggleGroupv1;// Alternancia dos botoes de selecao de velocidade do trem 1.
  @FXML // Marcador FXML.
  private ToggleGroup toggleGroupv2;// Alternancia dos botoes de selecao de velocidade do trem 2.

  // Botões de selecao.
  @FXML // Marcador FXML.
  public RadioButton btnAlternadoI;// Para Alternado I.
  @FXML // Marcador FXML.
  public RadioButton btnAlternadoII;// Para Alternado II.
  @FXML // Marcador FXML.
  public RadioButton btnInferior;// Para Inferior.
  @FXML // Marcador FXML.
  public RadioButton btnSuperior;// Para Superior.
  @FXML // Marcador FXML.
  public RadioButton t1Velocidade0;// Para Velocidade 0 do trem 1.
  @FXML // Marcador FXML.
  public RadioButton t1Velocidade25;// Para Velocidade 25 do trem 1.
  @FXML // Marcador FXML.
  public RadioButton t1Velocidade50;// Para Velocidade 50 do trem 1.
  @FXML // Marcador FXML.
  public RadioButton t1Velocidade75;// Para Velocidade 75 do trem 1.
  @FXML // Marcador FXML.
  public RadioButton t1Velocidade100;// Para Velocidade 100 do trem 1.
  @FXML // Marcador FXML.
  public RadioButton t2Velocidade0;// Para Velocidade 0 do trem 2.
  @FXML // Marcador FXML.
  public RadioButton t2Velocidade25;// Para Velocidade 25 do trem 2.
  @FXML // Marcador FXML.
  public RadioButton t2Velocidade50;// Para Velocidade 50 do trem 2.
  @FXML // Marcador FXML.
  public RadioButton t2Velocidade75;// Para Velocidade 75 do trem 2.
  @FXML // Marcador FXML.
  public RadioButton t2Velocidade100;// Para Velocidade 100 do trem 2.

  // Botoes
  @FXML // Marcador FXML.
  public Button btnComecar;// Para comecar o programa.
  @FXML // Marcador FXML.
  public Button btnIniciar;// Para iniciar a animacao.
  @FXML // Marcador FXML.
  public Button btnResetar;// Para resetar a animacao do ponto inicial.
  @FXML // Marcador FXML.
  private Button btnSolucaoDePeterson; // Para escolher solucao de Peterson.
  @FXML // Marcador FXML.
  private Button btnEstritaAlternancia; // Para escolher solucao de Estrita Alternancia.
  @FXML // Marcador FXML.
  private Button btnVariavelDeTravamento; // Para escolher solucao Variavel de Travamento.

  //Atributos
  private ThreadTrem1 threadTrem1; //Para Thread do Trem1.
  private ThreadTrem2 threadTrem2; //Para Thread do Trem2.

  int op; // Para definir a solucao.

  //Atributos para a solucao de Variavel de Travamento.
  public static int VT1;
  public static int VT2;

  //Atributos para a solucao de Estrita Alternancia.
  public static int VEZ1 = 1;
  public static int VEZ2 = 1;

  //Atributos para a solucao de Peterson.
  public int turno01;
  public boolean interessado01[] = { false, false };
  public int turno02;
  public boolean interessado02[] = { false, false };
  
   /* ***************************************************************
   * Metodo: initialize
   * Funcao: Inicializa a interface, define a visibilidade inicial dos elementos e instancia as threads.
   * Parametros: location (URL do local do arquivo de FXML), resources (Pacote de recursos).
   * Retorno: nenhum (void).
   *************************************************************** */
  @Override // Indica que o método a seguir está sendo sobrescrito.
  public void initialize(URL location, ResourceBundle resources) {
    anchorPanePrincipal.setVisible(true);// Define o painel principal como visivel.
    anchorPaneDirecao.setVisible(false);// Define o painel de direcao como invisivel.
    anchorPaneVelocidade.setVisible(false);// Define o painel de velocidade como invisivel.
    anchorPaneStatusTrens.setVisible(false);// Define o painel de status dos trens como invisivel.
    anchorPaneSolucao.setVisible(false);// Define o painel de solucao como invisivel.

    direcaoDePartida.setVisible(false);// Define o label de direcao de partida como invisivel.
    escolhaUmaSolucao.setVisible(false);// Define o label de escolha de solucao como invisivel.

    trilho.setVisible(false);// Define o trilho como invisivel.
    trem1.setVisible(false);// Define o trem 1 como invisivel.
    trem2.setVisible(false);// Define o trem 2 principal como invisivel.

    btnIniciar.setVisible(false);// Define o botao 'Iniciar' como invisivel.

    threadTrem1 = new ThreadTrem1(this, trem1);// Instancia ThreadTrem1.
    threadTrem2 = new ThreadTrem2(this, trem2);// Instancia ThreadTrem2.
  }
  
   /* ***************************************************************
   * Metodo: clickOnComecar
   * Funcao: Responde ao clique no botao "Começar", exibindo elementos
   * relacionados a escolha de direcao.
   * Parametros: event (O evento de clique do mouse que acionou o metodo).
   * Retorno: Nenhum (void).
   *************************************************************** */
  @FXML // Marcador FXML.
  void clickOnComecar(ActionEvent event) throws IOException {
    anchorPaneDirecao.setVisible(true);// Torna o painel de direcao visivel.
    direcaoDePartida.setVisible(true);// Torna a label de direcao de partida visivel.

    trilho.setVisible(true);// Torna o componente de trilho visivel.

    btnComecar.setVisible(false);// Torna o botao "Começar" invisivel.
  }
  
   /* ***************************************************************
   * Metodo: onClickbtnAlternadoI
   * Funcao: Acao ao selecionar a direcao "Alternado I". Posiciona os trens e configura botoes.
   * Parametros: event (O evento de clique do mouse que acionou o metodo).
   * Retorno: Nenhum (void).
   *************************************************************** */
  @FXML // Marcador FXML.
  void onClickbtnAlternadoI(ActionEvent event) throws IOException {
    trem1.setVisible(true);// Torna o trem1 visivel.
    trem1.setRotate(90);// Define sua rotacao.
    trem1.setLayoutX(21);// Define posicao em X.
    trem1.setLayoutY(0);// Define posicao em Y.

    trem2.setVisible(true);// Torna o trem2 visivel.
    trem2.setRotate(-90);// Define sua rotacao.
    trem2.setLayoutX(122);// Define posicao em X.
    trem2.setLayoutY(402);// Define posicao em Y.

    btnIniciar.setVisible(true);// Torna o botao "Iniciar" visivel.
    btnComecar.setVisible(false);// Torna o botao "Comecar" invisivel.
  }
  
   /* ***************************************************************
   * Metodo: onClickbtnAlternadoII
   * Funcao: Acao ao selecionar a direcao "Alternado II". Posiciona os trens e configura botoes.
   * Parametros: event (O evento de clique do mouse que acionou o metodo).
   * Retorno: Nenhum (void).
   *************************************************************** */
  @FXML // Marcador FXML.
  void onClickbtnAlternadoII(ActionEvent event) throws IOException {
    trem1.setVisible(true);// Torna o trem1 visivel.
    trem1.setRotate(-90);// Define sua rotacao.
    trem1.setLayoutX(21);// Define posicao em X.
    trem1.setLayoutY(402);// Define posicao em Y.

    trem2.setVisible(true);// Torna o trem2 visivel.
    trem2.setRotate(90);// Define sua rotacao.
    trem2.setLayoutX(122);// Define posicao em X.
    trem2.setLayoutY(0);// Define posicao em Y.

    btnIniciar.setVisible(true);// Torna o botao "Iniciar" visivel.
    btnComecar.setVisible(false);// Torna o botao "Comecar" invisivel.
  }
  
   /* ***************************************************************
   * Metodo: onClickbtnInferior
   * Funcao: Acao ao selecionar a direcao "Inferior". Posiciona os trens e configura botoes.
   * Parametros: event (O evento de clique do mouse que acionou o metodo).
   * Retorno: Nenhum (void).
   *************************************************************** */
  @FXML // Marcador FXML.
  void onClickbtnInferior(ActionEvent event) throws IOException {
    trem1.setVisible(true);// Torna o trem1 visivel.
    trem1.setRotate(-90);// Define sua rotacao.
    trem1.setLayoutX(21);// Define posicao em X.
    trem1.setLayoutY(402);// Define posicao em Y.

    trem2.setVisible(true);// Torna o trem2 visivel.
    trem2.setRotate(-90);// Define sua rotacao.
    trem2.setLayoutX(122);// Define posicao em X.
    trem2.setLayoutY(402);// Define posicao em Y.

    btnIniciar.setVisible(true);// Torna o botao "Iniciar" visivel.
    btnComecar.setVisible(false);// Torna o botao "Comecar" invisivel.
  }
  
   /* ***************************************************************
   * Metodo: onClickbtnSuperior
   * Funcao: Acao ao selecionar a direcao "Superior". Posiciona os trens e configura botoes.
   * Parametros: event (O evento de clique do mouse que acionou o metodo).
   * Retorno: Nenhum (void).
   *************************************************************** */
  @FXML // Marcador FXML.
  void onClickbtnSuperior(ActionEvent event) throws IOException {
    trem1.setVisible(true);// Torna o trem1 visivel.
    trem1.setRotate(90);// Define sua rotacao.
    trem1.setLayoutX(21);// Define posicao em X.
    trem1.setLayoutY(0);// Define posicao em Y.

    trem2.setVisible(true);// Torna o trem2 visivel.
    trem2.setRotate(90);// Define sua rotacao.
    trem2.setLayoutX(122);// Define posicao em X.
    trem2.setLayoutY(0);// Define posicao em Y.

    btnIniciar.setVisible(true);// Torna o botao "Iniciar" visivel.
    btnComecar.setVisible(false);// Torna o botao "Comecar" invisivel.
  }

   /* ***************************************************************
   * Metodo: onClickbtnIniciar
   * Funcao: Da acesso ao painel de solucao.
   * Parametros: event (O evento de clique do mouse que acionou o metodo).
   * Retorno: Nenhum (void).
   *************************************************************** */
  @FXML // Marcador FXML.
  void onClickbtnIniciar(ActionEvent event) throws IOException {
    direcaoDePartida.setVisible(false);// Oculta a label de direcao de partida.
    anchorPaneDirecao.setVisible(false);// Oculta o label de painel de direcao.
    anchorPaneSolucao.setVisible(true);// Torna visivel o painel de solucao.

    escolhaUmaSolucao.setVisible(true);// Define o label de escolha de solucao como visivel.

    btnIniciar.setVisible(false); // Torna o botão "Iniciar" invisivel.
  }

  /* ***************************************************************
   * Metodo: onClickbtnVariavelDeTravamento.
   * Funcao: Definir op = 1, que equivale a solucao de variavel de travamento.
   * Parametros: event (O evento de clique do mouse que acionou o metodo).
   * Retorno: Nenhum (void).
   *************************************************************** */
  @FXML
  void onClickbtnVariavelDeTravamento(ActionEvent event) {
  	setOp(1);// Define a solucao como 1 (Variavel De Travamento).

  	anchorPaneSolucao.setVisible(false);// Oculta painel de solucao.
  	escolhaUmaSolucao.setVisible(false);// Define o label de escolha de solucao como invisivel.

    anchorPaneVelocidade.setVisible(true);// Torna o painel de velocidade visivel.

    anchorPaneStatusTrens.setVisible(true);// Torna o painel de status dos trens visivel.
    
    // Define a visibilidade inicial dos status dos trens.(status 100km/h para trem 1 e trem 2).
    status0Trem1.setVisible(false);
    status25Trem1.setVisible(false);
    status50Trem1.setVisible(false);
    status75Trem1.setVisible(false);
    status100Trem1.setVisible(true);
    status0Trem2.setVisible(false);
    status25Trem2.setVisible(false);
    status50Trem2.setVisible(false);
    status75Trem2.setVisible(false);
    status100Trem2.setVisible(true);

    t1Velocidade100.setSelected(true);// Define a velocidade inicial 100 selecionada para o trem 1.
    t2Velocidade100.setSelected(true);// Define a velocidade inicial 100 selecionada para o trem 2.

    threadTrem1.start();// inicia a ThreadTrem1.
    threadTrem2.start();// inicia a ThreadTrem2.
  }

  /* ***************************************************************
   * Metodo: onClickbtnEstritaAlternancia
   * Funcao: Definir op = 2, que equivale a solucao de estrita alternancia.
   * Parametros: event (O evento de clique do mouse que acionou o metodo).
   * Retorno: Nenhum (void).
   *************************************************************** */
  @FXML
  void onClickbtnEstritaAlternancia(ActionEvent event) {
  	setOp(2);// Define a solucao como 2 (Estrita Alternancia).

  	anchorPaneSolucao.setVisible(false);// Oculta painel de solucao.
  	escolhaUmaSolucao.setVisible(false);// Define o label de escolha de solucao como invisivel.

    anchorPaneVelocidade.setVisible(true);// Torna o painel de velocidade visivel.

    anchorPaneStatusTrens.setVisible(true);// Torna o painel de status dos trens visivel.

    // Define a visibilidade inicial dos status dos trens.(status 100km/h para trem 1 e trem 2).
    status0Trem1.setVisible(false);
    status25Trem1.setVisible(false);
    status50Trem1.setVisible(false);
    status75Trem1.setVisible(false);
    status100Trem1.setVisible(true);
    status0Trem2.setVisible(false);
    status25Trem2.setVisible(false);
    status50Trem2.setVisible(false);
    status75Trem2.setVisible(false);
    status100Trem2.setVisible(true);

    t1Velocidade100.setSelected(true);// Define a velocidade inicial 100 selecionada para o trem 1
    t2Velocidade100.setSelected(true);// Define a velocidade inicial 100 selecionada para o trem 2

    threadTrem1.start();// inicia a ThreadTrem1.
    threadTrem2.start();// inicia a ThreadTrem2.
  }

  /* ***************************************************************
   * Metodo: onClickbtnSolucaoDePeterson
   * Funcao: Definir op = 3, que equivale a solucao de Peterson.
   * Parametros: event (O evento de clique do mouse que acionou o metodo).
   * Retorno: Nenhum (void).
   *************************************************************** */
  @FXML
  void onClickbtnSolucaoDePeterson(ActionEvent event) {
  	setOp(3);// Define a solucao como 3 (Solucao de Peterson).

  	anchorPaneSolucao.setVisible(false);// Oculta painel de solucao.
  	escolhaUmaSolucao.setVisible(false);// Define o label de escolha de solucao como invisivel.

    anchorPaneVelocidade.setVisible(true);// Torna o painel de velocidade visivel.

    anchorPaneStatusTrens.setVisible(true);// Torna o painel de status dos trens visivel.

    // Define a visibilidade inicial dos status dos trens.(status 100km/h para trem 1 e trem 2).
    status0Trem1.setVisible(false);
    status25Trem1.setVisible(false);
    status50Trem1.setVisible(false);
    status75Trem1.setVisible(false);
    status100Trem1.setVisible(true);
    status0Trem2.setVisible(false);
    status25Trem2.setVisible(false);
    status50Trem2.setVisible(false);
    status75Trem2.setVisible(false);
    status100Trem2.setVisible(true);

    t1Velocidade100.setSelected(true);// Define a velocidade inicial 100 selecionada para o trem 1
    t2Velocidade100.setSelected(true);// Define a velocidade inicial 100 selecionada para o trem 2

    threadTrem1.start();// inicia a ThreadTrem1.
    threadTrem2.start();// inicia a ThreadTrem2.
  }
  
   /* ***************************************************************
   * Metodo: clickOnT1Velocidade0
   * Funcao: Acao de pausar ao selecionar a velocidade 0 para o trem 1.
   * Parametros: event (O evento de clique do mouse que acionou o metodo).
   * Retorno: Nenhum (void).
   *************************************************************** */
  @FXML // Marcador FXML.
  void clickOnT1Velocidade0(ActionEvent event) throws IOException {
    // Mostra o status correspondente ao trem 1 com velocidade 0(PARADO).
    status0Trem1.setVisible(true);
    status25Trem1.setVisible(false);
    status50Trem1.setVisible(false);
    status75Trem1.setVisible(false);
    status100Trem1.setVisible(false);
    threadTrem1.pararTrem1();// Pausa a animacao do trem 1.
  }
  
   /* ***************************************************************
   * Metodo: clickOnT1Velocidade25
   * Funcao: Acao de 25Km/h ao selecionar a velocidade 25 para o trem 1.
   * Parametros: event (O evento de clique do mouse que acionou o metodo).
   * Retorno: Nenhum (void).
   *************************************************************** */
  @FXML // Marcador FXML.
  void clickOnT1Velocidade25(ActionEvent event) throws IOException {
    // Mostra o status correspondente ao trem 1 com velocidade 25.
    status0Trem1.setVisible(false);
    status25Trem1.setVisible(true);
    status50Trem1.setVisible(false);
    status75Trem1.setVisible(false);
    status100Trem1.setVisible(false);
    threadTrem1.mudarVelocidadeTrem1(0.25);//mudar velocidade.
  }

   /* ***************************************************************
   * Metodo: clickOnT1Velocidade50
   * Funcao: Acao de 50Km/h ao selecionar a velocidade 50 para o trem 1.
   * Parametros: event (O evento de clique do mouse que acionou o metodo).
   * Retorno: Nenhum (void).
   *************************************************************** */
  @FXML // Marcador FXML.
  void clickOnT1Velocidade50(ActionEvent event) throws IOException {
    // Mostra o status correspondente ao trem 1 com velocidade 50.
    status0Trem1.setVisible(false);
    status25Trem1.setVisible(false);
    status50Trem1.setVisible(true);
    status75Trem1.setVisible(false);
    status100Trem1.setVisible(false);
    threadTrem1.mudarVelocidadeTrem1(0.5);//mudar velocidade.
  }

   /* ***************************************************************
   * Metodo: clickOnT1Velocidade75
   * Funcao: Acao de 75Km/h ao selecionar a velocidade 75 para o trem 1.
   * Parametros: event (O evento de clique do mouse que acionou o metodo).
   * Retorno: Nenhum (void).
   *************************************************************** */
  @FXML // Marcador FXML.
  void clickOnT1Velocidade75(ActionEvent event) throws IOException {
    // Mostra o status correspondente ao trem 1 com velocidade 75.
    status0Trem1.setVisible(false);
    status25Trem1.setVisible(false);
    status50Trem1.setVisible(false);
    status75Trem1.setVisible(true);
    status100Trem1.setVisible(false);
    threadTrem1.mudarVelocidadeTrem1(0.75);//mudar velocidade.
  }
  
   /* ***************************************************************
   * Metodo: clickOnT1Velocidade100
   * Funcao: Acao de 100Km/h ao selecionar a velocidade 100 para o trem 1.
   * Parametros: event (O evento de clique do mouse que acionou o metodo).
   * Retorno: Nenhum (void).
   *************************************************************** */
  @FXML // Marcador FXML.
  void clickOnT1Velocidade100(ActionEvent event) throws IOException {
    // Mostra o status correspondente ao trem 1 com velocidade 100.
    status0Trem1.setVisible(false);
    status25Trem1.setVisible(false);
    status50Trem1.setVisible(false);
    status75Trem1.setVisible(false);
    status100Trem1.setVisible(true);
    threadTrem1.mudarVelocidadeTrem1(1);//mudar velocidade.
  }
  
   /* ***************************************************************
   * Metodo: clickOnT2Velocidade0
   * Funcao: Acao de pausar ao selecionar a velocidade 0 para o trem 2.
   * Parametros: event (O evento de clique do mouse que acionou o metodo).
   * Retorno: Nenhum (void).
   *************************************************************** */
  @FXML // Marcador FXML.
  void clickOnT2Velocidade0(ActionEvent event) throws IOException {
    // Mostra o status correspondente ao trem 2 com velocidade 0(PARADO).
    status0Trem2.setVisible(true);
    status25Trem2.setVisible(false);
    status50Trem2.setVisible(false);
    status75Trem2.setVisible(false);
    status100Trem2.setVisible(false);
    threadTrem2.pararTrem2();// Pausa a animacao do trem 2.
  }

   /* ***************************************************************
   * Metodo: clickOnT2Velocidade25
   * Funcao: Acao de 25Km/h ao selecionar a velocidade 25 para o trem 2.
   * Parametros: event (O evento de clique do mouse que acionou o metodo).
   * Retorno: Nenhum (void).
   *************************************************************** */
  @FXML // Marcador FXML.
  void clickOnT2Velocidade25(ActionEvent event) throws IOException {
    // Mostra o status correspondente ao trem 2 com velocidade 25.
    status0Trem2.setVisible(false);
    status25Trem2.setVisible(true);
    status50Trem2.setVisible(false);
    status75Trem2.setVisible(false);
    status100Trem2.setVisible(false);
    threadTrem2.mudarVelocidadeTrem2(0.25);//mudar velocidade.
  }

   /* ***************************************************************
   * Metodo: clickOnT2Velocidade50
   * Funcao: Acao de 50Km/h ao selecionar a velocidade 50 para o trem 2.
   * Parametros: event (O evento de clique do mouse que acionou o metodo).
   * Retorno: Nenhum (void).
   *************************************************************** */
  @FXML // Marcador FXML.
  void clickOnT2Velocidade50(ActionEvent event) throws IOException {
    // Mostra o status correspondente ao trem 2 com velocidade 50.
    status0Trem2.setVisible(false);
    status25Trem2.setVisible(false);
    status50Trem2.setVisible(true);
    status75Trem2.setVisible(false);
    status100Trem2.setVisible(false);
    threadTrem2.mudarVelocidadeTrem2(0.5);//mudar velocidade.
  }
  
   /* ***************************************************************
   * Metodo: clickOnT2Velocidade75
   * Funcao: Acao de 75Km/h ao selecionar a velocidade 75 para o trem 2.
   * Parametros: event (O evento de clique do mouse que acionou o metodo).
   * Retorno: Nenhum (void).
   *************************************************************** */
  @FXML // Marcador FXML.
  void clickOnT2Velocidade75(ActionEvent event) throws IOException {
    // Mostra o status correspondente ao trem 2 com velocidade 75.
    status0Trem2.setVisible(false);
    status25Trem2.setVisible(false);
    status50Trem2.setVisible(false);
    status75Trem2.setVisible(true);
    status100Trem2.setVisible(false);
    threadTrem2.mudarVelocidadeTrem2(0.75);//mudar velocidade.
  }
  
   /* ***************************************************************
   * Metodo: clickOnT2Velocidade100
   * Funcao: Acao de 100Km/h ao selecionar a velocidade 100 para o trem 2.
   * Parametros: event (O evento de clique do mouse que acionou o metodo).
   * Retorno: Nenhum (void).
   *************************************************************** */
  @FXML // Marcador FXML.
  void clickOnT2Velocidade100(ActionEvent event) throws IOException {
    // Mostra o status correspondente ao trem 2 com velocidade 100.
    status0Trem2.setVisible(false);
    status25Trem2.setVisible(false);
    status50Trem2.setVisible(false);
    status75Trem2.setVisible(false);
    status100Trem2.setVisible(true);
    threadTrem2.mudarVelocidadeTrem2(1);//mudar velocidade.
  }

   /* ***************************************************************
   * Metodo: clickOnBtnResetar
   * Funcao: Reinicia a simulacao, redefinindo animacoes, velocidades e estados iniciais dos trens.
   * Parametros: event (O evento de clique do mouse que acionou o metodo).
   * Retorno: Nenhum (void).
   *************************************************************** */
  @FXML // Marcador FXML.
  void clickOnBtnResetar(ActionEvent event) throws IOException {

    threadTrem1.resetarTrem1();// reseta posicao e para o trem1.
    threadTrem2.resetarTrem2();// reseta posicao e para o trem2.

    // Define a velocidade 0 para ambos os trens.
    t1Velocidade0.setSelected(true);
    t2Velocidade0.setSelected(true);

    // Define o status de velocidade inicial do trem 1(PARADO).
    status0Trem1.setVisible(true);
    status25Trem1.setVisible(false);
    status50Trem1.setVisible(false);
    status75Trem1.setVisible(false);
    status100Trem1.setVisible(false);
    // Define o status de velocidade inicial do trem 2(PARADO).
    status0Trem2.setVisible(true);
    status25Trem2.setVisible(false);
    status50Trem2.setVisible(false);
    status75Trem2.setVisible(false);
    status100Trem2.setVisible(false);
  }

  /* ***************************************************************
   * Metodo: close.
   * Funcao: Encerrar Threads.
   * Parametros: Nenhum.
   * Retorno: Nenhum (void).
   *************************************************************** */
  public void close() {
    System.exit(0);
  }

  /* ***************************************************************
   * Metodo: getOp
   * Funcao: Retornar variavel op.
   * Parametros: Nenhum.
   * Retorno: int op.
   *************************************************************** */
  public int getOp() {
	return op;
  }

  /* ***************************************************************
   * Metodo: setOp.
   * Funcao: Alterar valor de op.
   * Parametros: int op.
   * Retorno: Nenhum (void).
   *************************************************************** */
  public void setOp(int op){
  	this.op = op;
  }  

//-------------------------------------Metodos para ESTRITA ALTERNANCIA--------------------------------------//
  
  /* ***************************************************************
   * Metodo: passarVEZ1.
   * Funcao: alterar valor de VEZ1.
   * Parametros: int valor.
   * Retorno: Nenhum (void).
   *************************************************************** */
  public void passarVEZ1(int valor) {
    VEZ1 = valor;
  }

  /* ***************************************************************
   * Metodo: passarVEZ2.
   * Funcao: alterar valor de VEZ2.
   * Parametros: int valor.
   * Retorno: Nenhum (void).
   *************************************************************** */
  public void passarVEZ2(int valor) {
    VEZ2 = valor;
  }

  /* ***************************************************************
   * Metodo: getVEZ1.
   * Funcao: retornar valor de VEZ1.
   * Parametros: Nenhum.
   * Retorno: VEZ1.
   *************************************************************** */
  public static int getVEZ1() {
    return VEZ1;
  }

  /* ***************************************************************
   * Metodo: getVEZ2.
   * Funcao: retornar valor de VEZ2.
   * Parametros: Nenhum.
   * Retorno: VEZ2.
   *************************************************************** */
  public static int getVEZ2() {
    return VEZ2;
  }

//------------------------------------Metodos para SOLUCAO DE PETERSON------------------------------------//
  
  /* ***************************************************************
   * Metodo: setInteressado01.
   * Funcao: alterar interessado01[].
   * Parametros: int n , boolean modo.
   * Retorno: Nenhum (void).
   *************************************************************** */
  public void setInteressado01(int n, boolean modo) {
    this.interessado01[n] = modo;
  }

  /* ***************************************************************
   * Metodo: getInteressado01.
   * Funcao: retornar valor de interessado01[].
   * Parametros: int n.
   * Retorno: interessado01[].
   *************************************************************** */
  public boolean getInteressado01(int n) {
    return this.interessado01[n];
  }

  /* ***************************************************************
   * Metodo: setTurno01.
   * Funcao: altera valor de turno01.
   * Parametros: int turno.
   * Retorno: Nenhum (void).
   *************************************************************** */
  public void setTurno01(int turno) {
    this.turno01 = turno;
  }

  /* ***************************************************************
   * Metodo: getTurno01.
   * Funcao: retornar valor de turno01.
   * Parametros: Nenhum.
   * Retorno: turno01.
   *************************************************************** */
  public int getTurno01() {
    return this.turno01;
  }

  /* ***************************************************************
   * Metodo: setInteressado02.
   * Funcao: alterar interessado02[].
   * Parametros: int n , boolean modo.
   * Retorno: Nenhum (void).
   *************************************************************** */
  public void setInteressado02(int n, boolean modo) {
    this.interessado01[n] = modo;
  }

  /* ***************************************************************
   * Metodo: getInteressado02.
   * Funcao: retornar valor de interessado02[].
   * Parametros: int n.
   * Retorno: interessado02[].
   *************************************************************** */
  public boolean getInteressado02(int n) {
    return this.interessado01[n];
  }
  
  /* ***************************************************************
   * Metodo: setTurno02.
   * Funcao: altera valor de turno02.
   * Parametros: int turno.
   * Retorno: Nenhum (void).
   *************************************************************** */
  public void setTurno02(int turno) {
    this.turno01 = turno;
  }

  /* ***************************************************************
   * Metodo: getTurno02.
   * Funcao: retornar valor de turno02.
   * Parametros: Nenhum.
   * Retorno: turno01.
   *************************************************************** */
  public int getTurno02() {
    return this.turno01;
  }
}