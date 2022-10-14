package ru.vorobev.lesson2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.vorobev.lesson2");
        ProductService productService = context.getBean(ProductService.class);
        System.out.println("productService.getTitleById(2) = " + productService.getTitleById(2) + "\n");
        productService.showAllProducts();

        Cart cart1 = context.getBean(Cart.class);
        cart1.addInTheCart(2);
        cart1.addInTheCart(4);
        cart1.addInTheCart(6);

        Cart cart2 = context.getBean(Cart.class);
        cart2.addInTheCart(1);
        cart2.addInTheCart(3);
        cart2.addInTheCart(5);

        System.out.println("cart1 \n" + cart1.printAllProductsCart());
        System.out.println("cart2 \n" + cart2.printAllProductsCart());

        cart1.deleteProduct(2);
        cart2.deleteProduct(5);


        System.out.println("cart1 \n" + cart1.printAllProductsCart());
        System.out.println("cart2 \n" + cart2.printAllProductsCart());
    }
}
