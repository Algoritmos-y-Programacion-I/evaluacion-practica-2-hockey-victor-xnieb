package model;

public Arbitro implements Persona extends IDesplazarseEnPistaSinPalo {
    public Arbitro(String nombre, int edad) {
        super(nombre, edad);
    }

    public String desplazarse() {
        return nombre + " se desplaza en la pista como árbitro.";
    }
}
