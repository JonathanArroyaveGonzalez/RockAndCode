import java.time.LocalDate;
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

    public Album(String nombre, LocalDate fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
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
}
