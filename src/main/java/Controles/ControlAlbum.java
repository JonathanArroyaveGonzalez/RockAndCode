package Controles;

import ClasesEntidad.Album;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Descripcion de la Clase
 *
 * @author Jonathan A.
 * @version 1.0
 */
public class ControlAlbum {
    private HashMap<String, Album> listaAlbunes;

    public ControlAlbum() {
        this.listaAlbunes = new HashMap<>();
    }

    /**
     * Agrega un nuevo álbum al controlador de álbumes.
     *
     * @param nombre El nombre del álbum.
     * @param fecha La fecha de lanzamiento del álbum.
     * @return true si el álbum se agregó con éxito, false si no se pudo agregar (por ejemplo, si ya existe un álbum con el mismo nombre).
     */
    public boolean agregarAlbum(String nombre, LocalDate fecha){
        Album nuevoAlbum= new Album(nombre,fecha);
        this.listaAlbunes.put(nombre, nuevoAlbum);
        return this.listaAlbunes.get(nombre) != null;
    }

    /**
     * Consulta un álbum en el controlador por su nombre.
     *
     * @param nombreAlbum El nombre del álbum a consultar.
     * @return El objeto ClasesEntidad.Album correspondiente al nombre proporcionado, o null si no se encuentra.
     */
    public boolean consultarAlbum(String nombreAlbum) {
        Album albumBuscado=this.listaAlbunes.get(nombreAlbum);
        if(albumBuscado instanceof Album){
            return true;
        }else
        {
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

    @Override
    public String toString() {
        String albunes="";
        for (Map.Entry<String, Album> entry : this.listaAlbunes.entrySet()) {
            albunes += entry.getValue().toString();
            albunes += "\n";
        }
        return albunes;
    }
}
