package org.alvarowau;

import org.alvarowau.shopping.ShoppingCartSystem;
import org.alvarowau.view.ShoppingCartView;

public class Main {
    public static void main(String[] args) {
        ShoppingCartSystem system = new ShoppingCartSystem();
        ShoppingCartView view = new ShoppingCartView(system);

        view.showMenu();
    }
}
