<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>EduStream - Menu</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f0f0f0; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }
        .menu { background: white; padding: 40px; border-radius: 12px; text-align: center; width: 400px; }
        h1 { color: #333; margin-bottom: 30px; }
        .btn { display: block; width: 100%; padding: 15px; margin: 10px 0; border: none; border-radius: 8px; font-size: 16px; cursor: pointer; text-decoration: none; color: white; }
        .btn-insertar  { background: #4CAF50; }
        .btn-consultar { background: #2196F3; }
        .btn-actualizar{ background: #FF9800; }
        .btn-eliminar  { background: #f44336; }
        .btn:hover { opacity: 0.85; }
    </style>
</head>
<body>
    <div class="menu">
        <h1>EduStream LMS</h1>
        <h3>Gestión de Usuarios</h3>
        <a href="usuarios?accion=insertar"   class="btn btn-insertar" >Insertar Usuario</a>
        <a href="usuarios?accion=consultar"  class="btn btn-consultar">Consultar Usuarios</a>
        <a href="usuarios?accion=actualizar" class="btn btn-actualizar">Actualizar Usuario</a>
        <a href="usuarios?accion=eliminar"   class="btn btn-eliminar" >Eliminar Usuario</a>
    </div>
</body>
</html>