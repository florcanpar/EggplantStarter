import static biblioteca.Funciones.*;
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

                inicializarArrayBidimensionalBoolean(bloqueosUsuarios);
                inicializarArrayBidimensionalString(gestorDatos);
                inicializarArrayBidimensionalString(inversorDatos);
                inicializarArrayBidimensionalString(proyectos);
                inicializarArrayBidimensionalString(recompensas);

                adminDatos[0][0]="admin";
                adminDatos[0][1]="adminpass";
                adminDatos[0][2]="davidgalan001@gmail.com";

                gestorDatos[0][0]="gestor";
                gestorDatos[0][1]="gestorpass";
                gestorDatos[0][2]="davidgalan001@gmail.com";

                inversorDatos[0][0]="inversor1";
                inversorDatos[0][1]="inversor1pass";
                inversorDatos[0][2]="davidgalan001@gmail.com";
                inversorDatos[1][0]="inversor2";
                inversorDatos[1][1]="inversor2pass";
                inversorDatos[1][2]="davidgalan001@gmail.com";

                String Amin = "admin", Admin = "adminpass", GESTOR_USUARIO = "gestor", GESTOR_CONTRASENA = "gestorpass",
                inversor = "inversor1", inversorcontra = "inversor1pass", inversor12 = "inversor2", inversor2pass = "inversor2pass", usuario, contrasena, amigosReferidos="", correoUsuarioDestinatario;
                int contadorFallosGestor = 0, contadorFallosInversor1 = 0, contadorFallosInversor2 = 0;
                boolean bloquearGestor = false, bloquearInversor1 = false, bloquearInversor2 = false, admin = false, gestor = false, inversor1 = false, inversor2 = false;
                int carteraInversor1 = 0, carteraInversor2 = 0, dineroAnadido, cantidadInvertir, cantidadInvertidaInversor1Proy01 = 0, cantidadInvertidaInversor1Proy02 = 0, cantidadInvertidaInversor1Proy03 = 0,
                        cantidadInvertidaInversor2Proy01 = 0, cantidadInvertidaInversor2Proy02 = 0, cantidadInvertidaInversor2Proy03 = 0;

                String  rojo = "\033[31m", verde = "\033[32m", amarillo = "\033[33m", azul = "\033[34m", morado = "\033[35m", cyan = "\033[36m", colorNormal = "\u001B[0m";

                int menuGestor, opcion, opcion2;

                String nombreProyecto01="", nombreProyecto02 = "", nombreProyecto03 = "";
                String descProyecto01 = "", descProyecto02 = "", descProyecto03 = "";
                String categoriaProyecto01 = "", categoriaProyecto02 = "", categoriaProyecto03 = "";
                double cantNecesariaProyecto01 = 0, cantNecesariaProyecto02 = 0, cantNecesariaProyecto03 = 0;
                double cantFinanciadaProyecto01 = 10, cantFinanciadaProyecto02 = 0, cantFinanciadaProyecto03 = 0;

                // Fechas de los proyectos
                String fechaInicioProyecto01 = "", fechaInicioProyecto02 = "", fechaInicioProyecto03 = "";
                String fechaFinalProyecto01 = "", fechaFinalProyecto02 = "", fechaFinalProyecto03 = "";

                // Recompensas de los proyectos
                String recompensa1Proyecto01 = "", recompensa2Proyecto01 = "", recompensa3Proyecto01 = "";
                String recompensa1Proyecto02 = "", recompensa2Proyecto02 = "", recompensa3Proyecto02 = "";
                String recompensa1Proyecto03 = "", recompensa2Proyecto03 = "", recompensa3Proyecto03 = "";
                int preciorecompensa1Proyecto01 = 0, preciorecompensa2Proyecto01 = 0, preciorecompensa3Proyecto01 = 0;
                int preciorecompensa1Proyecto02 = 0, preciorecompensa2Proyecto02 = 0, preciorecompensa3Proyecto02 = 0;
                int preciorecompensa1Proyecto03 = 0, preciorecompensa2Proyecto03 = 0, preciorecompensa3Proyecto03 = 0;


                //nuevas variables
                Boolean hayHueco = false, nombreUsuarioNoExiste = false, codigo2PACorrecto = false;
                String tipoUsuarioRegistro ="", correoUsuarioRegistro = "", nombreUsuarioRegistro="", passUsuarioRegistro="", codigo2PAGeneradoSI="";
                int contadorFallosTipoUsuario = 0, contadorFallos2PARegistro = 0, tipoUsuarioIS = 0;

                do {
                    menuInicioSesion();
                    opcion= leerInt();
                    switch (opcion){
                        case 1:
                                //NUEVO
                                int contadorFallos=0;
                                String codigoInsertaUsuario="";
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
                                                    if (opcion<cuantosGestoresHay(gestorDatos) && !bloqueosUsuarios[opcion][0]) bloqueosUsuarios[opcion][0]=false;
                                                    else if(opcion<cuantosInversoresHay(inversorDatos) && !bloqueosUsuarios[opcion+gestorDatos.length][0]) bloqueosUsuarios[(opcion-1)+gestorDatos.length][0]=false;
                                                }while (opcion!=cantidadUsuarios);
                                        }
                                        break;
                                        case 2: {
                                            do {
                                                menuProyectosAdmin();
                                                opcion = leerInt();
                                                switch (opcion){
                                                    case 1:
                                                        if(nombreProyecto01.isEmpty() && nombreProyecto02.isEmpty() && nombreProyecto03.isEmpty()){
                                                            System.out.println( amarillo + "Ningún proyecto ha sido creado aún." + colorNormal);
                                                        }else{
                                                            do {
                                                                menuVerProyectos();
                                                                opcion = leerInt();
                                                                switch(opcion){
                                                                    case 1:
                                                                        if (nombreProyecto01.isEmpty()){
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún." + colorNormal);
                                                                        } else{
                                                                            mostrarResumenProyecto(proyectos, opcion);
                                                                            String InvertirODetallada = leerString();
                                                                            if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                                mostrarProyecto(proyectos, opcion, recompensas);
                                                                            }else System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                        }
                                                                        break;
                                                                    case 2:
                                                                        if (nombreProyecto02.isEmpty()) {
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún." + colorNormal);
                                                                        } else {
                                                                            mostrarResumenProyecto(proyectos, opcion);
                                                                            String InvertirODetallada = leerString();
                                                                            if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                                mostrarProyecto(proyectos, opcion, recompensas);
                                                                            } else {
                                                                                System.out.println(amarillo + "Opción inválida" + colorNormal);
                                                                            }
                                                                        }
                                                                        break;
                                                                    case 3:
                                                                        if (nombreProyecto03.isEmpty()) {
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún." + colorNormal);
                                                                        } else {
                                                                            mostrarResumenProyecto(proyectos, opcion);
                                                                            String InvertirODetallada = leerString();
                                                                            if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                                mostrarProyecto(proyectos, opcion, recompensas);
                                                                            } else {
                                                                                System.out.println(amarillo + "Opción inválida" + colorNormal);
                                                                            }
                                                                        }
                                                                        break;
                                                                    case 4:
                                                                        System.out.println("Saliendo...");
                                                                        break;
                                                                    default:
                                                                        System.out.println(amarillo + "Opción inválida, inténtelo de nuevo." + colorNormal);
                                                                        break;
                                                                }
                                                            }while (opcion != 4);
                                                        }
                                                        break;
                                                    case 2 :
                                                        if(nombreProyecto01.isEmpty() && nombreProyecto02.isEmpty() && nombreProyecto03.isEmpty()){
                                                            System.out.println(amarillo +"Ningún proyecto ha sido creado aún, dile al gesto que cree un proyecto para modificarlo." + colorNormal);
                                                        }else{
                                                            do {
                                                                menuCambiarProyectos();
                                                                opcion = leerInt();
                                                                switch(opcion){
                                                                    case 1:
                                                                        if (nombreProyecto01.isEmpty()){
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                                        } else {
                                                                            do {
                                                                                menuCambiarProyectosCaracteristicas();
                                                                                opcion = leerInt();
                                                                                switch (opcion) {
                                                                                    case 1:
                                                                                        System.out.println("Nombre:");
                                                                                        nombreProyecto01 = leerString();
                                                                                        break;
                                                                                    case 2:
                                                                                        System.out.println("Descripción:");
                                                                                        descProyecto01 = leerString();
                                                                                        break;
                                                                                    case 3:
                                                                                        System.out.println("Categoría:");
                                                                                        categoriaProyecto01 = leerString();
                                                                                        break;
                                                                                    case 4:
                                                                                        System.out.println("Cantidad Necesaria:");
                                                                                        cantNecesariaProyecto01 = leerInt();
                                                                                        break;
                                                                                    case 5:
                                                                                        System.out.println("Cantidad Financiada:");
                                                                                        cantFinanciadaProyecto01 = leerInt();
                                                                                        break;
                                                                                    case 6:
                                                                                        System.out.println("Fecha de Inicio de inversiones:");
                                                                                        fechaInicioProyecto01 = leerString();
                                                                                        break;
                                                                                    case 7:
                                                                                        System.out.println("Fecha de Inicio de inversiones:");
                                                                                        fechaFinalProyecto01 = leerString();
                                                                                        break;
                                                                                    case 8:
                                                                                        do {
                                                                                            menuCambiarRecompensa();
                                                                                            opcion = leerInt();
                                                                                            switch(opcion){
                                                                                                case 1:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 1:");
                                                                                                    recompensa1Proyecto01 = leerString();
                                                                                                    System.out.println("Escriba el precio de la recompensa 1:");
                                                                                                    preciorecompensa1Proyecto01 = leerInt();
                                                                                                    break;
                                                                                                case 2:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 2:");
                                                                                                    recompensa2Proyecto01 = leerString();
                                                                                                    System.out.println("Escriba el precio de la recompensa 2:");
                                                                                                    preciorecompensa2Proyecto01 = leerInt();

                                                                                                    break;
                                                                                                case 3:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 3:");
                                                                                                    recompensa3Proyecto01 = leerString();
                                                                                                    System.out.println("Escriba el precio de la recompensa 3:");
                                                                                                    preciorecompensa3Proyecto01 = leerInt();
                                                                                                    break;
                                                                                                case 4:
                                                                                                    System.out.println("Saliendo...");
                                                                                                    break;
                                                                                                default:
                                                                                                    System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                                                    break;
                                                                                            }
                                                                                        }while(opcion != 4);
                                                                                        break;
                                                                                    case 9:
                                                                                        System.out.println("Saliendo...");
                                                                                        break;
                                                                                }
                                                                            } while (opcion != 9);
                                                                        }
                                                                    case 2:
                                                                        if (nombreProyecto02.isEmpty()){
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                                        } else {
                                                                            do {
                                                                                menuCambiarProyectosCaracteristicas();
                                                                                opcion = leerInt();
                                                                                switch (opcion) {
                                                                                    case 1:
                                                                                        System.out.println("Nombre:");
                                                                                        nombreProyecto02 = leerString();
                                                                                        break;
                                                                                    case 2:
                                                                                        System.out.println("Descripción:");
                                                                                        descProyecto02 = leerString();
                                                                                        break;
                                                                                    case 3:
                                                                                        System.out.println("Categoría:");
                                                                                        categoriaProyecto02 = leerString();
                                                                                        break;
                                                                                    case 4:
                                                                                        System.out.println("Cantidad Necesaria:");
                                                                                        cantNecesariaProyecto02 = leerInt();
                                                                                        break;
                                                                                    case 5:
                                                                                        System.out.println("Cantidad Financiada:");
                                                                                        cantFinanciadaProyecto02 = leerInt();
                                                                                        break;
                                                                                    case 6:
                                                                                        System.out.println("Fecha de Inicio de inversiones:");
                                                                                        fechaInicioProyecto02 = leerString();
                                                                                        break;
                                                                                    case 7:
                                                                                        System.out.println("Fecha de Inicio de inversiones:");
                                                                                        fechaFinalProyecto02 = leerString();
                                                                                        break;
                                                                                    case 8:
                                                                                        do {
                                                                                            menuCambiarRecompensa();
                                                                                            opcion = leerInt();
                                                                                            switch(opcion){
                                                                                                case 1:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 1:");
                                                                                                    recompensa1Proyecto02 = leerString();
                                                                                                    System.out.println("Escriba el precio de la recompensa 1:");
                                                                                                    preciorecompensa1Proyecto02 = leerInt();
                                                                                                    break;
                                                                                                case 2:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 2:");
                                                                                                    recompensa2Proyecto02 = leerString();
                                                                                                    System.out.println("Escriba el precio de la recompensa 2:");
                                                                                                    preciorecompensa2Proyecto02 = leerInt();
                                                                                                    break;
                                                                                                case 3:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 3:");
                                                                                                    recompensa3Proyecto02 = leerString();
                                                                                                    System.out.println("Escriba el precio de la recompensa 3:");
                                                                                                    preciorecompensa3Proyecto02 = leerInt();
                                                                                                    break;
                                                                                                case 4:
                                                                                                    System.out.println("Saliendo...");
                                                                                                    break;
                                                                                            }

                                                                                        }while(opcion != 4);
                                                                                        break;
                                                                                    case 9:
                                                                                        System.out.println("Saliendo...");
                                                                                        break;
                                                                                }
                                                                            } while (opcion != 9);
                                                                        }
                                                                        break;
                                                                    case 3:
                                                                        if (nombreProyecto03.isEmpty()){
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                                        } else {
                                                                            do {
                                                                                menuCambiarProyectosCaracteristicas();
                                                                                opcion = leerInt();
                                                                                switch (opcion) {
                                                                                    case 1:
                                                                                        System.out.println("Nombre:");
                                                                                        nombreProyecto03 = leerString();
                                                                                        break;
                                                                                    case 2:
                                                                                        System.out.println("Descripción:");
                                                                                        descProyecto03 = leerString();
                                                                                        break;
                                                                                    case 3:
                                                                                        System.out.println("Categoría:");
                                                                                        categoriaProyecto03 = leerString();
                                                                                        break;
                                                                                    case 4:
                                                                                        System.out.println("Cantidad Necesaria:");
                                                                                        cantNecesariaProyecto03 = leerInt();
                                                                                        break;
                                                                                    case 5:
                                                                                        System.out.println("Cantidad Financiada:");
                                                                                        cantFinanciadaProyecto03 = leerInt();
                                                                                        break;
                                                                                    case 6:
                                                                                        System.out.println("Fecha de Inicio de inversiones:");
                                                                                        fechaInicioProyecto03 = leerString();
                                                                                        break;
                                                                                    case 7:
                                                                                        System.out.println("Fecha de Inicio de inversiones:");
                                                                                        fechaFinalProyecto03 = leerString();
                                                                                        break;
                                                                                    case 8:
                                                                                        do {
                                                                                            menuCambiarRecompensa();
                                                                                            opcion = leerInt();
                                                                                            switch(opcion){
                                                                                                case 1:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 1:");
                                                                                                    recompensa1Proyecto03 = leerString();
                                                                                                    System.out.println("Escriba el precio de la recompensa 1:");
                                                                                                    preciorecompensa1Proyecto03 = leerInt();
                                                                                                    break;
                                                                                                case 2:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 2:");
                                                                                                    recompensa2Proyecto03 = leerString();
                                                                                                    System.out.println("Escriba el precio de la recompensa 2:");
                                                                                                    preciorecompensa2Proyecto03 = leerInt();
                                                                                                    break;
                                                                                                case 3:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 3:");
                                                                                                    recompensa3Proyecto03 = leerString();
                                                                                                    System.out.println("Escriba el precio de la recompensa 3:");
                                                                                                    preciorecompensa3Proyecto03 = leerInt();
                                                                                                    break;
                                                                                                case 4:
                                                                                                    System.out.println("Saliendo...");
                                                                                                    break;
                                                                                            }
                                                                                        }while(opcion != 4);
                                                                                        break;
                                                                                    case 9:
                                                                                        System.out.println("Saliendo...");
                                                                                        break;
                                                                                }
                                                                            } while (opcion != 9);
                                                                            break;
                                                                        }
                                                                    case 4:
                                                                        System.out.println("Saliendo...");
                                                                        break;
                                                                }
                                                            }while (opcion != 4);
                                                            break;
                                                        }
                                                        break;
                                                    case 3 :
                                                        if (!(nombreProyecto01.isEmpty() && nombreProyecto02.isEmpty() && nombreProyecto03.isEmpty())){
                                                            do {
                                                                menuEliminarProyectos();
                                                                opcion = leerInt();
                                                                switch (opcion){
                                                                    case 1:
                                                                        if (nombreProyecto01.isEmpty()){
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                                        } else {
                                                                            System.out.println("¿Quieres eliminar el proyecto " + nombreProyecto01 + "? (s/n)");
                                                                            String eliminarProyecto1SiNo = leerString();
                                                                            if (eliminarProyecto1SiNo.equalsIgnoreCase("s")) {
                                                                                nombreProyecto01 = "";
                                                                                descProyecto01 = "";
                                                                                categoriaProyecto01 = "";
                                                                                cantNecesariaProyecto01 = 0;
                                                                                cantFinanciadaProyecto01 = 0;
                                                                                fechaFinalProyecto01 = "";
                                                                                fechaInicioProyecto01 = "";
                                                                                recompensa1Proyecto01 = "";
                                                                                recompensa2Proyecto01 = "";
                                                                                recompensa3Proyecto01 = "";
                                                                                preciorecompensa1Proyecto01 = 0;
                                                                                preciorecompensa2Proyecto01 = 0;
                                                                                preciorecompensa3Proyecto01 = 0;
                                                                                System.out.println(verde + "Proyecto eliminado satisfactoriamente." + colorNormal);
                                                                                break;
                                                                            } else {
                                                                                System.out.println("Saliendo...");
                                                                                break;
                                                                            }
                                                                        }
                                                                    case 2:
                                                                        if (nombreProyecto02.isEmpty()){
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                                        } else {
                                                                            System.out.println("¿Quieres eliminar el proyecto " + nombreProyecto02 + "? (s/n)");
                                                                            String eliminarProyecto2SiNo = leerString();
                                                                            if (eliminarProyecto2SiNo.equalsIgnoreCase("s")){
                                                                                nombreProyecto02 = "";
                                                                                descProyecto02 = "";
                                                                                categoriaProyecto02 = "";
                                                                                cantNecesariaProyecto02 = 0;
                                                                                cantFinanciadaProyecto02 = 0;
                                                                                fechaFinalProyecto02 = "";
                                                                                fechaInicioProyecto02 = "";
                                                                                recompensa1Proyecto02 = "";
                                                                                recompensa2Proyecto02 = "";
                                                                                recompensa3Proyecto02 = "";
                                                                                preciorecompensa1Proyecto02 = 0;
                                                                                preciorecompensa2Proyecto02 = 0;
                                                                                preciorecompensa3Proyecto02 = 0;
                                                                                System.out.println(verde + "Proyecto eliminado satisfactoriamente." + colorNormal);
                                                                                break;
                                                                            } else {
                                                                                System.out.println("Saliendo...");
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                    case 3:
                                                                        if (nombreProyecto01.isEmpty()){
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                                        } else {
                                                                            System.out.println("¿Quieres eliminar el proyecto " + nombreProyecto03 + "? (s/n)");
                                                                            String eliminarProyecto3SiNo = leerString();
                                                                            if (eliminarProyecto3SiNo.equalsIgnoreCase("s")) {
                                                                                nombreProyecto03 = "";
                                                                                descProyecto03 = "";
                                                                                categoriaProyecto03 = "";
                                                                                cantNecesariaProyecto03 = 0;
                                                                                cantFinanciadaProyecto03 = 0;
                                                                                fechaFinalProyecto03 = "";
                                                                                fechaInicioProyecto03 = "";
                                                                                recompensa1Proyecto03 = "";
                                                                                recompensa2Proyecto03 = "";
                                                                                recompensa3Proyecto03 = "";
                                                                                preciorecompensa1Proyecto03 = 0;
                                                                                preciorecompensa2Proyecto03 = 0;
                                                                                preciorecompensa3Proyecto03 = 0;
                                                                                System.out.println(verde + "Proyecto eliminado satisfactoriamente." + colorNormal);
                                                                                break;
                                                                            } else {
                                                                                System.out.println("Saliendo...");
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                    case 4:
                                                                        break;
                                                                    default:
                                                                        System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                        break;
                                                                }
                                                            }while (opcion != 4);
                                                        }else System.out.println(amarillo +"Aún no hay proyectos creados, cuando lo estén podrás eliminarlos."+ colorNormal);
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
                                        case 3: {
                                            do {
                                                menuConfiguracionUsuarioContrasena();
                                                opcion = leerInt();
                                                switch (opcion) {
                                                    case 1:
                                                        adminDatos[0][0]=cambiarUsuarioContrasena(adminDatos[0][1]);
                                                        break;
                                                    case 2:
                                                        adminDatos[0][1]=cambiarUsuarioContrasena(adminDatos[0][1]);
                                                        break;
                                                    case 3:
                                                        System.out.println("Saliendo...");
                                                        break;
                                                    default:
                                                        System.out.println(amarillo + "Opción Inválida." + colorNormal);
                                                }
                                            }while (opcion != 3) ;
                                        }
                                        break;
                                        case 4: {
                                            System.out.println("Cerrando sesión...");
                                            break;
                                        }
                                        default:
                                            System.out.println(amarillo + "Opción Inválida." + colorNormal);
                                    }
                                } while (opcion2 != 4);
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
                                                        do {
                                                            if (cuantosProyectosHay(proyectos) == proyectos.length)
                                                                System.out.println("La cantidad máxima de proyectos se ha alcanzado");
                                                            else {
                                                                mostrarProyectosDisponibles(proyectos);
                                                                int opcionProyecto = leerInt();
                                                                if (opcionProyecto < proyectos.length) {
                                                                    int cantNecesaria = 0;
                                                                    int cantFinanciada=0;
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
                                                                        cantNecesaria = Integer.parseInt(proyectos[opcion][3]);
                                                                        cantFinanciada = Integer.parseInt(proyectos[opcion][4]);
                                                                        if (cantNecesaria < cantFinanciada)
                                                                            System.out.println("La cantidad necesaria tiene que ser mayor que la financiada.");
                                                                    } while (cantNecesaria < cantFinanciada);
                                                                    do {
                                                                        menuCrearRecompensa();
                                                                        opcion = leerInt();
                                                                        if (opcion<4) {
                                                                            System.out.println("Escriba la descripción de la recompensa " + opcion + ":");
                                                                            recompensas[opcionProyecto][opcion] = leerString();
                                                                            System.out.println("Escriba el precio de la recompensa " + opcion + ":");
                                                                            recompensas[opcionProyecto][opcion + 1] = leerString();
                                                                            break;
                                                                        }else System.out.println("Saliendo...");
                                                                    } while (opcion != 4);
                                                                    break;
                                                                }
                                                            }
                                                        } while (opcion != proyectos.length);
                                                        break;
                                                    case 3:
                                                        proyectos[0][0]="puta";
                                                        if (cuantosProyectosHay(proyectos) < 1) System.out.println(amarillo + "Ningún proyecto ha sido creado aún." + colorNormal);
                                                        else {
                                                            do {

                                                                mostrarProyectosCreados(proyectos);
                                                                opcion = leerInt();
                                                                if (opcion<proyectos.length) {
                                                                    if (proyectos[opcion][0].isEmpty())
                                                                        System.out.println(amarillo + "Este proyecto no ha sido creado aún." + colorNormal);
                                                                    else {
                                                                        do {
                                                                            menuCambiarProyectosCaracteristicas();
                                                                            opcion = leerInt();

                                                                            switch (opcion) {
                                                                                case 0:
                                                                                    System.out.println("Nombre:");
                                                                                    proyectos[opcion][0] = leerString();
                                                                                    break;
                                                                                case 1:
                                                                                    System.out.println("Descripción:");
                                                                                    proyectos[opcion][1] = leerString();
                                                                                    break;
                                                                                case 2:
                                                                                    System.out.println("Categoría:");
                                                                                    proyectos[opcion][2] = leerString();
                                                                                    break;
                                                                                case 3:
                                                                                    System.out.println("Cantidad Necesaria:");
                                                                                    proyectos[opcion][3] = leerString();
                                                                                    break;
                                                                                case 4:
                                                                                    System.out.println("Cantidad Financiada:");
                                                                                    proyectos[opcion][4] = leerString();
                                                                                    break;
                                                                                case 5:
                                                                                    System.out.println("Fecha de Inicio de inversiones:");
                                                                                    proyectos[opcion][5] = leerString();
                                                                                    break;
                                                                                case 6:
                                                                                    System.out.println("Fecha de Inicio de inversiones:");
                                                                                    proyectos[opcion][6] = leerString();
                                                                                    break;
                                                                                case 7:
                                                                                    do {
                                                                                        menuCambiarRecompensa();
                                                                                        opcion = leerInt();
                                                                                        switch (opcion) {
                                                                                            case 1:
                                                                                                System.out.println("Escriba la descripción de la recompensa 1:");
                                                                                                recompensas[opcion][0] = leerString();
                                                                                                System.out.println("Escriba el precio de la recompensa 1:");
                                                                                                recompensas[opcion][1] = leerString();
                                                                                                break;
                                                                                            case 2:
                                                                                                System.out.println("Escriba la descripción de la recompensa 2:");
                                                                                                recompensas[opcion][2] = leerString();
                                                                                                System.out.println("Escriba el precio de la recompensa 2:");
                                                                                                recompensas[opcion][3] = leerString();

                                                                                                break;
                                                                                            case 3:
                                                                                                System.out.println("Escriba la descripción de la recompensa 3:");
                                                                                                recompensas[opcion][4] = leerString();
                                                                                                System.out.println("Escriba el precio de la recompensa 3:");
                                                                                                recompensas[opcion][5] = leerString();
                                                                                                break;
                                                                                            case 4:
                                                                                                System.out.println("Saliendo...");
                                                                                                break;
                                                                                            default:
                                                                                                System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                                                break;
                                                                                        }
                                                                                    } while (opcion != 4);
                                                                                    break;
                                                                                case 8:
                                                                                    System.out.println("Saliendo...");
                                                                                    break;
                                                                            }
                                                                        } while (opcion != 8);
                                                                    }
                                                                }
                                                            } while (opcion != proyectos.length);
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
                                                                            String eliminarProyecto1SiNo = leerString();
                                                                            if (eliminarProyecto1SiNo.equalsIgnoreCase("s")) {
                                                                                proyectos[opcion][0] = "";
                                                                                proyectos[opcion][0] = "";
                                                                                proyectos[opcion][0] = "";
                                                                                proyectos[opcion][0] = "";
                                                                                proyectos[opcion][0] = "";
                                                                                proyectos[opcion][0] = "";
                                                                                proyectos[opcion][0] = "";
                                                                                recompensas[opcion][0] = "";
                                                                                recompensas[opcion][2] = "";
                                                                                recompensas[opcion][4] = "";
                                                                                recompensas[opcion][1] = "";
                                                                                recompensas[opcion][3] = "";
                                                                                recompensas[opcion][5] = "";
                                                                                System.out.println(verde + "Proyecto eliminado satisfactoriamente." + colorNormal);
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
                                                switch (opcion) {
                                                    case 1:
                                                        gestorDatos[0][0] = cambiarUsuarioContrasena(gestorDatos[0][1]);
                                                        break;
                                                    case 2:
                                                        gestorDatos[0][1] = cambiarUsuarioContrasena(gestorDatos[0][1]);
                                                        break;
                                                    case 3:
                                                        System.out.println("Volviendo al Menú Gestor...");
                                                        break;
                                                    default:
                                                        System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                        break;
                                                }
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
                            } else if (inversor1 && !bloquearInversor1) {
                                do {
                                    menuInversor();
                                    opcion = leerInt();
                                    switch (opcion){
                                        case 1:
                                            if(nombreProyecto01.isEmpty() && nombreProyecto02.isEmpty() && nombreProyecto03.isEmpty()){
                                                System.out.println(amarillo + "Ningún proyecto ha sido creado aún." + colorNormal);
                                            }else{
                                                do {
                                                    menuVerProyectos();
                                                    opcion = leerInt();
                                                    switch(opcion){
                                                        case 1:
                                                            if (nombreProyecto01.isEmpty()){
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else{
                                                                mostrarResumenProyecto(proyectos, opcion);
                                                                System.out.println("Para invertir, inserte "+ amarillo +"[Y]" + colorNormal);
                                                                String InvertirODetallada = leerString();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")){
                                                                    mostrarProyecto(proyectos, opcion, recompensas);
                                                                } else if (InvertirODetallada.equals("y")){
                                                                    System.out.print("Cantidad a invertir: ");
                                                                    cantidadInvertir = leerInt();
                                                                    if (cantidadInvertir > carteraInversor1) {
                                                                        System.out.println("No tienes suficiente saldo en tu cartera");
                                                                    } else if (cantidadInvertir > (cantNecesariaProyecto01 - cantFinanciadaProyecto01)) {
                                                                        System.out.println("Cantidad Invertida mayor a la necesaria.");
                                                                    } else if (cantidadInvertir <= 0) {
                                                                        System.out.println("Introduce una cantidad mayor a 0.");
                                                                    } else {
                                                                        System.out.println("Has invertido " + cantidadInvertir + " euros.");
                                                                        carteraInversor1 = carteraInversor1 - cantidadInvertir;
                                                                        cantFinanciadaProyecto01 += cantidadInvertir;
                                                                        cantidadInvertidaInversor1Proy01 += cantidadInvertir;
                                                                    }
                                                                } else {
                                                                    System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            if (nombreProyecto02.isEmpty()) {
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else {
                                                                mostrarResumenProyecto(proyectos, opcion);
                                                                System.out.println("Para invertir, inserte "+ amarillo +"[Y]" + colorNormal);
                                                                String InvertirODetallada = leerString();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                    mostrarProyecto(proyectos, opcion, recompensas);
                                                                } else if (InvertirODetallada.equals("y")) {
                                                                    System.out.print("Cantidad a invertir: ");
                                                                    cantidadInvertir = leerInt();
                                                                    if (cantidadInvertir > carteraInversor1) {
                                                                        System.out.println("No tienes suficiente saldo en tu cartera");
                                                                    } else if (cantidadInvertir > (cantNecesariaProyecto02 - cantFinanciadaProyecto02)) {
                                                                        System.out.println("Cantidad Invertida mayor a la necesaria.");
                                                                    } else if (cantidadInvertir <= 0) {
                                                                        System.out.println("Introduce una cantidad mayor a 0.");
                                                                    } else {
                                                                        System.out.println("Has invertido " + cantidadInvertir + " euros.");
                                                                        carteraInversor1 = carteraInversor1 - cantidadInvertir;
                                                                        cantFinanciadaProyecto02 += cantidadInvertir;
                                                                        cantidadInvertidaInversor1Proy02 += cantidadInvertir;
                                                                    }
                                                                } else {
                                                                    System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                }
                                                            }
                                                            break;
                                                        case 3:
                                                            if (nombreProyecto03.isEmpty()) {
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else {
                                                                mostrarResumenProyecto(proyectos, opcion);
                                                                System.out.println("Para invertir, inserte "+ amarillo +"[Y]" + colorNormal);
                                                                String InvertirODetallada = leerString();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                    mostrarProyecto(proyectos, opcion, recompensas);
                                                                } else if (InvertirODetallada.equals("y")) {
                                                                    System.out.print("Cantidad a invertir: ");
                                                                    cantidadInvertir = leerInt();
                                                                    if (cantidadInvertir > carteraInversor1) {
                                                                        System.out.println("No tienes suficiente saldo en tu cartera");
                                                                    } else if (cantidadInvertir > (cantNecesariaProyecto03 - cantFinanciadaProyecto03)) {
                                                                        System.out.println("Cantidad Invertida mayor a la necesaria.");
                                                                    } else if (cantidadInvertir <= 0) {
                                                                        System.out.println("Introduce una cantidad mayor a 0.");
                                                                    } else {
                                                                        System.out.println("Has invertido " + cantidadInvertir + " euros.");
                                                                        carteraInversor1 = carteraInversor1 - cantidadInvertir;
                                                                        cantFinanciadaProyecto03 += cantidadInvertir;
                                                                        cantidadInvertidaInversor1Proy03 += cantidadInvertir;
                                                                    }
                                                                } else {
                                                                    System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                }
                                                            }
                                                            break;
                                                        case 4:
                                                            System.out.println("Saliendo...");
                                                            break;
                                                        default:
                                                            System.out.println(amarillo + "Opción inválida, inténtelo de nuevo." + colorNormal);
                                                            break;
                                                    }
                                                }while (opcion != 4);
                                            }
                                            break;
                                        case 2:
                                            if(nombreProyecto01.isEmpty() && nombreProyecto02.isEmpty() && nombreProyecto03.isEmpty()){
                                                System.out.println(amarillo + "Ningún proyecto ha sido creado aún." + colorNormal);
                                            }else{
                                                do {
                                                    menuVerProyectos();
                                                    opcion = leerInt();
                                                    switch(opcion){
                                                        case 1:
                                                            if (nombreProyecto01.isEmpty()){
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else{
                                                                mostrarResumenProyecto(proyectos, opcion);
                                                                String InvertirODetallada = leerString();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")){
                                                                    mostrarProyecto(proyectos, opcion, recompensas);
                                                                } else {
                                                                    System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            if (nombreProyecto02.isEmpty()) {
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else {
                                                                mostrarResumenProyecto(proyectos, opcion);
                                                                String InvertirODetallada = leerString();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                    mostrarProyecto(proyectos, opcion, recompensas);
                                                                } else {
                                                                    System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                }
                                                            }
                                                            break;
                                                        case 3:
                                                            if (nombreProyecto03.isEmpty()) {
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else {
                                                                mostrarResumenProyecto(proyectos, opcion);
                                                                String InvertirODetallada = leerString();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                    mostrarProyecto(proyectos, opcion, recompensas);
                                                                } else {
                                                                    System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                }
                                                            }
                                                            break;
                                                        case 4:
                                                            System.out.println("Saliendo...");
                                                            break;
                                                        default:
                                                            System.out.println(amarillo + "Opción inválida, inténtelo de nuevo." + colorNormal);
                                                            break;
                                                    }
                                                }while (opcion != 4);
                                            }
                                            break;
                                        case 3:
                                            do {
                                                menuCarteraDigital();
                                                opcion = leerInt();
                                                switch (opcion){
                                                    case 1:
                                                        System.out.println(carteraInversor1);
                                                        break;
                                                    case 2:
                                                        do {
                                                            System.out.println("¿Cuánto dinero quieres añadir?");
                                                            dineroAnadido = leerInt();
                                                            if (dineroAnadido<0) System.out.println("La cantidad añadida debe ser mayor a 0");
                                                            else carteraInversor1+=dineroAnadido;
                                                        }while (dineroAnadido<=0);
                                                        break;
                                                    case 3:
                                                        System.out.println("Saliendo");
                                                        break;
                                                }
                                            }while (opcion!=3);
                                            break;
                                        case 4:
                                            do {
                                                menuInvitarAmigos();
                                                opcion = leerInt();
                                                switch (opcion) {
                                                    case 1:
                                                        if (amigosReferidos.isEmpty()) {
                                                            System.out.println(amarillo + "Aún no has invitado a ningún amigo." + colorNormal);
                                                        } else {
                                                            System.out.println("Amigos referidos: " + amigosReferidos);
                                                        }
                                                        break;
                                                    case 2:
                                                        System.out.print("Introduce el correo electrónico del amigo: ");
                                                        String nuevoAmigo = leerString();
                                                        if (!nuevoAmigo.contains("@") || !nuevoAmigo.contains(".")) {
                                                            System.out.println(amarillo + "El correo introducido no es válido." + colorNormal);
                                                        } else {
                                                            if (amigosReferidos.isEmpty()) {
                                                                amigosReferidos = nuevoAmigo;
                                                            } else {
                                                                amigosReferidos += ", " + nuevoAmigo;
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
                                                switch (opcion){
                                                    case 1:
                                                        inversorDatos[0][0]=cambiarUsuarioContrasena(inversorDatos[0][1]);
                                                        break;
                                                    case 2:
                                                        inversorDatos[0][1]=cambiarUsuarioContrasena(inversorDatos[0][1]);
                                                        break;
                                                    case 3:
                                                        break;
                                                }
                                            }while (opcion!=3);
                                            break;
                                        case 6:
                                            System.out.println("Saliendo");
                                            break;
                                    }
                                }while (opcion!=6);
                            } else if (inversor2 && !bloquearInversor2) {
                                do {
                                    menuInversor();
                                    opcion = leerInt();
                                    switch (opcion) {
                                        case 1:
                                            if (nombreProyecto01.isEmpty() && nombreProyecto02.isEmpty() && nombreProyecto03.isEmpty()) {
                                                System.out.println(amarillo + "Ningún proyecto ha sido creado aún." + colorNormal);
                                            } else {
                                                do {
                                                    menuVerProyectos();
                                                    opcion = leerInt();
                                                    switch(opcion) {
                                                        case 1:
                                                            if (nombreProyecto01.isEmpty()) {
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else {
                                                                mostrarResumenProyecto(proyectos, opcion);
                                                                System.out.println("Para invertir, inserte "+ amarillo +"[Y]" + colorNormal);
                                                                String InvertirODetallada = leerString();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                    mostrarProyecto(proyectos, opcion, recompensas);
                                                                } else if (InvertirODetallada.equals("y")) {
                                                                    System.out.print("Cantidad a invertir: ");
                                                                    cantidadInvertir = leerInt();
                                                                    if (cantidadInvertir > carteraInversor2) {
                                                                        System.out.println(amarillo + "No tienes suficiente saldo en tu cartera" + colorNormal);
                                                                    } else if (cantidadInvertir > (cantNecesariaProyecto01 - cantFinanciadaProyecto01)) {
                                                                        System.out.println(amarillo +"Cantidad Invertida mayor a la necesaria." + colorNormal);
                                                                    } else if (cantidadInvertir <= 0) {
                                                                        System.out.println("Introduce una cantidad mayor a 0.");
                                                                    } else {
                                                                        System.out.println("Has invertido " + cantidadInvertir + " euros.");
                                                                        carteraInversor2 = carteraInversor2 - cantidadInvertir;
                                                                        cantFinanciadaProyecto01 += cantidadInvertir;
                                                                        cantidadInvertidaInversor2Proy01 += cantidadInvertir;
                                                                    }
                                                                } else {
                                                                    System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            if (nombreProyecto02.isEmpty()) {
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else {
                                                                mostrarResumenProyecto(proyectos, opcion);
                                                                System.out.println("Para invertir, inserte "+ amarillo +"[Y]" + colorNormal);
                                                                String InvertirODetallada = leerString();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                    mostrarProyecto(proyectos, opcion, recompensas);
                                                                } else if (InvertirODetallada.equals("y")) {
                                                                    System.out.print("Cantidad a invertir: ");
                                                                    cantidadInvertir = leerInt();
                                                                    if (cantidadInvertir > carteraInversor2) {
                                                                        System.out.println("No tienes suficiente saldo en tu cartera");
                                                                    } else if (cantidadInvertir > (cantNecesariaProyecto02 - cantFinanciadaProyecto02)) {
                                                                        System.out.println("Cantidad Invertida mayor a la necesaria.");
                                                                    } else if (cantidadInvertir <= 0) {
                                                                        System.out.println("Introduce una cantidad mayor a 0.");
                                                                    } else {
                                                                        System.out.println("Has invertido " + cantidadInvertir + " euros.");
                                                                        carteraInversor2 = carteraInversor2 - cantidadInvertir;
                                                                        cantFinanciadaProyecto02 += cantidadInvertir;
                                                                        cantidadInvertidaInversor2Proy02 += cantidadInvertir;
                                                                    }
                                                                } else {
                                                                    System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                }
                                                            }
                                                            break;
                                                        case 3:
                                                            if (nombreProyecto03.isEmpty()) {
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else {
                                                                mostrarResumenProyecto(proyectos, opcion);
                                                                System.out.println("Para invertir, inserte "+ amarillo +"[Y]" + colorNormal);
                                                                String InvertirODetallada = leerString();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                    mostrarProyecto(proyectos, opcion, recompensas);
                                                                } else if (InvertirODetallada.equals("y")) {
                                                                    System.out.print("Cantidad a invertir: ");
                                                                    cantidadInvertir = leerInt();
                                                                    if (cantidadInvertir > carteraInversor2) {
                                                                        System.out.println("No tienes suficiente saldo en tu cartera");
                                                                    } else if (cantidadInvertir > (cantNecesariaProyecto03 - cantFinanciadaProyecto03)) {
                                                                        System.out.println("Cantidad Invertida mayor a la necesaria.");
                                                                    } else if (cantidadInvertir <= 0) {
                                                                        System.out.println("Introduce una cantidad mayor a 0.");
                                                                    } else {
                                                                        System.out.println("Has invertido " + cantidadInvertir + " euros.");
                                                                        carteraInversor2 = carteraInversor2 - cantidadInvertir;
                                                                        cantFinanciadaProyecto03 += cantidadInvertir;
                                                                        cantidadInvertidaInversor2Proy03 += cantidadInvertir;
                                                                    }
                                                                } else {
                                                                    System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                }
                                                            }
                                                            break;
                                                        case 4:
                                                            System.out.println("Saliendo...");
                                                            break;
                                                        default:
                                                            System.out.println(amarillo + "Opción inválida, inténtelo de nuevo." + colorNormal);
                                                            break;
                                                    }
                                                } while (opcion != 4);
                                            }
                                        case 2:
                                            if(nombreProyecto01.isEmpty() && nombreProyecto02.isEmpty() && nombreProyecto03.isEmpty()){
                                                System.out.println(amarillo + "Ningún proyecto ha sido creado aún." + colorNormal);
                                            }else{
                                                do {
                                                    menuVerProyectos();
                                                    opcion = leerInt();
                                                    switch(opcion){
                                                        case 1:
                                                            if (nombreProyecto01.isEmpty()){
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else{
                                                                mostrarResumenProyecto(proyectos, opcion);
                                                                String InvertirODetallada = leerString();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")){
                                                                    mostrarProyecto(proyectos, opcion, recompensas);
                                                                } else {
                                                                    System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            if (nombreProyecto02.isEmpty()) {
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else {
                                                                mostrarResumenProyecto(proyectos, opcion);
                                                                String InvertirODetallada = leerString();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                    mostrarProyecto(proyectos, opcion, recompensas);
                                                                } else {
                                                                    System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                }
                                                            }
                                                            break;
                                                        case 3:
                                                            if (nombreProyecto03.isEmpty()) {
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else {
                                                                mostrarResumenProyecto(proyectos, opcion);
                                                                String InvertirODetallada = leerString();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                    mostrarProyecto(proyectos, opcion, recompensas);
                                                                } else {
                                                                    System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                }
                                                            }
                                                            break;
                                                        case 4:
                                                            System.out.println("Saliendo...");
                                                            break;
                                                        default:
                                                            System.out.println(amarillo + "Opción inválida, inténtelo de nuevo." + colorNormal);
                                                            break;
                                                    }
                                                }while (opcion != 4);
                                            }
                                            break;
                                        case 3:
                                            do {
                                                menuCarteraDigital();
                                                opcion = leerInt();
                                                switch (opcion) {
                                                    case 1:
                                                        System.out.println(carteraInversor2);
                                                        break;
                                                    case 2:
                                                        do {
                                                            System.out.println("¿Cuánto dinero quieres añadir?");
                                                            dineroAnadido = leerInt();
                                                            if (dineroAnadido < 0)
                                                                System.out.println("La cantidad añadida debe ser mayor a 0");
                                                            else carteraInversor2 += dineroAnadido;
                                                        } while (dineroAnadido <= 0);
                                                        break;
                                                    case 3:
                                                        System.out.println("Saliendo");
                                                        break;
                                                }
                                            } while (opcion != 3);
                                            break;
                                        case 4:
                                            do {
                                                menuInvitarAmigos();
                                                opcion = leerInt();
                                                switch (opcion) {
                                                    case 1:
                                                        if (amigosReferidos.isEmpty()) {
                                                            System.out.println(amarillo + "Aún no has invitado a ningún amigo." + colorNormal);
                                                        } else {
                                                            System.out.println("Amigos referidos: " + amigosReferidos);
                                                        }
                                                        break;
                                                    case 2:
                                                        System.out.print("Introduce el correo electrónico del amigo: ");
                                                        String nuevoAmigo = leerString();
                                                        if (!nuevoAmigo.contains("@") || !nuevoAmigo.contains(".")) {
                                                            System.out.println(amarillo + "El correo introducido no es válido." + colorNormal);
                                                        } else {
                                                            if (amigosReferidos.isEmpty()) {
                                                                amigosReferidos = nuevoAmigo;
                                                            } else {
                                                                amigosReferidos += ", " + nuevoAmigo;
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
                                                switch (opcion) {
                                                    case 1:
                                                        inversorDatos[1][0]=cambiarUsuarioContrasena(inversorDatos[1][1]);
                                                        break;
                                                    case 2:
                                                        inversorDatos[1][1]=cambiarUsuarioContrasena(inversorDatos[1][1]);
                                                        break;
                                                    case 3:
                                                        break;
                                                }
                                            } while (opcion != 3);
                                            break;
                                        case 6:
                                            System.out.println("Saliendo");
                                            break;
                                    }
                                } while (opcion != 6);
                            }
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
                                    System.out.println("Introduzca contraseña:");
                                    passUsuarioRegistro = s.nextLine();
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
                                    // falta comprobacion contraseña 😭😭😭😭😭😭😭😭😭😭😭
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
                }while(opcion!=3);
            }
        }