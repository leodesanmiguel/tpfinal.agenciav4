package agenciav4.persistencia;

import agenciav4.logica.Cliente;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import agenciav4.logica.Empleado;
import agenciav4.logica.Paquete;
import agenciav4.logica.Persona;
import agenciav4.logica.Servicio;
import agenciav4.logica.Usuario;
import agenciav4.logica.Venta;
import agenciav4.persistencia.exceptions.IllegalOrphanException;
import agenciav4.persistencia.exceptions.NonexistentEntityException;
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
        //  Crear Clientes
        crearClientes();

        //  Crear Ventas
        crearVentas();

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

                    int nro = (int) verificarSiEsta("servicio", servi.getTipoDServicios());
                    String esta = " **** ESTÁ CREADO DESDE ANTES";
                    if (nro == 0) {
                        serviJPA.create(servi);
                        nro = serviJPA.getServicioCount();
                        esta = "  <<<  de C R E A C I Ó N  >>>";
                    }

                    System.out.println("SERVICIO Nro: " + nro + esta
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
            Paquete pq = new Paquete(c, 0, s.getTipoDServicios(), se);
            paqueJPA.create(pq);
            int nro = paqueJPA.getPaqueteCount();
            System.out.println("Creo el paquete Nro: " + nro
                    + "\n" + pq);
        }
        // "HOTEL POR NOCHE", "ALQUILER DE AUTO",
        // "PASAJE DE COLECTIVO", "PASAJE DE AVIÓN", "PASAJE DE TREN",
        // "EXCURSIÓN", "ENTRADAS A EVENTOS";
        int[][] ssr = {{1, 3}, {1, 2, 4}, {1, 3, 6}, {3, 6, 7}};
        String[] ssn = new String[]{"Noche+bus", "Hotel+Auto+Avion",
            "Hotel+Bus+Excursion", "bus+excursion+evento"};

        int i = 0;
        for (int[] s : ssr) {

            List<Servicio> se = new ArrayList<>();
            double c = 0;
            for (int j = 0; j < s.length; j++) {
                Servicio se1 = serviJPA.findServicio(s[j]);
                se.add(se1);
                c += se1.getCostoS();
            }
            c *= 0.9;
            Paquete pq = new Paquete(c, 0.1, ssn[i], se);

            // verificando si ya existe
            int nro = (int) verificarSiEsta("paquete", ssn[i]);
            i++;
            String esta = " **** ESTÁ CREADO DESDE ANTES";
            if (nro == 0) {
                paqueJPA.create(pq);
                nro = paqueJPA.getPaqueteCount();
                esta = "  <<<  de C R E A C I Ó N  >>>";
            }

            System.out.println("PAQUETE Nro: " + nro + esta
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

            Usuario u = new Usuario(dn + "", "12345", true);

            // verificando si ya existe usuario
            int nro = (int) verificarSiEsta("usuario", dn + "");

            String esta = " **** ESTÁ CREADO DESDE ANTES";
            if (nro == 0) {
                userJPA.create(u);
                nro = userJPA.getUsuarioCount();
                esta = "  <<<  de C R E A C I Ó N  >>>";
            }
            Usuario us1 = userJPA.findUsuario(nro);

            System.out.println("USUARIO Nro: " + nro + esta
                    + "\n" + us1);

            em.setUsuario(us1);

            // verificando si ya existe empleado
            nro = (int) verificarSiEsta("empleado", dn + "");

            esta = " **** ESTÁ CREADO DESDE ANTES";
            if (nro == 0) {
                empleJPA.create(em);
                nro = paqueJPA.getPaqueteCount();
                esta = "  <<<  de C R E A C I Ó N  >>>";
            }

            Empleado em1 = empleJPA.findEmpleado(nro);
            System.out.println("EMLEADO Nro: " + nro + esta
                    + "\n" + em1);

        }

    }

    /**
     * Clientes
     *
     * Crear al manos 10 clientes
     *
     *
     */
    private void crearClientes() {

        String[][] eMs = new String[][]{
            {"AGUSTINELLI", "SOFIA ELENA", "1166837154", " Gabriel Miro 2881", "sofia.elena179@gmail.com", "33333333", "1970-06-25", "argentino"},
            {"BALCASA", "ANDREA EVELYN", "1165164353", "Fernández Moreno 1415", "andrea.evelyn188@gmail.com", "77777777", "1988-06-19", "argentino"},
            {"BARRIOS", "SONIA INES", "1150587598", "Rawson 5715", "sonia.ines941@gmail.com", "55611110", "1979-01-01", "argentino"},
            {"CONTARDO", "JULIETA ANABELLA", "1122008549", "Salguero 1869", "julieta.anabella528@gmail.com", "89777776", "1964-01-10", "argentino"},
            {"CORONEL", "KAREN AGUSTINA", "1167805264", "paez 1882", "karen.agustina615@gmail.com", "22244444", "1991-05-18", "argentino"},
            {"CORTELL CUBÍ", "KAREN MICHELLE", "1135090901", "Lourdes 2657", "karen.michelle485@gmail.com", "33366666", "1990-09-20", "argentino"},
            {"DOMINGUEZ", "DAIANA NOEMI", "2320437458", "Carlos Calvo 760", "daiana.noemi637@gmail.com", "11222222", "1978-06-02", "argentino"},
            {"GAYOSO",
                "MALENA SOLANA AGUSTINA", "1128679238", "25 DE MAYO 1496", "malena.solana.agustina671@gmail.com", "22224444", "1994-04-18", "argentino"},
            {"GIORGI",
                "ELIANA AGUSTINA", "2320696354", "12 de Octubre 2431", "eliana.agustina825@gmail.com", "56111110", "1983-07-24", "argentino"},
            {"GRISETTI",
                "MARÍA ANGÉLICA", "1160368533", "Paraguay 215", "maría.angélica615@gmail.com", "88888888", "1980-04-20", "argentino"},
            {"INSAURRALDE",
                "FLORENCIA ROMINA", "1136101561", "blandegue", "florencia.romina253@gmail.com", "77855554", "1962-01-07", "argentino"},
            {"JOHO",
                "FREDDY RAUL", "2320696806", "Arias 3300 Manzana 1 Casa 8", "freddy.raul808@gmail.com", "77785554", "1963-07-05", "argentino"},
            {"JUAREZ",
                "MATIAS", "1525155527", "Gregorio Marañon 3748", "matias471@gmail.com", "55561110", "1974-12-14", "argentino"},
            {"LEIVA",
                "MELINA FLAVIA", "2320453039", "PAULA ALBARRACIN 2041", "melina.flavia171@gmail.com", "99999999", "1977-10-01", "argentino"},
            {"LEZCANO DE ROCCO",
                "PAOLA DEL CARMEN", "1165116425", "ZUVIRIA 4439", "paola.del.carmen361@gmail.com", "44888888", "1975-03-03", "argentino"},
            {"LOVASCHI",
                "JOHANNA ELIZABETH", "1140986245", "LABARDEN 1415", "johanna.elizabeth389@gmail.com", "66666666", "1967-06-18", "argentino"},
            {"MARTINEZ",
                "JUAN GABRIEL", "2320551282", "Avenida Croacia 340", "juan.gabriel160@gmail.com", "67333332", "1967-08-05", "argentino"},
            {"NAVARRO",
                "LUCÍA INÉS", "1144947521", "GRANADERO BAIGORRIA 5612", "lucía.inés276@gmail.com", "55555555", "1962-09-24", "argentino"},
            {"ROMERO",
                "JUANA MARÍA", "1123864132", "MARCELO T DE ALVEAR 130", "juana.maría248@gmail.com", "44448888", "1966-05-19", "argentino"},
            {"ROMERO",
                "MARIA DE LA PAZ", "1154002857", "Luis Maria Campos 2178  ", "maria.de.la.paz333@gmail.com", "22444444", "1995-09-24", "argentino"},
            {"SULLCA",
                "LUCILA BELEN", "1165711345", "Corbeta Uruguay 3370", "lucila.belen106@gmail.com", "11122222", "1980-03-20", "argentino"},
            {"THOMPSON",
                "MICAELA FLORENCIA", "1154320501", "EMILIO ZOLA 2084", "micaela.florencia816@gmail.com", "33666666", "1999-11-23", "argentino"},
            {"TORRES",
                "MALENA SOLANA AGUSTINA", "2320484477", "Arechavala 5383", "malena.solana.agustina604@gmail.com", "66673332", "1993-03-09", "argentino"},
            {"VERA",
                "ROSANA ANDREA", "1140518526", "Santiago del Estero 2575", "rosana.andrea593@gmail.com", "44488888", "1968-02-13", "argentino"},
            {"VERGARA",
                "MARIA DE LA PAZ", "1121038044", "Arturo Capdevilla 336", "maria.de.la.paz121@gmail.com", "33336666", "1977-08-28", "argentino"},};

        for (String[] e : eMs) {
//  0               1               2                   3               4                 5         6               7            
//"AGUSTINELLI", "SOFIA ELENA", "1166837154", " Gabriel Miro 2881", "sofi@gmail.com", "33333333", "1970-06-25", "argentino"
            Date dat = new Date();
            int dn = Integer.parseInt(e[5]);

            //String fe = e[6];
            try {
                dat = new SimpleDateFormat("yyyy-MM-dd").parse(e[6]);
            } catch (ParseException ex) {
                Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            }

            //public Cliente( String nombreP, String apellidoP, String direccionP
            //             , int dni, Date fechaNacio, String nacionalidad
            //             , String celular, String email)
            Cliente em = new Cliente(
                    e[1], e[0], e[3],
                    dn, dat, e[7],
                    e[2], e[4]);
            System.out.println("Cliente: " + em);

            // verificando si ya existe Cliente
            int nro = (int) verificarSiEsta("cliente", dn + "");

            String esta = " **** ESTÁ CREADO DESDE ANTES";
            if (nro == 0) {
                clieJPA.create(em);
                nro = clieJPA.getClienteCount();
                esta = "  <<<  de C R E A C I Ó N  >>>";
            }

            Cliente em1 = clieJPA.findCliente(nro);
            System.out.println("CLIENTE Nro: " + nro + esta
                    + "\n" + em1);

        }

    }

    /**
     * VENTAS
     *
     * Crear al manos 10 VENTAS
     *
     *
     */
    public void crearVentas() {

        // Usuarios que van a operar
        int[] usr = {45653845, 52037316, 71820903, 56828023};

        // Crear una lista de clientes que compra
        int[] cli = {66733332, 77855554, 88977776, 11222222, 22444444,
            33666666, 44888888, 56111110, 67333332, 78555554};

        //  paquetes qie van a comprar
        int[] paq = {1, 2, 3, 4, 10, 11, 6, 5, 8, 9};

        //  medios de Pago:  uno por cada venta
        int[] med = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};

        // fecha de venta
        String[] fec = new String[]{"2001-06-15", "2013-11-03", "2016-11-25",
            "2020-01-25", "2012-11-14", "2012-08-25", "2018-09-03",
            "2021-06-14", "2008-03-31", "2015-04-27"};

        int li = 0;
        int ls = 4;
        Date dat = new Date();
        for (int u = usr.length - 1; u > -1; u--) {
            Usuario usuario = buscarUsuario(usr[u]);

            for (int c = li; c < ls; c++) {
                Cliente cliente = buscarComprador(cli[c]);
                Paquete paquete = buscarPaquete(paq[c]);
                String medio = buscarMedio(med[c]);
                double comis = buscarComision(med[c]);

                try {
                    dat = new SimpleDateFormat("yyyy-MM-dd").parse(fec[c]);
                } catch (ParseException ex) {
                    Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
                }

                double importe = calcularImporteVta(paquete, comis, 1);

                String contratacion = buscarContratacion(paquete.getDescuento());

                Venta vta = new Venta(dat, importe, medio, true, cliente, usuario, contratacion, paquete);
                ventaJPA.create(vta);
                int nro = clieJPA.getClienteCount();
                System.out.println(" ✨ *** V E N T A Nro: " + nro
                        + "\n" + vta);

            }
            li = ls;
            ls = ls + u;

        }

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

    public int verificarSiEsta(String queCosa, String identifi) {
        switch (queCosa) {
            case "servicio":
                List<Servicio> ss = serviJPA.findServicioEntities();
                for (Servicio s : ss) {
                    if (identifi.equals(s.getTipoDServicios())) {
                        return (int) s.getIdServicio();
                    }
                }
                break;

            case "empleado":
                List<Empleado> ee = empleJPA.findEmpleadoEntities();
                for (Empleado s : ee) {

                    if (identifi.equals(s.getDni() + "")) {
                        return (int) s.getIdPersona();
                    }
                }
                break;
            case "usuario":
                List<Usuario> uu = userJPA.findUsuarioEntities();
                for (Usuario s : uu) {

                    if (identifi.equals(s.getNombreUsr())) {
                        return (int) s.getIdUser();
                    }
                }
                break;
            case "paquete":
                List<Paquete> pp = paqueJPA.findPaqueteEntities();
                for (Paquete s : pp) {
                    if (identifi.equals(s.getNombrePaquete())) {
                        return (int) s.getIdPaquete();
                    }
                }
                break;

            case "cliente":
                List<Cliente> cc = clieJPA.findClienteEntities();
                for (Cliente s : cc) {

                    if (identifi.equals(s.getDni() + "")) {
                        return (int) s.getIdCliente();
                    }
                }
                break;

        }
        return 0;
    }

    public Usuario buscarUsuario(int dni) {

        try {

            List<Usuario> uss = userJPA.findUsuarioEntities();
            for (Usuario u : uss) {
                if (u.getNombreUsr().equals(dni + "")) {
                    return u;
                }
            }

        } catch (Exception e) {
            System.out.println("\n ERROR AL TRATAR DE BUSCAR USUARIO POR DNI."
                    + "\n" + e);

        }
        return null;

    }

    public Cliente buscarComprador(int dni) {

        try {

            List<Cliente> css = clieJPA.findClienteEntities();
            for (Cliente u : css) {
                if (u.getDni() == dni) {
                    return u;
                }
            }

        } catch (Exception e) {
            System.out.println("\n ERROR AL TRATAR DE BUSCAR USUARIO POR DNI."
                    + "\n" + e);

        }
        return null;
    }

    public Paquete buscarPaquete(int idPaquete) {

        try {
            return paqueJPA.findPaquete(idPaquete);

        } catch (Exception e) {
            System.out.println("\n ERROR AL TRATAR DE BUSCAR USUARIO POR DNI."
                    + "\n" + e);

        }
        return null;
    }

    public String buscarMedio(int m) {

        switch (m) {
            case 1:
                return "Efectivo: Sin comisión";
            case 2:
                return "Tarjeta de Débito: 3%";
            case 3:
                return "Tarjeta de Crédito: 9%";
            case 4:
                return "Monedero Virtual: Sin comisión";
            case 5:
                return "Transferencia: 2.45%";
        }
        return null;
    }

    public double buscarComision(int m) {

        switch (m) {
            case 1:
                return 0.0;
            case 2:
                return 0.03;
            case 3:
                return 0.09;
            case 4:
                return 0.0;
            case 5:
                return 0.0245;
        }
        return 0;
    }

    public double calcularImporteVta(Paquete paqu, double comi, int cant) {

        return cant * (double) paqu.getCostoPaquete() * (1 + (comi));

    }

    public String buscarContratacion(double dto) {

        if (dto != 0) {
            return "PAQUETE";
        }
        return "INDIVIDUAL";
    }

    public List<Cliente> obtenerClientes() {
        return clieJPA.findClienteEntities();
    }

    public boolean borrarCliente(int dn) {

        Cliente c = buscarComprador(dn);
        int id = c.getIdPersona();
        try {
            clieJPA.destroy(id);
            return true;

        } catch (IllegalOrphanException | NonexistentEntityException e) {
            System.out.println("\n *** No se Borro el cliente \n" + e);
        }
        return false;
    }

    public Cliente obtener1Cliente(int dn) {

        try {
            Cliente c = buscarComprador(dn);
            int id = c.getIdPersona();
            return clieJPA.findCliente(id);

        } catch (Exception e) {
            System.out.println("\n *** NO ENCONTGRÓ EL CLIENTE \n" + e);
        }
        return null;
    }

    public void editarCliente(Cliente c) {
        try {
            clieJPA.edit(c);
            
        } catch (Exception e) {
             System.out.println("\n *** NO se pudo E D I T A R  EL CLIENTE \n" + e);
        }
    }

    public void crear1Cliente(Cliente c) {
        
        int dn = c.getDni();
        
        // verificando si ya existe Cliente
            int nro = (int) verificarSiEsta("cliente", dn + "");

            String esta = " **** ESTÁ CREADO DESDE ANTES";
            if (nro == 0) {
                clieJPA.create(c);
                nro = clieJPA.getClienteCount();
                esta = "  <<<  de C R E A C I Ó N  >>>";
            }

            Cliente em1 = clieJPA.findCliente(nro);
            System.out.println("CLIENTE Nro: " + nro + esta
                    + "\n" + em1);
        
        
        
    }

}
