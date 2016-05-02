/*
 * repaso banco castor
 */
package repasocastor;

import java.util.ArrayList;
import utilidades.EntradaDatos;

/**
 *
 * @author Miquel Port666
 */
public class RepasoCastor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Cuenta> misCuentas = new ArrayList<>();

        int opcion;

        do {
            menu();
            opcion = EntradaDatos.pedirEntero("Escoge una opción");
            switch (opcion) {
                case 1:
                    Cuenta c = altaCuenta(misCuentas);
                    misCuentas.add(c);
                    break;
                case 2:

                    ingreso(misCuentas);
                    break;
                case 3:

                    retirada(misCuentas);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:

                    break;
                case 7:
                    listarCuentas(misCuentas);
                    break;
                case 8:
                    System.out.println("Vuelve pronto con más dinero!!");
                    break;
                default:
                    System.out.println("Opcion incorrecta debe ser del 1 al 7");
            }

        } while (opcion != 8);

    }

    public static void retirada(ArrayList<Cuenta> misCuentas) {
        int id;
        double retirada = 0;

        id = EntradaDatos.pedirEntero("En que cuenta quieres retirar dinero");
        for (Cuenta actual : misCuentas) {
            if (actual.getId() == id) {

                retirada = EntradaDatos.pedirDouble("Cuanto quieres retirar");

                if (actual.getSaldo() - retirada < 0) {
                    System.out.println("No tienes suficiente dinero para retirar dispones de: " + actual.getSaldo());
                } else {
                    
                    actual.setSaldo(actual.getSaldo() - retirada);
                    System.out.println("Aqui tiene sus " + retirada + " €");
                    System.out.println("Le quedan " + actual.getSaldo() + "  €");
                }

            } else {
                System.out.println("No hay cuentas con ese codigo");
            }
        }

    }

    public static void ingreso(ArrayList<Cuenta> misCuentas) {
        int id;
        double ingreso = 0;
        boolean idencontrado = false;

        do {
            id = EntradaDatos.pedirEntero("En que cuenta quieres hacer el ingreso");
            for (Cuenta actual : misCuentas) {
                if (actual.getId() == id) {
                    idencontrado = true;
                    ingreso = EntradaDatos.pedirDouble("Cuanto quieres ingresar");
                    actual.setSaldo(actual.getSaldo() + ingreso);
                    System.out.println("Ingreso añadido");
                } else {
                    System.out.println("No existe ese codigo");
                }
            }
        } while (!idencontrado);

    }

    public static Cuenta altaCuenta(ArrayList<Cuenta> misCuentas) {

        int id;

        boolean idexiste = false;

        do {
            idexiste = false;
            id = EntradaDatos.pedirEntero("Introduce el codigo de la cuenta");
            for (Cuenta actual : misCuentas) {
                if (actual.getId() == id) {
                    System.out.println("Ese codigo está en uso");
                    idexiste = true;
                }
            }

        } while (idexiste);

        String titular = EntradaDatos.pedirCadena("Introduce el titular de la cuenta");

        double saldo;
        do {

            saldo = EntradaDatos.pedirDouble("Introduce el saldo de la cuenta");
            if (saldo < 0) {
                System.out.println("El saldo no puede ser negativo");
            }

        } while (saldo < 0);

        double comision = 0;

        String respuesta;
        boolean tipo = true;

        do {

            respuesta = EntradaDatos.pedirCadena("Cuenta personal o de empresa (P/E)?");
            if (respuesta.equalsIgnoreCase("P")) {
                tipo = true;
            } else if (respuesta.equalsIgnoreCase("E")) {
                tipo = false;
            } else {
                System.out.println("Debes poner P o E");
            }

        } while (!respuesta.equalsIgnoreCase("P") && !respuesta.equalsIgnoreCase("E"));

        System.out.println("Libro añadido correctamente");

        Cuenta c = new Cuenta(id, titular, saldo, comision, tipo);
        return c;
    }

    public static void listarCuentas(ArrayList<Cuenta> misCuentas) {

        if (misCuentas.isEmpty()) {
            System.out.println("No hay cuentas para mostrar");
        } else {

            for (Cuenta actual : misCuentas) {
                System.out.println(actual);
            }
        }

    }

    public static void menu() {

        System.out.println("1. Alta de cuenta");
        System.out.println("2. Ingresar dinero");
        System.out.println("3. Retirar dinero");
        System.out.println("4. Emitir transferencia");
        System.out.println("5. Datos de las cuentas de un titular determinado");
        System.out.println("6. Saldo total del banco");
        System.out.println("7. Listar cuentas");
        System.out.println("8. Salir");

    }

}
