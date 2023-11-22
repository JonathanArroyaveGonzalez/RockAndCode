import java.util.HashMap;

/**
 * Descripcion de la Clase
 *
 * @author Jonathan A.
 * @version 1.0
 */
public class ControlMiembros {
    private HashMap<String, Miembro> miembros;

    ControlMiembros() {
        this.miembros = new HashMap<String, Miembro>();
    }

    public boolean agregarMiembro(String nombre, String cedula, String direccion) {
        if (buscarMiembro(cedula) instanceof Miembro) {
            return false;
        }
        Miembro miembro = new Miembro(nombre, cedula, direccion);
        miembros.put(cedula, miembro);
        return true;
    }

    public boolean eliminarMiembro(String cedula) {
        if (buscarMiembro(cedula) instanceof Miembro) {
            miembros.remove(cedula);
            return true;
        }
        return false;
    }

    public Miembro buscarMiembro(String cedula) {
        if (miembros.keySet().contains(cedula)) {
            return miembros.get(cedula);
        }
        return null;
    }

    public boolean agregarInstrumento(String cedula, Instrumento instrumento) {
        Miembro miembro = buscarMiembro(cedula);
        if (miembro instanceof Miembro) {
            if (miembro.agregarInstrumento(instrumento)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean agregarRol(String cedula, Rol rol) {
        Miembro miembro = buscarMiembro(cedula);
        if (miembro instanceof Miembro) {
            if (miembro.agregarRol(rol)) {
                return true;
            }
            return false;
        }
        return false;
    }

}
