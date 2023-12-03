package Controles;

import ClasesEntidad.Concierto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;

public class ControlConcierto {
    private HashMap<String, Concierto> conciertos;

    public ControlConcierto() {
        this.conciertos = new HashMap<>();
    }

    /**
     * Programa un nuevo concierto y lo agrega a los conciertos.
     * Si el nombre, lugar, fecha, hora o codigo nulos o son cadenas
     * vacias lanza IllegalArgumentException
     *
     * @param nombre    El nombre del concierto.
     * @param lugar     El lugar en que se realizo el concierto.
     * @param fecha     La fecha del concierto mayor al año 1900.
     * @param hora      La hora en que se realizo el concierto.
     * @param capacidad La capacidad del lugar del concierto positiva.
     * @param codigo    El código único que identifica el concierto.
     * @return true si el concierto se programó con éxito, false si ya existe un
     *         concierto con el mismo código.
     */
    public boolean programarConcierto(String nombre, String lugar, LocalDate fecha, LocalTime hora, int capacidad,
                                      String codigo) {
        if (nombre == null || nombre.isEmpty() || lugar == null || lugar.isEmpty() || codigo == null || codigo.isEmpty()
                || fecha == null || hora == null) {
            throw new IllegalArgumentException("Nombre, lugar, codigo, fecha u hora no puede ser de valor nulo");
        } else if (fecha.getYear() <= 1900) {
            throw new IllegalArgumentException("La fecha no puede ser menor a el año 1900");
        } else if (capacidad <= 0) {
            throw new IllegalArgumentException("La cantidad no puede ser menor o igual a cero");
        }

        if (conciertos.containsKey(codigo)) {
            return false;
        }
        Concierto nuevoConcierto = new Concierto(nombre, lugar, fecha, hora, capacidad, codigo);
        conciertos.put(codigo, nuevoConcierto);
        return true;
    }

    /**
     *
     * Busca entre todos los conciertos el concierto que le pertenece ese codigo
     *
     * @param codigo String del codigo para buscar el concierto
     * @return null si no encuentra el codigo del concierto
     *         el concierto al que pertenece ese codigo si lo encuentra
     */
    public Concierto buscarConcierto(String codigo) {
        return conciertos.get(codigo);
    }

    /**
     * Consulta la información de todos los conciertos programados.
     *
     * @return Una cadena de texto que representa la información de todos los
     *         conciertos programados.
     */
    public String consultarConciertos() {
        String conciertosInfo = "";
        for (Concierto concierto : conciertos.values()) {
            conciertosInfo += concierto.toString();
        }
        return conciertosInfo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((conciertos == null) ? 0 : conciertos.hashCode());
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
        ControlConcierto other = (ControlConcierto) obj;
        if (conciertos == null) {
            if (other.conciertos != null)
                return false;
        } else if (!conciertos.equals(other.conciertos))
            return false;
        return true;
    }

}
