package org.alvarowau.shopping;

import org.alvarowau.model.products.AbstractProduct;
import org.alvarowau.model.products.Book;
import org.alvarowau.util.BigDecimalUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShoppingCartSystem {

    private final List<AbstractProduct> productList;

    public ShoppingCartSystem() {
        productList = new ArrayList<>();
    }

    // Método para agregar un producto al carrito
    public boolean addProduct(AbstractProduct product) {
        return productList.add(product);
    }

    // Método para aplicar un descuento a un producto
    public void applyDiscount(String name, Double discount) {
        if (discount != null && discount > 0) {
            Optional<AbstractProduct> optionalProduct = findProductByName(name);
            if (optionalProduct.isPresent()) {
                AbstractProduct product = optionalProduct.get();
                BigDecimal updatedPrice = BigDecimalUtils.applyDiscount(discount, product);
                int indexOf = productList.indexOf(product);
                if (indexOf >= 0) {
                    productList.get(indexOf).setPrice(updatedPrice);
                    System.out.println("Se aplicó el descuento al producto. El precio final es: " + updatedPrice);
                } else {
                    System.out.println("Error: Producto no encontrado en la lista.");
                }
            } else {
                System.out.println("No se encontró ningún producto con ese nombre.");
            }
        } else {
            System.out.println("El descuento debe ser un valor positivo.");
        }
    }

    // Método privado para encontrar un producto por nombre
    private Optional<AbstractProduct> findProductByName(String name) {
        return productList.stream()
                .filter(product -> product.getName().equals(name))
                .findFirst();
    }

    // Método para eliminar un producto del carrito
    public void removeProduct(String name) {
        Optional<AbstractProduct> optionalProduct = findProductByName(name);
        if (optionalProduct.isPresent()) {
            AbstractProduct product = optionalProduct.get();
            productList.remove(product);
            System.out.println("Se eliminó el producto " + product);
        } else {
            System.out.println("No hemos encontrado el producto " + name);
        }
    }

    // Método para iniciar la descarga de un libro
    public void initiateDownload(String bookName) {
        Optional<AbstractProduct> optionalProduct = findProductByName(bookName);
        if (optionalProduct.isPresent() && optionalProduct.get() instanceof Book) {
            Book book = (Book) optionalProduct.get();
            book.download();
        } else {
            System.out.println("El producto no es un libro descargable o no se encontró.");
        }
    }

    // Método para mostrar todos los productos en el carrito
    public void showCart() {
        if (productList.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            for (AbstractProduct product : productList) {
                System.out.println(product);
            }
        }
    }
}
