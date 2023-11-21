import java.util.List;

/**
 * Descripcion de la Clase
 *
 * @author Jonathan A.
 * @version 1.0
 */
public class Miembro {
    private String cedula;
    private String nombre;
    private String direccion;
    private List<String> listaRoles;
    private List<String> listaInstrumentos;

    public Miembro(String cedula, String nombre, String direccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
    }
}
