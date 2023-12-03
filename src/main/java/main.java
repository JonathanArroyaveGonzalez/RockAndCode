import java.time.LocalDate;
import java.time.LocalTime;

import ClasesEntidad.Banda;
import Controles.ControlAlbum;
import Controles.ControlCancion;
import Controles.ControlConcierto;
import Controles.ControlMiembros;

/**
 * Descripcion de la Clase
 *
 * @author Jonathan A.
 * @version 1.0
 */
import java.time.LocalDate;
import java.time.LocalTime;
public class main {

        public static void main(String[] args) {

            //Prueba Funcionalidad (A)
            Banda miBanda = new Banda();
            System.out.println(miBanda.toString());

            // Prueba de agregar fotos
            miBanda.agregarFoto("ruta_foto_1");
            miBanda.agregarFoto("ruta_foto_2");

            // Imprimir información después de agregar fotos
            System.out.println("Informacion sin fotos: \n" + miBanda.toString());


            /**
             * Pruebas de funcionalidad B
             */
            // Crear una instancia de ControlMiembros
            ControlMiembros controlMiembros = new ControlMiembros();

            // Agregar miembros
            controlMiembros.agregarMiembro("John Doe", "123456789", "123 Main St");
            controlMiembros.agregarMiembro("Jane Smith", "987654321", "456 Oak St");

            // Imprimir información de miembros antes de agregar roles e instrumentos
            System.out.println("Miembros antes de agregar roles e instrumentos:\n" + controlMiembros.toString());

            // Agregar roles e instrumentos a los miembros
            controlMiembros.agregarRol("123456789", "GUITARRISTA");
            controlMiembros.agregarRol("987654321", "BAJISTA");
            controlMiembros.agregarInstrumento("123456789", "GUITARRA");
            controlMiembros.agregarInstrumento("987654321", "VIOLIN");

            // Imprimir información de miembros después de agregar roles e instrumentos
            System.out.println("Miembros después de agregar roles e instrumentos:\n" + controlMiembros.toString());

            // Eliminar un miembro
            controlMiembros.eliminarMiembro("123456789");

            // Imprimir información de miembros después de eliminar un miembro
            System.out.println("Miembros después de eliminar un miembro:\n" + controlMiembros.toString());


            /**
             * Prueba de funcionalidad C se valida mediante los print Anteriores
             */

        /*
        Prueba de funcionalida D, E y F
         */
            // Crear instancia de ControlAlbum
            ControlAlbum controlAlbum = new ControlAlbum();

            // Agregar un nuevo álbum
            controlAlbum.agregarAlbum("Mi Primer Album", LocalDate.of(2023, 11, 22));

            // Imprimir información de álbumes antes de agregar canciones
            System.out.println("Álbumes antes de agregar canciones:\n" + controlAlbum.toString());

            // Crear instancia de ControlCancion
            ControlCancion controlCancion = new ControlCancion();

            // Agregar canciones al álbum
            controlCancion.agregarCancion("Cancion1", LocalTime.of(0, 3, 30), "Mi Primer Album");
            controlCancion.agregarCancion("Cancion2", LocalTime.of(0, 4, 15), "Mi Primer Album");

            // Eliminar una canción
            controlCancion.eliminarCancion("Cancion1");

            // Consultar canciones por álbum
            String cancionesXAlbum = controlCancion.consultarCancionesXAlbum("Mi Primer Album");
            System.out.println("Canciones del álbum 'Mi Primer Album':\n" + cancionesXAlbum);


            /**
             * Prueba de Funcionalidad G y J
             */
            // Crear instancia de ControlConcierto
            ControlConcierto controlConcierto = new ControlConcierto();

            // Programar conciertos
            controlConcierto.programarConcierto("Concierto1", "Lugar1", LocalDate.of(2023, 12, 1), LocalTime.of(20, 0), 1000, "CODIGO1");
            controlConcierto.programarConcierto("Concierto2", "Lugar2", LocalDate.of(2023, 12, 15), LocalTime.of(19, 30), 800, "CODIGO2");

            // Imprimir información de conciertos
            System.out.println("Información de conciertos:" + controlConcierto.consultarConciertos());

        }
    }
