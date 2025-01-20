import static biblioteca.Funciones.*;
import static biblioteca.FuncionesCadenas.*;
import java.util.Scanner;

        public class Main {
            public static void main(String[] args) {
                Scanner s = new Scanner(System.in);
                int cantPosibleAdmin=1;
                int datosNecesariosAdmin=3;
                int cantPosibleGestor=10;
                int datosNecesariosGestor=4;
                int cantPosibleInversor=10;
                int datosNecesarioInversor=4;
                String[][] adminDatos = new String[cantPosibleAdmin][datosNecesariosAdmin];
                String[][] gestorDatos = new String[cantPosibleGestor][datosNecesariosGestor];
                String[][] inversorDatos = new String[cantPosibleInversor][datosNecesarioInversor];
                Boolean[][] bloqueosUsuarios = new Boolean[cantPosibleGestor+cantPosibleInversor][1];
                String[][] proyectos= new String[20][7];
                String[][] recompensas= new String[20][6];
                int[][] carteraInversores = new int[cantPosibleInversor][1];
                String[][] amigosReferidosInversores = new String[cantPosibleInversor][1];

                inicializarArrayBidimensionalBoolean(bloqueosUsuarios);
                inicializarArrayBidimensionalString(gestorDatos);
                inicializarArrayBidimensionalString(inversorDatos);
                inicializarArrayBidimensionalString(proyectos);
                inicializarArrayBidimensionalString(recompensas);
                inicializarArrayBidimensionalInt(carteraInversores);
                inicializarArrayBidimensionalString(amigosReferidosInversores);

                adminDatos[0][0]="admin";
                adminDatos[0][1]="adminpass";
                adminDatos[0][2]="davidgalan001@gmail.com";

                gestorDatos[0][0]="gestor";
                gestorDatos[0][1]="gestorpass";
                gestorDatos[0][2]="davidgalan001@gmail.com";
                inversorDatos[2][0]="david";
                inversorDatos[2][1]="david";
                inversorDatos[2][2]="davidgalan001@gmail.com";
                bloqueosUsuarios[12][0]=true;

                inversorDatos[0][0]="inversor1";
                inversorDatos[0][1]="inversor1pass";
                inversorDatos[0][2]="davidgalan001@gmail.com";
                inversorDatos[1][0]="inversor2";
                inversorDatos[1][1]="inversor2pass";
                inversorDatos[1][2]="davidgalan001@gmail.com";

                proyectos[19][0]="David";
                proyectos[19][1]="David";
                proyectos[19][2]="David";
                proyectos[19][3]="400";
                proyectos[19][4]="200";
                proyectos[19][5]="1";
                proyectos[19][6]="2";

                String usuario, contrasena;
                int dineroAnadido;

                String  rojo = "\033[31m", verde = "\033[32m", amarillo = "\033[33m", azul = "\033[34m", morado = "\033[35m", cyan = "\033[36m", colorNormal = "\u001B[0m";

                int menuGestor, opcion, opcion2;

                //nuevas variables
                Boolean hayHueco, nombreUsuarioNoExiste, codigo2PACorrecto;
                String tipoUsuarioRegistro, correoUsuarioRegistro, nombreUsuarioRegistro, passUsuarioRegistro, codigo2PAGeneradoSI="", passUsuarioRegistroRepetida;
                int contadorFallosTipoUsuario, contadorFallos2PARegistro, tipoUsuarioIS;
                int opcionInicio;

                do {
                    menuInicioSesion();
                    opcionInicio= leerInt();
                    switch (opcionInicio){
                        case 1:
                                //NUEVO
                                int contadorFallos=0;
                                String codigoInsertaUsuario;
                                Boolean correoCorrecto=false;
                                do {
                                    do {
                                        System.out.println("Introduzca el tipo de Usuario: 1 Admin, 2 Gestor y 3 Inversor");
                                        tipoUsuarioIS = Integer.parseInt(s.nextLine());
                                    }while (!(tipoUsuarioIS==1 || tipoUsuarioIS==2 || tipoUsuarioIS==3));
                                    System.out.print("Usuario: ");
                                    usuario = leerString();
                                    System.out.print("Contraseña: ");
                                    contrasena = leerString();
                                    //Problema en si el nombre y la contraseña no coinciden con algo
                                    int posicionUsuario=posicionAdminGestorInversorIS(tipoUsuarioIS,usuario,adminDatos,gestorDatos,inversorDatos);
                                    if ((tipoUsuarioIS==2 && !(bloqueosUsuarios[posicionUsuario][0])) || (tipoUsuarioIS == 3 && !(bloqueosUsuarios[gestorDatos.length + posicionUsuario][0])) || tipoUsuarioIS==1) {
                                        if (usuarioAdmin(tipoUsuarioIS, usuario, contrasena, adminDatos, gestorDatos, inversorDatos)) {
                                            contadorFallos = 0;
                                            if (tipoUsuarioIS == 1)
                                                codigo2PAGeneradoSI = correoEnviar(adminDatos[posicionUsuario][2]);
                                            else if (tipoUsuarioIS == 2)
                                                codigo2PAGeneradoSI = correoEnviar(gestorDatos[posicionUsuario][2]);
                                            else if (tipoUsuarioIS == 3)
                                                codigo2PAGeneradoSI = correoEnviar(inversorDatos[posicionUsuario][2]);
                                            System.out.println("Se le ha enviado un código de verificación a su correo.");
                                            System.out.println("Inserte el código: ");
                                            codigoInsertaUsuario = leerString();
                                            if (!(codigoInsertaUsuario.equals(codigo2PAGeneradoSI))) {
                                                System.out.println(rojo + "Código incorrecto." + colorNormal);
                                                contadorFallos++;
                                                if (contadorFallos==3) {
                                                    System.out.println("Su cuenta ha sido bloqueada");
                                                    bloqueosUsuarios[posicionUsuario][0]=true;
                                                }
                                            }else correoCorrecto=true;
                                        } else {
                                            System.out.println("Algo está mal...");
                                            contadorFallos++;
                                            if (contadorFallos==3) {
                                                System.out.println("Su cuenta ha sido bloqueada");
                                                if (tipoUsuarioIS==2) bloqueosUsuarios[posicionUsuario][0]=true;
                                                if (tipoUsuarioIS==3) bloqueosUsuarios[gestorDatos.length+posicionUsuario][0]=true;
                                            }
                                        }
                                    }else System.out.println("Su cuenta está: BLOQUEADA");
                                }while (!correoCorrecto);
                            if (tipoUsuarioIS==1){
                                do {
                                    menuAdmin();
                                    opcion2 = leerInt();
                                    switch (opcion2) {
                                        case 1: {
                                            menuPanelDeControl();
                                            int cantidadUsuarios = cuantosGestoresHay(gestorDatos) + cuantosInversoresHay(inversorDatos);
                                                do {
                                                    mostrarUsuarioBloqueados(bloqueosUsuarios,gestorDatos,inversorDatos);
                                                    opcion = leerInt();
                                                    if (opcion<cuantosGestoresHay(gestorDatos) && bloqueosUsuarios[opcion][0]) bloqueosUsuarios[opcion][0]=false;
                                                    else if(bloqueosUsuarios[(opcion-1)+gestorDatos.length][0]) bloqueosUsuarios[(opcion-1)+gestorDatos.length][0]=false;
                                                }while (opcion!=cantidadUsuarios);
                                        }
                                        break;
                                        case 2: {
                                            do {
                                                menuProyectosAdmin();
                                                opcion = leerInt();
                                                switch (opcion){
                                                    case 1:
                                                        if (cuantosProyectosHay(proyectos) < 1)
                                                            System.out.println(amarillo + "Ningún proyecto ha sido creado aún." + colorNormal);
                                                        else {
                                                            do {
                                                                mostrarProyectosCreados(proyectos);
                                                                opcion = leerInt();
                                                                if (opcion<proyectos.length) {
                                                                    if (proyectos[opcion][0].isEmpty()) {
                                                                        System.out.println(amarillo + "Este proyecto no ha sido creado aún." + colorNormal);
                                                                    } else {
                                                                        mostrarResumenProyecto(proyectos, opcion);
                                                                        String InvertirODetallada = leerString();
                                                                        if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                            mostrarProyecto(proyectos, opcion, recompensas);
                                                                        } else
                                                                            System.out.println("Opción inválida");
                                                                    }
                                                                }
                                                            } while (opcion != proyectos.length);
                                                        }
                                                        break;
                                                    case 2 :
                                                        int opcionProyecto;
                                                        if (cuantosProyectosHay(proyectos) < 1) System.out.println(amarillo + "Ningún proyecto ha sido creado aún." + colorNormal);
                                                        else {
                                                            do {
                                                                mostrarProyectosCreados(proyectos);
                                                                opcionProyecto = leerInt();
                                                                if (opcionProyecto<proyectos.length) {
                                                                    if (proyectos[opcionProyecto][0].isEmpty())
                                                                        System.out.println(amarillo + "Este proyecto no ha sido creado aún." + colorNormal);
                                                                    else {
                                                                        do {
                                                                            menuCambiarProyectosCaracteristicas();
                                                                            opcion = leerInt();
                                                                            switch (opcion) {
                                                                                case 0:
                                                                                    System.out.println("Nombre:");
                                                                                    proyectos[opcionProyecto][opcion] = leerString();
                                                                                    break;
                                                                                case 1:
                                                                                    System.out.println("Descripción:");
                                                                                    proyectos[opcionProyecto][opcion] = leerString();
                                                                                    break;
                                                                                case 2:
                                                                                    System.out.println("Categoría:");
                                                                                    proyectos[opcionProyecto][opcion] = leerString();
                                                                                    break;
                                                                                case 3:
                                                                                    System.out.println("Cantidad Necesaria:");
                                                                                    proyectos[opcionProyecto][opcion] = leerString();
                                                                                    break;
                                                                                case 4:
                                                                                    System.out.println("Cantidad Financiada:");
                                                                                    proyectos[opcionProyecto][opcion] = leerString();
                                                                                    break;
                                                                                case 5:
                                                                                    System.out.println("Fecha de Inicio de inversiones:");
                                                                                    proyectos[opcionProyecto][opcion] = leerString();
                                                                                    break;
                                                                                case 6:
                                                                                    System.out.println("Fecha de Inicio de inversiones:");
                                                                                    proyectos[opcionProyecto][opcion] = leerString();
                                                                                    break;
                                                                                case 7:
                                                                                    do {
                                                                                        menuCambiarRecompensa();
                                                                                        opcion = leerInt();
                                                                                        switch (opcion) {
                                                                                            case 0:
                                                                                                System.out.println("Escriba la descripción de la recompensa 1:");
                                                                                                recompensas[opcionProyecto][opcion] = leerString();
                                                                                                System.out.println("Escriba el precio de la recompensa 1:");
                                                                                                recompensas[opcionProyecto][opcion+1] = leerString();
                                                                                                break;
                                                                                            case 1:
                                                                                                System.out.println("Escriba la descripción de la recompensa 2:");
                                                                                                recompensas[opcionProyecto][opcion+1] = leerString();
                                                                                                System.out.println("Escriba el precio de la recompensa 2:");
                                                                                                recompensas[opcionProyecto][opcion+2] = leerString();

                                                                                                break;
                                                                                            case 2:
                                                                                                System.out.println("Escriba la descripción de la recompensa 3:");
                                                                                                recompensas[opcionProyecto][opcion+2] = leerString();
                                                                                                System.out.println("Escriba el precio de la recompensa 3:");
                                                                                                recompensas[opcionProyecto][opcion+3] = leerString();
                                                                                                break;
                                                                                            case 3:
                                                                                                System.out.println("Saliendo...");
                                                                                                break;
                                                                                            default:
                                                                                                System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                                                break;
                                                                                        }
                                                                                    } while (opcion != 3);
                                                                                    break;
                                                                                case 8:
                                                                                    System.out.println("Saliendo...");
                                                                                    break;
                                                                            }
                                                                        } while (opcion != 8);
                                                                    }
                                                                }
                                                            } while (opcionProyecto != proyectos.length);
                                                        }
                                                        break;
                                                    case 3 :
                                                        if (cuantosProyectosHay(proyectos) < 1) System.out.println(amarillo + "Ningún proyecto ha sido creado aún." + colorNormal);
                                                        else{
                                                            do {
                                                                mostrarProyectosCreados(proyectos);
                                                                opcion = leerInt();
                                                                if (opcion<proyectos.length) {
                                                                    if (proyectos[opcion][0].isEmpty()) {
                                                                        System.out.println(amarillo + "Este proyecto no ha sido creado aún." + colorNormal);
                                                                    } else {
                                                                        System.out.println("¿Quieres eliminar el proyecto " + proyectos[opcion][0] + "? (s/n)");
                                                                        String eliminarProyectoSiNo = leerString();
                                                                        if (eliminarProyectoSiNo.equalsIgnoreCase("s")) {
                                                                            eliminarProyecto(proyectos,recompensas,opcion);
                                                                            break;
                                                                        } else {
                                                                            System.out.println("Saliendo...");
                                                                            break;
                                                                        }
                                                                    }
                                                                }
                                                            } while (opcion != proyectos.length);
                                                        }
                                                        break;
                                                    case 4 :
                                                        System.out.println("Saliendo...");
                                                        break;
                                                    default:
                                                        System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                }
                                            } while (opcion != 4);
                                        }
                                        break;
                                        case 3:
                                            do {
                                                menuConfiguracionUsuarioContrasena();
                                                opcion = leerInt();
                                                int posicion=posicionAdminGestorInversorIS(tipoUsuarioIS,usuario,adminDatos,gestorDatos,inversorDatos);
                                                if (opcion!=3) cambiarUsuarioContrasena(adminDatos[posicion][1],opcion,adminDatos,gestorDatos,inversorDatos,tipoUsuarioIS,posicion);
                                            }while (opcion != 3) ;
                                        break;
                                        case 4: {
                                            System.out.println("Cerrando sesión...");
                                            break;
                                        }
                                        default:
                                            System.out.println(amarillo + "Opción Inválida." + colorNormal);
                                    }
                                } while (opcion2 != 4);
                                break;
                            } else if (tipoUsuarioIS==2) {
                                do{
                                    mostrarMenuGestor();
                                    menuGestor = leerInt();
                                    switch (menuGestor) {
                                        case 1:
                                            do {
                                                mostrarMenuProyectosGestor();
                                                opcion = leerInt();
                                                switch (opcion) {
                                                    case 1:
                                                        if (cuantosProyectosHay(proyectos) < 1)
                                                            System.out.println(amarillo + "Ningún proyecto ha sido creado aún." + colorNormal);
                                                        else {
                                                            do {
                                                                mostrarProyectosCreados(proyectos);
                                                                opcion = leerInt();
                                                                if (opcion<proyectos.length) {
                                                                    if (proyectos[opcion][0].isEmpty()) {
                                                                        System.out.println(amarillo + "Este proyecto no ha sido creado aún." + colorNormal);
                                                                    } else {
                                                                        mostrarResumenProyecto(proyectos, opcion);
                                                                        String InvertirODetallada = leerString();
                                                                        if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                            mostrarProyecto(proyectos, opcion, recompensas);
                                                                        } else
                                                                            System.out.println("Opción inválida");
                                                                    }
                                                                }
                                                            } while (opcion != proyectos.length);
                                                        }
                                                        break;
                                                    case 2:
                                                        int opcionProyecto=0;
                                                        do {
                                                            if (cuantosProyectosHay(proyectos) == proyectos.length)
                                                                System.out.println("La cantidad máxima de proyectos se ha alcanzado");
                                                            else {
                                                                mostrarProyectosDisponibles(proyectos);
                                                                opcionProyecto = leerInt();
                                                                if (opcionProyecto < proyectos.length) {
                                                                    int cantNecesaria;
                                                                    int cantFinanciada;
                                                                    do {
                                                                        System.out.println("Nombre:");
                                                                        proyectos[opcionProyecto][0] = s.nextLine();
                                                                        System.out.println("Descripción:");
                                                                        proyectos[opcionProyecto][1] = s.nextLine();
                                                                        System.out.println("Categoría:");
                                                                        proyectos[opcionProyecto][2] = s.nextLine();
                                                                        System.out.println("Cantidad necesaria:");
                                                                        proyectos[opcionProyecto][3] = String.valueOf(leerInt());
                                                                        System.out.println("Cantidad financiada:");
                                                                        proyectos[opcionProyecto][4] = String.valueOf(leerInt());
                                                                        System.out.println("Fecha de Inicio de inversiones:");
                                                                        proyectos[opcionProyecto][5] = s.nextLine();
                                                                        System.out.println("Fecha de finalización de inversiones: ");
                                                                        proyectos[opcionProyecto][6] = s.nextLine();
                                                                        cantNecesaria = Integer.parseInt(proyectos[opcionProyecto][3]);
                                                                        cantFinanciada = Integer.parseInt(proyectos[opcionProyecto][4]);
                                                                        if (cantNecesaria < cantFinanciada)
                                                                            System.out.println("La cantidad necesaria tiene que ser mayor que la financiada.");
                                                                    } while (cantNecesaria < cantFinanciada);
                                                                    do {
                                                                        menuCrearRecompensa();
                                                                        opcion = leerInt();
                                                                        if (opcion<3) {
                                                                            switch (opcion) {
                                                                                case 0:
                                                                                    System.out.println("Escriba la descripción de la recompensa 1:");
                                                                                    recompensas[opcionProyecto][opcion] = leerString();
                                                                                    System.out.println("Escriba el precio de la recompensa 1:");
                                                                                    recompensas[opcionProyecto][opcion+1] = leerString();
                                                                                    break;
                                                                                case 1:
                                                                                    System.out.println("Escriba la descripción de la recompensa 2:");
                                                                                    recompensas[opcionProyecto][opcion+1] = leerString();
                                                                                    System.out.println("Escriba el precio de la recompensa 2:");
                                                                                    recompensas[opcionProyecto][opcion+2] = leerString();
                                                                                    break;
                                                                                case 2:
                                                                                    System.out.println("Escriba la descripción de la recompensa 3:");
                                                                                    recompensas[opcionProyecto][opcion+2] = leerString();
                                                                                    System.out.println("Escriba el precio de la recompensa 3:");
                                                                                    recompensas[opcionProyecto][opcion+3] = leerString();
                                                                                    break;
                                                                                default:
                                                                                    System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                                    break;
                                                                            }
                                                                        }else System.out.println("Saliendo...");
                                                                    } while (opcion != 3);
                                                                    break;
                                                                }
                                                            }
                                                        } while (opcionProyecto != proyectos.length);
                                                        break;
                                                    case 3:
                                                        if (cuantosProyectosHay(proyectos) < 1) System.out.println(amarillo + "Ningún proyecto ha sido creado aún." + colorNormal);
                                                        else {
                                                            do {
                                                                mostrarProyectosCreados(proyectos);
                                                                opcionProyecto = leerInt();
                                                                if (opcionProyecto<proyectos.length) {
                                                                    if (proyectos[opcionProyecto][0].isEmpty())
                                                                        System.out.println(amarillo + "Este proyecto no ha sido creado aún." + colorNormal);
                                                                    else {
                                                                        do {
                                                                            menuCambiarProyectosCaracteristicas();
                                                                            opcion = leerInt();
                                                                            switch (opcion) {
                                                                                case 0:
                                                                                    System.out.println("Nombre:");
                                                                                    proyectos[opcionProyecto][opcion] = leerString();
                                                                                    break;
                                                                                case 1:
                                                                                    System.out.println("Descripción:");
                                                                                    proyectos[opcionProyecto][opcion] = leerString();
                                                                                    break;
                                                                                case 2:
                                                                                    System.out.println("Categoría:");
                                                                                    proyectos[opcionProyecto][opcion] = leerString();
                                                                                    break;
                                                                                case 3:
                                                                                    System.out.println("Cantidad Necesaria:");
                                                                                    proyectos[opcionProyecto][opcion] = leerString();
                                                                                    break;
                                                                                case 4:
                                                                                    System.out.println("Cantidad Financiada:");
                                                                                    proyectos[opcionProyecto][opcion] = leerString();
                                                                                    break;
                                                                                case 5:
                                                                                    System.out.println("Fecha de Inicio de inversiones:");
                                                                                    proyectos[opcionProyecto][opcion] = leerString();
                                                                                    break;
                                                                                case 6:
                                                                                    System.out.println("Fecha de Inicio de inversiones:");
                                                                                    proyectos[opcionProyecto][opcion] = leerString();
                                                                                    break;
                                                                                case 7:
                                                                                    do {
                                                                                        menuCambiarRecompensa();
                                                                                        opcion = leerInt();
                                                                                        switch (opcion) {
                                                                                            case 0:
                                                                                                System.out.println("Escriba la descripción de la recompensa 1:");
                                                                                                recompensas[opcionProyecto][opcion] = leerString();
                                                                                                System.out.println("Escriba el precio de la recompensa 1:");
                                                                                                recompensas[opcionProyecto][opcion+1] = leerString();
                                                                                                break;
                                                                                            case 1:
                                                                                                System.out.println("Escriba la descripción de la recompensa 2:");
                                                                                                recompensas[opcionProyecto][opcion+1] = leerString();
                                                                                                System.out.println("Escriba el precio de la recompensa 2:");
                                                                                                recompensas[opcionProyecto][opcion+2] = leerString();

                                                                                                break;
                                                                                            case 2:
                                                                                                System.out.println("Escriba la descripción de la recompensa 3:");
                                                                                                recompensas[opcionProyecto][opcion+2] = leerString();
                                                                                                System.out.println("Escriba el precio de la recompensa 3:");
                                                                                                recompensas[opcionProyecto][opcion+3] = leerString();
                                                                                                break;
                                                                                            case 3:
                                                                                                System.out.println("Saliendo...");
                                                                                                break;
                                                                                            default:
                                                                                                System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                                                break;
                                                                                        }
                                                                                    } while (opcion != 3);
                                                                                    break;
                                                                                case 8:
                                                                                    System.out.println("Saliendo...");
                                                                                    break;
                                                                            }
                                                                        } while (opcion != 8);
                                                                    }
                                                                }
                                                            } while (opcionProyecto != proyectos.length);
                                                        }
                                                        break;
                                                    case 4:
                                                        if (cuantosProyectosHay(proyectos) < 1) System.out.println(amarillo + "Ningún proyecto ha sido creado aún." + colorNormal);
                                                        else{
                                                                do {
                                                                    mostrarProyectosCreados(proyectos);
                                                                    opcion = leerInt();
                                                                    if (opcion<proyectos.length) {
                                                                        if (proyectos[opcion][0].isEmpty()) {
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún." + colorNormal);
                                                                        } else {
                                                                            System.out.println("¿Quieres eliminar el proyecto " + proyectos[opcion][0] + "? (s/n)");
                                                                            String eliminarProyectoSiNo = leerString();
                                                                            if (eliminarProyectoSiNo.equalsIgnoreCase("s")) {
                                                                            eliminarProyecto(proyectos,recompensas,opcion);
                                                                                break;
                                                                            } else {
                                                                                System.out.println("Saliendo...");
                                                                                break;
                                                                            }
                                                                        }
                                                                    }
                                                                } while (opcion != proyectos.length);
                                                        }
                                                        break;
                                                    case 5:
                                                        System.out.println("Saliendo...");
                                                        break;
                                                    default:
                                                        System.out.println(amarillo + "Opción inválida, inténtelo de nuevo." + colorNormal);
                                                        break;
                                                }
                                            } while (opcion != 5);
                                            break;
                                        case 2:
                                            do {
                                                menuConfiguracionUsuarioContrasena();
                                                opcion = leerInt();
                                                int posicion=posicionAdminGestorInversorIS(tipoUsuarioIS,usuario,adminDatos,gestorDatos,inversorDatos);
                                                cambiarUsuarioContrasena(gestorDatos[posicion][1],opcion,adminDatos,gestorDatos,inversorDatos,tipoUsuarioIS,posicion);
                                            } while (opcion != 3);
                                            break;
                                        case 3:
                                            System.out.println("Cerrando sesión...");
                                            break;
                                        default:
                                            System.out.println(amarillo + "Opción inválida." + colorNormal);
                                            break;
                                    }
                                }while(menuGestor != 3);
                            } else if (tipoUsuarioIS==3) {
                                do {
                                    menuInversor();
                                    opcion = leerInt();
                                    switch (opcion){
                                        case 1:
                                            int posicion=posicionAdminGestorInversorIS(tipoUsuarioIS,usuario,adminDatos,gestorDatos,inversorDatos);
                                            if (cuantosProyectosHay(proyectos) < 1) System.out.println(amarillo + "Ningún proyecto ha sido creado aún." + colorNormal);
                                            else {
                                                int opcionProyectos=0;
                                                do {
                                                    mostrarProyectosCreados(proyectos);
                                                    opcionProyectos = leerInt();
                                                    if (opcionProyectos<proyectos.length) {
                                                        if (proyectos[opcionProyectos][0].isEmpty()) {
                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún." + colorNormal);
                                                        } else {
                                                            mostrarResumenProyecto(proyectos, opcionProyectos);
                                                            String InvertirODetallada = leerString();
                                                            if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                mostrarProyecto(proyectos, opcionProyectos, recompensas);
                                                                System.out.println("Inserte (I) Invertir (X) Salir");
                                                                String invertirSiNo = s.nextLine();
                                                                if (invertirSiNo.equalsIgnoreCase("I")) {
                                                                    int cantInvertir=0;
                                                                    Boolean invertirCorrecto=false;
                                                                    do {
                                                                        System.out.println("Introduce la cantidad a invertir: ");
                                                                        cantInvertir= Integer.parseInt(s.nextLine());
                                                                    }while ((cantInvertir>carteraInversores[posicion][0]) && cantInvertir+Integer.parseInt(proyectos[opcionProyectos][4])>Integer.parseInt(proyectos[opcionProyectos][3]));
                                                                    carteraInversores[posicion][0]-=cantInvertir;
                                                                    proyectos[opcionProyectos][4]=String.valueOf(cantInvertir);
                                                                }else System.out.println("Saliendo...");
                                                            } else
                                                                System.out.println("Opción inválida");
                                                        }
                                                    }
                                                }while (opcionProyectos != proyectos.length);
                                            }
                                            break;
                                        case 2:
                                            if (cuantosProyectosHay(proyectos) < 1) System.out.println(amarillo + "Ningún proyecto ha sido creado aún." + colorNormal);
                                            else {
                                                do {
                                                    mostrarProyectosCreados(proyectos);
                                                    opcion = leerInt();
                                                    if (opcion<proyectos.length) {
                                                        if (proyectos[opcion][0].isEmpty()) {
                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún." + colorNormal);
                                                        } else {
                                                            mostrarResumenProyecto(proyectos, opcion);
                                                            String InvertirODetallada = leerString();
                                                            if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                mostrarProyecto(proyectos, opcion, recompensas);
                                                            } else
                                                                System.out.println("Opción inválida");
                                                        }
                                                    }
                                                } while (opcion != proyectos.length);
                                            }
                                            break;
                                        case 3:
                                            do {
                                                menuCarteraDigital();
                                                opcion = leerInt();
                                                posicion=posicionAdminGestorInversorIS(tipoUsuarioIS,usuario,adminDatos,gestorDatos,inversorDatos);
                                                switch (opcion){
                                                    case 1:
                                                        System.out.println(carteraInversores[posicion][0]);
                                                        break;
                                                    case 2:
                                                        do {
                                                            System.out.println("¿Cuánto dinero quieres añadir?");
                                                            dineroAnadido = leerInt();
                                                            if (dineroAnadido<0) System.out.println("La cantidad añadida debe ser mayor a 0");
                                                            else carteraInversores[posicion][0]+=dineroAnadido;
                                                        }while (dineroAnadido<=0);
                                                        break;
                                                    case 3:
                                                        System.out.println("Saliendo");
                                                        break;
                                                }
                                            }while (opcion!=3);
                                            break;
                                        case 4:
                                            posicion=posicionAdminGestorInversorIS(tipoUsuarioIS,usuario,adminDatos,gestorDatos,inversorDatos);
                                            do {
                                                menuInvitarAmigos();
                                                opcion = leerInt();
                                                switch (opcion) {
                                                    case 1:
                                                        if (amigosReferidosInversores[posicion][0].isEmpty()) System.out.println(amarillo + "Aún no has invitado a ningún amigo." + colorNormal);
                                                        else System.out.println("Amigos referidos: " + amigosReferidosInversores[posicion][0]);
                                                        break;
                                                    case 2:
                                                        System.out.print("Introduce el correo electrónico del amigo: ");
                                                        String nuevoAmigo = leerString();
                                                        if (!nuevoAmigo.contains("@") || !nuevoAmigo.contains(".")) {
                                                            System.out.println(amarillo + "El correo introducido no es válido." + colorNormal);
                                                        } else {
                                                            if (amigosReferidosInversores[posicion][0].isEmpty()) {
                                                                amigosReferidosInversores[posicion][0] = nuevoAmigo;
                                                            } else {
                                                                amigosReferidosInversores[posicion][0] += ", " + nuevoAmigo;
                                                            }
                                                            System.out.println(cyan + "Amigo añadido correctamente." + colorNormal);
                                                        }
                                                        break;
                                                    case 3:
                                                        System.out.println("Saliendo del menú Invitar Amigos.");
                                                        break;
                                                    default:
                                                        System.out.println(amarillo + "Opción no válida, inténtalo de nuevo." + colorNormal);
                                                        break;
                                                }
                                            } while (opcion != 3);
                                            break;
                                        case 5:
                                            do {
                                                menuConfiguracionUsuarioContrasena();
                                                opcion = leerInt();
                                                posicion=posicionAdminGestorInversorIS(tipoUsuarioIS,usuario,adminDatos,gestorDatos,inversorDatos);
                                                cambiarUsuarioContrasena(inversorDatos[posicion][1],opcion,adminDatos,gestorDatos,inversorDatos,tipoUsuarioIS,posicion);
                                            }while (opcion!=3);
                                            break;
                                        case 6:
                                            System.out.println("Saliendo");
                                            break;
                                    }
                                }while (opcion!=6);
                            }else System.out.println("Nos vemos pronto");
                            break;
                        case 2:
                            hayHueco = codigo2PACorrecto = false;
                            contadorFallosTipoUsuario = contadorFallos2PARegistro = 0;
                            do{
                                System.out.println("Introduzca el tipo de usuario: <G> para GESTOR <I> para Inversor");
                                tipoUsuarioRegistro = s.nextLine();
                                if (hayHuecoGestorInversor(tipoUsuarioRegistro, gestorDatos,inversorDatos)) hayHueco = true;
                                else {
                                    System.out.println("No hay espacio.");
                                    contadorFallosTipoUsuario++;
                                }
                            }while (!hayHueco && contadorFallosTipoUsuario<3);
                            if (hayHueco){
                                do {
                                    nombreUsuarioNoExiste=false;
                                    System.out.println("Introduzca nombre de usuario:");
                                    nombreUsuarioRegistro = s.nextLine();
                                    do {
                                        System.out.println("Introduzca contraseña:");
                                        passUsuarioRegistro = s.nextLine();
                                    }while (!fortalezaContra(passUsuarioRegistro));
                                    Boolean correcto=false;
                                    do {
                                        System.out.println("Repita la contraseña: ");
                                        passUsuarioRegistroRepetida=s.nextLine();
                                        if (passUsuarioRegistro.equals(passUsuarioRegistroRepetida)) correcto=true;
                                    }while (!correcto);
                                    if (tipoUsuarioRegistro.equalsIgnoreCase("G")){
                                        for (int i = 0; i < gestorDatos.length; i++) {
                                            if (gestorDatos[i][0].equals(nombreUsuarioRegistro)) {
                                                System.out.println("El nombre de Usuario ya existe.");
                                                nombreUsuarioNoExiste = true;
                                            }
                                        }
                                    } else if (tipoUsuarioRegistro.equalsIgnoreCase("I")) {
                                        for (int i = 0; i < inversorDatos.length; i++) {
                                            if (inversorDatos[i][0].equals(nombreUsuarioRegistro)){
                                                System.out.println("El nombre de Usuario ya existe.");
                                                nombreUsuarioNoExiste = true;
                                            }
                                        }
                                    }
                                }while (nombreUsuarioNoExiste);
                                do {
                                    System.out.println("Introduzca su email: ");
                                    correoUsuarioRegistro = s.nextLine();
                                    String codigoCorrecto = correoEnviar(correoUsuarioRegistro);
                                    System.out.println("El código ha sido enviado.");
                                    System.out.println("Introduce el código: ");
                                    String codigo2PARegistro = s.nextLine();
                                    if (codigo2PARegistro.equals(codigoCorrecto)) codigo2PACorrecto = true;
                                    else contadorFallos2PARegistro++;
                                }while (!codigo2PACorrecto && contadorFallos2PARegistro<2);
                                int posicion = posicionGestorInversorRegistro(tipoUsuarioRegistro, gestorDatos, inversorDatos);
                                if (tipoUsuarioRegistro.equalsIgnoreCase("G")) {
                                    gestorDatos[posicion][0] = nombreUsuarioRegistro;
                                    gestorDatos[posicion][1] = passUsuarioRegistro;
                                    gestorDatos[posicion][2] = correoUsuarioRegistro;
                                } else if (tipoUsuarioRegistro.equalsIgnoreCase("I")) {
                                    inversorDatos[posicion][0] = nombreUsuarioRegistro;
                                    inversorDatos[posicion][1] = passUsuarioRegistro;
                                    inversorDatos[posicion][2] = correoUsuarioRegistro;
                                }
                            }
                        break;
                        case 3: // se pone case 2 para que no salga el mensaje de default al pulsar 2
                            System.out.println("Bye Bye...👋👋");
                            break;
                        default:
                            System.out.println("Vuelve a intentarlo");
                    }
                }while(opcionInicio!=3);
            }
        }