package agenciav4.logica;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import agenciav4.persistencia.ControladoraPersistencia;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import static java.time.LocalDate.now;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo Martinez
 */
public class Controladora {

    ControladoraPersistencia ctrlJPA = new ControladoraPersistencia();

    //////////////////////////////////////////////////////////////
    //  CONTROL DE LA LÓGICA
    //////////////////////////////////////////////////////////////
    public String verificarUsuario(String usuario, String password, String empleado) {
        System.out.println("Verificando Usuario <<ctrl>> : " + usuario + " " + password + " " + empleado);
        switch (empleado.toUpperCase()) {
            case "ADMIN":
                if (usuario.equals(empleado) && password.equals(empleado)) {
                    //usrAprobado = ctrlJPA.verificaUsuario(usuario, password, "ADMIN");
                    System.out.println("Yendo a crear bases...");
                    ctrlJPA.crearBases();
                    return "inicial.jsp";
                } else {
                    return "noverificado.jsp";
                }

            case "JEFE":
                if (ctrlJPA.verificaUsuario(usuario, password, "JEFE")) {
                    return "index.jsp";
                } else {
                    return "noverificado.jsp";
                }

            case "VENDEDOR":
                if (ctrlJPA.verificaUsuario(usuario, password, "VENDEDOR")) {
                    return "index.jsp";
                } else {
                    return "noverificado.jsp";
                }

        }

        return "index.jsp";
    }

    public boolean verificarJefe(String usuario, String password) {

        return false;
    }

    public boolean verificarVendedor(String usuario, String password) {

        return false;
    }

    public boolean verificarUsuario(String usuario, String password) {

        return false;
    }

    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public List<Cliente> obtenerClientes() {

        return ctrlJPA.obtenerClientes();

    }

    public boolean borrarCliente(int dn) {

        return ctrlJPA.borrarCliente(dn);

    }

    public Cliente modificarCliente(int dn) {

        return ctrlJPA.obtener1Cliente(dn);
    }

    public void modificarCliente(
            String frmNombre, String frmApellido, String frmDomicilio,
            String frmDNI, String frmFechaN, String frmNacional,
            String frmCelular, String frmEmail) {

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = Date.from(Instant.now());
        try {
            fecha = formato.parse(frmFechaN);
        } catch (ParseException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);

        }

        int dn = Integer.parseInt(frmDNI);
        Cliente c = new Cliente(frmNombre, frmApellido, frmNacional, dn, fecha, frmNacional, frmCelular, frmEmail);
        ctrlJPA.editarCliente(c);

    }

   

}
