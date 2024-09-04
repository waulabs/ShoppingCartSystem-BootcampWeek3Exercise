# Shopping Cart System

## Descripción

Este proyecto implementa un sistema de carrito de compras en Java que permite agregar productos, aplicar descuentos, eliminar productos y realizar descargas de contenido. El sistema utiliza clases para representar productos, interfaces para definir comportamientos comunes, y un carrito de compras para manejar las operaciones.

## Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes:

- `org.alvarowau.model.interfaces`: Contiene las interfaces `Downloadable` y `Purchasable`.
- `org.alvarowau.model.products`: Contiene las clases `AbstractProduct`, `Book`, y `Electronics`.
- `org.alvarowau.util`: Contiene la utilidad `BigDecimalUtils` para aplicar descuentos.
- `org.alvarowau.shopping`: Contiene la clase `ShoppingCartSystem` que maneja la lógica del carrito de compras.
- `org.alvarowau.view`: Contiene la clase `ShoppingCartView` para la interfaz de usuario en consola.