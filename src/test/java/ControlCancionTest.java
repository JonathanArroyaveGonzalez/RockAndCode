import Controles.ControlCancion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class ControlCancionTest {
    private ControlCancion controlCancion;

    @BeforeEach
    void setUp() {
        controlCancion = new ControlCancion();
    }

    @Test
    void agregarCancionExitosa() {
        assertTrue(controlCancion.agregarCancion("Cancion1", LocalTime.of(0, 3, 30), "Album1"));
    }

    @Test
    void agregarCancionExistenteDeberiaLanzarExcepcion() {
        controlCancion.agregarCancion("Cancion2", LocalTime.of(0, 4, 15), "Album2");
        assertThrows(IllegalArgumentException.class,
                () -> controlCancion.agregarCancion("Cancion2", LocalTime.of(0, 4, 15), "Album2"));
    }

    @Test
    void agregarCancionConArgumentosNulosDeberiaLanzarExcepcion() {
        assertThrows(IllegalArgumentException.class,
                () -> controlCancion.agregarCancion(null, null, null));
    }

    @Test
    void eliminarCancionExistenteDeberiaEliminarCancion() {
        controlCancion.agregarCancion("Cancion3", LocalTime.of(0, 3, 0), "Album3");
        assertTrue(controlCancion.eliminarCancion("Cancion3"));
    }

    @Test
    void eliminarCancionNoExistenteDeberiaRetornarFalse() {
        assertFalse(controlCancion.eliminarCancion("CancionInexistente"));
    }

    @Test
    void consultarCancionesXAlbumConCancionesDeberiaRetornarCanciones() {
        controlCancion.agregarCancion("Cancion4", LocalTime.of(0, 2, 45), "Album4");
        controlCancion.agregarCancion("Cancion5", LocalTime.of(0, 3, 15), "Album4");

        String resultado = controlCancion.consultarCancionesXAlbum("Album4");

        assertTrue(resultado.contains("Cancion4") && resultado.contains("Cancion5"));
    }

    @Test
    void consultarCancionesXAlbumSinCancionesDeberiaRetornarCadenaVacia() {
        String resultado = controlCancion.consultarCancionesXAlbum("AlbumInexistente");
        assertEquals("", resultado);
    }
}
