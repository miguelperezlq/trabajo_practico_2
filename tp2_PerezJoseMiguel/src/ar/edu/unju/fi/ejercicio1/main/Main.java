package ar.edu.unju.fi.ejercicio1.main;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFabricacion;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Producto> productos = new ArrayList<>();
		
		//precarga
		Producto prod01 = new Producto("001", "Descripcion producto 001", 123, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR);
		Producto prod02 = new Producto("002", "Descripcion producto 002", 234, OrigenFabricacion.CHINA, Categoria.INFORMATICA);
		Producto prod03 = new Producto("003", "Descripcion producto 003", 345, OrigenFabricacion.URUGUAY, Categoria.TELEFONIA);
		productos.add(prod01);
		productos.add(prod02);
		productos.add(prod03);
		
		Scanner scanner = new Scanner(System.in);
		int opcion;
		
		do {
			System.out.println(">>>>> Menú de opciones: <<<<<");
            System.out.println("1 - Crear Producto");
            System.out.println("2 - Mostrar productos");
            System.out.println("3 - Modificar producto");
            System.out.println("4 - Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            
            switch (opcion) {
            case 1:
                //crear un producto
            	System.out.println("Ingrese los detalles del producto: ");
            	try {
            		
            		System.out.print("Código: ");
                    String codigo = scanner.next();
                    System.out.print("Descripción: ");
                    String descripcion = scanner.next();
                    System.out.print("Precio Unitario: ");
                    double precioUnitario = scanner.nextDouble();
                    
                    System.out.println("----- origen de Fabricacion -----");
                    System.out.println("1 - Argentina  \n2 - China  \n3 - Brasil  \n4 - Uruguay");
                    int origenOpcion = scanner.nextInt();
                    OrigenFabricacion origenFabricacion;
                    switch (origenOpcion) {
                    case 1:
                        origenFabricacion = OrigenFabricacion.ARGENTINA;
                        break;
                    case 2:
                        origenFabricacion = OrigenFabricacion.CHINA;
                        break;
                    case 3:
                        origenFabricacion = OrigenFabricacion.BRASIL;
                        break;
                    case 4:
                        origenFabricacion = OrigenFabricacion.URUGUAY;
                        break;
                    default:
                        System.out.println("Opción de origen inválida. Se asignará Argentina por defecto.");
                        origenFabricacion = OrigenFabricacion.ARGENTINA;
                }
                    
                    System.out.println("----- Categoria -----");
                    System.out.println("1 - Telefonía  \n2 - Informática  \n3 - Electrohogar  \n4 - Herramientas");
                    int categoriaOpcion = scanner.nextInt();
                    Categoria categoria;
                    switch (categoriaOpcion) {
                    case 1:
                        categoria = Categoria.TELEFONIA;
                        break;
                    case 2:
                        categoria = Categoria.INFORMATICA;
                        break;
                    case 3:
                        categoria = Categoria.ELECTROHOGAR;
                        break;
                    case 4:
                        categoria = Categoria.HERRAMIENTAS;
                        break;
                    default:
                        System.out.println("Opción de categoría inválida. Se asignará Telefonía por defecto.");
                        categoria = Categoria.TELEFONIA;
                }
                    
                    Producto nuevoProducto = new Producto(codigo, descripcion, precioUnitario, origenFabricacion, categoria);
                    productos.add(nuevoProducto);
                    System.out.println("Producto creado de forma correcta");

            	}catch (InputMismatchException e) {
            		System.out.println("error al ingresar los datos");
            		scanner.nextLine();
            	}
                break;
            case 2:
                // mostrar productos
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
                break;
            case 3:
                // modificar producto
                if (productos.isEmpty()) {
                    System.out.println("No hay productos disponibles para modificar.");
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

                    System.out.print("Ingrese el código del producto a modificar: ");
                    String codigoModificar = scanner.next();

                    Producto productoModificar = null;
                    for (Producto producto : productos) {
                        if (producto.getCodigo().equals(codigoModificar)) {
                            productoModificar = producto;
                            break;
                        }
                    }
                    
                    if (productoModificar != null) {
                        System.out.println("Seleccione qué desea modificar:");
                        System.out.println("1 - Descripción");
                        System.out.println("2 - Precio Unitario");
                        System.out.println("3 - Origen de Fabricación");
                        System.out.println("4 - Categoría");
                        System.out.print("Ingrese su opción: ");
                        int opcionModificar = scanner.nextInt();

                        switch (opcionModificar) {
                            case 1:
                                System.out.print("Nueva Descripción: ");
                                String nuevaDescripcion = scanner.next();
                                productoModificar.setDescripcion(nuevaDescripcion);
                                break;
                            case 2:
                                System.out.print("Nuevo Precio Unitario: ");
                                double nuevoPrecio = scanner.nextDouble();
                                productoModificar.setPrecioUnitario(nuevoPrecio);
                                break;
                            case 3:
                                System.out.println("----- Seleccione Nuevo origen de Fabricacion -----");
                                System.out.println("1 - Argentina  \n2 - China  \n3 - Brasil  \n4 - Uruguay");
                                int opcionModificarFabricacion = scanner.nextInt();
                                switch (opcionModificarFabricacion) {
                                case 1:
                                    productoModificar.setOrigenFabricacion(OrigenFabricacion.ARGENTINA);
                                    break;
                                case 2:
                                    productoModificar.setOrigenFabricacion(OrigenFabricacion.CHINA);
                                    break;
                                case 3:
                                    productoModificar.setOrigenFabricacion(OrigenFabricacion.BRASIL);
                                    break;
                                case 4:
                                    productoModificar.setOrigenFabricacion(OrigenFabricacion.URUGUAY);
                                    break;
                                default:
                                    System.out.println("Opción inválida.");
                            }
                                break;
                            case 4:
                                System.out.println("----- Seleccione Nueva Categoria -----");
                                System.out.println("1 - Telefonía  \n2 - Informática  \n3 - Electrohogar  \n4 - Herramientas");
                                int opcionModificarCategoria = scanner.nextInt();
                                switch (opcionModificarCategoria) {
                                case 1:
                                    productoModificar.setCategoria(Categoria.TELEFONIA);
                                    break;
                                case 2:
                                    productoModificar.setCategoria(Categoria.INFORMATICA);
                                    break;
                                case 3:
                                    productoModificar.setCategoria(Categoria.ELECTROHOGAR);
                                    break;
                                case 4:
                                    productoModificar.setCategoria(Categoria.HERRAMIENTAS);
                                    break;
                                default:
                                    System.out.println("Opción inválida.");
                            }

                            default:
                                System.out.println("Opción inválida.");
                        }
                        System.out.println("Producto modificado exitosamente.");
                    } else {
                        System.out.println("No se encontró un producto con ese código.");
                    }
                }  
                break;
            case 4:
                System.out.println("Saliendo del programa.");
                break;
            default:
                System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
        }
			
		}while (opcion != 4);
		
		scanner.close();

	}

}
