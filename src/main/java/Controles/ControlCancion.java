package Controles;

import ClasesEntidad.Cancion;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class ControlCancion {
    private HashMap<String, Cancion>canciones;

    public ControlCancion() {
        this.canciones = new HashMap<>();
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

    /**
     * Agrega una nueva canción al controlador de canciones.
     *
     * @param nombre El nombre de la canción.
     * @param duracion La duración de la canción.
     * @param nombreAlbum El nombre del álbum al que pertenece la canción.
     * @return true si la canción se agregó con éxito, false si no se pudo agregar (por ejemplo, si ya existe una canción con el mismo nombre).
     */
    public boolean agregarCancion(String nombre, LocalTime duracion, String nombreAlbum) {
        Cancion nuevaCancion = new Cancion(nombre, duracion, nombreAlbum);
        this.canciones.put(nombre, nuevaCancion);
        return this.canciones.get(nombre) != null;
    }
    /**
     * Elimina una canción del controlador de canciones.
     *
     * @param nombre El nombre de la canción a eliminar.
     * @return true si la canción se eliminó con éxito, false si la canción no existe en el controlador.
     */
    public boolean eliminarCancion(String nombre) {

        if(this.canciones.get(nombre)!=null) {
            this.canciones.remove(nombre);
            return true;
        }else
        {
            return false;
        }
    }
    /**
     * Consulta las canciones asociadas a un álbum en el controlador de canciones.
     *
     * @param nombreAlbum El nombre del álbum.
     * @return Una cadena de texto que representa las canciones del álbum, o una cadena vacía si no hay canciones para el álbum.
     */
    public String consultarCancionesXAlbum(String nombreAlbum){
        String cancionesXAlbum="";
        for (Map.Entry<String, Cancion> entry : this.canciones.entrySet()) {
            cancionesXAlbum += entry.getValue().toString();
        }
            return cancionesXAlbum;
        }
}
