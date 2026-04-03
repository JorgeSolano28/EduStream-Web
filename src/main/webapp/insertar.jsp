<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>EduStream - Insertar Usuario</title>
    
<%-- Parte de CSS para que se vea decente y no todo regado y sin color--%>
    <style>
        body { 
            font-family: Arial; 
            background: #212529; 
            display: flex; 
            justify-content: center;
            padding: 40px; }
        
        .card { 
            background: #343a40; 
            padding: 30px; 
            border-radius: 12px; 
            width: 400px; }
        
        h2 { 
            text-align: center;
            color: white; }
        
        label { 
            display: block;
            color: white;
            margin-top: 12px; 
            font-weight: bold; }
        
        input, select { 
            width: 100%; 
            padding: 8px; 
            margin-top: 4px; 
            box-sizing: border-box; 
            border: 1px solid #ccc; 
            border-radius: 4px; }
        
        .btn { 
            display: inline-block; 
            padding: 10px 20px; 
            margin-top: 16px; 
            border: none; 
            border-radius: 6px; 
            cursor: pointer; 
            color: white; 
            font-size: 15px; 
            text-decoration: none; }
        
        .btn-guardar { 
            background: #2b8a3e; }
        
        .btn-volver  { 
            background: #d9480f; }
        
    </style>
</head>

<%-- Parte del cuerpo del jsp a mostrar al usuario final--%>
<body>
    <div class="card">
        <h2>Insertar Nuevo Usuario</h2>
        <form action="usuarios" method="POST">
            <input type="hidden" name="accion" value="insertar"/>

            <label>Nombre:</label>
            <input type="text" name="nombre" placeholder="Digite el nombre del nuevo usuario" required/>

            <label>Email:</label>
            <input type="email" name="email" placeholder="Digite el email del nuevo usuario" required/>

            <label>Password:</label>
            <input type="password" name="password" placeholder="Digite la contraseña del nuevo usuario" required/>

            <label>Rol (Indique el rol del nuevo usuario):</label>
            <select name="rol">
                <option value="ESTUDIANTE">ESTUDIANTE</option>
                <option value="PROFESOR">PROFESOR</option>
            </select>

            <br/>
            <button type="submit" class="btn btn-guardar">Guardar nuevo usuario</button>
            <a href="usuarios" class="btn btn-volver">Volver al Menú principal</a>
        </form>
    </div>
</body>
</html>