<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>EduStream - Inicio de sesión</title>
    
    <%-- Parte de CSS para que se vea decente y no todo regado y sin color--%>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #212529;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .card {
            background: #343a40;
            padding: 40px;
            border-radius: 12px;
            width: 380px;
            text-align: center;
        }
        h1 { color: white; 
             margin-bottom: 8px; }
        
        p  { color: white; 
             margin-bottom: 24px; }
        
        label { display: block;
                color: white;
                text-align: left; 
                font-weight: bold; 
                margin-top: 12px; }
        
        input {
            width: 100%;
            padding: 10px;
            margin-top: 4px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 15px;
        }
        .btn-login {
            width: 100%;
            padding: 12px;
            margin-top: 24px;
            background: #2196F3;
            color: white;
            border: none;
            border-radius: 6px;
            font-size: 16px;
            cursor: pointer;
        }
        .btn-login:hover { background: #1976D2; }
        
        .error {
            background: #ffebee;
            color: #c62828;
            padding: 10px;
            border-radius: 6px;
            margin-bottom: 16px;
            font-size: 14px;
        }
    </style>
</head>

<%-- Parte del cuerpo del jsp a mostrar al usuario final--%>
<body>
    <div class="card">
        <h1>EduStream</h1>
        <p>Ingresa tus credenciales de administrador para inresar al sistema</p>

        <% if (request.getAttribute("error") != null) { %>
            <div class="error"><%= request.getAttribute("error") %></div>
        <% } %>

        <form action="login" method="POST">
            <label>Correo electrónico:</label>
            <input type="email" name="email" placeholder="Ingresa tu correo electrónico" required/>

            <label>Contraseña:</label>
            <input type="password" name="password" placeholder="Ingresa tu contraseña" required/>

            <button type="submit" class="btn-login">Iniciar Sesión</button>
        </form>
    </div>
</body>
</html>