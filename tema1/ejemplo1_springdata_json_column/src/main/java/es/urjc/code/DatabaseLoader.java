package es.urjc.code;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
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
    private ProductoRepository repository;

    @Override
    public void run(String... args) {

        // Guardando algunos productos
        repository.save(new Producto("{\"nombre\": \"Macbook\", \"marca\": \"Apple\", " +
                "\"etiquetas\":[\"Portátil\",\"Mac\"]}"));
        repository.save(new Producto("{\"nombre\": \"P30 Lite 4\", \"marca\": \"Huawei\", " +
                "\"etiquetas\":[\"Móvil\"]}"));
        repository.save(new Producto("{\"nombre\": \"iPhone 11 Pro\", \"marca\": \"Apple\", " +
                "\"etiquetas\":[\"Móvil\"]}"));
        repository.save(new Producto("{\"nombre\": \"Teclado 105\", \"marca\": \"Logitech\"}"));

        // Producto a partir del toString de un objeto JSON
        JSONObject jo = new JSONObject();
        jo.put("nombre", "EliteBook 840");
        jo.put("marca", "HP");
        JSONArray jsonArray = new JSONArray();
        jsonArray.put("Portátil");
        jsonArray.put("Ligero");
        jo.put("etiquetas",jsonArray);
        repository.save(new Producto(jo.toString()));


        // Recupera productos
        List<Producto> productos = repository.findAll();
        System.out.println("Productos con findAll():");
        System.out.println("----------------------------------------");
        muestraDatos(productos);

        // Recupera productos por marca
        String marca = "HP";
        productos = repository.findByMarca(marca);
        System.out.println("Productos "+marca+":");
        System.out.println("----------------------------------------");
        muestraDatos(productos);

        // Recupera productos por etiqueta
        String etiqueta = "Ligero";
        productos = repository.findByEtiqueta(etiqueta);
        System.out.println("Productos con etiqueta \""+etiqueta+"\":");
        System.out.println("----------------------------------------");
        muestraDatos(productos);
    }


    private static void muestraDatos(List datos) {
        for (Object p : datos) {
            System.out.println(p);
        }
        System.out.println();
    }

}
