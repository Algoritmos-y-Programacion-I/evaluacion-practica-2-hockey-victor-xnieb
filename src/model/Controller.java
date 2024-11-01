package model;

import java.util.Random;

public class Controller {

    private Equipo[] equipos;
    private Arbitro[] arbitros;

    private final int CANTIDAD_EQUIPOS = 4;
    private final int CANTIDAD_ARBITROS = 4;

    private int contadorEquipos = 0;

    /**
     * Constructor de la clase Controller para inicializar variables globales.
     *
     * @pre No se requieren precondiciones específicas.
     * @post Se crea una instancia de Controller con un arreglo de personas vacío.
     */
    public Controller() {
        equipos = new Equipo[CANTIDAD_EQUIPOS];
        arbitros = new Arbitro[CANTIDAD_ARBITROS];
    }

    public String fixture() {
        String fixture = "";
        Random random = new Random();
        int equipo1 = random.nextInt(4);
        int equipo2;
        do {
            equipo2 = random.nextInt(4);
        } while (equipo2 == equipo1);

        fixture += "Partido 1: Equipo " + equipo1 + " vs Equipo " + equipo2;
        fixture += "\n";

        do {
            equipo1 = random.nextInt(4);
            equipo2 = random.nextInt(4);
        } while (equipo2 == equipo1);

        fixture += "Partido 2: Equipo " + equipo1 + " vs Equipo " + equipo2;
        return fixture;
    }


    public Equipo crearEquipo(String nombre){
        Equipo equipo = new Equipo(nombre);
        return equipo;
    }

    public boolean anadirEquipo(Equipo equipo){
        for(int i=0; i<equipos.length; i++){
            if(equipos[i]==null){
                equipos[i] = equipo;
                return true;
            }
        }
        return false;
    
    }



    public boolean crearJugadorHockey( Equipo equipo, String nombre, int edad, Posicion posicion){

        return equipo.agregarJugador(equipo.crearJugador( nombre, edad, posicion));

    }


    public boolean anadirArbitro(Arbitro arbitro){
        for (int i=0; i<arbitros.length;i++){
            if(arbitros[i]==null){
                arbitros[i] = arbitro;
                return true;
            }
        }
        return false;
    }

    public Arbitro crearArbitroPrincipal(String nombre, int edad){

        Arbitro arbitro = new ArbitroPrincipal(nombre,edad);
        return arbitro;

    }

    public Arbitro crearJuezLinea(String nombre, int edad){

        Arbitro arbitro = new JuezDeLinea( nombre,  edad);
        return arbitro;

    }


    public void precargarInformacion(){

        Equipo equipo1 = crearEquipo("Equipo 1");
        anadirEquipo(equipo1);
        crearJugadorHockey(equipo1, "Jugador 1", 27, Posicion.PORTERO);
        crearJugadorHockey(equipo1, "Jugador 2", 27, Posicion.DEFENSA);
        crearJugadorHockey(equipo1, "Jugador 3", 27, Posicion.ALA);
        crearJugadorHockey(equipo1, "Jugador 4", 27, Posicion.ALA);
        crearJugadorHockey(equipo1, "Jugador 5", 27, Posicion.DEFENSA);
        crearJugadorHockey(equipo1, "Jugador 6", 27, Posicion.CENTRO);

        Arbitro arbitro1 = crearArbitroPrincipal("Arbitro 1", 22);
        anadirArbitro(arbitro1);
        Arbitro arbitro2 = crearArbitroPrincipal("Arbitro 2", 22);
        anadirArbitro(arbitro2);
        Arbitro juez1 = crearJuezLinea("Juez 1", 22);
        anadirArbitro(juez1);
        Arbitro juez2 = crearJuezLinea("Juez 2", 22);
        anadirArbitro(juez2);

    }

    /*public String simularPartido(){
        String message = "";
        for(int i=0; i<equipos.length; i++){
            if(equipos[i]!=null){

                for(int j=0; i<equipos[i].getJugadores[i].length;j++){
                    message = message + equipos[i].getJugadores[j].getNombre() + equipos[i].getJugadores[j].pasarElDisco() ;
                }
                
                

            }
        }
        return message;
    }*/

    public String simularPartido(){
        String message = "";
       

       Random index = new Random();
        int jugador1;
        int jugador2;
        int jugador3 = 0;
       for (int i=0; i<5; i++){
            do{
                jugador1 = index.nextInt(6);
                jugador2 = index.nextInt(6);
                jugador3 = index.nextInt(6);
            } while (jugador1==jugador2);


            message = message + equipos[0].getJugadores()[jugador1].getNombre() + equipos[0].getJugadores()[jugador1].pasarElDisco() + equipos[0].getJugadores()[jugador2].getNombre() + "\n";

            message = message + arbitros[0].desplazarse()+ "\n";

            jugador3 = jugador2;


        }

        message = message + equipos[0].getJugadores()[jugador3].getNombre() + equipos[0].getJugadores()[jugador3].hacerGol();


        return message;
 

       
    }


}