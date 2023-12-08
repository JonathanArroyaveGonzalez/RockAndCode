package ClasesEntidad;

import java.util.ArrayList;
import java.util.List;

/**
 * Descripcion de la Clase
 *
 * @author Jonathan A.
 * @version 1.0
 */
public class Banda {
private String genero;
private String fechaCreacion;
private List<String> fotos;

    public Banda(String genero,String fechaCreacion) {
        this.genero = genero;
        this.fechaCreacion = fechaCreacion;
        this.fotos = new ArrayList<>();
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void agregarFoto(String rutaFoto) {
        this.fotos.add(rutaFoto);
    }


    @Override
    public String toString() {

        return "Informacion Rock&Code: \n" +
                "Genero: " + genero + "\n" +
                "Fecha de creacion: " + fechaCreacion + "\n"+
                "Fotos: "+ fotos.toString();
    }
}
