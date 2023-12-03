import Controles.ControlConcierto;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Descripcion de la Clase
 *
 * @author Jonathan A.
 * @version 1.0
 */
class ControlConciertoTest {
    private ControlConcierto controlConcierto;

    @BeforeEach
    public void setUp() {
        controlConcierto = new ControlConcierto();
    }

    @Test
    void testProgramarConcierto() {
        boolean resultado = controlConcierto.programarConcierto("Yupiter", "la luna", LocalDate.of(2023, 12, 1),
                LocalTime.of(20, 0), 1000,
                "CODIGO1");
        assertTrue(resultado);
    }

    @Test
    void testProgramarConciertoCodigoRepetido() {
        boolean resultado = controlConcierto.programarConcierto("Yupiter", "la luna", LocalDate.of(2023, 12, 1),
                LocalTime.of(20, 0), 1000,
            "CODIGO1");
        assertTrue(resultado);
        String valor = controlConcierto.consultarConciertos();
        resultado = controlConcierto.programarConcierto("Yupiter", "la luna",
                LocalDate.of(2023, 12, 1), LocalTime.of(20, 0), 1000,
                "CODIGO1");
        assertFalse(resultado);
        String resultadoConciertos = controlConcierto.consultarConciertos();
        assertEquals(valor, resultadoConciertos);
    }

    @Test
    void testFechaMuyVieja() {
        assertThrows(
                IllegalArgumentException.class,
                () -> controlConcierto.programarConcierto("Yupiter", "la luna", LocalDate.of(1900, 12, 1),
                        LocalTime.of(20, 0), 1000,
                        "CODIGO1"));
    }

    @Test
    void testCapacidadNegativa() {
        assertThrows(
                IllegalArgumentException.class,
                () -> controlConcierto.programarConcierto("Yupiter", "la luna", LocalDate.of(2023, 12, 1),
                        LocalTime.of(20, 0), -1000,
                        "CODIGO1"));
    }

    @Test
    void testGuardarValor() {
        ControlConcierto controlConcierto1 = new ControlConcierto();
        String resultado = controlConcierto1.consultarConciertos();
        controlConcierto1.programarConcierto("Yupiter", "la luna", LocalDate.of(2023, 12, 1),
                LocalTime.of(20, 0), 1000,
                "CODIGO1");
        String valor = controlConcierto1.consultarConciertos();
        assertNotEquals(valor, resultado);
    }

    @Test
    void testNoGuardarValorRepetido() {
        ControlConcierto controlConcierto1 = new ControlConcierto();
        controlConcierto1.programarConcierto("Yupiter", "la luna", LocalDate.of(2023, 12, 1),
                LocalTime.of(20, 0), 1000,
                "CODIGO1");
        String resultado = controlConcierto1.consultarConciertos();
        controlConcierto1.programarConcierto("Yupiter", "la luna", LocalDate.of(2023, 12, 1),
                LocalTime.of(20, 0), 1000,
                "CODIGO1");
        String valor = controlConcierto1.consultarConciertos();
        assertEquals(valor, resultado);
    }

    @Test
    void testValoresNulos() {
        assertThrows(
                IllegalArgumentException.class,
                () -> controlConcierto.programarConcierto(null, null, null, null, 1, null));
    }

}
