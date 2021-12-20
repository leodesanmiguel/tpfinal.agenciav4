/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenciav4.servlet;

import agenciav4.logica.Controladora;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author profl
 */
@WebServlet(name = "SvUsuario", urlPatterns = {"/SvUsuario"})
public class SvUsuario extends HttpServlet {

     Controladora ctrl = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("frmNombre");
        String password = request.getParameter("frmPassword");
        String empleado = request.getParameter("empleado");

        System.out.println("\n SV usuario: " + usuario + " " + password + " " + empleado );
        
        request.getSession().setAttribute("user", usuario);
        request.getSession().setAttribute("pass", password);

        String pagina = ctrl.verificarUsuario(usuario, password, empleado);
        response.sendRedirect(pagina);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}
