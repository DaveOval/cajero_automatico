import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import static java.lang.System.exit;

public class Main {
    static float saldo = 10000;
    static float contador = 0;
    static String tipoDeUltimoMovimiento = "sin movimientos";
    static LocalDate fechaActual = LocalDate.now();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    static String fechaFormateada = fechaActual.format(formatter);
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
                hacerDepositos();
                break;
            case 3:
                consultarSaldo();
                break;
            case 4:
                quejas();
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
    //----------------------------- Funciones
    public static void retirarDinero(){
        Scanner scan = new Scanner(System.in);
        System.out.println("=====================================");
        System.out.println("        Retirar dinero");
        System.out.println("Dinero disponible: " + saldo);
        System.out.println("Cuanto dinero quieres retirar?");
        System.out.println("''Solo disponible multiplos de $50.00''");
        System.out.println("Cantidades menores a $6000.00");
        System.out.println("=====================================");
        int opcion = scan.nextInt();
        if (opcion % 50 != 0){
            System.out.println("Cantidad no valida: Solo multiplos de $50,00");
            System.out.println("Saliedo al menu principal...");
        } else if (opcion > 6000) {
            System.out.println("No se puede retirar mas de $6000");
            System.out.println("Saliedo al menu principal...");
        }else{
            saldo = saldo - opcion ;
            tipoDeUltimoMovimiento = "Retiero de efectivo de " + opcion ;
            System.out.println("deseas donar $200 para los gatetes? (y/n) ");
            char donar = scan.next().charAt(0);
            if (donar == 'y'){
                saldo = saldo - 200;
                System.out.println("Gracias por su donacion.");
                System.out.println("Su saldo es de: " + saldo);
            }else{
                System.out.println("Regresando al menu principal");
            }
            //scan.close();
        }
    }
    public static void hacerDepositos(){
        contador = 0;
        System.out.println("=====================================");
        System.out.println("        Hacer Depositos");
        System.out.println("    Ingresa la opcion deseada");
        System.out.println("=====================================");
        System.out.println("opcion 1: Cuenta de cheque");
        System.out.println("Opcion 2: Deposito a tarjeta de credito");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        switch (opcion){
            case 1:
                cuentaDeCheque();
                break;
            case 2:
                DepositoATarjetaDeCredito();
                break;
            default:
                System.out.println("Opcion no valida");
                System.out.println("Saliendo al menu principal...");
        }
    }

    public static void consultarSaldo(){
        contador = 0;
        System.out.println("=====================================");
        System.out.println("Tu saldo actual es de: " + saldo);
        System.out.println("=====================================");
    }
    public static void quejas(){
        contador = 0;
        System.out.println("No disponible por el momento");
    }
    public static void verMovimiento(){
        contador = 0;
        System.out.println("=====================================");
        System.out.println("Ultimo movimiento " + fechaFormateada);
        System.out.println("Tipo de moviminto: " + tipoDeUltimoMovimiento);
    }
    public static void salir(){
        contador = 0;
        System.out.println("=====================================");
        System.out.println("       Gracias por tu prefencia.");
        System.out.println("                :D");
        System.out.println("=====================================");
        exit(0);
    }
    public static void cuentaDeCheque(){
        System.out.println("Deposito a tarjeta de credito");
        System.out.println("Ingresa la cantidad para depositar");
        System.out.println("Solo multiplos de $50.00");
        Scanner scan = new Scanner(System.in);
        int opcion = scan.nextInt();
        if(opcion % 50 != 0){
            System.out.println("Cantidad no valida: Solo multiplos de $50,00");
            System.out.println("Saliedo al menu principal...");
        }else{
            saldo = saldo + opcion;
            System.out.println("Deposito de: " + opcion + " Realizada con exito" );
            System.out.println("Saldo: " + saldo);
            tipoDeUltimoMovimiento = "Deposito en cuenta de cheque de " + opcion;
        }
    }
    public static void DepositoATarjetaDeCredito(){
        System.out.println("Deposito a tarjeta de credito");
        System.out.println("Ingresa la cantidad a depositar a tu tarjeta de credito");
        Scanner scan = new Scanner(System.in);
        float opcion = scan.nextFloat();
        saldo = saldo - opcion;
        tipoDeUltimoMovimiento = ("Retiro a tarjeta de credito de " + opcion);
        System.out.println("Cantidad a retirar a la tarjeta de credito " + opcion);
        System.out.println("Saldo: " + saldo);
    }
}

