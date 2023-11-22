import java.util.HashMap;
import java.util.Map;

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((miembros == null) ? 0 : miembros.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ControlMiembros other = (ControlMiembros) obj;
        if (miembros == null) {
            if (other.miembros != null)
                return false;
        } else if (!miembros.equals(other.miembros))
            return false;
        return true;
    }

    @Override
    public String toString() {
        String integrantes="";
        for (Map.Entry<String,Miembro> entry : this.miembros.entrySet()) {
            integrantes += entry.getValue().toString();
        }
        return integrantes;
    }

}

