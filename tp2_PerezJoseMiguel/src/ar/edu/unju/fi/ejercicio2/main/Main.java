package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {

	public static void main(String[] args) {
		ArrayList<Efemeride> efemerides = new ArrayList<>();
		
		//precarga
		Efemeride efe01 = new Efemeride(1, Mes.ENERO, 2, "descripcion 01");
		Efemeride efe02 = new Efemeride(2, Mes.ABRIL, 12, "descripcion 02");
		Efemeride efe03 = new Efemeride(3, Mes.JUNIO, 15, "descripcion 03");
		efemerides.add(efe01);
		efemerides.add(efe02);
		efemerides.add(efe03);
		
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println(">>>> Elija una opción: <<<<<<");
            System.out.println("1 - Crear efeméride");
            System.out.println("2 - Mostrar efemérides");
            System.out.println("3 - Eliminar efeméride");
            System.out.println("4 - Modificar efeméride");
            System.out.println("5 - Salir");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearEfemeride(scanner, efemerides);
                    break;
                case 2:
                    mostrarEfemerides(efemerides);
                    break;
                case 3:
                    eliminarEfemeride(scanner, efemerides);
                    break;
                case 4:
                    modificarEfemeride(scanner, efemerides);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 5);
	}
	
    private static void crearEfemeride(Scanner scanner, ArrayList<Efemeride> efemerides) {
        System.out.println("Ingrese el código:");
        int codigo = scanner.nextInt();
        System.out.println("Ingrese el número correspondiente al mes:");
        int numMes = scanner.nextInt();

        if (numMes < 1 || numMes > 12) {
            System.out.println("Mes no válido");
            return;
        }

        Mes mes = Mes.values()[numMes - 1];

        System.out.println("Ingrese el día:");
        int dia = scanner.nextInt();
        scanner.nextLine(); // 
        System.out.println("Ingrese el detalle:");
        String detalle = scanner.nextLine();

        Efemeride efemeride = new Efemeride(codigo, mes, dia, detalle);
        efemerides.add(efemeride);
        System.out.println("Efeméride creada correctamente...");
    }
    private static void mostrarEfemerides(ArrayList<Efemeride> efemerides) {
        System.out.println("Efemérides:");
        for (Efemeride efemeride : efemerides) {
            System.out.println(efemeride.getCodigo() + " - " + efemeride.getMes() + " " + efemeride.getDia() + ": " + efemeride.getDetalle());
        }
    }
    private static void eliminarEfemeride(Scanner scanner, ArrayList<Efemeride> efemerides) {
        System.out.println("Ingrese el código de la efeméride a eliminar:");
        int codigo = scanner.nextInt();

        for (Efemeride efemeride : efemerides) {
            if (efemeride.getCodigo() == codigo) {
                efemerides.remove(efemeride);
                System.out.println("Efeméride eliminada correctamente.");
                return;
            }
        }

        System.out.println("Efeméride no encontrada.");
    }
    private static void modificarEfemeride(Scanner scanner, ArrayList<Efemeride> efemerides) {
        System.out.println("Ingrese el código de la efeméride a modificar:");
        int codigo = scanner.nextInt();

        for (Efemeride efemeride : efemerides) {
            if (efemeride.getCodigo() == codigo) {
                System.out.println("Ingrese el nuevo número correspondiente al mes:");
                int numMes = scanner.nextInt();

                if (numMes < 1 || numMes > 12) {
                    System.out.println("Mes no válido");
                    return;
                }

                Mes mes = Mes.values()[numMes - 1];

                System.out.println("Ingrese el nuevo día:");
                int dia = scanner.nextInt();
                scanner.nextLine(); // 
                System.out.println("Ingrese el nuevo detalle:");
                String detalle = scanner.nextLine();

                efemeride.setMes(mes);
                efemeride.setDia(dia);
                efemeride.setDetalle(detalle);
                System.out.println("Efeméride modificada correctamente.");
                return;
            }
        }

        System.out.println("Efeméride no encontrada.");
    }
	
}
