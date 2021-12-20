
package agenciav4.logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Leo Martinez
 */
@Entity
@Table(name = "cliente")
public class Cliente extends Persona implements Serializable {

    
    
    /**
     * Los clientes realizan compras puede haber una o varias Las compras son
     * las ventas de la AGENCIA
     *
     */
    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Venta> compras;


    public Cliente() {
    }

    public Cliente( String nombreP, String apellidoP, String direccionP
            , int dni, Date fechaNacio, String nacionalidad
            , String celular, String email) {
        super(nombreP, apellidoP, direccionP, dni
                , fechaNacio, nacionalidad, celular, email);
        
 
    }

    
    
    public List<Venta> getCompras() {
        return compras;
    }

    public void setCompras(List<Venta> compras) {
        this.compras = compras;
    }

    @Override
    public String toString() {
        return "Cliente: " 
                + super.getApellidoP() + ", " + super.getNombreP() + "("+ super.getDni() +")";
    }

        
    
}
