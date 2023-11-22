import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Descripcion de la Clase
 *
 * @author Jonathan A.
 * @version 1.0
 */
public class Concierto {
    private String nombre;
    private String lugar;
    private LocalDate fecha;
    private LocalTime hora;
    private int capacidad;
    private String codigo;

    public Concierto(String nombre, String lugar, LocalDate fecha, LocalTime hora, int capacidad, String codigo) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.fecha = fecha;
        this.hora = hora;
        this.capacidad = capacidad;
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Concierto [nombre=" + nombre + ", lugar=" + lugar + ", fecha=" + fecha + ", hora=" + hora
                + ", capacidad=" + capacidad + ", codigo=" + codigo + "]";
    }




}
