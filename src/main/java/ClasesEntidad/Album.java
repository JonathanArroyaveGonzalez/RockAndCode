package ClasesEntidad;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

/**
 * Descripcion de la Clase
 *
 * @author Jonathan A.
 * @version 1.0
 */
public class Album {
    private String nombre;
    private LocalDate fecha;
    private HashMap<String, Cancion>canciones;

    public Album(String nombre, LocalDate fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.canciones = new HashMap<>();
    }


    public boolean agregarCancion(Cancion cancion) {
        if (this.canciones.containsKey(cancion.getNombre())) {
            return false;
        }else
        {
            this.canciones.put(cancion.getNombre(), cancion);
            return true;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Album)) return false;
        Album album = (Album) o;
        return nombre.equals(album.nombre) && fecha.equals(album.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "Album " + nombre + "\nFecha lanzamiento: "
                + fecha + "\n"+this.infoCanciones();
    }

    public String infoCanciones(){
        String canciones = "";
        for (Map.Entry<String, Cancion> entry : this.canciones.entrySet()) {
            canciones += entry.getValue().toString();
            canciones += "\n-------------------------------------";
        }
        return canciones;
    }
}
