package es.urjc.code;

import java.util.ArrayList;
import java.util.Iterator;

public class DatabaseTest implements Runnable {

    private int num_prods;

    private ProductoRepository productoRepository;


    public DatabaseTest(ProductoRepository productoRepository, int n) {
        this.productoRepository = productoRepository;
        this.num_prods = n;
    }

    public void oneByOne(ArrayList<Producto> prods) {
        for (Producto prod : prods) {
            productoRepository.save(prod);
        }
    }

    public void allAtOnce(ArrayList<Producto> prods) {
        productoRepository.saveAll(prods);
    }


    @Override
    public void run() {
        ArrayList<Producto> prods = new ArrayList<>(num_prods);
        for (int i = 0; i< num_prods; i++) {
            Producto p1 = new Producto("Producto " + i + " - "+Thread.currentThread().getName());
            prods.add(p1);
        }

        // De uno en uno se ven las inserciones en el count por múltiples transacciones.
        oneByOne(prods);
        // Todos a la vez implica transacción larga y no se ven.
        //allAtOnce(prods);
    }
}
