package serverlet;

import claseDAO.UsuarioDAO;
import clasePOJOS.Rol;
import clasePOJOS.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/usuarios")
public class SvUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null) {
            request.getRequestDispatcher("/menu.jsp").forward(request, response);
            return;
        }

        UsuarioDAO dao = new UsuarioDAO();

        switch (accion) {

            case "insertar":
                request.getRequestDispatcher("/insertar.jsp").forward(request, response);
                break;

            case "consultar":
                String filtro = request.getParameter("filtro");
                List<Usuario> lista;

                if ("PROFESOR".equals(filtro)) {
                    lista = dao.listarPorRol("PROFESOR");
                } else if ("ESTUDIANTE".equals(filtro)) {
                    lista = dao.listarPorRol("ESTUDIANTE");
                } else {
                    lista = dao.listarUsuarios();
                }

                request.setAttribute("usuarios", lista);
                request.setAttribute("filtro", filtro);
                request.getRequestDispatcher("/consultar.jsp").forward(request, response);
                break;

            case "actualizar":
                String idStr = request.getParameter("id");
                if (idStr != null) {
                    Usuario u = dao.buscarUsuarioPorId(Integer.parseInt(idStr));
                    request.setAttribute("usuario", u);
                }
                request.getRequestDispatcher("/actualizar.jsp").forward(request, response);
                break;

            case "eliminar":
                request.getRequestDispatcher("/eliminar.jsp").forward(request, response);
                break;

            default:
                request.getRequestDispatcher("/menu.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        UsuarioDAO dao = new UsuarioDAO();

        switch (accion) {

            case "insertar":
                String nombre = request.getParameter("nombre");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                Rol rol = Rol.valueOf(request.getParameter("rol"));
                dao.insertarUsuario(nombre, email, password, rol);
                response.sendRedirect("usuarios?accion=consultar");
                break;

            case "actualizarGeneral":
                int idGen = Integer.parseInt(request.getParameter("id"));
                String nomGen = request.getParameter("nombre");
                String emailGen = request.getParameter("email");
                String passGen = request.getParameter("password");
                String rolGen = request.getParameter("rol");
                dao.actualizarUsuario(idGen, nomGen, emailGen, passGen, rolGen);
                response.sendRedirect("usuarios?accion=consultar");
                break;

            case "actualizarNombre":
                int idNom = Integer.parseInt(request.getParameter("id"));
                dao.actualizarNombre(idNom, request.getParameter("nombre"));
                response.sendRedirect("usuarios?accion=consultar");
                break;

            case "actualizarEmail":
                int idEmail = Integer.parseInt(request.getParameter("id"));
                dao.actualizarEmail(idEmail, request.getParameter("email"));
                response.sendRedirect("usuarios?accion=consultar");
                break;

            case "actualizarPassword":
                int idPass = Integer.parseInt(request.getParameter("id"));
                dao.actualizarPassword(idPass, request.getParameter("password"));
                response.sendRedirect("usuarios?accion=consultar");
                break;

            case "actualizarRol":
                int idRol = Integer.parseInt(request.getParameter("id"));
                dao.actualizarRol(idRol, Rol.valueOf(request.getParameter("rol")));
                response.sendRedirect("usuarios?accion=consultar");
                break;

            case "eliminar":
                int idElim = Integer.parseInt(request.getParameter("id"));
                dao.eliminarUsuario(idElim);
                response.sendRedirect("usuarios?accion=consultar");
                break;

            default:
                response.sendRedirect("usuarios");
        }
    }
}