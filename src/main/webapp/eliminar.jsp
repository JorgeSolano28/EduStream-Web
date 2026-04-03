<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>EduStream - Eliminar Usuario</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f0f0f0; display: flex; justify-content: center; padding: 40px; }
        .card { background: white; padding: 30px; border-radius: 12px; width: 400px; }
        h2 { color: #f44336; }
        label { display: block; margin-top: 12px; font-weight: bold; }
        input { width: 100%; padding: 8px; margin-top: 4px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 4px; }
        .btn { display: inline-block; padding: 10px 20px; margin-top: 16px; border: none; border-radius: 6px; cursor: pointer; color: white; font-size: 15px; text-decoration: none; }
        .btn-eliminar { background: #f44336; }
        .btn-volver   { background: #9E9E9E; }
    </style>
</head>
<body>
    <div class="card">
        <h2>Eliminar Usuario</h2>
        <p>Ingresa el ID del usuario que deseas eliminar.</p>

        <form action="usuarios" method="POST">
            <input type="hidden" name="accion" value="eliminar"/>
            <label>ID del usuario:</label>
            <input type="number" name="id" placeholder="Digite el ID" required/>
            <br/>
            <button type="submit" class="btn btn-eliminar">Eliminar</button>
            <a href="usuarios" class="btn btn-volver">Volver al Menú</a>
        </form>
    </div>
</body>
</html>