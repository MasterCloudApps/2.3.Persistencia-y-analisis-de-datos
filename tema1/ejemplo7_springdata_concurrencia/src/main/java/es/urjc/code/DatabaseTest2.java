package es.urjc.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


/**
 * Bean diferente para ejemplificar el uso de Transactional.
 *
 * @author J. Manuel Colmenar
 */

@Service
public class DatabaseTest2 {

    @Autowired
    private ProductoRepository productoRepository;

    @Transactional
    public void oneByOneTransaccional(ArrayList<Producto> prods) {
        for (Producto prod : prods) {
            productoRepository.save(prod);
        }
    }

    public void oneByOneNoTransaccional(ArrayList<Producto> prods) {
        for (Producto prod : prods) {
            productoRepository.save(prod);
        }
    }
}
