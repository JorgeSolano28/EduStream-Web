package main;

import claseDAO.UsuarioDAO;
import claseDAO.CursoDAO;
import clasePOJOS.Usuario;
import clasePOJOS.Curso;
import clasePOJOS.Rol;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;



public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       System.out.println("Conectando...");
       System.out.println("Logueandose...");
       System.out.println();

       
       
       Scanner menu = new Scanner(System.in);
       String respuesta = "S";
       while (respuesta.equalsIgnoreCase("S")){
            System.out.println("_______ MENU PRINCIPAL _______");
            System.out.println("1.Manejo de Usuarios");
            System.out.println("2.Manejo de Cursos");
            System.out.println("3.Manejo de Inscripciones");
            System.out.println(); 
            System.out.print("Seleccione una de las anteriores: ");
            
            try{
                int opt = menu.nextInt();
            
                if(opt<1 || opt>3){
                    System.out.print("ERROR: debe de ingresar numero del 1 al 3");
                }else{
                    switch(opt){
                        case 1:
                            UsuarioDAO usuario = new UsuarioDAO();
                            String resp = "S";
                                
                            while(resp.equalsIgnoreCase("S")){
                                System.out.println();
                                System.out.println("____Manejo de Usuarios____");
                                System.out.println("1.Insertar Nuevo Usuario");
                                System.out.println("2.Ver Usuarios");
                                System.out.println("3.Actualizar Usuario");
                                System.out.println("4.Eliminar Usuario");
                                System.out.println("5.Devolverse al menu anterior");
                                System.out.print("Seleccione una de las anteriores: ");
                                
                                try{
                                    int optusuario = menu.nextInt();
                                    
                                    if(optusuario<1 || optusuario>5){
                                        System.out.print("ERROR: debe de ingresar numero del 1 al 5");
                                    }else{
                                        switch(optusuario){
                                            case 1:
                                                menu.nextLine();
                                                
                                                boolean valido;
                                                String nombre;
                                                
                                                do {
                                                    valido = true;
                                                    
                                                    System.out.println();
                                                    System.out.print("Digite un nombre: ");
                                                    nombre = menu.nextLine();

                                                    for (int i = 0; i < nombre.length(); i++) {
                                                        char c = nombre.charAt(i);

                                                        // Validar que sea letra o espacio y no un número
                                                        if (!Character.isLetter(c) && c != ' ') {
                                                            valido = false;
                                                            break;
                                                        }
                                                    }

                                                    if (!valido) {
                                                        System.out.println("Error: Solo se permiten letras.");
                                                    }

                                                } while (!valido);

                                                System.out.print("Email: ");
                                                
                                                String email = menu.nextLine();
                                                System.out.print("Password: ");
                                                String password = menu.nextLine();
                                                Rol rol = null;
                                                boolean verRol = false;
                                                
                                                while(!verRol){
                                                    try{
                                                        System.out.println("Rol");
                                                        System.out.println("1.ESTUDIANTE");
                                                        System.out.println("2.PROFESOR");
                                                        System.out.print("Digite 1 o 2: ");
                                                        int optrol = menu.nextInt();

                                                        if(optrol == 1){
                                                            rol = Rol.ESTUDIANTE;
                                                            verRol = true;
                                                        }else if(optrol == 2){
                                                            rol = Rol.PROFESOR;
                                                            verRol = true;
                                                        }else{
                                                            System.out.println("ERROR: digite 1 o 2");
                                                        }
                                                        
                                                    }catch(InputMismatchException e){
                                                        System.out.print("ERROR: tiene que ingresar numero valido, no caracteres");
                                                        menu.next();
                                                        System.out.println();
                                                    }
                                                }
                                            usuario.insertarUsuario(nombre, email, password, rol); 
                                            break;
                                            
                                            case 2:
                                                System.out.println("____Ver Datos de Usuario____");
                                                System.out.println("1. Ver Usuarios");
                                                System.out.println("2. Devolverse al menu anterior");
                                                System.out.print("Seleccione una de las anteriores: ");

                                                try {
                                                    int optver = menu.nextInt();
                                                    menu.nextLine();

                                                    if (optver < 1 || optver > 2) {
                                                        System.out.println("ERROR: debe de ingresar numero del 1 al 2");
                                                    } else {
                                                        switch (optver) {
                                                            case 1:
                                                                usuario.leerUsuario();
                                                                break;

                                                            case 2:
                                                                System.out.println("Regresando al menú anterior...");
                                                                break;
                                                        }
                                                    }
                                                } catch (InputMismatchException e) {
                                                    System.out.println("ERROR: debe ingresar un número válido");
                                                    menu.nextLine();
                                                }

                                                break;
                                                
                                            case 3:
                                                break;
                                            
                                            case 4:
                                                break;
                                                
                                            case 5:
                                                resp = "N";
                                                break;
                                        }
                                    }
                                }catch(InputMismatchException e){
                                    System.out.print("ERROR: tiene que ingresar numero valido, no caracteres");
                                    menu.next();
                                }
                            }
                            break;
                            
                        case 2:
                            System.out.print("Manejo de Cursos");
                            break;
                            
                        case 3:
                            System.out.print("Manejo de Inscripciones");
                            break;
                    }
                }
            
            }catch(InputMismatchException e){
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
