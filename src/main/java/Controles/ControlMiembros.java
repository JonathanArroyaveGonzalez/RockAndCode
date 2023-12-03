package Controles;

import ClasesEntidad.Instrumento;
import ClasesEntidad.Miembro;
import ClasesEntidad.Rol;

import java.util.HashMap;
import java.util.Map;

/**
 * ControlMiembros es una clase que gestiona y mantiene un conjunto de miembros.
 * Permite agregar nuevos miembros, eliminar miembros, buscar miembros por cédula,
 * y asignar instrumentos y roles a los miembros existentes.
 * Además, proporciona métodos para comparar instancias y generar representaciones en formato de cadena.
 *
 * @author Jonathan A, Juan J Morales.
 * @version 1.0
 */
public class ControlMiembros {
    private HashMap<String, Miembro> miembros;

    public ControlMiembros() {
        this.miembros = new HashMap<>();
    }
    /**
     * Agrega un nuevo miembro al controlador de miembros.
     *
     * @param nombre    El nombre del miembro.
     * @param cedula    La cédula del miembro.
     * @param direccion La dirección del miembro.
     * @return true si el miembro se agregó con éxito, false si ya existe un miembro con la misma cédula.
     */
    public boolean agregarMiembro(String nombre, String cedula, String direccion) {
        if (buscarMiembro(cedula) instanceof Miembro) {
            return false;
        }
        Miembro miembro = new Miembro(nombre, cedula, direccion);
        miembros.put(cedula, miembro);
        return true;
    }
    /**
     * Elimina un miembro del controlador de miembros.
     *
     * @param cedula La cédula del miembro a eliminar.
     * @return true si el miembro se eliminó con éxito, false si el miembro no existe en el controlador.
     */
    public boolean eliminarMiembro(String cedula) {
        if (buscarMiembro(cedula) instanceof Miembro) {
            miembros.remove(cedula);
            return true;
        }
        return false;
    }
    /**
     * Busca un miembro en el controlador de miembros por su cédula.
     * @param cedula La cédula del miembro a buscar.
     * @return Una instancia de ClasesEntidad.Miembro si se encuentra, o null si no se encuentra.
     */
    public Miembro buscarMiembro(String cedula) {
        if (miembros.keySet().contains(cedula)) {
            return miembros.get(cedula);
        }
        return null;
    }
    /**
     * Agrega un instrumento a un miembro existente en el controlador de miembros.
     * @param cedula      La cédula del miembro.
     * @param pInstrumento El instrumento a agregar.
     * @return true si el instrumento se agregó con éxito al miembro, false si el miembro no existe en el controlador o el instrumento ya está asignado al miembro.
     */
    public boolean agregarInstrumento(String cedula, String pInstrumento) {

        Instrumento instrumento;

        switch (pInstrumento) {
            case "BATERIA":
                instrumento = Instrumento.BATERIA;
                break;
            case "GUITARRA":
                instrumento = Instrumento.GUITARRA;
                break;
            case "PIANO":
                instrumento = Instrumento.PIANO;
                break;
            case "VIOLIN":
                instrumento = Instrumento.VIOLIN;
                break;
            default:
                return false;
        }

        Miembro miembro = buscarMiembro(cedula);
        return miembro instanceof Miembro && miembro.agregarInstrumento(instrumento);
    }
    /**
     * Agrega un rol a un miembro existente en el controlador de miembros.
     *
     * @param cedula La cédula del miembro.
     * @param pRol    El rol a agregar.
     * @return true si el rol se agregó con éxito al miembro, false si el miembro no existe en el controlador o el rol ya está asignado al miembro.
     */
    public boolean agregarRol(String cedula, String pRol) {
        Rol rol;

        switch (pRol) {
            case "GUITARRISTA":
                rol = Rol.GUITARRISTA;
                break;
            case "VOCALISTA":
                rol = Rol.VOCALISTA;
                break;
            case "BAJISTA":
                rol = Rol.BAJISTA;
                break;
            case "BATERISTA":
                rol = Rol.BATERISTA;
                break;
            case "TECLADISTA":
                rol = Rol.TECLADISTA;
                break;
            case "MANAGER":
                rol = Rol.MANAGER;
                break;
            default:
                return false;
        }

        Miembro miembro = buscarMiembro(cedula);
        if (miembro instanceof Miembro) {
            return miembro.agregarRol(rol);
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
        for (Map.Entry<String, Miembro> entry : this.miembros.entrySet()) {
            integrantes += entry.getValue().toString();
            integrantes += "\n";
        }
        return integrantes;
    }

}
