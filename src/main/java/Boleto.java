/**
 * Descripcion de la Clase
 *
 * @author Jonathan A.
 * @version 1.0
 */
public class Boleto {

private int idBoleto;
private int numeroAsiento;
private double valor;
private String fechaCompra;
private String cedulaCliente;

    public Boleto(int idBoleto, int numeroAsiento, double valor, String fechaCompra, String cedulaCliente) {
        this.idBoleto = idBoleto;
        this.numeroAsiento = numeroAsiento;
        this.valor = valor;
        this.fechaCompra = fechaCompra;
        this.cedulaCliente = cedulaCliente;
    }
}
