import ClasesEntidad.Miembro;
import Controles.ControlMiembros;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControlMiembrosTest {

    private ControlMiembros controlMiembro;

    @BeforeEach
    void setUp() {
        controlMiembro = new ControlMiembros();
    }

    @Test
    public void testAgregarMiembro() {
        boolean resultado = controlMiembro.agregarMiembro("Juan", "110000", "Cr24 #14-16");
        assertTrue(resultado);
    }
    @Test
    public void testNoAgregarMiembroRepetido() {
        ControlMiembros controlMiembro1 = new ControlMiembros();
        controlMiembro1.agregarMiembro("Juan", "110000", "Cr24 #14-16");
        boolean resultado = controlMiembro1.agregarMiembro("Juan", "110000", "Cr24 #14-16");
        assertFalse(resultado);
    }
    @Test
    public void testValoresNulosMiembro() {
        assertThrows(
                IllegalArgumentException.class,
                () -> controlMiembro.agregarMiembro(null, null, null));
    }
    @Test
    public void testEliminarMiembro() {
        controlMiembro.agregarMiembro("Juan", "20100", "Cr24 #14-16");
        boolean resultado = controlMiembro.eliminarMiembro("20100");
        assertTrue(resultado);
    }
    @Test
    public void testEliminarMiembroNoEnMemoria() {
        boolean resultado = controlMiembro.eliminarMiembro("110001");
        assertFalse(resultado);
    }
    @Test
    public void testBuscarMiembroNoEnMemoria() {
        Miembro resultado = controlMiembro.buscarMiembro("110001");
        assertNull(resultado);
    }
    @Test
    public void testAgregarInstrumento() {
        controlMiembro.agregarMiembro("carlos","1100001","nula");
        boolean resultado = controlMiembro.agregarInstrumento("1100001", "BATERIA");
        assertTrue(resultado);
    }
    @Test
    public void testAgregarInstrumentoMalCedulaInst() {
        boolean resultado = controlMiembro.agregarInstrumento("110001", "BTERIA");
        assertFalse(resultado);
    }
    @Test
    public void testAgregarInstrumentoMalCedula() {
        boolean resultado = controlMiembro.agregarInstrumento("110001", "BATERIA");
        assertFalse(resultado);
    }
    @Test
    public void testAgregarInstrumentoMalInst() {
        boolean resultado = controlMiembro.agregarInstrumento("110000", "BATERI");
        assertFalse(resultado);
    }
    @Test
    public void testAgregarRol() {
        controlMiembro.agregarMiembro("carlos","111","nula");
        boolean resultado = controlMiembro.agregarRol("111", "GUITARRISTA");
        assertTrue(resultado);
    }
    @Test
    public void testAgregarRolMalCedulaRol() {
        boolean resultado = controlMiembro.agregarRol("110001", "GUITARRIST");
        assertFalse(resultado);
    }
    @Test
    public void testAgregarRolMalCedula() {
        boolean resultado = controlMiembro.agregarRol("110001", "GUITARRISTA");
        assertFalse(resultado);
    }
    @Test
    public void testAgregarRolMalRol() {
        boolean resultado = controlMiembro.agregarRol("110000", "GUITARRTA");
        assertFalse(resultado);
    }

    @Test
    public void testGuardarMiembro() {
        ControlMiembros controlMiembros1 = new ControlMiembros();
        String resultado = controlMiembros1.toString();
        controlMiembros1.agregarMiembro("Juan", "110000", "Cr24 #14-16");
        String valor = controlMiembros1.toString();
        assertNotEquals(valor, resultado);
    }

    @Test
    public void testNoGuardarMiembroRepetido() {
        ControlMiembros controlMiembros1 = new ControlMiembros();
        controlMiembros1.agregarMiembro("Juan", "110000", "Cr24 #14-16");
        String resultado = controlMiembros1.toString();
        controlMiembros1.agregarMiembro("Juan", "110000", "Cr24 #14-16");
        String valor = controlMiembros1.toString();
        assertEquals(valor, resultado);
    }

}
