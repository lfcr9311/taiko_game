package jogopoo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {
    private List<Carta> baralho = new ArrayList<>();
    
    public Baralho() {
        Carta assassino1 = new Carta(Tipo.Assassino);
        Carta assassino2 = new Carta(Tipo.Assassino);
        Carta tanke1 = new Carta(Tipo.Tank);
        Carta tanke2 = new Carta(Tipo.Tank);
        Carta guerreiro1 = new Carta(Tipo.Guerreiro);
        Carta guerreiro2 = new Carta(Tipo.Guerreiro);
        Carta mago1 = new Carta(Tipo.Mago);
        Carta mago2 = new Carta(Tipo.Mago);
        Carta suport1 = new Carta(Tipo.Support);
        Carta suport2 = new Carta(Tipo.Support);       
        
        baralho.add(assassino1);
        baralho.add(assassino2);
        baralho.add(tanke1);
        baralho.add(tanke2);
        baralho.add(guerreiro1);
        baralho.add(guerreiro2);
        baralho.add(mago1);
        baralho.add(mago2);
        baralho.add(suport1);
        baralho.add(suport2);
    }

    public Carta getCarta(int i) {
        return baralho.get(i);
    }

    public void embaralhar() {
        Collections.shuffle(baralho);
    }
}