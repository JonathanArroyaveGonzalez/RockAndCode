package Controles;

import ClasesEntidad.Album;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * ControlAlbum es una clase que gestiona y mantiene un conjunto de álbumes.
 * Permite agregar nuevos álbumes, consultar álbumes por nombre, y proporciona una representación
 * en formato de cadena de los álbumes contenidos en el controlador.
 *
 * @author Jonathan A, Juan J Morales.
 * @version 1.0
 */
public class ControlAlbum {
    private HashMap<String, Album> listaAlbunes;

    public ControlAlbum() {
        this.listaAlbunes = new HashMap<>();
    }

    /**
     * Agrega un nuevo álbum
     *
     * @param nombre El nombre del álbum. No puede ser nulo o una cadena vacía.
     * @param fecha La fecha de lanzamiento del álbum. No puede ser nula.
     * @return true si el álbum se agregó con éxito, false si no se pudo agregar (por ejemplo, si ya existe un álbum con el mismo nombre).
     * @throws IllegalArgumentException Si alguno de los argumentos es nulo o una cadena vacía, o si ya existe un álbum con el mismo nombre.
     */
    public boolean agregarAlbum(String nombre, LocalDate fecha){
        if (nombre == null || fecha == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("Argumentos inválidos: nombre y fecha no pueden ser nulos o cadenas vacías.");
        }
        if (this.listaAlbunes.containsKey(nombre)) {
            throw new IllegalArgumentException("Ya existe un album con el mismo nombre.");
        }
        Album nuevoAlbum= new Album(nombre,fecha);
        this.listaAlbunes.put(nombre, nuevoAlbum);
        return this.listaAlbunes.get(nombre) != null;
    }

    /**
     * Consulta un álbum en el controlador por su nombre.
     *
     * @param nombreAlbum El nombre del álbum a consultar.
     * @return El objeto Album correspondiente al nombre proporcionado, o null si no se encuentra.
     */
    public boolean consultarAlbum(String nombreAlbum) {
        if (nombreAlbum == null || nombreAlbum.equalsIgnoreCase("")) {
            // Manejar la situación cuando el parámetro es nulo o una cadena vacia
            throw new IllegalArgumentException("El nombre del album no puede ser de tipo NULL ó una cadena vacia.");
        }
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
