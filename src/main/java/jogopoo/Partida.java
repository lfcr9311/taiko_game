package jogopoo;

public class Partida {
    private Jogador jog1 = new Jogador();
    private Jogador jog2 = new Jogador();
    public boolean gameState;

    public Jogador getJog1() {
        return jog1;
    }

    public Jogador getJog2() {
        return jog2;
    }

    public boolean getGameState(){
        if (jog1.jogou && jog2.jogou)
        return true;
        else return false;
    }

    public void ataqueJogador1() {
        try {
            int dano = jog1.getArenaJogador().getCartaAtaque();
            jog2.setVida(dano);
            jog2.getArenaJogador().getCarta().atualizavida();
            
        } catch (Exception e) {
            
        }
    } 

    public void mataCarta2(){
        try {
            if (jog2.getArenaJogador().getCartaVida() <= 0) {
                jog2.getArenaJogador().removeCarta();
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void mataCarta1(){
        try {
            if (jog2.getArenaJogador().getCartaVida() <= 0) {
                jog2.getArenaJogador().removeCarta();
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void ataqueJogador2() {
        try {
            int dano = jog2.getArenaJogador().getCartaAtaque();
            jog1.setVida(dano);
            if (jog1.getArenaJogador().getCartaVida() <= 0) {
                jog1.getArenaJogador().removeCarta();
                return;
            }
            jog1.getArenaJogador().getCarta().atualizavida();
            
        } catch (Exception e) {
            
        }
    }
}