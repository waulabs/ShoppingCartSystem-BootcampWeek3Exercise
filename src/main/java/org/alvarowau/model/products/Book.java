package org.alvarowau.model.products;

import org.alvarowau.model.interfaces.Downloadable;

import java.math.BigDecimal;

public class Book extends AbstractProduct implements Downloadable {
    public Book(String name, BigDecimal price) {
        super(name, price);
    }

    @Override
    public void download() {
        System.out.println("Descargando el libro: " + getName());
    }

    @Override
    public String toString() {
        return String.format("Book { name='%s', price=%s }", getName(), getPrice().setScale(2, BigDecimal.ROUND_HALF_UP));
    }


}
