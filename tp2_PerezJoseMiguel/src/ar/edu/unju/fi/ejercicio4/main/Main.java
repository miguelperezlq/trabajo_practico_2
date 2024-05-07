package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {

	public static void main(String[] args) {
		ArrayList<Jugador> jugadores = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		
		//precarga
		Jugador jugador1 = new Jugador("Miguel", "Perez", LocalDate.parse("1996-08-10"),"Argentino",171,65,Posicion.ARQUERO);
		Jugador jugador2 = new Jugador("Ariel", "Villanueva", LocalDate.parse("1977-08-10"),"Argentino",171,65,Posicion.DELANTERO);
		Jugador jugador3 = new Jugador("Horacio", "Carrizo", LocalDate.parse("1979-08-10"),"Argentino",171,65,Posicion.MEDIO);
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		jugadores.add(jugador3);
		
		
		int opcion;
		
        do {
            System.out.println("**** Menú de opciones ****");
            System.out.println("1 - Alta de jugador");
            System.out.println("2 - Mostrar todos los jugadores");
            System.out.println("3 - Modificar la posición de un jugador");
            System.out.println("4 - Eliminar un jugador");
            System.out.println("5 - Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    altaJugador(jugadores, scanner);
                    break;
                case 2:
                    mostrarJugadores(jugadores);
                    break;
                case 3:
                    modificarPosicion(jugadores, scanner);
                    break;
                case 4:
                    eliminarJugador(jugadores, scanner);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
                    break;
            }
        } while (opcion != 5);
	}
	
	
	private static void altaJugador(ArrayList<Jugador> jugadores, Scanner scanner) {
	    try {
	        System.out.println("Ingrese el nombre del jugador:");
	        String nombre = scanner.next();

	        System.out.println("Ingrese el apellido del jugador:");
	        String apellido = scanner.next();

	        System.out.println("Ingrese la fecha de nacimiento (YYYY-MM-DD) del jugador:");
	        String fechaStr = scanner.next();
	        LocalDate fechaNacimiento = LocalDate.parse(fechaStr);

	        System.out.println("Ingrese la nacionalidad del jugador:");
	        String nacionalidad = scanner.next();

	        System.out.println("Ingrese la estatura del jugador:");
	        double estatura = scanner.nextDouble();

	        System.out.println("Ingrese el peso del jugador:");
	        double peso = scanner.nextDouble();
	        
            System.out.println("----- seleccione posicion del jugador -----");
            System.out.println("1 - Delantero  \n2 - Medio  \n3 - Defensa  \n4 - Arquero");
            int posicionOpcion = scanner.nextInt();
            Posicion posicionJugador;
            switch (posicionOpcion) {
            case 1:
            	posicionJugador = Posicion.DELANTERO;
                break;
            case 2:
                posicionJugador = Posicion.MEDIO;
                break;
            case 3:
                posicionJugador = Posicion.DEFENSA;
                break;
            case 4:
                posicionJugador = Posicion.ARQUERO;
                break;
            default:
                System.out.println("Opción de origen inválida. Se asignará Delantero por defecto.");
                posicionJugador = Posicion.DELANTERO;
        }

	        Jugador nuevoJugador = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicionJugador);
	        jugadores.add(nuevoJugador);

	        System.out.println("Jugador agregado correctamente.");
	    } catch (DateTimeParseException | InputMismatchException e) {
	        System.out.println("Error al ingresar los datos del jugador.");
	    } finally {
	        scanner.nextLine(); //
	    }
	}
	
	private static void mostrarJugadores(ArrayList<Jugador> jugadores) {
	    if (jugadores.isEmpty()) {
	        System.out.println("No hay jugadores registrados.");
	    } else {
	        System.out.println(">>>>>> Lista de jugadores <<<<<<<");
	        for (Jugador jugador : jugadores) {
	            System.out.println("Nombre: " + jugador.getNombre());
	            System.out.println("Apellido: " + jugador.getApellido());
	            System.out.println("Fecha de nacimiento: " + jugador.getFechaNacimiento());
	            System.out.println("Nacionalidad: " + jugador.getNacionalidad());
	            System.out.println("Estatura: " + jugador.getEstatura());
	            System.out.println("Peso: " + jugador.getPeso());
	            System.out.println("Posición: " + jugador.getPosicion());
	            System.out.println("Edad: " + jugador.calcularEdad());
	            System.out.println("----------------------------");
	            System.out.println();
	        }
	    }
	}
	
	private static void modificarPosicion(ArrayList<Jugador> jugadores, Scanner scanner) {
	    if (jugadores.isEmpty()) {
	        System.out.println("No hay jugadores registrados para modificar la posición.");
	    } else {
	        System.out.println("Ingrese el nombre del jugador:");
	        String nombre = scanner.next();

	        System.out.println("Ingrese el apellido del jugador:");
	        String apellido = scanner.next();

	        boolean jugadorEncontrado = false;
	        for (Jugador jugador : jugadores) {
	            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
	                System.out.println("----- seleccione posicion del jugador -----");
	                System.out.println("1 - Delantero  \n2 - Medio  \n3 - Defensa  \n4 - Arquero");
                    int opcionModificarPosicion = scanner.nextInt();
                    switch (opcionModificarPosicion) {
                    case 1:
                    	jugador.setPosicion(Posicion.DELANTERO);
                        break;
                    case 2:
                    	jugador.setPosicion(Posicion.MEDIO);
                    	break;
                    case 3:
                        jugador.setPosicion(Posicion.DEFENSA);
                        break;
                    case 4:
                    	jugador.setPosicion(Posicion.ARQUERO);
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
	                jugadorEncontrado = true;
	                System.out.println("Posición del jugador modificada correctamente.");
	                break;
	            }
	        }

	        if (!jugadorEncontrado) {
	            System.out.println("Jugador no encontrado.");
	        }
	    }
	}
	
	
	private static void eliminarJugador(ArrayList<Jugador> jugadores, Scanner scanner) {
	    if (jugadores.isEmpty()) {
	        System.out.println("No hay jugadores registrados para eliminar.");
	    } else {
	        System.out.println("Ingrese el nombre del jugador a eliminar:");
	        String nombre = scanner.next();

	        System.out.println("Ingrese el apellido del jugador a eliminar:");
	        String apellido = scanner.next();

	        Iterator<Jugador> iterator = jugadores.iterator();
	        boolean jugadorEliminado = false;

	        while (iterator.hasNext()) {
	            Jugador jugador = iterator.next();
	            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
	                iterator.remove();
	                jugadorEliminado = true;
	                System.out.println("Jugador eliminado correctamente.");
	                break;
	            }
	        }

	        if (!jugadorEliminado) {
	            System.out.println("Jugador no encontrado.");
	        }
	    }
	}
	
	

}
