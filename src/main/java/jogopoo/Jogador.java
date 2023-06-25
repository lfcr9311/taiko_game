package jogopoo;

public class Jogador {
    private Mao maoJogador;
    private Arena arenaJogador;
    private int vida;
    public boolean jogou;

    public Jogador() {
        this.vida = 5;
        maoJogador = new Mao(this);
        arenaJogador = new Arena();
    }

    public Mao getMaoJogador() {
        return maoJogador;
    }

    public Arena getArenaJogador() {
        return arenaJogador;
    }

    public void setVida(int dano) {
        arenaJogador.getCarta().recebeDano(dano);
    }

    public int getVida() {
        return vida;
    }

    public void tiraVida() {
        this.vida--;
    }
    
    public void colocaNaArena(Carta card){
        if(arenaJogador.add(card))
        arenaJogador.getChildren().add(maoJogador.remove(card));
    }
}
