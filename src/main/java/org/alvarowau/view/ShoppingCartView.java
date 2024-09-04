package org.alvarowau.view;

import org.alvarowau.model.products.Book;
import org.alvarowau.model.products.Electronics;
import org.alvarowau.shopping.ShoppingCartSystem;

import java.math.BigDecimal;
import java.util.Scanner;

public class ShoppingCartView {

    private final ShoppingCartSystem system;
    private final Scanner scanner;

    public ShoppingCartView(ShoppingCartSystem system) {
        this.system = system;
        this.scanner = new Scanner(System.in);
    }

    // Método para mostrar el menú principal
    public void showMenu() {
        while (true) {
            System.out.println("1. Agregar producto");
            System.out.println("2. Aplicar descuento");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Iniciar descarga");
            System.out.println("5. Mostrar carrito");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    applyDiscount();
                    break;
                case 3:
                    removeProduct();
                    break;
                case 4:
                    initiateDownload();
                    break;
                case 5:
                    system.showCart();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
            }
        }
    }

    // Método para agregar un producto al carrito
    private void addProduct() {
        System.out.print("Ingrese el tipo de producto (book/electronics): ");
        String type = scanner.nextLine();
        System.out.print("Ingrese el nombre del producto: ");
        String name = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        BigDecimal price = scanner.nextBigDecimal();
        scanner.nextLine();  // Consumir el salto de línea

        switch (type.toLowerCase()) {
            case "book":
                system.addProduct(new Book(name, price));
                break;
            case "electronics":
                system.addProduct(new Electronics(name, price));
                break;
            default:
                System.out.println("Tipo de producto inválido.");
        }
    }

    // Método para aplicar un descuento a un producto
    private void applyDiscount() {
        System.out.print("Ingrese el nombre del producto: ");
        String name = scanner.nextLine();
        System.out.print("Ingrese el descuento (en porcentaje): ");
        double discount = scanner.nextDouble();
        scanner.nextLine();  // Consumir el salto de línea

        system.applyDiscount(name, discount);
    }

    // Método para eliminar un producto del carrito
    private void removeProduct() {
        System.out.print("Ingrese el nombre del producto: ");
        String name = scanner.nextLine();
        system.removeProduct(name);
    }

    // Método para iniciar la descarga de un libro
    private void initiateDownload() {
        System.out.print("Ingrese el nombre del libro: ");
        String bookName = scanner.nextLine();
        system.initiateDownload(bookName);
    }
}
