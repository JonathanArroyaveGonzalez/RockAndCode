package ClasesFrontera;

import Controles.ControlAlbum;
import Controles.ControlMiembros;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Descripcion de la Clase
 *
 * @author Jonathan A.
 * @version 1.0
 */
public class MenuAlbum {
    private ControlAlbum controlAlbum;

    public MenuAlbum() {
        this.controlAlbum = new ControlAlbum();
    }
    public void menuAlbum() {
        while (true) {
            String[] options = {"Agregar Album", "Agregar canción a un album", "Consultar canciones de un album", "Salir"};

            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Menú  Album",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    this.crearAlbum();
                    break;
                case 1:
                    this.agregarCancionAAlbum();
                    break;
                case 2:
                    this.consultarCancionesAlbum();
                    break;
                case 3:
                    return;
            }
        }
    }
    private void crearAlbum(){
        // Título y mensaje del JOptionPane
        String mensaje = "Agregar Album";

        // Etiquetas y campos para la entrada de datos
        String[] labels = {"Nombre: ", "Año: ","Mes: ","Dia: "};
        JTextField[] textFields = new JTextField[labels.length];

        // Crear los campos de texto
        for (int i = 0; i < labels.length; i++) {
            textFields[i] = new JTextField();
        }

        // Crear el panel para los componentes
        JPanel panel = new JPanel(new GridLayout(labels.length, 2));

        // Agregar etiquetas y campos al panel
        for (int i = 0; i < labels.length; i++) {
            panel.add(new JLabel(labels[i]));
            panel.add(textFields[i]);
        }

        // Mostrar el JOptionPane con el panel personalizado
        int option = JOptionPane.showConfirmDialog(null, panel, mensaje, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Procesar la entrada si se hace clic en "OK"
        if (option == JOptionPane.OK_OPTION) {
            // Obtener los valores de los campos
            String nombre = textFields[0].getText();
            int ano = Integer.parseInt(textFields[1].getText());
            int mes = Integer.parseInt(textFields[2].getText());
            int dia = Integer.parseInt(textFields[3].getText());
            try {
                if (this.controlAlbum.agregarAlbum(nombre,LocalDate.of(ano, mes, dia))){
                    JOptionPane.showMessageDialog(null,"Album creado con exito.");
                }
            }catch (IllegalArgumentException exception){
                JOptionPane.showMessageDialog(null,exception.getMessage());
            }
        }
    }

    private void agregarCancionAAlbum(){
        // Título y mensaje del JOptionPane
        String mensaje = "Agregar Cancion";

        // Etiquetas y campos para la entrada de datos
        String[] labels = {"Nombre Album: ", "Nombre Cancion: ","Horas: ","Minutos: ","Segundos"};
        JTextField[] textFields = new JTextField[labels.length];

        // Crear los campos de texto
        for (int i = 0; i < labels.length; i++) {
            textFields[i] = new JTextField();
        }

        // Crear el panel para los componentes
        JPanel panel = new JPanel(new GridLayout(labels.length, 2));

        // Agregar etiquetas y campos al panel
        for (int i = 0; i < labels.length; i++) {
            panel.add(new JLabel(labels[i]));
            panel.add(textFields[i]);
        }

        // Mostrar el JOptionPane con el panel personalizado
        int option = JOptionPane.showConfirmDialog(null, panel, mensaje, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Procesar la entrada si se hace clic en "OK"
        if (option == JOptionPane.OK_OPTION) {
            // Obtener los valores de los campos
            String nombreAlbum = textFields[0].getText();
            String nombreCancion = textFields[1].getText();
            int hora = Integer.parseInt(textFields[2].getText());
            int minutos = Integer.parseInt(textFields[3].getText());
            int segundos = Integer.parseInt(textFields[4].getText());
            try {
                if (this.controlAlbum.agregarCancion(nombreCancion, LocalTime.of(hora, minutos, segundos),nombreAlbum)){
                    JOptionPane.showMessageDialog(null,"Canción Agregada al album.");
                }
            }catch (IllegalArgumentException exception){
                JOptionPane.showMessageDialog(null,exception.getMessage());
            }
        }
    }

    private void consultarCancionesAlbum(){
        String nombreAlbum=JOptionPane.showInputDialog("Ingrese el nombre del album");
        if(this.controlAlbum.consultarAlbum(nombreAlbum)){
            JOptionPane.showMessageDialog(null,this.controlAlbum.consultarCancionesDeAlbum(nombreAlbum));
        }else
        {
            JOptionPane.showMessageDialog(null,"No se encontro un album con el nombre ingresado.");
        }
    }

}
