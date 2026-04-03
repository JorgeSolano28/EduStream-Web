<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clasePOJOS.Usuario"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>EduStream - Actualizar Usuario</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f0f0f0; padding: 30px; }
        .card { background: white; padding: 30px; border-radius: 12px; max-width: 500px; margin: auto; }
        h2, h3 { color: #333; }
        label { display: block; margin-top: 12px; font-weight: bold; }
        input, select { width: 100%; padding: 8px; margin-top: 4px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 4px; }
        .btn { display: inline-block; padding: 10px 20px; margin-top: 10px; border: none; border-radius: 6px; cursor: pointer; color: white; font-size: 14px; text-decoration: none; }
        .btn-buscar    { background: #2196F3; }
        .btn-guardar   { background: #FF9800; }
        .btn-volver    { background: #9E9E9E; }
        .seccion { border: 1px solid #ddd; border-radius: 8px; padding: 16px; margin-top: 16px; }
        hr { margin: 20px 0; }
    </style>
</head>
<body>
    <div class="card">
        <h2>Actualizar Usuario</h2>

        <%-- Paso 1: Buscar usuario por ID --%>
        <form action="usuarios" method="GET">
            <input type="hidden" name="accion" value="actualizar"/>
            <label>ID del usuario a actualizar:</label>
            <input type="number" name="id" placeholder="Digite el ID" required/>
            <button type="submit" class="btn btn-buscar">Buscar</button>
        </form>

        <%
            Usuario u = (Usuario) request.getAttribute("usuario");
            if (u != null) {
        %>
            <hr/>
            <h3>Usuario encontrado: <%= u.getNombre() %></h3>

            <%-- Actualización general --%>
            <div class="seccion">
                <strong>Actualización general</strong>
                <form action="usuarios" method="POST">
                    <input type="hidden" name="accion" value="actualizarGeneral"/>
                    <input type="hidden" name="id" value="<%= u.getId() %>"/>
                    <label>Nombre:</label>
                    <input type="text" name="nombre" value="<%= u.getNombre() %>" required/>
                    <label>Email:</label>
                    <input type="email" name="email" value="<%= u.getEmail() %>" required/>
                    <label>Password:</label>
                    <input type="password" name="password" required/>
                    <label>Rol:</label>
                    <select name="rol">
                        <option value="ESTUDIANTE" <%= u.getRol().name().equals("ESTUDIANTE") ? "selected" : "" %>>ESTUDIANTE</option>
                        <option value="PROFESOR"   <%= u.getRol().name().equals("PROFESOR")   ? "selected" : "" %>>PROFESOR</option>
                    </select>
                    <button type="submit" class="btn btn-guardar">Actualizar Todo</button>
                </form>
            </div>

            <%-- Actualización individual --%>
            <div class="seccion">
                <strong>Actualizar solo el nombre</strong>
                <form action="usuarios" method="POST">
                    <input type="hidden" name="accion" value="actualizarNombre"/>
                    <input type="hidden" name="id" value="<%= u.getId() %>"/>
                    <input type="text" name="nombre" value="<%= u.getNombre() %>" required/>
                    <button type="submit" class="btn btn-guardar">Actualizar Nombre</button>
                </form>
            </div>

            <div class="seccion">
                <strong>Actualizar solo el email</strong>
                <form action="usuarios" method="POST">
                    <input type="hidden" name="accion" value="actualizarEmail"/>
                    <input type="hidden" name="id" value="<%= u.getId() %>"/>
                    <input type="email" name="email" value="<%= u.getEmail() %>" required/>
                    <button type="submit" class="btn btn-guardar">Actualizar Email</button>
                </form>
            </div>

            <div class="seccion">
                <strong>Actualizar solo el password</strong>
                <form action="usuarios" method="POST">
                    <input type="hidden" name="accion" value="actualizarPassword"/>
                    <input type="hidden" name="id" value="<%= u.getId() %>"/>
                    <input type="password" name="password" placeholder="Nuevo password" required/>
                    <button type="submit" class="btn btn-guardar">Actualizar Password</button>
                </form>
            </div>

            <div class="seccion">
                <strong>Actualizar solo el rol</strong>
                <form action="usuarios" method="POST">
                    <input type="hidden" name="accion" value="actualizarRol"/>
                    <input type="hidden" name="id" value="<%= u.getId() %>"/>
                    <select name="rol">
                        <option value="ESTUDIANTE" <%= u.getRol().name().equals("ESTUDIANTE") ? "selected" : "" %>>ESTUDIANTE</option>
                        <option value="PROFESOR"   <%= u.getRol().name().equals("PROFESOR")   ? "selected" : "" %>>PROFESOR</option>
                    </select>
                    <button type="submit" class="btn btn-guardar">Actualizar Rol</button>
                </form>
            </div>

        <%
            } else if (request.getParameter("id") != null) {
        %>
            <p style="color:red">No se encontró ningún usuario con ese ID.</p>
        <%
            }
        %>

        <br/>
        <a href="usuarios" class="btn btn-volver">Volver al Menú</a>
    </div>
</body>
</html>