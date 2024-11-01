package model;

public abstract class Arbitro extends Persona {
    public Arbitro(String nombre, int edad) {
        super(nombre, edad);
    }

    
    public String desplazarse() {
        return nombre + " se desplaza en la pista como árbitro.";
    }
}
