package es.urjc.code;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;


/**
 * Cargador de la BD y ejemplos de consulta.
 *
 * @author J. Manuel Colmenar
 */
@Controller
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private DatabaseTest2 otroBean;

    final int NUM_PRODS = 10000;

    @Override
    public void run(String... args) throws ParseException, InterruptedException {

        // Creación de datos
        ArrayList<Producto> prods1 = creaProductos(NUM_PRODS);
        ArrayList<Producto> prods2 = creaProductos(NUM_PRODS);
                
        System.out.println("\nGuardando datos:");
        long start, time;


        /* Save vs saveAll --------------------------- */

        DatabaseTest dbTest = new DatabaseTest(productoRepository,NUM_PRODS/4,true,null);

        // Guardando datos:
        // De uno en uno
        start = System.currentTimeMillis();
        dbTest.oneByOne(prods1);
        time = (System.currentTimeMillis()-start)/1000;
        System.out.println("\n"+NUM_PRODS+" productos, uno a uno \t->\t"+time+" seg.");

        // Todos a la vez (dejo la llamada a método para que cuente en el tiempo, como en las otras):
        start = System.currentTimeMillis();
        dbTest.allAtOnce(prods2);
        time = (System.currentTimeMillis()-start)/1000;
        System.out.println("\n"+NUM_PRODS+" productos, en array \t->\t"+time+" seg.");


        /* Hebras y transacciones --------------------------- */

        /* Ejecución paralela mismo bean --------------------------- * /

        DatabaseTest dbTest2 = new DatabaseTest(productoRepository,NUM_PRODS/4,true,null);
        System.out.println("\nComitea de uno en uno, se ven diferentes conteos");
        ejecucionConcurrente(dbTest2);

        DatabaseTest dbTest3 = new DatabaseTest(productoRepository,NUM_PRODS/4,false,null);
        System.out.println("\nComitea todos a la vez, no se ven entre sí");
        ejecucionConcurrente(dbTest3);

        /* Ejecución paralela otro bean, mismo código pero con anotación @Transactional ---------------- * /
        // @Transactional solamente funciona si se invoca desde otro bean
        DatabaseTest dbTest4 = new DatabaseTest(productoRepository,NUM_PRODS/4,true,otroBean);
        System.out.println("\nComitea de uno en uno en otro bean, diferentes conteos");
        ejecucionConcurrente(dbTest4);

        DatabaseTest dbTest5 = new DatabaseTest(productoRepository,NUM_PRODS/4,false,otroBean);
        System.out.println("\nComitea de uno en uno con trasactional (todos a la vez) en otro bean, no se ven entre sí");
        ejecucionConcurrente(dbTest5);


        /* */

        System.out.println("\nTotal de productos en la BD: "+productoRepository.numProductos()+"\n");
    }


    private ArrayList<Producto> creaProductos(int n) {

        ArrayList<Producto> prods = new ArrayList<>(n);
        for (int i=0; i<n; i++) {
            Producto p1 = new Producto("Producto " + i);
            prods.add(p1);
        }
        return prods;

    }


    private void ejecucionConcurrente(DatabaseTest dbTest) throws ParseException, InterruptedException {
        long start, time;

        // Concurrencia
        Thread th1 = new Thread(dbTest);
        Thread th2 = new Thread(dbTest);
        Thread th3 = new Thread(dbTest);
        Thread th4 = new Thread(dbTest);
        start = System.currentTimeMillis();
        th1.start();
        th2.start();
        th3.start();
        th4.start();

        // Recupera productos mientras hay inserciones
        Thread.sleep(2000);

        List<Producto> productos = productoRepository.findAll();
        System.out.println("\nProductos con findAll(): "+productos.size());

        // Un método alternativo se comporta igual (aunque bloquea más)
        System.out.println("Productos con count() de repositorio: "+productoRepository.numProductos());

        th1.join();
        th2.join();
        th3.join();
        th4.join();
        time = (System.currentTimeMillis()-start)/1000;
        System.out.println("\n"+NUM_PRODS+" productos, en 4 hebras \t->\t"+time+" seg.\n");
    }


}
