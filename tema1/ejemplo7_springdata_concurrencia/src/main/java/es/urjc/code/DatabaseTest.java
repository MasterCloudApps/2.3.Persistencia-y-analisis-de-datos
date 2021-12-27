package es.urjc.code;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

public class DatabaseTest implements Runnable {

    private int num_prods;
    private boolean oneByOne;
    private DatabaseTest2 otroBean;

    private ProductoRepository productoRepository;


    public DatabaseTest(ProductoRepository productoRepository, int n, boolean oneByOne, DatabaseTest2 otroBean) {
        this.productoRepository = productoRepository;
        this.num_prods = n;
        this.oneByOne = oneByOne;
        this.otroBean = otroBean;
    }

    // Esta anotación no funciona porque se invoca al método desde el mismo bean!!!
    @Transactional
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

        if (otroBean == null) {

            if (oneByOne) {
                // De uno en uno se ven las inserciones en el count por múltiples transacciones.
                oneByOne(prods);
            } else {
                // Todos a la vez implica transacción larga y no se ven.
                allAtOnce(prods);
            }

        } else {

            if (oneByOne) {
                // De uno en uno se ven las inserciones en el count por múltiples transacciones, aunque
                // esté en otro bean
                otroBean.oneByOneNoTransaccional(prods);
            } else {
                // De uno en uno con el otro bean es transaccional y no se ven porque se hacen a la vez
                // en la misma transacción.
                otroBean.oneByOneTransaccional(prods);
            }

        }

    }
}
