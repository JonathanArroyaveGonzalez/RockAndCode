package ClasesEntidad;

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

    public Cancion(String nombre, LocalTime duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
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
        return "nombre: " + nombre + ", duracion: " + duracion;
    }


}
