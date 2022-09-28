package ru.vorobev.lesson2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {
    @Autowired
    private ProductRepository repository;

    private List<Product> productsTheCart;

    @PostConstruct
    private void init(){
        productsTheCart = new ArrayList<>();
    }


    public void addInTheCart(int id){
        productsTheCart.add(repository.findById(id));
    }

    public void deleteProduct(int id){
        productsTheCart.remove(repository.findById(id));
    }

    public String printAllProductsCart(){
        StringBuilder str = new StringBuilder();
        for (Product product : productsTheCart) {
            str.append(product.toString() + "\n");
        }
        return str.toString();
    }
}
