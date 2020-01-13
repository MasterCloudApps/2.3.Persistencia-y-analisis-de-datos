package es.urjc.code.mappedsuperclass;

import javax.persistence.Entity;

@Entity
public class Balonmanista extends Jugador {

    private String posicion;

    public Balonmanista() { }

    public Balonmanista(String nombre, String posicion) {
        super(nombre);
        this.posicion = posicion;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        String padre = super.toString();
        return padre + " Balonmanista{" +
                "posicion=" + posicion +
                '}';
    }
}
