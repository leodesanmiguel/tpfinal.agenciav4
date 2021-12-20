package agenciav4.logica;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import agenciav4.persistencia.ControladoraPersistencia;

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
        System.out.println("Verificando Usuario <<ctrl>> : " + usuario + " " + password + " "+ empleado);
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

}
