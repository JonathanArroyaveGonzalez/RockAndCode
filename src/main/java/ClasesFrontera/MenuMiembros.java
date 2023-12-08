package ClasesFrontera;

import ClasesEntidad.Banda;
import ClasesEntidad.Miembro;
import Controles.ControlMiembros;

import javax.swing.*;
import java.awt.*;

/**
 * Descripcion de la Clase
 *
 * @author Jonathan A.
 * @version 1.0
 */
public class MenuMiembros {
    private ControlMiembros controlMiembros;

    public MenuMiembros() {
        this.controlMiembros= new ControlMiembros();
    }

    public void menuMiembros() {
        while (true) {
            String[] options = {"Agregar Miembro", "Eliminar Miembro", "Buscar Miembro", "Agregar Instrumento",
                    "Agregar Rol", "Información de los miembros", "Salir"};

            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Menú de Miembros",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    agregarMiembro();
                    break;
                case 1:
                    eliminarMiembro();
                    break;
                case 2:
                    buscarMiembro();
                    break;
                case 3:
                    agregarInstrumento();
                    break;
                case 4:
                    agregarRol();
                    break;
                case 5:
                    informacionMiembros();
                    break;
                case 6:
                    return;
            }
        }

    }

    private void agregarMiembro() {
        // Título y mensaje del JOptionPane
        String mensaje = "Agregar Miembro";

        // Etiquetas y campos para la entrada de datos
        String[] labels = {"Cedula: ", "Nombre: ","Dirección: "};
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
            String cedula = textFields[0].getText();
            String nombre = textFields[1].getText();
            String direccion = textFields[1].getText();

            try {
                this.controlMiembros.agregarMiembro(nombre,cedula,direccion);
                JOptionPane.showMessageDialog(null,"Miembro agregado con exito.");
            }catch (IllegalArgumentException exception){
                JOptionPane.showMessageDialog(null,exception.getMessage());
            }


        }
    }


    private void eliminarMiembro() {
        String cedula=JOptionPane.showInputDialog("Ingrese la cedula del miembro: ");
        if(this.controlMiembros.eliminarMiembro(cedula)){
            JOptionPane.showMessageDialog(null,"El miembro con cedula "+cedula+" ha sido eliminado con exito.");
        }else
        {
            JOptionPane.showMessageDialog(null,"No se encontro un miembro registrado con la cedula ingresada.");
        }
    }

    private void buscarMiembro() {
        String cedula=JOptionPane.showInputDialog("Ingrese la cedula del miembro: ");
        Miembro miembro=this.controlMiembros.buscarMiembro(cedula);

        if(miembro!=null){
            JOptionPane.showMessageDialog(null,miembro.toString());
        }
    }

    private void agregarInstrumento() {
        // Título y mensaje del JOptionPane
        String mensaje = "Agregar Instrumento";

        // Etiquetas y campos para la entrada de datos
        String[] labels = {"Cedula: ", "Instrumento (BATERIA,GUITARRA,PIANO,VIOLIN: "};
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
            String cedula = textFields[0].getText();
            String instrumento = textFields[1].getText();

            if(this.controlMiembros.agregarInstrumento(cedula,instrumento)) {
                JOptionPane.showMessageDialog(null,"Instrumento agregado con exito.");
            }else {
                JOptionPane.showMessageDialog(null,"Se produjo un error al agregar el instrumento.");
            }

        }

    }

    private void agregarRol() {
        // Título y mensaje del JOptionPane
        String mensaje = "Agregar Rol";

        // Etiquetas y campos para la entrada de datos
        String[] labels = {"Cedula: ", "Rol (GUITARRISTA,VOCALISTA,BAJISTA,BATERISTA,TECLADISTA,MANAGER): "};
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
            String cedula = textFields[0].getText();
            String rol = textFields[1].getText();

            if(this.controlMiembros.agregarRol(cedula,rol)) {
                JOptionPane.showMessageDialog(null,"Rol agregado con exito.");
            }else {
                JOptionPane.showMessageDialog(null,"Se produjo un error al agregar el rol.");
            }

        }
    }

    private void informacionMiembros() {
        JOptionPane.showMessageDialog(null,this.controlMiembros.toString());
    }
}
