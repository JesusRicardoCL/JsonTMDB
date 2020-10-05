package jsonapp2;

import com.google.gson.Gson;
import entidades.movies;
import util.archivo;

/**
 *
 * @author jesus
 */
public class JsonApp2 {

    public static void main(String[] args) {
        movies tc = new movies();
        
        Gson gson = new Gson();
        
        //Lectura rachivos
        String nombreArchivo = "movies.json";
        archivo _archivo = new archivo(nombreArchivo);
        if(_archivo.abrir()){
            
            _archivo.leer();
            
            tc = gson.fromJson(_archivo.getTexto().toString(), movies.class);
            
        } else {
            System.out.println("No se pudo abrir el archivo");
        }

        //Uso de datos
        System.out.println("Listado de 20 peliculas recientes y su fecha de estreno");
        System.out.println("(Nota: Los resultados no estan ordenados y se"
                + "\nincluyen peliculas ya estrenadas)");
        System.out.println("-------------------------------------------------------");
        System.out.println("Pagina consultada: "+ tc.getPage());
        System.out.println("Resultados totales: " + tc.getTotal_results());
        System.out.println("Paginas totales encontradas: " + tc.getTotal_pages());
        System.out.println("---------------------[Resultados]----------------------");
        
        for (int i = 0; i < tc.getResult().length; i++) {
            //Nota: Solo utilice 2 parametros de los 14 que habia por cuestiones de tiempo
            System.out.println("[" + tc.getResult()[i].getTitle() + " - " + tc.getResult()[i].getRelease_date() +"]");
        }
    
    }
    
}
