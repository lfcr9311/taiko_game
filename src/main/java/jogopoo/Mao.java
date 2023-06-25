package jogopoo;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.HBox;

public class Mao extends HBox{
    private List<Carta> mao = new ArrayList<>();
    private Baralho baralho = new Baralho();
    private Jogador jogador;

    public Mao(Jogador jogador){
        fazerMao1(baralho);
        this.jogador = jogador;
    }

    public List<Carta> getMao() {
        return mao;
    }

    public Carta getCarta(Carta card){
        for (Carta carta : mao) {
            if(carta==card)
            return carta;
        }
        return null;
    }

    public Carta remove(Carta card){
        Carta retorna = getCarta(card);
        mao.remove(getCarta(card));
        this.getChildren().remove(retorna);
        return retorna;
    }
    
    public void addJogador1(Carta a) {
        mao.add(a);
    }

    public void removeJogador1(Carta c) {
        mao.remove(c);
    }

    public int tamanhoMao1() {
        return mao.size();
    }

    public List<Carta> fazerMao1(Baralho baralho) {
        baralho.embaralhar();
        for ( int i = 0; i < 5; i++) {
            Carta novaCarta = baralho.getCarta(i);
            novaCarta.setOnMouseClicked(e -> {
                jogador.colocaNaArena(novaCarta);
            });
            mao.add(novaCarta);
            this.getChildren().add(novaCarta);
        }
        return mao;
    }


}

