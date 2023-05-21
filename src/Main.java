import java.util.Scanner;

public class Main {
    static int saldo = 10000;
    static int contador = 0;
    static String tipoDeUltimoMovimiento = "";
    static int ultimoRetiro = 0;

    public static void main(String[] args) {
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("========Bienvenido al cajero========");
            System.out.println("    Que es lo que quieres hacer?");
            System.out.println("    Ingresa la opcion deseada.");
            System.out.println("=====================================");
            System.out.println("opcion 1: Retirar dinero.");
            System.out.println("opcion 2: Hacer depositos.");
            System.out.println("opcion 3: Consultar saldo.");
            System.out.println("opcion 4: Quejas.");
            System.out.println("opcion 5: Ver ultimo movimiento.");
            System.out.println("opcion 9: Salir del cajero.");
            System.out.println("=====================================");
            int opcion = scan.nextInt();
            System.out.println("Seleccionaste: " + opcion);
        switch (opcion){
            case 1:
                retirarDinero();
                break;
            case 2:
                hacerDeposito();
                break;
            case 3:
                consultarSaldo();
                break;
            case 4:
                //quejas();
                break;
            case 5:
                verMovimiento();
                break;
            case 6 , 7, 8:
                contador++;
                System.out.println("Opcion incorrecta");
                System.out.println("Vuelva a intentarlo");
                System.out.println(contador);
                break;
            case 9:
                salir();
                break;
            default:
                System.out.println("Opcion no disponible");
                break;
        }
            if (contador == 3) {
                System.out.println("Demasiados intentos fallidos saliendo del sistema.");
            }
        }
        while( contador < 3 );
    }
    public static void retirarDinero(){
        Scanner scan = new Scanner(System.in);
        System.out.println("=====================================");
        System.out.println("        Retirar dinero");
        System.out.println("Dinero disponible: " + saldo);
        System.out.println("Cuanto dinero quieres retirar?");
        System.out.println("''Solo disponible multiplos de $50.00''");
        System.out.println("=====================================");
        int opcion = scan.nextInt();
        if (opcion % 50 != 0){
            System.out.println("Cantidad no valida: Solo multiplos de $50,00");
            System.out.println("Saliedo al menu principal...");
        } else{
            saldo = saldo - opcion ;
            tipoDeUltimoMovimiento = "Retiero de efectivo";
            ultimoRetiro = saldo - opcion;
            System.out.println("deseas donar $200 para los gatetes? (y/n) ");
            char donar = scan.next().charAt(0);
            if (donar == 'y'){
                saldo = saldo - 200;
                System.out.println("Gracias por su donacion.");
                System.out.println("Su saldo es de: " + saldo);
            }else{
                System.out.println("Regresando al menu principal");
            }
        }
    }
    public static void hacerDeposito(){
        System.out.println("=====================================");
        System.out.println("deposito");
    }
    public static void consultarSaldo(){
        System.out.println("=====================================");
        System.out.println("Tu saldo actual es de: " + saldo);
        System.out.println("=====================================");
    }
    public static void verMovimiento(){
        System.out.println("=====================================");
        System.out.println("Ultimo movimiento");
        System.out.println("Tipo de moviminto: " + tipoDeUltimoMovimiento);
    }
    public static void salir(){
        System.out.println("=====================================");
        System.out.println("       Gracias por tu prefencia.");
        System.out.println("                :D");
        System.out.println("=====================================");
        contador = 3;
    }
    public static void quejas(){
        System.out.println("Opcion no disponible ");
    }
}

