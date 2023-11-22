import java.util.HashMap;

public class ControlConcierto {
    private HashMap<String, Concierto> conciertos;

    ControlConcierto() {
        this.conciertos = new HashMap<>();
    }

    public String consultarConciertos() {
        String conciertosInfo = "";
        for (Concierto concierto : conciertos.values()) {
            conciertosInfo += "\\n" + concierto.toString();
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
