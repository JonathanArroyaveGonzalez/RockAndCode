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
        this.listaAlbunes = null;
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
}
