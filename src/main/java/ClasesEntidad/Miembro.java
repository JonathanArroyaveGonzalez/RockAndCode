package ClasesEntidad;

import ClasesEntidad.Instrumento;

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

    public Miembro(String nombre, String cedula, String direccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaRoles = new ArrayList<>();
        this.listaInstrumentos = new ArrayList<>();
    }

    /**
     *
     * Agrega un rol a un miembro.
     *
     * @param rol String del rol a agregar.
     * @return true si el rol se agregó con éxito al miembro,
     *         false si el rol ya está asignado al miembro.
     */
    public boolean agregarRol(Rol rol) {
        if (listaRoles.contains(rol)) {
            return false;
        }
        listaRoles.add(rol);
        return true;
    }


    /**
     *  Agrega un instrumento a un miembro.
     *
     * @param instrumento String del instrumento a agregar.
     * @return true si el instrumento se agrego con exito al miembro
     *          false si el instrumento ya esta asignado al miembro
     */
    public boolean agregarInstrumento(Instrumento instrumento) {
        if (listaInstrumentos.contains(instrumento)) {
            return false;
        }
        listaInstrumentos.add(instrumento);
        return true;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre+"\nCedula: " + cedula  + "\nDireccion: " + direccion + "\nRoles: "
                + getInfoRoles() + "\nInstrumentos: " + getInfoInstrumentos() ;
    }

    /**
     *  Devuelve un string con la informacion de la lista de roles
     *
     * @return el String con la informacion de todos los roles del miembro
     */
    public String getInfoRoles() {
        String roles = "";
        for (Rol rol : listaRoles) {
            roles += " " + rol + " ";
        }
        return roles;
    }

    /**
     * Devuelve un string con la informacion de la lista de instrumentos
     *
     * @return el String con la informacion de todos los instrumentos del miembro
     */
    public String getInfoInstrumentos() {
        String instrumentos = "";
        for (Instrumento instrumento : listaInstrumentos) {
            instrumentos += " " + instrumento + " ";
        }
        return instrumentos;
    }


}
