import java.time.LocalDate;
import java.util.HashMap;

/**
 * Descripcion de la Clase
 *
 * @author Jonathan A.
 * @version 1.0
 */
public class ControlAlbum {
    private HashMap<String,Album> listaAlbunes;

    public ControlAlbum() {
        this.listaAlbunes = new HashMap<String, Album>();
    }

    public boolean agregarAlbum(String nombre, LocalDate fecha){
        Album nuevoAlbum= new Album(nombre,fecha);
        this.listaAlbunes.put(nombre,nuevoAlbum);

        if (this.listaAlbunes.get(nombre)!= null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((listaAlbunes == null) ? 0 : listaAlbunes.hashCode());
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
        ControlAlbum other = (ControlAlbum) obj;
        if (listaAlbunes == null) {
            if (other.listaAlbunes != null)
                return false;
        } else if (!listaAlbunes.equals(other.listaAlbunes))
            return false;
        return true;
    }
}
