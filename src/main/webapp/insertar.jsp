<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>EduStream - Insertar Usuario</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f0f0f0; display: flex; justify-content: center; padding: 40px; }
        .card { background: white; padding: 30px; border-radius: 12px; width: 400px; }
        h2 { color: #333; }
        label { display: block; margin-top: 12px; font-weight: bold; }
        input, select { width: 100%; padding: 8px; margin-top: 4px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 4px; }
        .btn { display: inline-block; padding: 10px 20px; margin-top: 16px; border: none; border-radius: 6px; cursor: pointer; color: white; font-size: 15px; text-decoration: none; }
        .btn-guardar { background: #4CAF50; }
        .btn-volver  { background: #9E9E9E; }
    </style>
</head>
<body>
    <div class="card">
        <h2>Insertar Nuevo Usuario</h2>
        <form action="usuarios" method="POST">
            <input type="hidden" name="accion" value="insertar"/>

            <label>Nombre:</label>
            <input type="text" name="nombre" placeholder="Digite el nombre" required/>

            <label>Email:</label>
            <input type="email" name="email" placeholder="Digite el email" required/>

            <label>Password:</label>
            <input type="password" name="password" placeholder="Digite la contraseña" required/>

            <label>Rol:</label>
            <select name="rol">
                <option value="ESTUDIANTE">ESTUDIANTE</option>
                <option value="PROFESOR">PROFESOR</option>
            </select>

            <br/>
            <button type="submit" class="btn btn-guardar">Guardar</button>
            <a href="usuarios" class="btn btn-volver">Volver al Menú</a>
        </form>
    </div>
</body>
</html>