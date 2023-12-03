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
        boolean resultado = controlMiembro.eliminarMiembro("110000");
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
        boolean resultado = controlMiembro.agregarRol("110000", "GUITARRISTA");
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
        controlMiembros1.agregarMiembro("Juan", "110000", "Cr24 #14-16");
        String resultado = controlMiembros1.toString();
        String valor = "Nombre: Juan\r\n" + //
                "Cedula: 110000\r\n" + //
                "Direccion: Cr24 #14-16\r\n" + //
                "Roles:\r\n" + //
                "Instrumentos:\\r\\n";
        assertEquals(valor, resultado);
    }

    @Test
    public void testNoGuardarMiembroRepetido() {
        ControlMiembros controlMiembros1 = new ControlMiembros();
        controlMiembros1.agregarMiembro("Juan", "110000", "Cr24 #14-16");
        controlMiembros1.agregarMiembro("Juan", "110000", "Cr24 #14-16");
        String resultado = controlMiembros1.toString();
        String valor = "Nombre: Juan\r\n" + //
                "Cedula: 110000\r\n" + //
                "Direccion: Cr24 #14-16\r\n" + //
                "Roles:\r\n" + //
                "Instrumentos:\\r\\n";
        assertEquals(valor, resultado);
    }

}
