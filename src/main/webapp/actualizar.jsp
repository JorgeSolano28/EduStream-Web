<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clasePOJOS.Usuario"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>EduStream - Actualizar Usuario</title>
    
    <%-- Parte de CSS para que se vea decente y no todo regado y sin color--%>
    <style>
        body {
            font-family: Arial;
            background: #212529;
            padding: 30px;
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 0;
        }
        
        .card {
            background: #343a40;
            padding: 30px;
            border-radius: 12px;
        }
        
        h2 {
            color: white;
            text-align: center;
        }        
        
        strong{
            color: white;
        }
        
        label {
            display: block;
            margin-top: 12px;
            color: white;
            font-weight: bold;
        }
        
        input, select {
            width: 100%;
            padding: 8px;
            margin-top: 4px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        
        .btn {
            display: inline-block;
            padding: 10px 20px;
            margin-top: 10px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            color: white;
            font-size: 14px;
            text-decoration: none;
        }
        
        .btn-buscar {
            background: #1864ab;
        }

        .btn-guardar {
            background: #2b8a3e;
        }

        .btn-volver {
            background: #d9480f;
        }

        .btn-actualizar {
            background: #1864ab;
        }
        
        th, td {
            border: 1px solid #868e96;
            background: #495057;
            padding: 10px;
            color: white;
            text-align: left;
        }

        th {
            background: #40c057;
            text-align: center;
            color: white;
        }
        
        table {
            border-collapse: collapse;
            width: 100%;
            margin-top: 20px;
        }
        
        .action {
            border: 1px solid #ddd;
            color: white;
            border-radius: 8px;
            padding: 16px;
            margin-top: 16px;
        }
        
        hr {
            margin: 20px 0;
        }
    </style>
</head>

<%-- Parte del cuerpo del jsp a mostrar al usuario final--%>
<body>
    <div class="card">
        <h2>Actualizar Usuario</h2>

            <table>
                <tr>
                    <th>Nombre</th>
                    <th>Email</th>
                    <th>Rol</th>
                </tr>
              
                <%
                    List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
                    if (usuarios != null && !usuarios.isEmpty()) {
                        for (Usuario u : usuarios) {
                            if ((u.getId() != 3) && (u.getId() != 4)){
                %>
                                <tr>
                                    <td><%= u.getNombre() %></td>
                                    <td><%= u.getEmail() %></td>
                                    <td><%= u.getRol() %></td>
                                    <td>
                                        <form action="usuarios" method="GET">
                                            <input type="hidden" name="accion" value="actualizar"/>
                                            <input type="hidden" name="id" value="<%= u.getId()%>"/>
                                            <button type="submit" class="btn btn-actualizar"> Actualizar </button>                       
                                        </form>
                                    </td>
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
                %>
            </table>
            
 
            <%-- Secciones para actualización individual según lo que se requiera--%>
            <%
                Usuario act = (Usuario) request.getAttribute("usuario");
                if (act != null) {
            %>
                    <%-- Actualización de nombre de usuario--%>
                    <br/>
                    <br/>
                    <div class="action">
                        <strong>Actualizar Nombre</strong>
                        <form action="usuarios" method="POST">
                            <input type="hidden" name="accion" value="actualizarNombre"/>
                            <input type="hidden" name="id" value="<%= act.getId() %>"/>
                            <input type="text" name="nombre" value="<%= act.getNombre() %>" required/>
                            <button type="submit" class="btn btn-guardar">Actualizar Nombre</button>
                        </form>
                    </div>

                    <%-- Actualización de email de usuario--%>  
                    <br/>
                    <div class="action">
                        <strong>Actualizar Email</strong>
                        <form action="usuarios" method="POST">
                            <input type="hidden" name="accion" value="actualizarEmail"/>
                            <input type="hidden" name="id" value="<%= act.getId() %>"/>
                            <input type="email" name="email" value="<%= act.getEmail() %>" required/>
                            <button type="submit" class="btn btn-guardar">Actualizar Email</button>
                        </form>
                    </div>

                    <%-- Actualización de contraseña de usuario--%>        
                    <br/>
                    <div class="action">
                        <strong>Actualizar Password</strong>
                        <form action="usuarios" method="POST">
                            <input type="hidden" name="accion" value="actualizarPassword"/>
                            <input type="hidden" name="id" value="<%= act.getId() %>"/>
                            <input type="password" name="password" placeholder="Nuevo password" required/>
                            <button type="submit" class="btn btn-guardar">Actualizar Password</button>
                        </form>
                    </div>

                    <%-- Actualización de rol de usuario--%>                    
                    <br/>
                    <div class="action">
                        <strong>Actualizar Rol</strong>
                        <form action="usuarios" method="POST">
                            <input type="hidden" name="accion" value="actualizarRol"/>
                            <input type="hidden" name="id" value="<%= act.getId() %>"/>
                            <select name="rol">
                                <option value="ESTUDIANTE" <%= act.getRol().name().equals("ESTUDIANTE") ? "selected" : "" %>>ESTUDIANTE</option>
                                <option value="PROFESOR"   <%= act.getRol().name().equals("PROFESOR")   ? "selected" : "" %>>PROFESOR</option>
                            </select>
                            <button type="submit" class="btn btn-guardar">Actualizar Rol</button>
                        </form>
                    </div>
            <% 
                }
            %>

        <br/>
        <a href="menu.jsp" class="btn btn-volver">Volver al Menú principal</a>
    </div>
</body>
</html>