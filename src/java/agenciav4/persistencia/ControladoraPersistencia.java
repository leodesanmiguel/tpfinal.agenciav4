package agenciav4.persistencia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import agenciav4.logica.Empleado;
import agenciav4.logica.Paquete;
import agenciav4.logica.Servicio;
import agenciav4.logica.Usuario;
import agenciav4.persistencia.exceptions.IllegalOrphanException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo Martinez
 */
public class ControladoraPersistencia {

    //////////////////////////////////////////////////////////////
    //  CONTROL DE PERSISTENCIA
    //////////////////////////////////////////////////////////////
    // personas clientes --> Podria estar Package Clientes
    PersonaJpaController persJPA = new PersonaJpaController();
    ClienteJpaController clieJPA = new ClienteJpaController();
    // Empleados y usuarios --> Podria estar Package Empleados
    EmpleadoJpaController empleJPA = new EmpleadoJpaController();
    UsuarioJpaController userJPA = new UsuarioJpaController();
    // Productos y Servicios --> Podria estar Package Productos
    ServicioJpaController serviJPA = new ServicioJpaController();
    PaqueteJpaController paqueJPA = new PaqueteJpaController();
    VentaJpaController ventaJPA = new VentaJpaController();
    //////////////////////////////////////////////////////////////

    public boolean verificaUsuario(String usuario, String password, String empleado) {
        System.out.println("Verificando Usuario <<ctrlJPA>> : " + usuario + " " + password + " " + empleado);

        //boolean si=false;
        List<Usuario> uss = userJPA.findUsuarioEntities();
        for (Usuario u : uss) {
            if (u.getNombreUsr().equals(usuario) && u.getPassword().equals(password)) {
                return true;
                //si=true;
                //break;
            }
        }
        return false;
    }

    /**
     * CREANDO BASES INICIALES
     * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     * PERMITE CREAR DATOS DEL SISTEMA EN FORMA AUTOMÁTICA
     * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     *
     */
    public void crearBases() {

        //  Crear SERVICIOS pautados en el PDF
        crearServicios();
        //  Crear PAQUETES 
        crearPaquetes();
        //  Crear Empleados y Usuarios
        crearEmpleados();
        //  Crear Empleados y Usuarios
        crearClientes();

    }

    /**
     * Servicios
     *
     * Recorre cada Seervicio y genera un registro. Esto lo hace por unica vez
     *
     */
    private void crearServicios() {
        try {
            String[] tS = new String[]{"HOTEL POR NOCHE", "ALQUILER DE AUTO",
                "PASAJE DE COLECTIVO", "PASAJE DE AVIÓN", "PASAJE DE TREN",
                "EXCURSIÓN", "ENTRADAS A EVENTOS"};
            String[] tDV = new String[]{"Cada noche de Hotel",
                "Se alquila el auto, con un kilometraje fijo.",
                "Cada Pasaje de Colectivo",
                "Cada Pasaje de avión",
                "Cada Pasaje de tren",
                "Una excursión de turistica",
                "el ingreso a un evento."};
            double[] c = new double[]{3000, 5000, 1000, 50000,
                1500, 3500, 10000};

            List<Servicio> ss = serviJPA.findServicioEntities();
            if (ss.isEmpty()) {

                for (int i = 0; i < tS.length; i++) {
                    Servicio servi = new Servicio();
                    servi.setTipoDServicios(tS[i]);
                    servi.setDescripcionBreve(tDV[i]);
                    servi.setDestinoS("...");
                    Date fechaServicio = new Date();
                    servi.setFechaServicio(fechaServicio);
                    servi.setCostoS(c[i]);
                    serviJPA.create(servi);
                    int nro = serviJPA.getServicioCount();
                    System.out.println("Creo el servicio Nro: " + nro
                            + "\n" + servi);
                }

            }

        } catch (Exception e) {
            System.out.println("\n****"
                    + "********  No se Creo la forma de Pago .....\n");
        }
    }

