package org.alvarowau.util;

import org.alvarowau.model.products.AbstractProduct;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface BigDecimalUtils {
    // Método para aplicar un descuento al precio de un producto
    static BigDecimal applyDiscount(Double discount, AbstractProduct product) {
        if (product == null || discount == null || discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Producto o descuento no válidos");
        }

        // Convertir discount a BigDecimal
        BigDecimal discountAmount = BigDecimal.valueOf(discount).divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP);

        // Obtener el precio actual del producto y convertirlo a BigDecimal
        BigDecimal currentPrice = product.getPrice();

        // Calcular el monto de descuento
        BigDecimal discountValue = currentPrice.multiply(discountAmount);

        // Calcular el nuevo precio después del descuento
        BigDecimal newPrice = currentPrice.subtract(discountValue);

        // Redondear el nuevo precio a dos decimales
        newPrice = newPrice.setScale(2, RoundingMode.HALF_UP);

        return newPrice;
    }
}
