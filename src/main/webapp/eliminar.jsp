<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="clasePOJOS.Usuario"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>EduStream - Eliminar Usuario</title>
    
    <%-- Parte de CSS para que se vea decente y no todo regado y sin color--%>
    <style>

        body { font-family: Arial; 
               background: #212529;
               display: flex;
               justify-content: center;
               align-items: center;
               padding: 30px;
               margin: 0;
        }
        
        .card { background: #343a40; 
               padding: 30px; 
               border-radius: 12px; }
        
        h2 { 
            color: white; 
            text-align: center;
        }
        
        label { display: block;
                color: white;
                margin-top: 12px; 
                font-weight: bold; }
        
        p {color: white;
           text-align: center;
        }
        
        .btn { 
            display: inline-block; 
            padding: 8px 16px; 
            margin: 4px; 
            border-radius: 6px; 
            text-decoration: none; 
            color: white; 
            font-size: 14px; }
        
        .btn-volver     { 
            background: #d9480f; }
        
        table { border-collapse: collapse; 
                width: 100%; 
                margin-top: 20px; }
        
        th, td { border: 1px solid #868e96;
                 background: #495057;
                 padding: 10px;
                 color: white;
                 text-align: left; }
        
        th { background: #40c057;
             text-align: center;
             color: white; }
        
        
        .btn-eliminar { background: #c92a2a; }
        
        .btn-volver   { background: #d9480f; }
        
        tr:nth-child(even) { 
            background: #f2f2f2; }
    </style>
</head>

<%-- Parte del cuerpo del jsp a mostrar al usuario final--%>
<body>
    <div class="card">
        <h2>Eliminar Usuario</h2>
        <p>Advertencia: tenga en cuenta que el usuario no podrá recuperarse.</p>

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
                                    <form action="usuarios" method="POST">
                                        <input type="hidden" name="accion" value="eliminar"/>
                                        <input type="hidden" name="id" value="<%= u.getId()%>"/>
                                        <button type="submit" class="btn btn-eliminar" onclick=" return confirm('¿Estás seguro de que deseas eliminar el usuario <%= u.getNombre()%>?')">
                                            Eliminar
                                        </button>
                                    </form>
                                </td>
                            </tr>
            <%
                        }
                    }
                } else {
            %>
            <tr>
                <td colspan="3">No hay usuarios registrados</td>
            </tr>
            <%
                }
            %>
        </table>
        
        <br/>
        <a href="menu.jsp" class="btn btn-volver">Volver al Menú principal</a>
    </div>
</body>
</html>