import java.util.Scanner;

public class Main {
    static int saldo = 10000;
    static int contador = 0;
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
                verMovimiento();
                break;
            case 5 , 6 , 7, 8:
                contador++;
                System.out.println("Opcion incorrecta");
                System.out.println(contador);
                break;
            case 9:
                salir();
                break;
            default:
                System.out.println("Opcion no disponible");
                break;
        }
        }
        while( contador < 3 );

    }
    public static void retirarDinero(){
        System.out.println("=====================================");
        System.out.println("        Retirar dinero");
        System.out.println("Dinero disponible: " + saldo);
        System.out.println("Cuanto dinero quieres retirar?");
    }
    public static void hacerDeposito(){
        System.out.println("=====================================");
        System.out.println("deposito");
    }
    public static void consultarSaldo(){
        System.out.println("=====================================");
        System.out.println("Tu saldo actual es de: " + saldo);
        System.out.println("Consultar saldo");
    }
    public static void verMovimiento(){
        System.out.println("=====================================");
        System.out.println("Ultimo movimiento");
    }
    public static void salir(){
        System.out.println("=====================================");
        System.out.println("       Gracias por tu prefencia.");
        System.out.println("                :D");
        System.out.println("=====================================");
        contador = 3;
    }
}