    /**
     * Paquetes
     *
     * Recorre cada Seervicio y genera un registro en Paquete. Se agregan otros
     * paquetes con varios servicios. Esto lo hace por unica vez
     *
     */
    private void crearPaquetes() {
        List<Servicio> ss = serviJPA.findServicioEntities();
        for (Servicio s : ss) {

            double c = s.getCostoS();
            List<Servicio> se = new ArrayList<>();
            se.add(s);
            Paquete pq = new Paquete(c, 0, se);
            paqueJPA.create(pq);
            int nro = paqueJPA.getPaqueteCount();
            System.out.println("Creo el paquete Nro: " + nro
                    + "\n" + pq);
        }
        // "HOTEL POR NOCHE", "ALQUILER DE AUTO",
        // "PASAJE DE COLECTIVO", "PASAJE DE AVIÓN", "PASAJE DE TREN",
        // "EXCURSIÓN", "ENTRADAS A EVENTOS";
        int[][] ssr = {{1, 3}, {1, 2, 4}, {1, 3, 6}, {3, 6, 7}};

        for (int[] s : ssr) {
            List<Servicio> se = new ArrayList<>();
            double c = 0;
            for (int j = 0; j < s.length; j++) {
                Servicio se1 = serviJPA.findServicio(s[j]);
                se.add(se1);
                c += se1.getCostoS();
            }
            c *= 0.9;
            Paquete pq = new Paquete(c, 0.1, se);
            paqueJPA.create(pq);
            int nro = paqueJPA.getPaqueteCount();
            System.out.println("Creo el paquete Nro: " + nro
                    + "\n" + pq);

        }

    }

