package jogopoo;

import javafx.scene.layout.VBox;

public class Arena extends VBox{
    private Carta ativa;

    public int getCartaAtaque() {
        return ativa.getAtaque();
    }

    public int getCartaVida() {
        return ativa.getVida();
    }

    public Carta getCarta() {
        if (ativa == null)
        return null;
        return ativa;
    }

    public boolean add(Carta card){
        if(ativa != null){
            return false;
        }else{
            ativa = card;
            return true;
        }
    }

    public void removeCarta(){
        getChildren().remove(ativa);
        ativa = null;
    }
}