import java.util.ArrayList;
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
    private List<Rol> listaRoles;
    private List<Instrumento> listaInstrumentos;

    public Miembro(String cedula, String nombre, String direccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaRoles = new ArrayList<>();
        this.listaInstrumentos = new ArrayList<>();
    }

    public boolean agregarRol(Rol rol) {
        if (listaRoles.contains(rol)) {
            return false;
        }
        listaRoles.add(rol);
        return true;
    }

    public boolean agregarInstrumento(Instrumento instrumento) {
        if (listaInstrumentos.contains(instrumento)) {
            return false;
        }
        listaInstrumentos.add(instrumento);
        return true;
    }

}
