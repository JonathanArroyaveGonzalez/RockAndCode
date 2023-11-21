/**
 * Descripcion de la Clase
 *
 * @author Jonathan A.
 * @version 1.0
 */
public class ControlBanda {
    private Banda banda;


    public ControlBanda() {
        this.banda = new Banda("Rock","21/11/2023");
    }

    public void agregarFotos(String rutaFoto){
        this.banda.agregarFoto(rutaFoto);
    }
}
