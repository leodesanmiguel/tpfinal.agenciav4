/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenciav4.logica;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Leo Martinez
 */
@Entity
@Table(name = "empleado")
public class Empleado extends Persona implements Serializable {

    private String suPuesto;
    private String tarea;
    private double sueldo;

    @OneToOne
    private Usuario usuario;

    public Empleado() {
    }

    public Empleado(String nombreP, String apellidoP, String direccionP,
             int dni, Date fechaNacio, String nacionalidad,
             String celular, String email,
            String suPuesto, String tarea, double sueldo) {

        super(nombreP, apellidoP, direccionP, dni, fechaNacio,
                 nacionalidad, celular, email);
        this.suPuesto = suPuesto;
        this.tarea = tarea;
        this.sueldo = sueldo;

    }

    public Empleado(String string, String string0, String string1, int dn, String argentino, String string2, String string3, String string4, String string5, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getSuPuesto() {
        return suPuesto;
    }

    public void setSuPuesto(String suPuesto) {
        this.suPuesto = suPuesto;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    
    ////////////////////////////////////////////
    //  F U N C I O N E S 
    ////////////////////////////////////////////
    // Convertir una fecha de LocalDate a Date usando ZoneId del sistema
    public LocalDateTime ld2D(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    @Override
    public String toString() {

        return  "  Puesto:" + suPuesto + " (" + sueldo + ")"
                + "\n apyno: " + super.getApellidoP() 
                + ", " + super.getNombreP() + " (" + super.getDni() + ")";
    }

}
