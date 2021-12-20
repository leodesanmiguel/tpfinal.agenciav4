package agenciav4.servlet;

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
@WebServlet(name = "SvBorrarClie", urlPatterns = {"/SvBorrarClie"})
public class SvBorrarClie extends HttpServlet {

    Controladora ctrl = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // traer id
        System.out.println("DNI elegido: " + request.getParameter("dni"));
        if (request.getParameter("dni") != null) {
            int dn = Integer.valueOf(request.getParameter("dni"));
            boolean borradoOk = ctrl.borrarCliente(dn);
            if (borradoOk) {
                request.getSession().setAttribute("borradoOk", true);

            }
        }
        response.sendRedirect("clientes.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
