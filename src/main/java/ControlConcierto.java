import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;

public class ControlConcierto {
    private HashMap<String, Concierto> conciertos;

    ControlConcierto() {
        this.conciertos = new HashMap<>();
    }
    /**
     * Programa un nuevo concierto y lo agrega al controlador de conciertos.
     *
     * @param nombre El nombre del concierto.
     * @param lugar El lugar del concierto.
     * @param fecha La fecha del concierto.
     * @param hora La hora del concierto.
     * @param capacidad La capacidad del lugar del concierto.
     * @param codigo El código único del concierto.
     * @return true si el concierto se programó con éxito, false si ya existe un concierto con el mismo código.
     */
    public boolean programarConcierto(String nombre, String lugar, LocalDate fecha, LocalTime hora, int capacidad, String codigo) {

        if (conciertos.containsKey(codigo)) {
            return false;
        }
        Concierto nuevoConcierto = new Concierto(nombre, lugar, fecha, hora, capacidad, codigo);
        conciertos.put(codigo, nuevoConcierto);
        return true;
    }
    /**
     * Consulta la información de todos los conciertos programados.
     *
     * @return Una cadena de texto que representa la información de todos los conciertos programados.
     */
    public String consultarConciertos() {
        String conciertosInfo = "";
        for (Concierto concierto : conciertos.values()) {
            conciertosInfo +=concierto.toString();
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
