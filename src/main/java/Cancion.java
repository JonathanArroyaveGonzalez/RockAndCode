import java.time.LocalTime;

/**
 * Descripcion de la Clase
 *
 * @author Jonathan A.
 * @version 1.0
 */
public class Cancion {
    private String nombre;
    private LocalTime duracion;
    private Album album;

    public Cancion(String nombre, LocalTime duracion, Album album) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.album = album;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalTime getDuracion() {
        return duracion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDuracion(LocalTime duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Cancion [nombre=" + nombre + ", duracion=" + duracion + "]";
    }

}
