package ar.edu.unju.fi.ejercicio5.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio5.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio5.model.Producto.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio5.model.Producto;

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
		
		boolean salir = false;
	       while (!salir) {
	            System.out.println("Menú de opciones:");
	            System.out.println("1 - Mostrar productos");
	            System.out.println("2 - Realizar compra");
	            System.out.println("3 - Salir");
	            System.out.print("Ingrese una opción: ");

	            int opcion = scanner.nextInt();
	            switch (opcion) {
	                case 1:
	                    mostrarProductos(productos);
	                    break;
	                case 2:
	                    ArrayList<Producto> productosComprados = seleccionarProductos(scanner, productos);
	                    if (!productosComprados.isEmpty()) {
	                        realizarPago(scanner, productosComprados);
	                    }
	                    break;
	                case 3:
	                    salir = true;
	                    break;
	                default:
	                    System.out.println("Opción inválida. Intente nuevamente.");
	                    break;
	            }
	        }

	        scanner.close();
	}
    private static void mostrarProductos(ArrayList<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            System.out.println("Productos disponibles:");
            for (Producto producto : productos) {
                System.out.println("Código: " + producto.getCodigo());
                System.out.println("Descripción: " + producto.getDescripcion());
                System.out.println("Precio Unitario: " + producto.getPrecioUnitario());
                System.out.println("Origen de Fabricación: " + producto.getOrigenFabricacion());
                System.out.println("Categoría: " + producto.getCategoria());
                System.out.println("----------------------");
            }
        }
    }
    private static ArrayList<Producto> seleccionarProductos(Scanner scanner, ArrayList<Producto> productos) {
        ArrayList<Producto> productosComprados = new ArrayList<>();
        boolean seleccionar = true;

        while (seleccionar) {
            System.out.println("Seleccione un producto para comprar (ingrese el codigo): ");
            mostrarProductos(productos);
            int opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= productos.size()) {
                Producto productoSeleccionado = productos.get(opcion - 1);
                if (productoSeleccionado.isEstado()) {
                    productosComprados.add(productoSeleccionado);
                    productoSeleccionado.setEstado(seleccionar); // Marcar como no disponible
                } else {
                    System.out.println("Este producto no está disponible.");
                }
            } else {
                System.out.println("Opción inválida. Intente nuevamente.");
            }

            System.out.println("¿Desea seleccionar otro producto? (S/N): ");
            String continuar = scanner.next();
            if (!continuar.equalsIgnoreCase("S")) {
                seleccionar = false;
            }
        }
        return productosComprados;
    }
    
    private static void realizarPago(Scanner scanner, ArrayList<Producto> productosComprados) {
        double totalCompra = calcularTotalCompra(productosComprados);
        System.out.println("Total de la compra: $" + totalCompra);

        System.out.println("Seleccione el método de pago:");
        System.out.println("1 - Pago efectivo");
        System.out.println("2 - Pago con tarjeta");
        int opcionPago = scanner.nextInt();

        switch (opcionPago) {
            case 1:
                PagoEfectivo pagoEfectivo = new PagoEfectivo(totalCompra, LocalDate.now());
                pagoEfectivo.realizarPago(totalCompra);
                pagoEfectivo.imprimirRecibo();
                break;
            case 2:
                System.out.println("Ingrese el número de tarjeta:");
                String numeroTarjeta = scanner.next();
                PagoTarjeta pagoTarjeta = new PagoTarjeta(numeroTarjeta, LocalDate.now(), totalCompra);
                pagoTarjeta.realizarPago(totalCompra);
                pagoTarjeta.imprimirRecibo();
                break;
            default:
                System.out.println("Opción de pago inválida.");
                break;
        }
    }
    
    private static double calcularTotalCompra(ArrayList<Producto> productosComprados) {
        double total = 0;
        for (Producto producto : productosComprados) {
            total += producto.getPrecioUnitario();
        }
        return total;
    }
    
    
	

}
