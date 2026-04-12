## EduStream-Web
- Proyecto Final - Programación 2 | Universidad Tecnológica Costarricense (UTC)

## Requisitos previos

Antes de correr el proyecto asegúrate de tener instalado lo siguiente:

- JDK 11 o superior — [Descargar aquí](https://www.oracle.com/java/technologies/downloads/)
- Apache Tomcat — [Descargar aquí](https://tomcat.apache.org/download-90.cgi)
- MySQL (motor de base de datos) — [Descargar aquí](https://dev.mysql.com/downloads/mysql/)
- MySQL Workbench (gestor de base de datos) — [Descargar aquí](https://dev.mysql.com/downloads/workbench/)
- NetBeans 24 o superior con soporte Maven — [Descargar aquí](https://netbeans.apache.org/download/)
- Driver de conexión a MySQL — En este caso es obligatorio, sin embargo, las dependencias del archivo pom.xlm fueron modificadas para que cualquiera que descargue el programa y lo corra se le descargue de forma automática sin necesidad de hacerlo de forma manual como archivo externo


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
3. Luego ve a la carpeta donde descomprimiste el archivo .zip del proyecto descargado del repositorio
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
- Correo electrónico: soporte1@utc.ac.cr
- Contraseña: admin

## Contenido del proyecto

## Clases Java

### claseConexion
- Conexion: empleada para la conexión a MySQL por medio de JDBC, a su vez todos las clases DAO la utilizan para obtener una conexión y poder interactuar con la base de datos

### claseDAO
- CursoDAO: gestiona las acciones y métodos a emplear sobre la tabla "cursos" de la base de datos, en este caso el respectivo CRUD
- InscripcionDAO: gestiona las acciones y métodos a emplear sobre la tabla "inscrpciones" de la base de datos, en este caso el respectivo CRUD
- UsuarioDAO: gestiona las acciones y métodos a emplear sobre la tabla "usuarios" de la base de datos, en este caso el respectivo CRUD, además de validar las credenciales permitidas para el acceso al sistema

### clasePojos
- Curso: clase que representa una materia y a su vez su relación con un profesor que la imparte
- Estudiante: clase que se extiende de la clase abstracta "Usuario" y representa en este caso un usuario con rol de estudiante predispuesto por la clase Rol como enum
- Inscripción: clase que representa la relación entre un usuario estudiante y un curso
- Profesor: clase que se extiende de la clase abstracta "Usuario" y representa en este caso un usuario con rol de profesor predispuesto por la clase Rol como enum
- Rol: enum empleado para la definición estricta de roles. dejando solamente a elección PROFESOR y ESTUDIANTE, evitando errores de escritura o innecesarios cambios o o estandarización entre mayúsculas y minúsculas
- Usuario: clase abstracta que define los getters, setters y constructores para las clases Estudiante y Profesor

## JSP (vistas finales para el usuario)
- actualizar
- consultar
- eliminar
- insertar
- login
- menu

## Documentos HTML
- index

## Autores

- Jorge Solano 
- Luis Abarca
