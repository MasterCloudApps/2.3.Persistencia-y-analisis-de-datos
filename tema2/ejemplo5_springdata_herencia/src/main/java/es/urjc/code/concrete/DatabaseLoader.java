package es.urjc.code.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.List;

/**
 * Cargador de la BD y ejemplos de consulta.
 *
 * @author J. Manuel Colmenar
 */
@Controller
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    private JugadorRepository jugadorRepository;

    @Autowired
    private GolfistaRepository golfistaRepository;

    @Override
    public void run(String... args) throws ParseException {

        // Guardando datos ...
        Jugador j1 = new Jugador("Jugador 1");
        Golfista g1 = new Golfista("Jon Rahm",5);
        Balonmanista b1 = new Balonmanista("Raúl Entrerríos", "Central");

        jugadorRepository.save(j1);
        jugadorRepository.save(g1);
        jugadorRepository.save(b1);


        // Recupera jugadores
        List<Jugador> jugadores = jugadorRepository.findAll();
        System.out.println("Jugadores con findAll():");
        System.out.println("----------------------------------------");
        muestraDatos(jugadores);

        // Recupera golfistas
        List<Golfista> golfistas = golfistaRepository.findAll();
        System.out.println("Golfistas con findAll():");
        System.out.println("----------------------------------------");
        muestraDatos(golfistas);

    }


    private static void muestraDatos(List datos) {
        for (Object p : datos) {
            System.out.println(p);
        }
        System.out.println();
    }

}