    /**
     * Empleados
     *
     * Crear al manos un Admin, un Jefe y Un Vendedor
     *
     */
    private void crearEmpleados() {
        String[][] eMs = new String[][]{
            {"MEMOLI", "RUTH ESTEFANIA", "1162884470", "Las Delicias", "ruth.estefania208@gmail.com", "Jefe", "1985-12-15", "39144923", "100000"},
            {"AGUSTINELLI", "MARIELA ELIZABETH", "1152920038", "Luis Maria Campos 2178  ", "mariela.elizabeth585@gmail.com", "Jefe", "1997-08-29", "46514699", "100000"},
            {"TORREZ", "PAOLA DEL CARMEN", "1168789470", "Alejandro Sirio 3417", "paola.del.carmen702@gmail.com", "Jefe", "1971-07-24", "35265817", "100000"},
            {"URQUIJO", "MARÍA ALEJANDRA LEONOR", "1120624906", "Salguero 3957", "maría.alejandra.leonor630@gmail.com", "Jefe", "1987-06-17", "51584081", "100000"},
            {"VERGARA", "ROSANA BEATRIZ", "1550296920", "Adolfo Alsina 2441", "rosana.beatriz952@gmail.com", "Jefe", "1974-11-13", "53045177", "100000"},
            {"ZAPATA", "MARIA DEL ROSARIO", "1150042512", "Isabel la Catolica", "maria.del.rosario460@gmail.com", "Vendedor", "1977-06-09", "48475827", "70000"},
            {"GAUNA", "DIAMELA AYELÉN", "1138339839", "mexico 878", "diamela.ayelén789@gmail.com", "Vendedor", "1960-09-07", "36921131", "70000"},
            {"ACUÑA", "SANDRA PAOLA", "1161722706", "Portugal 5538", "sandra.paola563@gmail.com", "Vendedor", "1985-06-25", "45653845", "70000"},
            {"THOMPSON", "MALENA DEL PILAR", "1151778185", "Arroyo 289", "malena.del.pilar565@gmail.com", "Vendedor", "1965-12-29", "47415935", "70000"},
            {"GIORGI", "MARCELA ALEJANDRA", "1144515996", " EL CALLAO 745", "marcela.alejandra755@gmail.com", "Vendedor", "1969-05-11", "37631235", "70000"},
            {"GRISETTI", "EVA NATALIA", "1122509023", "CAÑONERA TORTUGA  1372", "eva.natalia177@gmail.com", "Vendedor", "1973-11-21", "52037316", "70000"},
            {"CARDOZO", "CARLA", "1156172092", "Cruz del sur 1912", "carla503@gmail.com", "Vendedor", "1979-11-12", "71820903", "70000"},
            {"CONTARDO", "CINTIA ELIZABETH", "1151598110", "conesa 4743", "cintia.elizabeth386@gmail.com", "Vendedor", "1987-11-19", "56828023", "70000"},
            {"ZAPATA", "RUTH ESTEFANIA", "1138710762", "Copello 1350", "ruth.estefania554@gmail.com", "Vendedor", "1980-01-08", "55220001", "70000"},
            {"AVILA", "ANALÍA AGOSTINA", "1133070528", "Las Heras 1825", "analía.agostina352@gmail.com", "Vendedor", "1967-03-07", "55966867", "70000"},
            {"INSAURRALDE", "MARIELA ELIZABETH", "1144558061", "sarmiento2987", "mariela.elizabeth996@gmail.com", "Vendedor", "1982-02-06", "70029489", "70000"},
            {"ROBLES", "MARCELA VERONICA", "1155954339", "Isabel la Catolica", "marcela.veronica557@gmail.com", "Vendedor", "1975-11-06", "54675205", "70000"},
            {"DOMINGUEZ", "LUCÍA INÉS", "2320627498", "Chopin 445", "lucía.inés993@gmail.com", "Vendedor", "1987-05-09", "63900955", "70000"}};

        for (String[] e : eMs) {
            /*
            //0	1	2	3	4	5	6	7	8
         //ape  nocom	cel	dire	emai	pues	naci	dni	suel
            
         // direccionP, 0, fechaNacio, nacionalidad, celular, email, suPuesto, tarea, 0
            
  public Empleado(String nombreP, String apellidoP, String direccionP,
             int dni, Date fechaNacio, String nacionalidad,
             String celular, String email,
            String suPuesto, String tarea, double sueldo) {
             */
            Date dat = new Date();
            int dn = Integer.parseInt(e[7]);
            double su = Double.parseDouble(e[8]);
            String fe = e[6];
            try {
                dat = new SimpleDateFormat("yyyy-MM-dd").parse(fe);
            } catch (ParseException ex) {
                Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            }

            Empleado em = new Empleado(
                    e[1], e[0], e[3],
                    dn, dat, "argentino",
                    e[2], e[4], e[5], "...", su);
            System.out.println("Empleado: " + em);

            Usuario u = new Usuario( dn + "", "12345", true);
            
            userJPA.create(u);
            int nro = userJPA.getUsuarioCount();
            Usuario us1 = userJPA.findUsuario(nro);
            System.out.println("Creo el Usuario Nro: " + nro
                    + "\n" + us1);
            
            em.setUsuario(u);

            empleJPA.create(em);
            nro = paqueJPA.getPaqueteCount();
            Empleado em1 = empleJPA.findEmpleado(nro);
            System.out.println("Creo el empleado Nro: " + nro
                    + "\n" + em1);

           
        }

    }

    /**
     * Clientes
     *
     * Crear al manos 10 clientes
     *
     */
    private void crearClientes() {

    }

    public boolean existeUsuario(Usuario usua) {
        boolean existe = false;
        List<Usuario> uss = userJPA.findUsuarioEntities();

        for (Usuario u : uss) {
            if (u.getNombreUsr().equals(usua.getNombreUsr()) || u.getPassword().equals(usua.getPassword())) {
                System.out.println("El usuario EXISTE !!" + u);
                existe = true;
                break;
            }
        }
        return existe;
    }

}
