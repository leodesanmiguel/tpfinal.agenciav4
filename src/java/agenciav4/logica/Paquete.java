package agenciav4.logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Leo Martinez
 */
@Entity
@Table(name = "paquete")
public class Paquete implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPaquete;

    private double costoPaquete;
    private String nombrePaquete;
    private double descuento;

    @ManyToMany
    private List<Servicio> servicios;

    public Paquete() {
    }

    public Paquete(double costoPaquete, double descuento,
            String nombrePaquete,
            List<Servicio> servicios) {
        this.costoPaquete = costoPaquete;
        this.descuento = descuento;
        this.nombrePaquete = nombrePaquete;
        this.servicios = servicios;
    }

    public int getIdPaquete() {
        return idPaquete;
    }

    public double getCostoPaquete() {
        return costoPaquete;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String getNombrePaquete() {
        return nombrePaquete;
    }

    public void setNombrePaquete(String nombrePaquete) {
        this.nombrePaquete = nombrePaquete;
    }

    
    
    public List<Servicio> getServicios() {

        return servicios;
    }

    /**
     * El paquete contiene unalista de servicios.Cuando se le asigna los
     * servicios se calcula el costo del paquete También se supone que todos los
     * paquetes que tengan mas de un servicio se asigna un descuento que no
     * indicarlo se le asigna un 10%
     *
     *
     * @param servicios
     */
    public void setServicios(List<Servicio> servicios) {
        // al asignar los servicios se debe consignar el costo del paquete

        double costo = 0;

        for (Servicio s : servicios) {
            costo += s.getCostoS();
        }
        if (this.descuento == 0) {
            this.descuento = 10 / 100;
        }
        if (servicios.size() > 1) {
            costo *= 1 - this.descuento;
        }

        this.costoPaquete = costo;
        this.servicios = servicios;
    }

    @Override
    public String toString() {
        return "Paquete " + "$" + costoPaquete + ", descuento=" + descuento + '}';
    }

}
