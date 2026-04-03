<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="clasePOJOS.Usuario"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>EduStream - Consultar Usuarios</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f0f0f0; padding: 30px; }
        .card { background: white; padding: 30px; border-radius: 12px; }
        h2 { color: #333; }
        .filtros { margin-bottom: 20px; }
        .btn { display: inline-block; padding: 8px 16px; margin: 4px; border-radius: 6px; text-decoration: none; color: white; font-size: 14px; }
        .btn-todos      { background: #2196F3; }
        .btn-estudiante { background: #4CAF50; }
        .btn-profesor   { background: #9C27B0; }
        .btn-volver     { background: #9E9E9E; }
        table { border-collapse: collapse; width: 100%; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 10px; text-align: left; }
        th { background: #2196F3; color: white; }
        tr:nth-child(even) { background: #f2f2f2; }
    </style>
</head>
<body>
    <div class="card">
        <h2>Consultar Usuarios</h2>

        <div class="filtros">
            <strong>Filtrar por:</strong><br/>
            <a href="usuarios?accion=consultar" class="btn btn-todos">Todos</a>
            <a href="usuarios?accion=consultar&filtro=ESTUDIANTE" class="btn btn-estudiante">Solo Estudiantes</a>
            <a href="usuarios?accion=consultar&filtro=PROFESOR" class="btn btn-profesor">Solo Profesores</a>
        </div>

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
            %>
                <tr>
                    <td><%= u.getId() %></td>
                    <td><%= u.getNombre() %></td>
                    <td><%= u.getEmail() %></td>
                    <td><%= u.getRol() %></td>
                </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="4">No hay usuarios registrados</td>
                </tr>
            <%
                }
            %>
        </table>

        <br/>
        <a href="usuarios" class="btn btn-volver">Volver al Menú</a>
    </div>
</body>
</html>