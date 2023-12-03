import Controles.ControlAlbum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class ControlAlbumTest {

    private ControlAlbum controlAlbum;

    @BeforeEach
    void setUp() {
        this.controlAlbum = new ControlAlbum();
    }

    @Test
    void agregarAlbumExitosoDeberiaRetornarTrue() {
        boolean resultado = controlAlbum.agregarAlbum("Álbum1", LocalDate.of(2022, 1, 1));
        assertTrue(resultado);
    }

    @Test
    void agregarAlbumExistenteDeberiaLanzarExcepcion() {
        // Agregar un álbum
        controlAlbum.agregarAlbum("Álbum2", LocalDate.of(2022, 2, 2));

        // Intentar agregar otro álbum con el mismo nombre debería lanzar una excepción
        assertThrows(IllegalArgumentException.class,
                () -> controlAlbum.agregarAlbum("Álbum2", LocalDate.of(2022, 2, 2)));
    }


    @Test
    void agregarAlbumConNombreNuloDeberiaLanzarExcepcion() {
        assertThrows(IllegalArgumentException.class,
                () -> controlAlbum.agregarAlbum(null, LocalDate.of(2022, 3, 3)));
    }

    @Test
    void agregarAlbumConNombreVacioDeberiaLanzarExcepcion() {
        assertThrows(IllegalArgumentException.class,
                () -> controlAlbum.agregarAlbum("", LocalDate.of(2022, 4, 4)));
    }

    @Test
    void agregarAlbumConFechaNulaDeberiaLanzarExcepcion() {
        assertThrows(IllegalArgumentException.class,
                () -> controlAlbum.agregarAlbum("Álbum3", null));
    }

    @Test
    void consultarAlbumExistenteDeberiaRetornarTrue() {
        // Agregar un álbum y luego consultarlo
        controlAlbum.agregarAlbum("Álbum4", LocalDate.of(2022, 5, 5));
        boolean resultado = controlAlbum.consultarAlbum("Álbum4");
        assertTrue(resultado);
    }

    @Test
    void consultarAlbumNoExistenteDeberiaRetornarFalse() {
        boolean resultado = controlAlbum.consultarAlbum("Álbum5");
        assertFalse(resultado);
    }

    @Test
    void consultarAlbumConNombreNuloDeberiaLanzarExcepcion() {
        assertThrows(IllegalArgumentException.class,
                () -> controlAlbum.consultarAlbum(null));
    }

    @Test
    void consultarAlbumConNombreVacioDeberiaLanzarExcepcion() {
        assertThrows(IllegalArgumentException.class,
                () -> controlAlbum.consultarAlbum(""));
    }
}

