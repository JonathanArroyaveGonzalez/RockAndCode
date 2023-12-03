import ClasesEntidad.Instrumento;
import ClasesEntidad.Miembro;
import ClasesEntidad.Rol;
import ClasesEntidad.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MiembrosTest {
    private Miembro miembro;

    @BeforeEach
    void setUp() {
        miembro = new Miembro("Juan", "2222", "20-23");
    }

    @Test
    void testAgregarIntrumento() {
        boolean resultado = miembro.agregarInstrumento(Instrumento.BATERIA);
        assertTrue(resultado);
    }

    @Test
    void testNoAgregarIntrumento() {
        miembro.agregarInstrumento(Instrumento.BATERIA);
        boolean resultado = miembro.agregarInstrumento(Instrumento.BATERIA);
        assertFalse(resultado);
    }

    @Test
    void testAgregarRolMiembro() {
        boolean resultado = miembro.agregarRol(Rol.BAJISTA);
        assertTrue(resultado);
    }

    @Test
    void testNoAgregarRol() {
        miembro.agregarRol(Rol.BAJISTA);
        boolean resultado = miembro.agregarRol(Rol.BAJISTA);
        assertFalse(resultado);
    }

    @Test
    public void testGuardarRol() {
        String resultado = miembro.getInfoRoles();
        miembro.agregarRol(Rol.MANAGER);
        String valor = miembro.getInfoRoles();
        assertNotEquals(valor, resultado);
    }

    @Test
    public void testNoGuardarRol() {
        Miembro miembro1 = new Miembro("Pepa", "200000", "40-3");
        miembro1.agregarRol(Rol.MANAGER);
        String resultado = miembro1.getInfoRoles();
        miembro1.agregarRol(Rol.MANAGER);
        String valor = miembro1.getInfoRoles();
        assertEquals(valor, resultado);
    }

    @Test
    void testGuardarInstrumento() {
        String resultado = miembro.getInfoInstrumentos();
        miembro.agregarInstrumento(Instrumento.PIANO);
        String valor = miembro.getInfoInstrumentos();
        assertNotEquals(valor, resultado);
    }

    @Test
    void testNoGuardarInstrumento() {
        Miembro miembro1 = new Miembro("Pepa", "200000", "40-3");
        miembro1.agregarInstrumento(Instrumento.VIOLIN);
        String resultado = miembro1.getInfoInstrumentos();
        miembro1.agregarInstrumento(Instrumento.VIOLIN);
        String valor = miembro1.getInfoInstrumentos();
        assertEquals(valor, resultado);
    }

}
