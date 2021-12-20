package agenciav4.logica;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Leo Martinez
 */
@Entity
@Table(name = "venta")
public class Venta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDVENTA")
    private int idVenta;

    @Temporal(TemporalType.DATE)
    private Date fechaVenta;

    private double importe;
    private boolean estaPago;
    private String medioDPago;

    /**
     * Cada venta tiene un cliente como comprador
     */
    @ManyToOne(targetEntity = Cliente.class)
    @JoinColumn(name = "IDPERSONA")
    private Cliente cliente;

    /**
     * Cada venta tiene un usuario que es empleado y tiene la funcion de
     * vendedor
     *
     */
    @ManyToOne
    @JoinColumn(name = "IDUSUARIO", nullable = false)
    private Usuario usuario;

    /**
     * Cada venta se realiza en forma individual o de forma de paquete.
     */
    String Contratacion;

    /**
     * Un paquete puede tener un solo servicio o puede tener varios servicios
     * juntos. De forma que todas las ventas tienen un paquete.<p>
     * Todas las ventas tienen un solo paquete
     */
    @ManyToOne
    @JoinColumn(name = "IDPAQUETE")
    private Paquete paquete;

    public Venta() {
    }

    public Venta(Date fechaVenta, double importe, String medioDPago,
            boolean estaPago, Cliente cliente,
            Usuario usuario, String Contratacion, Paquete paquete) {

        this.fechaVenta = fechaVenta;
        this.importe = importe;
        this.estaPago = estaPago;
        this.cliente = cliente;
        this.usuario = usuario;
        this.Contratacion = Contratacion;
        this.paquete = paquete;
        this.medioDPago = medioDPago;

    }

    public int getIdVenta() {
        return idVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getMedioDPago() {
        return medioDPago;
    }

    public void setMedioDPago(String medioDPago) {
        this.medioDPago = medioDPago;
    }

    public boolean isEstaPago() {
        return estaPago;
    }

    public void setEstaPago(boolean estaPago) {
        this.estaPago = estaPago;
    }

    public Cliente getComprador() {
        return cliente;
    }

    public void setComprador(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getContratacion() {
        return Contratacion;
    }

    public void setContratacion(String Contratacion) {
        this.Contratacion = Contratacion;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    @Override
    public String toString() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String fe = sdf.format(fechaVenta);
        
        return " VENTA NRO: xxx " + ", fechaVenta=" + fe
                                + "\n Vendedor.......: " + usuario
                + "\n Contratacion...: " + Contratacion
                + "\n Paquete=" + paquete.getIdPaquete() + " ($" + paquete.getCostoPaquete() + ")";
    }

}
