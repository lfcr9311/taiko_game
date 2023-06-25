package jogopoo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

public class Carta extends Pane{
    private int vida;
    private int ataque;
    private Label labelVida = new Label();
    private Label labelAtaque = new Label();
    
    public int getVida() {
        return vida;
    }
    
    public void setVida(int vida) {
        this.vida = vida;
        labelVida.setText(vida + "");
    }
    
    public int getAtaque() {
        return ataque;
    }
    
    public void setAtaque(int ataque) {
        this.ataque = ataque;
        labelAtaque.setText(ataque + "");
    }

    public void recebeDano(int dano){
        vida = vida - dano;
    }

    public BackgroundImage imagem(int i){
        try (FileInputStream file = new FileInputStream("src/main/java/jogopoo/imagens/" + i + ".png")) {
            Image imagem = new Image(file);
            BackgroundSize size = new BackgroundSize(1.0, 1.0, true, true, false, false);
            return new BackgroundImage(imagem, null, null, null, size);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Carta(Tipo tipo) {
        Random random = new Random();        
        int cont = random.nextInt(9);
        setMinHeight(120);
        setMinWidth(100);
        setMaxHeight(120);
        setMaxWidth(100);
        
        if (tipo == Tipo.Assassino) {
            this.vida = 5;
            this.ataque = 5;
        } else if (tipo == Tipo.Tank) {
            this.vida = 9;
            this.ataque = 2;
        } else if (tipo == Tipo.Support) {
            this.vida = 5;
            this.ataque = 3;
        } else if (tipo == Tipo.Guerreiro) {
            this.vida = 6;
            this.ataque = 6;
        } else if (tipo == Tipo.Mago){
            this.vida = 5;
            this.ataque = 3; 
        }

        labelVida.setText(this.vida + "");
        labelAtaque.setText(this.ataque + "");
        getChildren().add(labelAtaque);
        getChildren().add(labelVida);
        labelVida.setLayoutX(17);
        labelVida.setLayoutY(93);
        labelAtaque.setLayoutX(73);
        labelAtaque.setLayoutY(93);
        labelVida.setId("labelVida");
        labelAtaque.setId("labelAtaque");
        getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        setBackground(new Background(imagem(cont)));        
    }

    public int atualizavida(){
        labelVida.setText(vida + "");
        return vida;
    }
}

