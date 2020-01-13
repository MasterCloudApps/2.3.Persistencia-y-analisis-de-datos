package es.urjc.code.single;

import javax.persistence.Entity;

@Entity
public class Golfista extends Jugador {

    private int handicap;

    public Golfista() { }

    public Golfista(String nombre, int handicap) {
        super(nombre);
        this.handicap = handicap;
    }

    public int getHandicap() {
        return handicap;
    }

    public void setHandicap(int handicap) {
        this.handicap = handicap;
    }

    @Override
    public String toString() {
        String padre = super.toString();
        return padre + " Golfista{" +
                "handicap=" + handicap +
                '}';
    }
}
