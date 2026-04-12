package main;

import java.io.PrintStream;                 /**Para poder ver caracteres especiales en consola aunque no se digiten en codigo*/
import java.nio.charset.StandardCharsets;   /**Para poder ver caracteres especiales en consola aunque no se digiten en codigo*/
import claseDAO.UsuarioDAO;
import claseDAO.CursoDAO;
import claseDAO.InscripcionDAO;
import clasePOJOS.Rol;
import java.sql.Date;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));   /**Para poder ver caracteres especiales en consola aunque no se digiten en codigo*/
        System.setErr(new PrintStream(System.err, true, StandardCharsets.UTF_8));   /**Para poder ver caracteres especiales en consola aunque no se digiten en codigo*/
        System.out.println("Conectando...");
        System.out.println("Logueandose...");
        System.out.println();

        Scanner menu = new Scanner(System.in);
        String respuesta = "S";
        while (respuesta.equalsIgnoreCase("S")) {
            System.out.println("_______ MENU PRINCIPAL _______");
            System.out.println("1. Manejo de Usuarios");
            System.out.println("2. Manejo de Cursos");
            System.out.println("3. Manejo de Inscripciones");
            System.out.println("4. Salir del Sistema");
            System.out.println();
            System.out.print("Seleccione una de las anteriores: ");

            try{
                int opt = menu.nextInt();

                if (opt < 1 || opt > 4) {
                    System.out.print("ERROR: debe de ingresar numero del 1 al 4");  /**validacion para que el usuario ponga solo del 1 al 4*/
                } else {
                    switch (opt) {
                        case 1:
                            UsuarioDAO usuario = new UsuarioDAO();  /**hacemos esto para usar todos los metodos creados en la clase UsuarioDAO*/
                            String respusuario = "S";

                            while (respusuario.equalsIgnoreCase("S")) {    /**Le tiramos un while para que el usuario escoja si desea hacer algun otro procedimiento*/
                                System.out.println();
                                System.out.println("____ MANEJO DE USUARIOS ____");
                                System.out.println("1.Insertar Nuevo Usuario");
                                System.out.println("2.Ver Usuarios");
                                System.out.println("3.Actualizar Usuario");
                                System.out.println("4.Eliminar Usuario");
                                System.out.println("5.Devolverse al menu anterior");
                                System.out.print("Seleccione una de las anteriores: ");

                                try {
                                    int optusuario = menu.nextInt();                                    /**optusuario nombre de lo que escoja el usuario y usarlo para los case*/

                                    if (optusuario < 1 || optusuario > 5) {
                                        System.out.print("ERROR: debe de ingresar numero del 1 al 5");  /**validacion para que el usuario ponga solo del 1 al 5*/
                                    } else {
                                        switch (optusuario) {
                                            case 1:
                                                menu.nextLine();

                                                boolean insertarvalido;
                                                String nombre;

                                                do {
                                                    insertarvalido = true;
                                                    System.out.println();
                                                    System.out.println("____ INSERTAR NUEVO USUARIO ____");
                                                    System.out.print("Digite un nombre: ");
                                                    nombre = menu.nextLine();

                                                    for (int i = 0; i < nombre.length(); i++) {     /**Recorremos todo lo que digite el usuario permitiendo solo letras en el nombre*/
                                                        char c = nombre.charAt(i);

                                                        if (!Character.isLetter(c) && c != ' ') {   /**Validar que sea letra o espacio y no un número*/
                                                            insertarvalido = false;
                                                            break;
                                                        }
                                                    }

                                                    if (!insertarvalido) {
                                                        System.out.println("Error: Solo se permiten letras.");     /**Mensaje de error cuando digita algun numero en el nombre*/
                                                    }
                                                } while (!insertarvalido);

                                                System.out.print("Email: ");
                                                String email = menu.nextLine();
                                                
                                                System.out.print("Password: ");
                                                String password = menu.nextLine();
                                                Rol rol = null;
                                                boolean verRol = false;

                                                while (!verRol) {
                                                    try {
                                                        System.out.println("Rol");
                                                        System.out.println("1.ESTUDIANTE");
                                                        System.out.println("2.PROFESOR");
                                                        System.out.print("Digite 1 o 2: ");
                                                        int optrol = menu.nextInt();

                                                        if (optrol == 1) {
                                                            rol = Rol.ESTUDIANTE;
                                                            verRol = true;
                                                        } else if (optrol == 2) {
                                                            rol = Rol.PROFESOR;
                                                            verRol = true;
                                                        } else {
                                                            System.out.println("ERROR: digite 1 o 2");
                                                        }
                                                    } catch (InputMismatchException e) {
                                                        System.out.print("ERROR: tiene que ingresar numero valido, no caracteres"); /**Mensaje de error para cuando se digitan numeros que no sean 1,2 o caracteres*/
                                                        menu.next();
                                                        System.out.println();
                                                    }
                                                }
                                                usuario.insertarUsuario(nombre, email, password, rol);      /**Con esto insertamos todos los datos a la tabla usuarios de la BD*/
                                                break;
                                            case 2:
                                                System.out.println();
                                                System.out.println("____ VER DATOS DE USUARIO ____");
                                                System.out.println("1. Ver Usuarios");
                                                System.out.println("2. Devolverse al menu anterior");
                                                System.out.print("Seleccione una de las anteriores: ");

                                                try {
                                                    int optver = menu.nextInt();        /**optver nombre de lo que escoja el usuario y usarlo para los case*/
                                                    menu.nextLine();

                                                    if (optver < 1 || optver > 2) {
                                                        System.out.println("ERROR: debe de ingresar numero del 1 al 2");    /**Manejo de errores de solo 1 o 2*/
                                                    } else {
                                                        switch (optver) {
                                                            case 1:
                                                                System.out.println();
                                                                System.out.println("**** LISTA DE USUARIOS ****");
                                                                usuario.leerUsuario();      /**Nos muestra todos los valores de la tabla usuarios de la BD*/
                                                                break;
                                                            case 2:
                                                                System.out.println("Regresando al menu anterior...");
                                                                break;
                                                        }
                                                    }
                                                } catch (InputMismatchException e) {
                                                    System.out.println("ERROR: debe ingresar un número válido");
                                                    menu.nextLine();
                                                }
                                                break;
                                            case 3:
                                                System.out.println();
                                                System.out.println("____ ACTUALIZAR DATOS DE USUARIO ____");
                                                System.out.print("Digite el ID a actualizar: ");
                                                int idact = menu.nextInt();     /**idact nombre de lo que escoja el usuario y usarlo para los case*/
                                                
                                                boolean idexiste = usuario.buscarUsuario(idact);    /**Metodo que hicimos en UsuarioDAO para verificar si el id digitado existe o no*/
                                                if (!idexiste){
                                                    System.out.println("El ID " + idact + " NO existe");
                                                }else{
                                                    System.out.println("1. Nombre");
                                                    System.out.println("2. Email");
                                                    System.out.println("3. Password");
                                                    System.out.println("4. Rol");
                                                    System.out.println("5. Devolverse al menu anterior");
                                                    System.out.print("Seleccione una de las anteriores a modificar: ");

                                                    try {
                                                        int actusuario = menu.nextInt();

                                                        if (actusuario < 1 || actusuario > 5) {
                                                            System.out.print("ERROR: debe de ingresar numero del 1 al 5");      /**Manejo de errores de solo 1 al 5*/
                                                        } else {
                                                            switch (actusuario) {
                                                                case 1:
                                                                    menu.nextLine();
                                                                    boolean actvalido;
                                                                    String nuevoNombre;

                                                                    do {
                                                                        actvalido = true;
                                                                        System.out.println();
                                                                        System.out.print("Digite nuevo nombre: ");
                                                                        nuevoNombre = menu.nextLine();

                                                                        for (int i = 0; i < nuevoNombre.length(); i++) {
                                                                            char c = nuevoNombre.charAt(i);

                                                                            if (!Character.isLetter(c) && c != ' ') {       /**Validar que sea letra o espacio y no un número*/
                                                                                actvalido = false;
                                                                                break;
                                                                            }
                                                                        }

                                                                        if (!actvalido) {
                                                                            System.out.println("Error: Solo se permiten letras");
                                                                        }
                                                                    } while (!actvalido);
                                                                    usuario.actualizarNombre(idact, nuevoNombre);       /**Para modificar el nombre dependiendo del ID(idact) que digito el usuario*/
                                                                    break;
                                                                case 2:
                                                                    menu.nextLine();
                                                                    System.out.print("Digite su nuevo Email: ");
                                                                    String nuevoEmail = menu.nextLine();
                                                                    usuario.actualizarEmail(idact, nuevoEmail);         /**Para modificar el email dependiendo del ID(idact) que digito el usuario*/
                                                                    break;
                                                                case 3:
                                                                    menu.nextLine();
                                                                    System.out.print("Digite su nuevo Password: ");
                                                                    String nuevoPassword = menu.nextLine();
                                                                    usuario.actualizarPassword(idact, nuevoPassword);   /**Para modificar el password dependiendo del ID(idact) que digito el usuario*/
                                                                    break;
                                                                case 4:
                                                                    Rol nuevoRol = null;
                                                                    boolean actverRol = false;
                                                                    while (!actverRol) {
                                                                        try {
                                                                            System.out.println("Nuevo Rol");
                                                                            System.out.println("1.ESTUDIANTE");
                                                                            System.out.println("2.PROFESOR");
                                                                            System.out.print("Digite 1 o 2: ");
                                                                            int optrol = menu.nextInt();

                                                                            if (optrol == 1) {
                                                                                nuevoRol = Rol.ESTUDIANTE;
                                                                                actverRol = true;
                                                                            } else if (optrol == 2) {
                                                                                nuevoRol = Rol.PROFESOR;
                                                                                actverRol = true;
                                                                            } else {
                                                                                System.out.println("ERROR: digite 1 o 2");
                                                                            }
                                                                        } catch (InputMismatchException e) {
                                                                            System.out.print("ERROR: tiene que ingresar numero valido, no caracteres");
                                                                            menu.next();
                                                                            System.out.println();
                                                                        }
                                                                    }
                                                                    usuario.actualizarRol(idact, nuevoRol);             /**Para modificar el rol dependiendo del ID(idact) que digito el usuario*/
                                                                    break;
                                                                case 5:
                                                                    System.out.println("Regresando al menu anterior...");
                                                                    break;
                                                            }
                                                        }
                                                    } catch (InputMismatchException e) {
                                                        System.out.print("ERROR: tiene que ingresar numero valido, no caracteres");
                                                        menu.next();
                                                        System.out.println();
                                                    }
                                                }
                                                break;
                                            case 4:
                                                menu.nextLine();
                                                System.out.println();
                                                System.out.println("____ ELIMINACION DATOS DE USUARIO ____");
                                                System.out.print("Digite el ID para eliminar: ");
                                                int eliId = menu.nextInt();
                                                
                                                boolean eliexiste = usuario.buscarUsuario(eliId);           /**Metodo que hicimos en UsuarioDAO para verificar si el id digitado existe o no*/
                                                if (!eliexiste){
                                                    System.out.println("El ID " + eliId + " NO existe");
                                                    break;
                                                }else{
                                                    usuario.eliminarUsuario(eliId);         /**Para eliminar el usuario dependiendo del ID(idact) que digito el usuario*/
                                                }
                                                break;
                                            case 5:
                                                respusuario = "N";
                                                break;
                                        }
                                    }
                                }catch (InputMismatchException e) {
                                    System.out.print("ERROR: tiene que ingresar numero valido, no caracteres");
                                    menu.next();
                                }
                        }
                            break;
                            
                        case 2:
                        CursoDAO curso = new CursoDAO();  /**hacemos esto para usar todos los metodos creados en la clase CursoDAO*/
                            String respcurso = "S";

                            while (respcurso.equalsIgnoreCase("S")) {    /**Le tiramos un while para que el usuario escoja si desea hacer algun otro procedimiento*/
                                System.out.println();
                                System.out.println("____ MANEJO DE CURSOS ____");
                                System.out.println("1.Insertar Nuevo Curso");
                                System.out.println("2.Ver Cursos");
                                System.out.println("3.Actualizar Cursos");
                                System.out.println("4.Eliminar Cursos");
                                System.out.println("5.Devolverse al menu anterior");
                                System.out.print("Seleccione una de las anteriores: ");
                                
                                try{
                                    int optcurso = menu.nextInt();    /**optcurso nombre de lo que escoja el usuario y usarlo para los case*/

                                    if (optcurso < 1 || optcurso > 5) {
                                        System.out.print("ERROR: debe de ingresar numero del 1 al 5");  /**validacion para que el usuario ponga solo del 1 al 5*/
                                    }else {
                                        switch (optcurso) {
                                            case 1:
                                                menu.nextLine();

                                                System.out.println();
                                                System.out.println("____ INSERTAR NUEVO CURSO ____");
                                                System.out.print("Nombre de curso: ");
                                                String nombreCurso = menu.nextLine();
                                                System.out.print("Descripcion de Curso: ");
                                                String descripcion = menu.nextLine();
                                                System.out.print("ID de Profesor: ");
                                                int idProfesor = menu.nextInt();
                                                
                                                curso.insertarCurso(nombreCurso, descripcion, idProfesor);      /**Con esto insertamos todos los datos a la tabla cursos de la BD*/
                                                break;
                                            case 2:
                                                System.out.println();
                                                System.out.println("____ VER DATOS DE CURSO ____");
                                                System.out.println("1. Ver Cursos");
                                                System.out.println("2. Devolverse al menu anterior");
                                                System.out.print("Seleccione una de las anteriores: ");

                                                try {
                                                    int optver = menu.nextInt();        /**optver nombre de lo que escoja el usuario y usarlo para los case*/
                                                    menu.nextLine();

                                                    if (optver < 1 || optver > 2) {
                                                        System.out.println("ERROR: debe de ingresar numero del 1 al 2");    /**Manejo de errores de solo 1 o 2*/
                                                    } else {
                                                        switch (optver) {
                                                            case 1:
                                                                System.out.println();
                                                                System.out.println("**** LISTA DE CURSOS ****");
                                                                curso.leerCurso();      /**Nos muestra todos los valores de la tabla cursos de la BD*/
                                                                break;
                                                            case 2:
                                                                System.out.println("Regresando al menu anterior...");
                                                                break;
                                                        }
                                                    }
                                                } catch (InputMismatchException e) {
                                                    System.out.println("ERROR: debe ingresar un número válido");
                                                    menu.nextLine();
                                                }
                                                break;
                                            case 3:
                                                System.out.println();
                                                System.out.println("____ ACTUALIZAR DATOS DE CURSO ____");
                                                System.out.print("Digite el ID a actualizar: ");
                                                int idact = menu.nextInt();     /**idact nombre de lo que escoja el usuario y usarlo para los case*/
                                                
                                                boolean idexiste = curso.buscarCurso(idact);    /**Metodo que hicimos en CursoDAO para verificar si el id digitado existe o no*/
                                                if (!idexiste){
                                                    System.out.println("El ID " + idact + " NO existe");
                                                }else{
                                                    System.out.println("1. Nombre de Curso");
                                                    System.out.println("2. Descripcion de Curso");
                                                    System.out.println("3. ID de Profesor");
                                                    System.out.println("4. Devolverse al menu anterior");
                                                    System.out.print("Seleccione una de las anteriores a modificar: ");

                                                    try {
                                                        int actcurso = menu.nextInt();

                                                        if (actcurso < 1 || actcurso > 4) {
                                                            System.out.print("ERROR: debe de ingresar numero del 1 al 4");      /**Manejo de errores de solo 1 al 4*/
                                                        } else {
                                                            switch (actcurso) {
                                                                case 1:
                                                                    menu.nextLine();
                                                                    System.out.println();
                                                                    System.out.print("Digite nuevo nombre: ");
                                                                    String nuevoNombre = menu.nextLine();
                                                                    curso.actualizarNombre(idact, nuevoNombre);       /**Para modificar el nombre del curso dependiendo del ID(idact) que digito el usuario*/
                                                                    break;
                                                                case 2:
                                                                    menu.nextLine();
                                                                    System.out.print("Digite nueva descripcion: ");
                                                                    String nuevaDescripcion = menu.nextLine();
                                                                    curso.actualizarDescripcion(idact, nuevaDescripcion);         /**Para modificar la descripcion del curso dependiendo del ID(idact) que digito el usuario*/
                                                                    break;
                                                                case 3:
                                                                    menu.nextLine();
                                                                    System.out.print("Digite nuevo ID de profesor: ");
                                                                    String nuevoIdProfesor = menu.nextLine();
                                                                    curso.actualizarIdProfesor(idact, nuevoIdProfesor);   /**Para modificar el ID del profe dependiendo del ID(idact) que digito el usuario*/
                                                                    break;
                                                                case 4:
                                                                    System.out.println("Regresando al menu anterior...");
                                                                    break;
                                                            }
                                                        }
                                                    } catch (InputMismatchException e) {
                                                        System.out.print("ERROR: tiene que ingresar numero valido, no caracteres");
                                                        menu.next();
                                                        System.out.println();
                                                    }
                                                }
                                                break;
                                            case 4:
                                                menu.nextLine();
                                                System.out.println();
                                                System.out.println("____ ELIMINACION DATOS DE CURSO ____");
                                                System.out.print("Digite el ID para eliminar: ");
                                                int eliId = menu.nextInt();
                                                
                                                boolean eliExiste = curso.buscarCurso(eliId);           /**Metodo que hicimos en CursoDAO para verificar si el id digitado existe o no*/
                                                if (!eliExiste){
                                                    System.out.println("El ID " + eliId + " NO existe");
                                                    break;
                                                }else{
                                                    curso.eliminarCurso(eliId);         /**Para eliminar el curso dependiendo del ID(idact) que digito el usuario*/
                                                }
                                                break;
                                            case 5:
                                                respcurso = "N";
                                                break;
                                        }
                                    }
                                }catch(InputMismatchException e) {
                                    System.out.print("ERROR: tiene que ingresar numero valido, no caracteres");
                                    menu.next();
                                }
                            }
                            break;

                        case 3:
                            InscripcionDAO inscripcion = new InscripcionDAO();  /**hacemos esto para usar todos los metodos creados en la clase InscripcionDAO*/
                            String respins = "S";

                            while (respins.equalsIgnoreCase("S")) {    /**Le tiramos un while para que el usuario escoja si desea hacer algun otro procedimiento*/
                                System.out.println();
                                System.out.println("____ MANEJO DE INSCRIPCIONES ____");
                                System.out.println("1.Insertar Nueva Inscripcion");
                                System.out.println("2.Ver Inscripciones");
                                System.out.println("3.Actualizar Inscripcion");
                                System.out.println("4.Eliminar Inscripcion");
                                System.out.println("5.Devolverse al menu anterior");
                                System.out.print("Seleccione una de las anteriores: ");
                                
                                try{
                                    int optInscripcion = menu.nextInt();    /**optInscripcion nombre de lo que escoja el usuario y usarlo para los case*/

                                    if (optInscripcion < 1 || optInscripcion > 5) {
                                        System.out.print("ERROR: debe de ingresar numero del 1 al 5");  /**validacion para que el usuario ponga solo del 1 al 5*/
                                        System.out.println();
                                    }else {
                                        switch (optInscripcion) {
                                            case 1:
                                                menu.nextLine();

                                                System.out.println();
                                                System.out.println("____ INSERTAR NUEVA INSCRIPCION ____");
                                                System.out.println("**** ESTUDIANTES ACTIVOS ****");
                                                inscripcion.buscarEstudiante();
                                                System.out.print("Digite ID del Estudiante a inscribir: ");
                                                int idEstudiante = menu.nextInt();
                                                System.out.println();
                                                System.out.println("**** CURSOS ACTIVOS ****");
                                                inscripcion.buscarCurso();
                                                System.out.print("Digite ID del Curso a inscribir: ");
                                                int idCurso = menu.nextInt();
                                                LocalDate fechaInscripcion = LocalDate.now();
                                                System.out.println("Fecha de Inscripcion: " + Date.valueOf(fechaInscripcion));  /**Obtenemos la fecha en que se hizo la inscripcion*/
                                                System.out.println();
                                                
                                                inscripcion.insertarInscripcion(idEstudiante, idCurso, fechaInscripcion);      /**Con esto insertamos todos los datos a la tabla inscripciones de la BD*/
                                                break;
                                            case 2:
                                                System.out.println();
                                                System.out.println("____ VER DATOS DE INSCRIPCION ____");
                                                
                                                System.out.println("1. Ver Inscripciones");
                                                System.out.println("2. Devolverse al menu anterior");
                                                System.out.print("Seleccione una de las anteriores: ");

                                                try {
                                                    int optver = menu.nextInt();        /**optver nombre de lo que escoja el usuario y usarlo para los case*/
                                                    menu.nextLine();

                                                    if (optver < 1 || optver > 2) {
                                                        System.out.println("ERROR: debe de ingresar numero del 1 al 2");    /**Manejo de errores de solo 1 o 2*/
                                                    } else {
                                                        switch (optver) {
                                                            case 1:
                                                                System.out.println();
                                                                System.out.println("      LISTA DE INSCRIPCIONES ");
                                                                inscripcion.leerInscripciones();      /**Nos muestra todos los valores de la tabla inscripcion de la BD*/
                                                                break;
                                                            case 2:
                                                                System.out.println("Regresando al menu anterior...");
                                                                break;
                                                        }
                                                    }
                                                } catch (InputMismatchException e) {
                                                    System.out.println("ERROR: debe ingresar un número válido");
                                                    menu.nextLine();
                                                }
                                                break;
                                            case 3:
                                                System.out.println();
                                                System.out.println("____ ACTUALIZAR DATOS DE INSCRIPCION ____");
                                                System.out.println("1. ID de Estudiante");
                                                System.out.println("2. ID de Curso");
                                                System.out.println("3. Devolverse al menu anterior");
                                                System.out.print("Seleccione una de las anteriores: ");
                                                int idact = menu.nextInt();     /**idact nombre de lo que escoja el usuario y usarlo para los case*/
                                                
                                                try {
                                                    menu.nextLine();

                                                    if (idact < 1 || idact > 3) {
                                                        System.out.println("ERROR: debe de ingresar numero del 1 al 3");    /**Manejo de errores de solo 1 o 3*/
                                                    } else {
                                                        switch (idact) {
                                                            case 1:
                                                                System.out.println();
                                                                System.out.println("**** LISTA DE INSCRIPCIONES ACTIVAS ****");
                                                                inscripcion.leerInscripciones();      /**Nos muestra todos los valores de la tabla inscripciones de la BD*/
                                                                System.out.print("Digite el ID de la inscripcion donde aparece el Estudiante a modificar: ");
                                                                int idInscripEst = menu.nextInt();      /**idInscripEst ubicarnos en el numero de inscripcion que el usuario digite*/
                                                                System.out.print("Cual es el nuevo ID del Estudiante: ");
                                                                int nuevoIdEstudiante = menu.nextInt(); 
                                                                System.out.println();
                                                                inscripcion.actualizarIdEstudiante(idInscripEst, nuevoIdEstudiante);    /**Actulizamos el ID del estudiante en la inscripcion*/
                                                                break;
                                                            case 2:
                                                                System.out.println();
                                                                System.out.println("**** LISTA DE INSCRIPCIONES ACTIVAS ****");
                                                                inscripcion.leerInscripciones();      /**Nos muestra todos los valores de la tabla inscripciones de la BD*/
                                                                System.out.print("Digite el ID de la inscripcion donde aparece el Curso a modificar: ");
                                                                int idInscripCurso = menu.nextInt();    /**idInscripCurso ubicarnos en el numero de inscripcion que el usuario digite*/
                                                                System.out.print("Cual es el nuevo ID del Curso: ");
                                                                int nuevoIdCurso = menu.nextInt();
                                                                System.out.println();
                                                                inscripcion.actualizarIdCurso(idInscripCurso, nuevoIdCurso);    /**Actulizamos el ID del curso en la inscripcion*/
                                                                break;
                                                            case 3:
                                                                System.out.println("Regresando al menu anterior...");
                                                                break;
                                                        }
                                                    }
                                                } catch (InputMismatchException e) {
                                                    System.out.println("ERROR: debe ingresar un número válido");
                                                    menu.nextLine();
                                                }
                                                break;
                                            case 4:
                                                menu.nextLine();
                                                System.out.println();
                                                System.out.println("____ ELIMINACION DATOS DE INSCRIPCION ____");
                                                System.out.println("      LISTA DE INSCRIPCIONES ACTIVAS ");
                                                inscripcion.leerInscripciones();
                                                System.out.print("Digite el ID de Inscripcion a eliminar: ");
                                                int eliId = menu.nextInt();
                                                
                                                boolean eliExiste = inscripcion.buscarCurso(eliId);           /**Metodo que hicimos en InscripcionDAO para verificar si el id digitado existe o no*/
                                                if (!eliExiste){
                                                    System.out.println("El ID " + eliId + " NO existe");
                                                    break;
                                                }else{
                                                    inscripcion.eliminarInscripcion(eliId);                   /**Para eliminar la inscripcion dependiendo del ID(eliId) que digito el usuario*/
                                                }
                                                break;
                                            case 5:
                                                respins = "N";
                                                break;
                                        }
                                    }
                                }catch(InputMismatchException e) {
                                    System.out.print("ERROR: tiene que ingresar numero valido, no caracteres");
                                    menu.next();
                                }
                            }
                            break;
                    }
                }

            }catch (InputMismatchException e) {
                System.out.print("ERROR: tiene que ingresar numero valido, no caracteres");
                menu.next();
            }
                
            System.out.println();
            System.out.print("Desea realizar otro tipo de acciones(S/N): ");
            respuesta = menu.next();
            System.out.println();
        }
                menu.close();
    }
}
