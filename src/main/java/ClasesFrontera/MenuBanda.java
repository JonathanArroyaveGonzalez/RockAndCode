package ClasesFrontera;

import ClasesEntidad.Banda;
import Controles.ControlAlbum;
import Controles.ControlConcierto;
import Controles.ControlMiembros;

import javax.swing.*;
import java.awt.*;

/**
 * Descripcion de la Clase
 *
 * @author Jonathan A.
 * @version 1.0
 */
public class MenuBanda {
    private Banda banda;
    private MenuAlbum menuAlbum;
    private MenuConcierto menuConcierto;
    private MenuMiembros menuMiembros;

    public MenuBanda() {
        this.menuAlbum = new MenuAlbum();
        this.menuConcierto = new MenuConcierto();
        this.menuMiembros = new MenuMiembros();
    }

    public void iniciarMenu() {
        int opcion = 6;
        if (this.registrarDatosBanda(1)) {
            String textoMenu = " Bienvenido \n" +
                    "Ingrese la opción de la acción que desea realizar:\n" +
                    "1- Actualizar la información de la banda.\n" +
                    "2- Menú Miembros\n" +
                    "3- Menú Album.\n" +
                    "4- Menú Concierto\n"+
                    "5- Consultar la información de la banda.\n" +
                    "6- Salir\n";
            do {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(textoMenu));
                switch (opcion) {
                    case 1:
                        this.registrarDatosBanda(2);
                        break;
                    case 2:
                        this.menuMiembros.menuMiembros();
                        break;
                    case 3:
                        this.menuAlbum.menuAlbum();
                        break;
                    case 4:
                        this.menuConcierto.menuConcierto();
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, this.banda.toString());
                        break;
                    default:
                        break;
                }
            } while (opcion != 6);
        }
    }



    public boolean registrarDatosBanda(int seleccion){
        // Título y mensaje del JOptionPane
        String mensaje = "BANDA ROCK & CODE";

        // Etiquetas y campos para la entrada de datos
        String[] labels = {"Género: ", "Fecha de Creación \n Formato DD/MM/AA: "};
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
            String genero = textFields[0].getText();
            String fechaCreacion = textFields[1].getText();

            switch (seleccion){
                case 1: this.banda=new Banda(genero,fechaCreacion);
                case 2: if (genero.isEmpty()){
                            break;
                        }else
                            {
                                this.banda.setGenero(genero);
                            }
                        if(fechaCreacion.isEmpty()){
                            break;
                        }else
                        {
                            this.banda.setFechaCreacion(fechaCreacion);
                        }
                default: break;
            }
            this.banda=new Banda(genero,fechaCreacion);
            JOptionPane.showMessageDialog(null,this.banda.toString());
            return true;
        }else return false;
    }

}
