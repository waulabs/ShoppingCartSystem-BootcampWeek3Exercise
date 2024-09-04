package org.alvarowau.model.products;

import java.math.BigDecimal;

public class Electronics extends AbstractProduct{

    public Electronics(String name, BigDecimal price) {
        super(name, price);
    }


    @Override
    public String toString() {
        return String.format("Electronics { name='%s', price=%s }", getName(), getPrice().setScale(2, BigDecimal.ROUND_HALF_UP));
    }
}
