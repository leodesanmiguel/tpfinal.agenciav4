package agenciav4.logica;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Leo Martinez
 */
@Entity
@Table(name = "servicio")
public class Servicio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServicio;

    private String tipoDServicios;
    private String descripcionBreve;
    private String destinoS;

    @Temporal(TemporalType.DATE)
    private Date fechaServicio;

    private double costoS;

    /**
     * Cada Servicio puede estar en uno o mas paquetes.
     */
    @ManyToMany
    private List<Paquete> paquetes;

    public Servicio() {
    }

    public Servicio(String tipoDServicios,
             String descripcionBreve, String destinoS, Date fechaServicio,
             double costoS) {

        this.tipoDServicios = tipoDServicios;
        this.descripcionBreve = descripcionBreve;
        this.destinoS = destinoS;
        this.fechaServicio = fechaServicio;
        this.costoS = costoS;

    }

    public int getIdServicio() {
        return idServicio;
    }

    public String getTipoDServicios() {
        return tipoDServicios;
    }

    public void setTipoDServicios(String tipoDServicios) {
        this.tipoDServicios = tipoDServicios;
    }

    public String getDescripcionBreve() {
        return descripcionBreve;
    }

    public void setDescripcionBreve(String descripcionBreve) {
        this.descripcionBreve = descripcionBreve;
    }

    public String getDestinoS() {
        return destinoS;
    }

    public void setDestinoS(String destinoS) {
        this.destinoS = destinoS;
    }

    public Date getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(Date fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public double getCostoS() {
        return costoS;
    }

    public void setCostoS(double costoS) {
        this.costoS = costoS;
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(List<Paquete> paquetes) {
        this.paquetes = paquetes;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fe = sdf.format(fechaServicio);

        return idServicio + ") Tipo: " + tipoDServicios + " ($" + costoS + ")"
                + "\n descripcionBreve=" + descripcionBreve
                + " Fecha del Servicio=" + fe;
    }

}
