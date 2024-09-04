package org.alvarowau.model.products;

import org.alvarowau.model.interfaces.Purchasable;

import java.math.BigDecimal;

public abstract class AbstractProduct implements Purchasable {

    private String name;
    private BigDecimal price;

    public AbstractProduct(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Product { name='%s', price=%s }", name, price.setScale(2, BigDecimal.ROUND_HALF_UP));
    }
    @Override
    public void purchase() {
        System.out.println("Comprando: " + getName());
    }

}
