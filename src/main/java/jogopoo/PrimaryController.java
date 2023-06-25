package jogopoo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PrimaryController {

    private Partida partida = new Partida();

    @FXML 
    private ResourceBundle resources;

    @FXML 
    private URL location;

    @FXML 
    private VBox areabotaodir; 

    @FXML 
    private VBox areabotaoesq; 

    @FXML 
    private Button botaodir; 

    @FXML 
    private Button botaoesq; 

    @FXML 
    private BorderPane centro; 

    @FXML 
    private AnchorPane fundo; 

    private Arena arena1 = partida.getJog1().getArenaJogador();

    private Arena arena2 = partida.getJog2().getArenaJogador();

    private HBox mao = partida.getJog1().getMaoJogador();

    private HBox mao2 = partida.getJog2().getMaoJogador();

    @FXML 
    void initialize() throws FileNotFoundException {
        assert areabotaodir != null : "fx:id=\"areabotaodir\" was not injected: check your FXML file 'aa.fxml'.";
        assert areabotaoesq != null : "fx:id=\"areabotaoesq\" was not injected: check your FXML file 'aa.fxml'.";
        assert botaodir != null : "fx:id=\"botaodir\" was not injected: check your FXML file 'aa.fxml'.";
        assert botaoesq != null : "fx:id=\"botaoesq\" was not injected: check your FXML file 'aa.fxml'.";
        assert centro != null : "fx:id=\"centro\" was not injected: check your FXML file 'aa.fxml'.";
        assert fundo != null : "fx:id=\"fundo\" was not injected: check your FXML file 'aa.fxml'.";
        assert mao != null : "fx:id=\"mao\" was not injected: check your FXML file 'aa.fxml'.";
        assert mao2 != null : "fx:id=\"mao2\" was not injected: check your FXML file 'aa.fxml'.";
        

        fundo.getChildren().addAll(mao,mao2);
        constroiMao1();
        constroiMao2();
        constroiArena1();
        constroiArena2();

        FileInputStream file = new FileInputStream("src/main/java/jogopoo/imagens/fundo.png");
        Image imagem = new Image(file);
        BackgroundSize size = new BackgroundSize(1.0, 1.0, true, true, false, false);
        fundo.setBackground(new Background(new BackgroundImage(imagem, null, null, null, size)));

        botaodir.setText("PRONTO 1");
        botaodir.setOnAction(e -> {
            partida.getJog1().jogou = true;
            if(partida.getGameState()){
                partida.ataqueJogador2();
                partida.ataqueJogador1();
                partida.mataCarta1();
                partida.mataCarta2();
                partida.getJog2().jogou = false;
                partida.getJog1().jogou = false;
            } 
            if(mao2.getChildren().size()==0 && mao2.getChildren().size()==0 && partida.getJog2().getArenaJogador().getCarta() == null){
                System.out.println("Fim do jogo!\n Jogador 1 ganhou!");
                System.exit(1);
            }

            if(mao.getChildren().size()==0 && mao.getChildren().size()==0 && partida.getJog1().getArenaJogador().getCarta() == null){
                System.out.println("Fim do jogo!\n Jogador 1 ganhou!");
                System.exit(1);
            }
        });
    
        
        botaoesq.setText("PRONTO 2");
        botaoesq.setOnAction(e -> {
            partida.getJog2().jogou = true;
            if(partida.getGameState()){
                partida.ataqueJogador1();
                partida.ataqueJogador2();
                partida.mataCarta1();
                partida.mataCarta2();
                partida.getJog2().jogou = false;
                partida.getJog1().jogou = false;
            }
            if(mao2.getChildren().size()==0 && mao2.getChildren().size()==0 && partida.getJog2().getArenaJogador().getCarta() == null){
                System.out.println("Fim do jogo!\n Jogador 1 ganhou!");
                System.exit(1);
            }

            if(mao.getChildren().size()==0 && mao.getChildren().size()==0 && partida.getJog1().getArenaJogador().getCarta() == null){
                System.out.println("Fim do jogo!\n Jogador 1 ganhou!");
                System.exit(1);
            }
        });
    }       

    public void constroiMao1(){
        mao.setLayoutX(126);
        mao.setLayoutY(631);
        mao.minHeight(140);
        mao.minWidth(800);
        mao.prefHeight(140);
        mao.prefWidth(800);
        fundo.setBottomAnchor(mao, 5.0);
        fundo.setRightAnchor(mao, 200.0);
        fundo.setRightAnchor(mao, 200.0);
    }

    public void constroiMao2() {
        mao2.setLayoutX(400);
        mao2.setLayoutY(31);
        mao2.minHeight(140);
        mao2.minWidth(800);
        mao2.prefHeight(140);
        mao2.prefWidth(800);
        fundo.setTopAnchor(mao2, 5.0);
        fundo.setLeftAnchor(mao2, 200.0);
        fundo.setRightAnchor(mao2, 200.0);
    }

    public void constroiArena1() {
        arena1.setMinWidth(300);
        arena1.setMinHeight(150);
        centro.setBottom(arena1);
    }

    public void constroiArena2() {
        arena2.setMinWidth(300);
        arena2.setMinHeight(150);
        centro.setTop(arena2);
    }
}
