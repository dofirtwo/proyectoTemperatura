package proyectotemperatura;

import java.util.Scanner;

public class ProyectoTemperatura {

    private static final Scanner teclado = new Scanner(System.in);
    private static double[][] temperatura = new double[7][2];
    private static final String[] dias = {"LUNES", "MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO", "DOMINGO"};

    private static void ingresarTemperaturas() {
        System.out.println("INGRESAR TEMPERATURAS");
        for (int i = 0; i < 7; i++) {
            System.out.println("TEMPERATURAS DEL DIA " + dias[i]);
            System.out.println("Ingrese temperatura minima: ");
            temperatura[i][0] = Double.parseDouble(teclado.nextLine());
            boolean maximoPermitido = false;
            do {
                System.out.println("Ingrese temperatura maxima: ");
                double tempMaxima = Double.parseDouble(teclado.nextLine());
                if (temperatura[i][0] <= tempMaxima) {
                    temperatura[i][1] = tempMaxima;
                    maximoPermitido = true;
                } else {
                    System.out.println("La temperatura maxima no puede ser menor a la minima. Enter para volver a ingresar");
                    teclado.nextLine();
                }
            } while (!maximoPermitido);

            System.out.println("**************************************************************************");
            System.out.println("");
        }
    }

    private static void obtenerDiaTemperaturaMaxima() {
        int diaMaximaTemperatura = 0;
        double maximaTemperatura = temperatura[diaMaximaTemperatura][1];
        for (int i = 0; i < 7; i++) {
            if (temperatura[i][1] > maximaTemperatura) {
                maximaTemperatura = temperatura[i][1];
                diaMaximaTemperatura=i;
            }
        }
        System.out.println("Dia con maxima temperatura: " + dias[diaMaximaTemperatura]);
        System.out.println("Valor: " + temperatura[diaMaximaTemperatura][1]);
    }

    private static void temperaturasDiaDeterminado() {
        System.out.println("Ingrese dia que desea conocer las temperaturas: ");
        String dia = teclado.nextLine().toUpperCase();
        boolean existeDia = false;
        for (int i = 0; i < 7; i++) {
            if (dias[i].equals(dia)) {
                System.out.println("Temperatura Minima: " + temperatura[i][0]);
                System.out.println("Temperatura Maxima: " + temperatura[i][1]);
                existeDia = true;
            }
        }
        if (!existeDia) {
            System.out.println("Dia ingresado NO existe........");
        }
    }

    private static void listarTemperaturas() {
        System.out.println("Las temperaturas de la semana fueron");
        for (int i = 0; i < 7; i++) {
            System.out.println("La tempenratura del " + dias[i] + " fue: ");
            System.out.print("Minima:  ");
            System.out.println("Maxima:");
            System.out.print(temperatura[i][0] + "        ");
            System.out.println(temperatura[i][1]);
        }
    }

    private static void menu() {
        int opcion = 0;
        do {
            System.out.println("\t\tMENU EJERCICIO TEMPERATURAS");
            System.out.println("\t1. Ingresar Temperaturas");
            System.out.println("\t2. Dia con la temperatura Maxima");
            System.out.println("\t3. Temperatruas de un dia Determinado");
            System.out.println("\t4. Listar temperaturas para todos los dias");
            System.out.println("\t5. Salir");
            System.out.println("\tIngrese Opcion: ");
            opcion = Integer.parseInt(teclado.nextLine());
            switch (opcion) {
                case 1: {
                    ingresarTemperaturas();
                }
                break;
                case 2: {
                    obtenerDiaTemperaturaMaxima();
                }
                break;
                case 3: {
                    temperaturasDiaDeterminado();
                }
                break;
                case 4: {
                    listarTemperaturas();
                }
                break;
                case 5: {
                    System.out.println("Saliendo....");
                }
                break;
                default: {
                    System.out.println("Opcion errada");
                }
                break;
            }
            System.out.println("Precione enter para continuar");
            teclado.nextLine();
        } while (opcion != 5);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menu();
    }

}
