package es.urjc.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Cargador de la BD y ejemplos.
 *
 * @author J. Manuel Colmenar
 */
@Controller
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    private RepositorioPelicula repository;


    @Override
    public void run(String... args) throws ParseException {
        // Borra la colección asociada al repositorio.
        repository.deleteAll();

        // Creación de dos películas
        Pelicula p1 = new Pelicula("Matrix", 1999, "http://www.imdb.com/title/tt0133093/");
        List<Actor> a1 = new ArrayList<>();
        a1.add(new Actor("Keanu Reeves","Canadá"));
        a1.add(new Actor("Carrie-Ann Moss","Canadá"));
        a1.add(new Actor("Laurence Fishburne","Estados Unidos"));
        p1.setActores(a1);
        repository.save(p1);

        Pelicula p2 = new Pelicula("El Padrino", 1972, "http://www.imdb.com/title/tt0068646/");
        List<Actor> a2 = new ArrayList<>();
        a2.add(new Actor("Al Pacino","Estados Unidos"));
        a2.add(new Actor("Marlon Brando","Estados Unidos"));
        p2.setActores(a2);
        repository.save(p2);


        // Consulta de todas las películas
        System.out.println("Películas almacenadas:");
        System.out.println("-------------------------------");
        for (Pelicula peli : repository.findAll()) {
            System.out.println(peli);
        }
        System.out.println();

        // Encuentra una película por título
        System.out.println("Película encontrada con findByTitulo('Matrix'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByTitulo("Matrix"));

    }
}
