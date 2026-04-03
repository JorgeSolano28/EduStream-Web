<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
               padding: 40px; }
        
        .card { background: #343a40; 
               padding: 30px; 
               border-radius: 12px; 
               width: 400px; }
        
        h2 { color: #c92a2a; 
             text-align: center; }
        
        label { display: block;
                color: white;
                margin-top: 12px; 
                font-weight: bold; }
        
        p {color: white;}
        
        input { width: 100%; 
                padding: 8px; 
                margin-top: 4px; 
                box-sizing: border-box; 
                border: 1px solid #ccc; 
                border-radius: 4px; }
        
        .btn { display: inline-block; 
              padding: 10px 20px; 
              margin-top: 16px; 
              border: none; 
              border-radius: 6px; 
              cursor: pointer; 
              color: white; 
              font-size: 15px; 
              text-decoration: none; }
        
        .btn-eliminar { background: #c92a2a; }
        
        .btn-volver   { background: #d9480f; }
    </style>
</head>

<%-- Parte del cuerpo del jsp a mostrar al usuario final--%>
<body>
    <div class="card">
        <h2>Eliminar Usuario</h2>
        <p>Advertencia: tenga en cuenta que el usuario no podrá recuperarse.</p>

        <form action="usuarios" method="POST">
            <input type="hidden" name="accion" value="eliminar"/>
            <label>ID del usuario:</label>
            <input type="number" name="id" placeholder="Digite el ID del usuario a eliminar" required/>
            <br/>
            <button type="submit" class="btn btn-eliminar">Eliminar usuario</button>
            <a href="usuarios" class="btn btn-volver">Volver al Menú principal</a>
        </form>
    </div>
</body>
</html>