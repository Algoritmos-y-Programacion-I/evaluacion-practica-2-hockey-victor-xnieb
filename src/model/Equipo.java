package model;

public class Equipo {

    private final int CANTIDAD_JUGADORES = 6;

    protected String nombreEquipo;

    private JugadorHockey[] jugadores;

    public Equipo(String nombre){
        jugadores = new JugadorHockey[CANTIDAD_JUGADORES];
        this.nombreEquipo = nombre;
    }

    public boolean agregarJugador(JugadorHockey jugador) {

        for (int i=0; i<jugadores.length; i++){
            if(jugadores[i]==null){
                jugadores[i] = jugador;
                return true;
            }
        }
        return false;

    }

    public JugadorHockey crearJugador(String nombre, int edad, Posicion posicion){
        JugadorHockey jugador = new JugadorHockey( nombre,  edad,  posicion);
        return jugador;
    }

    public JugadorHockey[] getJugadores() {
        return jugadores;
    }

    public String getNombreEquipo(){
        return nombreEquipo;
    }
}