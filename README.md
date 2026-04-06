## EduStream-Web
- Proyecto Final - Programación 2 | Universidad Tecnológica Costarricense (UTC)

## Requisitos previos

Antes de correr el proyecto asegúrate de tener instalado lo siguiente:

- JDK 11 o superior — [Descargar aquí](https://www.oracle.com/java/technologies/downloads/)
- Apache Tomcat 9 — [Descargar aquí](https://tomcat.apache.org/download-90.cgi)
- MySQL (motor de base de datos) — [Descargar aquí](https://dev.mysql.com/downloads/mysql/)
- MySQL Workbench (gestor de base de datos) — [Descargar aquí](https://dev.mysql.com/downloads/workbench/)
- NetBeans 24 o superior con soporte Maven — [Descargar aquí](https://netbeans.apache.org/download/)
- Driver de conexión a MySQL — En este caso es obligatorio, sin embargo, las dependencias del archivo pom.xlm fueron modificadas para que cualquiera que descargue el programa y lo corra se le descargue de forma automática sin necesidad de hacerlo de forma manual como archivo externo tal y como se observa en el siguiente fragmento de código extraido del pom.xml
```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>
```

## Paso 1: Descargar el proyecto como documento comprimido y luego descomprimirlo

Descarga directamente desde el repositorio con el botón verde "Code" ->  "Download ZIP" y extráelo.

## Paso 2: Configurar la base de datos

1. Abre MySQL Workbench
2. Conéctate a tu servidor MySQL local
3. En el menú superior ve a File -> Open SQL Script
4. Selecciona el archivo "EduStream_db.sql" que está en la raíz del proyecto
5. Ejecuta el script completo presionando el rayo (execute)
6. Verifica que se creó la base de datos "edustream_db" con sus respectivas tablas "inscripciones", "usuarios" y "cursos"

## Paso 3: Configurar la contraseña de MySQL

1. Abre el archivo llamado "Conexion.java" la cual se encuentra en la ruta de la carpeta del proyecto "src/main/java/claseConexion/Conexion.java"
2. Luego busca la siguiente linea y cambia el "1234" por la respectiva contraseña de tu usuario root
- private static final String PASS = "1234";

## Paso 4: Abrir el proyecto en NetBeans

1. Abre NetBeans
2. Ve a la parte superior izquierda y sigue la ruta "File -> Open Project
3. Ve a la carpeta donde descomprimiste el archivo .zip del proyecto descargado del repositorio
4. Marca la carpeta "EduStreamWeb" y haz clic en Open Project
5. Espera que Maven descargue las dependencias automáticamente (requiere internet la primera vez debido a que debe buscar y descargar las dependencias)

## Paso 5: Configurar para que arranque con servidor Tomcat

1. Da click derecho sobre el proyecto en NetBeans
2. Luego selecciona donde dice  "Properties" (normalmente es la ultima opción hasta abajo)
3. Luego dirigete al apartado que dice "Run", el cual está a la izquierda del recuadro emergente que se abrió
4. Luego da click donde dice "Server" y se debe seleccionar "Apachetomcat"
5. Luego en la parte que dice "Java EE Version" va a recomendar una versión, esta parte se deja la que te indique y dale a "Ok"

## Paso 6: Correr el proyecto e iniciar sesión

1. Luego dale a"Run" (icono verde arriba)
2. El navegador abrirá automáticamente en la pantalla de inicio de sesión del programa
3. El sistema solo permite el acceso a usuarios autorizados. Las credenciales de acceso por defecto son:
- Correo electrónico: soporte@utc.ac.cr
- Contraseña: admin
Las mismas están como usuario dentro del script en la parte de inserción de datos siendo el siguiente:
- INSERT INTO usuarios (nombre, email, password, rol)
- VALUES ('ADMIN', 'soporte@utc.ac.cr', 'admin', 'PROFESOR');

## Paso 7: Agregar usuarios autorizados

Por defecto solamente pueden iniciar sesión usuarios autorizados, en este caso las credenciales indicadas en el paso anterior. Para agregar un nuevo usuario autorizado se deben de seguir los siguientes pasos:

1. Abrir el archivo llamado "SvLogin.java" el cual está en la siguiente ruta dentro de la carpeta descomprimida "src/main/java/serverlet/SvLogin.java"
2. Para agregar un nuevo usuario primero debe estar agregado en la base de datos por medio de agregarlo de previo desde la página web o manualmente desde el MySQL por medio de script
3. Se debe buscar el siguiente fragmento de código:
- List<String> permitidos = new ArrayList<>();
- permitidos.add("soporte@utc.ac.cr");
4. Luego agregarlos de la siguiente forma de ejemplo:
- List<String> permitidos = new ArrayList<>();
- permitidos.add("soporte@utc.ac.cr");
- permitidos.add("otrocorreo@correo.com");  // nuevo usuario permitido
- permitidos.add("tercero@correo.com"); // nuevo usuario permitido
Esto hace que se agreguen los correos a la lista de correos de usuarios permitidos en el sistema
5. Para eliminar un correo de la lista de usuarios autorizados, solamente comenta la línea o eliminali del código.

- Importante: el usuario debe estar si o si ya registrado en la base de datos sino este dará error

## Modificaciones técnicas en el proyecto
1. Modificación directa al archivo pom.xml debido a que Jakarta es incompatible con tomcat 9 y el problema era recurrente con respecto a errores de compilación. Esto se puede visualizar en las siguientes líneas de ejemplo tanto de antes como después de su modificación
- Antes de su modificación
```xml
<dependency>
    <groupId>jakarta.platform</groupId>
    <artifactId>jakarta.jakartaee-api</artifactId>
</dependency>
```
- Luego de su modificación
```xml
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>4.0.1</version>
    <scope>provided</scope>
</dependency>
```
 
2. Driver de conexión a MySQL de forma automática — Se modificó el archivo pom.xml y se agregó el driver para que se descargue de forma automática en su apartado de dependencias para que cualquiera que descargue el programa y lo corra se le descargue automáticamente sin necesidad de tener que descargarlo como archivo adicional tal y como se puede visualizar en el siguiente ejemplo
```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>
```

## Documentos generados automáticamente
- Se incluye un documento .gitignore configurado para evitar subir la carpeta "target/", de forma que se evite subir al repositorio archivos temporales o información local que se pueda reconstruir como rutas y accesos, además, se parametrizó para que tampoco suba la carpeta "nbproject/private/", la cual contiene configuraciones sobre rutas y preferencias del IDE, lo cual dio algunos errores en pruebas con otros equipos 

## Autores

- Jorge Solano 
- Luis Abarca




