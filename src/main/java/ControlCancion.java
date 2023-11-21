import java.util.HashMap;

public class ControlCancion {
    private HashMap<String, Cancion>canciones;

    ControlCancion() {
        this.canciones = new HashMap<String, Cancion>();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((canciones == null) ? 0 : canciones.hashCode());
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
        ControlCancion other = (ControlCancion) obj;
        if (canciones == null) {
            if (other.canciones != null)
                return false;
        } else if (!canciones.equals(other.canciones))
            return false;
        return true;
    }

    public boolean agregarCancion(String nombre, float duracion, String nombreAlbum) {
        return true;
    }

    public boolean eliminarCancion(String nombre) {
        return true;
    }
}
