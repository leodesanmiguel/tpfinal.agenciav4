/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenciav4.servlet;

import agenciav4.logica.Cliente;
import agenciav4.logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leo Martinez
 */
@WebServlet(name = "SvEditarClie", urlPatterns = {"/SvEditarClie"})
public class SvEditarClie extends HttpServlet {

    Controladora ctrl = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // traer id
        // Viene de Modificar O de clientes
        String pagina = "";
        System.out.println("DNI elegido: " + request.getParameter("dni"));
        if (request.getParameter("dni") != null) {
            int dn = Integer.valueOf(request.getParameter("dni"));
            Cliente encontrarCliente = ctrl.modificarCliente(dn);
            if (encontrarCliente != null) {
                request.getSession().setAttribute("clienteOk", encontrarCliente);
                pagina = "modificarCliente.jsp";
            }
        } else {
            System.out.println("Cliente a Modificar: " + request.getParameter("frmNombre") 
                    + "\n DNI : " + request.getParameter("frmDNI"));
            if (request.getParameter("frmNombre") != null) {
                ctrl.modificarCliente(
                        request.getParameter("frmNombre"),
                        request.getParameter("frmApellido"),
                        request.getParameter("frmDomicilio"),
                        request.getParameter("frmDNI"),
                        request.getParameter("frmFechaN"),
                        request.getParameter("frmNacional"),
                        request.getParameter("frmCelular"),
                        request.getParameter("frmEmail")
                );
            }
            pagina = "clientes.jsp";

        }
        response.sendRedirect(pagina);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
