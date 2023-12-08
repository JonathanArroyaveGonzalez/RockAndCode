package ClasesFrontera;

import Controles.ControlConcierto;

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
public class MenuConcierto {
    private ControlConcierto controlConcierto;

    public MenuConcierto() {
        this.controlConcierto = new ControlConcierto();
    }

    public void menuConcierto(){
        while (true) {
            String[] options = {"Programar Concierto", "Consultar Conciertos", "Salir"};

            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Menú Concierto",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    this.programarConcierto();
                    break;
                case 1:
                    this.consultarConciertos();
                    break;
                case 2:
                    return;
            }
        }
    }
    private void programarConcierto (){
        // Título y mensaje del JOptionPane
        String mensaje = "Agregar Miembro";

        // Etiquetas y campos para la entrada de datos
        String[] labels = {"Nombre: ", "Lugar: ","Año: ","Mes:","Dia:","Hora:","Minutos:","Segundos:","Capacidad:","Codigo:"};
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
            String lugar = textFields[1].getText();
            int ano = Integer.parseInt(textFields[2].getText());
            int mes = Integer.parseInt(textFields[3].getText());
            int dia = Integer.parseInt(textFields[4].getText());
            int hora = Integer.parseInt(textFields[5].getText());
            int minutos = Integer.parseInt(textFields[6].getText());
            int segundos = Integer.parseInt(textFields[7].getText());
            LocalDate fecha=LocalDate.of(ano,mes,dia);
            LocalTime horaConcierto=LocalTime.of(hora,minutos,segundos);
            int capacidad = Integer.parseInt(textFields[8].getText());
            String codigo = textFields[9].getText();

            try {
                if(this.controlConcierto.programarConcierto(nombre,lugar,fecha,horaConcierto,capacidad,codigo)){
                    JOptionPane.showMessageDialog(null,"Concierto Programado con exito.");
                }else
                {
                    JOptionPane.showMessageDialog(null,"Ya existe un concierto con el mismo nombre.");

                }

            }catch (IllegalArgumentException exception){
                JOptionPane.showMessageDialog(null,exception.getMessage());
            }

        }

    }

    private void consultarConciertos(){
        JOptionPane.showMessageDialog(null,this.controlConcierto.consultarConciertos());
    }
}
