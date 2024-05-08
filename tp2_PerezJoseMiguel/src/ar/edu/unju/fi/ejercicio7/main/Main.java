package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio5.model.Producto.OrigenFabricacion;

public class Main {

	public static void main(String[] args) {
		ArrayList<Producto> productos = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		//precarga
		Producto prod01 = new Producto("001", "Descripcion producto 001", 123, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR,true);
		Producto prod02 = new Producto("002", "Descripcion producto 002", 234, OrigenFabricacion.CHINA, Categoria.INFORMATICA,false);
		Producto prod03 = new Producto("003", "Descripcion producto 003", 345, OrigenFabricacion.URUGUAY, Categoria.TELEFONIA,false);
		Producto prod04 = new Producto("004", "Descripcion producto 004", 345, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS,false);
		Producto prod05 = new Producto("005", "Descripcion producto 005", 123, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR,true);
		Producto prod06 = new Producto("006", "Descripcion producto 006", 234, OrigenFabricacion.CHINA, Categoria.INFORMATICA,false);
		Producto prod07 = new Producto("007", "Descripcion producto 007", 345, OrigenFabricacion.URUGUAY, Categoria.TELEFONIA,false);
		Producto prod08 = new Producto("008", "Descripcion producto 008", 345, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS,false);
		Producto prod09 = new Producto("009", "Descripcion producto 009", 123, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR,true);
		Producto prod10 = new Producto("010", "Descripcion producto 010", 234, OrigenFabricacion.CHINA, Categoria.INFORMATICA,true);
		Producto prod11 = new Producto("011", "Descripcion producto 011", 345, OrigenFabricacion.URUGUAY, Categoria.TELEFONIA,false);
		Producto prod12 = new Producto("012", "Descripcion producto 012", 345, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS,false);
		Producto prod13 = new Producto("013", "Descripcion producto 013", 123, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR,true);
		Producto prod14 = new Producto("014", "Descripcion producto 014", 234, OrigenFabricacion.CHINA, Categoria.INFORMATICA,true);
		Producto prod15 = new Producto("015", "Descripcion producto 015", 345, OrigenFabricacion.URUGUAY, Categoria.TELEFONIA,true);
		productos.add(prod01);productos.add(prod02);productos.add(prod03);productos.add(prod04);productos.add(prod05);
		productos.add(prod06);productos.add(prod07);productos.add(prod08);productos.add(prod09);productos.add(prod10);
		productos.add(prod11);productos.add(prod12);productos.add(prod13);productos.add(prod14);productos.add(prod15);
		
		int opcion;

        do {
            System.out.println("Menu:");
            System.out.println("1 - Mostrar productos activos");
            System.out.println("2 - Mostrar productos faltantes");
            System.out.println("3 - Incrementar precios en un 20%");
            System.out.println("4 - Mostrar productos de Electrohogar disponibles");
            System.out.println("5 - Ordenar productos por precio descendente");
            System.out.println("6 - Mostrar nombres de productos en mayusculas");
            System.out.println("7 - Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // 

            switch (opcion) {
                case 1:
                    mostrarProductosActivos(productos);
                    break;
                case 2:
                   mostrarProductosFaltantes(productos);
                    break;
                case 3:
                    incrementarPrecios(productos);
                    break;
                case 4:
                    mostrarProductosElectrohogarDisponibles(productos);
                    break;
                case 5:
                    ordenarProductosPorPrecioDescendente(productos);
                    break;
                case 6:
                    mostrarNombresEnMayusculas(productos);
                    break;
                case 7:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opcion invalida.");
                    break;
            }
        } while (opcion != 7);
        scanner.close();

	}
    private static void mostrarProductosActivos(ArrayList<Producto> productos) {
        Consumer<Producto> consumer = producto -> {
            if (producto.isEstado()) {
                System.out.println(producto);
            }
        };
        productos.forEach(consumer);
    }
    private static void mostrarProductosFaltantes(ArrayList<Producto> productos) {
        Predicate<Producto> predicate = producto -> !producto.isEstado();
        ArrayList<Producto> productosFaltantes = (ArrayList<Producto>) productos.stream()
                .filter(predicate)
                .collect(Collectors.toList());
        productosFaltantes.forEach(System.out::println);
    }
    private static void incrementarPrecios(ArrayList<Producto> productos) {
        Function<Producto, Producto> incrementador = producto -> {
            producto.setPrecioUnitario(producto.getPrecioUnitario() * 1.2); // Incrementar precio en un 20%
            return producto;
        };
        ArrayList<Producto> productosIncrementados = (ArrayList<Producto>) productos.stream()
                .map(incrementador)
                .collect(Collectors.toList());
        productosIncrementados.forEach(System.out::println);
    }
    private static void mostrarProductosElectrohogarDisponibles(ArrayList<Producto> productos) {
        Predicate<Producto> electrohogarDisponible = producto ->
                producto.getCategoria().equals(Categoria.ELECTROHOGAR) && producto.isEstado();
        productos.stream()
                .filter(electrohogarDisponible)
                .forEach(System.out::println);
    }
    private static void ordenarProductosPorPrecioDescendente(ArrayList<Producto> productos) {
        productos.sort((p1, p2) -> Double.compare(p2.getPrecioUnitario(), p1.getPrecioUnitario())); // Ordenar por precio descendente
        productos.forEach(System.out::println);
    }
    private static void mostrarNombresEnMayusculas(ArrayList<Producto> productos) {
        Function<Producto, String> nombreMayusculas = producto -> producto.getDescripcion().toUpperCase();
        ArrayList<String> nombresMayusculas = (ArrayList<String>) productos.stream()
                .map(nombreMayusculas)
                .collect(Collectors.toList());
        nombresMayusculas.forEach(System.out::println);
    }



}
