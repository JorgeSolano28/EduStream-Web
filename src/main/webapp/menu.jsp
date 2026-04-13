<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>EduStream - Menu</title>
    
<%-- Parte de CSS para que se vea decente y no todo regado y sin color--%>
    <style>
        body { 
            font-family: Arial; 
            background: #212529; 
            display: flex; 
            justify-content: center; 
            align-items: center; 
            height: 100vh; 
            margin: 0; }
        
        .menu{
            background: #343a40;
            padding: 40px; 
            border-radius: 12px; 
            text-align: center; 
            width: 400px; }
        
        h1 { 
            color: white; 
            margin-bottom: 30px; }
        
        h3,p {
            color: white;
        }
        
        .btn { 
            display: block; 
            width: 100%; 
            padding: 15px; 
            margin: 10px 0; 
            border: none; 
            border-radius: 8px; 
            font-size: 16px;
            font-family: Arial;
            cursor: pointer; 
            text-decoration: none; 
            color: white; 
            box-sizing: border-box }
        
        .btn-insertar  { 
            background: #2b8a3e;}
        
        .btn-consultar { 
            background: #3b5bdb; }
        
        .btn-actualizar{
            background: #862e9c; }
        
        .btn-eliminar  { 
            background: #c92a2a; }
        
        .btn:hover { 
            opacity: 0.85; }
    </style>
</head>


<%-- Parte del cuerpo del jsp a mostrar al usuario final--%>
<body>
    <div class="menu">
        <h1>EduStream</h1>
        <%
            String usuarioLogueado = (String) session.getAttribute("usuarioLogueado");
            if (usuarioLogueado != null) {
        %>
                <p>Bienvenido <%= usuarioLogueado%></p>
        <%
            }
        %>
        <h3>Gestión de Usuarios (CRUD completo)</h3>
        <a href="usuarios?accion=insertar"   class="btn btn-insertar">Insertar Usuario</a>
        <a href="usuarios?accion=consultar"  class="btn btn-consultar">Consultar Usuarios</a>
        <a href="usuarios?accion=actualizar" class="btn btn-actualizar">Actualizar Usuario</a>
        <a href="usuarios?accion=eliminar"   class="btn btn-eliminar" >Eliminar Usuario</a>
        
        <a href="logout" class="btn" style="background: #607D8B; margin-top: 20px;"> Cerrar Sesión </a>
        
        <hr style="margin: 24px 0; border: none; border-top: 1px solid #ddd;"/>

        <a href="https://github.com/JorgeSolano28/EduStream-Web" 
           target="_blank" 
           style="color: #2196F3; font-size: 13px; text-decoration: none;">
            Ver repositorio en GitHub
        </a>

        <p style="margin-top: 16px; font-size: 12px; color: #999;">
            Creado por Jorge Solano &amp; Luis Abarca
        </p>

    </div>
    </div>
</body>
</html>