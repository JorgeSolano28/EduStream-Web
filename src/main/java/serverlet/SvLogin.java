package serverlet;

import claseDAO.UsuarioDAO;
import clasePOJOS.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class SvLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("usuarioLogueado") != null) {
            response.sendRedirect("usuarios");
            return;
        }*/

        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UsuarioDAO dao = new UsuarioDAO();
        boolean user = dao.validarLogin(email, password);

        if (user) {
            List<String> permitidos = new ArrayList<>();
            permitidos.add("soporte@utc.ac.cr");

            /*if (permitidos.contains(user.getEmail())) {*/
            HttpSession session = request.getSession();
            session.setAttribute("usuarioLogueado", user);
            response.sendRedirect("usuarios");
            
        }else {
            request.setAttribute("error", "Email o contraseña incorrectos");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        
        /*if(user = false){
                request.setAttribute("error", "No tienes permiso para acceder al sistema");
                request.getRequestDispatcher("/login.jsp").forward (request, response);
            
        }*/
        
    }
}