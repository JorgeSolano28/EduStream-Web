<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="clasePOJOS.Usuario"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>EduStream - Usuarios</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        h2 { color: #333; }
        form { background: #f5f5f5; padding: 20px; border-radius: 8px; margin-bottom: 30px; width: 400px; }
        input, select { width: 100%; padding: 8px; margin: 8px 0; box-sizing: border-box; }
        button { background: #4CAF50; color: white; padding: 10px 20px; border: none; border-radius: 4px; cursor: pointer; }
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ddd; padding: 10px; text-align: left; }
        th { background: #4CAF50; color: white; }
        tr:nth-child(even) { background: #f2f2f2; }
    </style>
</head>
<body>

    <h2>Gestión de Usuarios</h2>

    <%-- FORMULARIO para insertar usuarios a la bd--%>
    <%--<form action="usuarios" method="POST">
        <h3>Nuevo Usuario</h3>

        <label>Nombre:</label>
        <input type="text" name="nombre" placeholder="Digite el nombre" required />

        <label>Email:</label>
        <input type="email" name="email" placeholder="Digite el email" required />

        <label>Password:</label>
        <input type="password" name="password" placeholder="Digite la contraseña" required />

        <label>Rol:</label>
        <select name="rol">
            <option value="ESTUDIANTE">ESTUDIANTE</option>
            <option value="PROFESOR">PROFESOR</option>
        </select>

        <br/><br/>
        <button type="submit">Guardar Usuario</button>
    </form>

    <%-- Tabla para mostrar usuarios existentes en la bd y confirmar su registro--%>
    <%--<h2>Usuarios Registrados</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Email</th>
            <th>Rol</th>
        </tr>

        <%
            List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
            if (usuarios != null && !usuarios.isEmpty()) {
                for (Usuario u : usuarios) {
                    if (u.getId() != 3){
        %>
        <tr>
                <td><%= u.getId() %></td>
                <td><%= u.getNombre() %></td>
                <td><%= u.getEmail() %></td>
                <td><%= u.getRol() %></td>
        </tr>
        <%
                    }
                }
            } else {
        %>
            <tr>
                <td colspan="4">No hay usuarios registrados</td>
            </tr>
        <%
            }
        %>--
</table>--%>

    <%--</body>
</html>--%>
