package ru.vorobev.lesson2;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1, "Apple", 15),
                new Product(2, "Orange", 19),
                new Product(3, "Avocado", 30),
                new Product(4, "Milk", 10),
                new Product(5, "Bread", 5),
                new Product(6, "Coffee", 50)
        ));
    }

    public Product findById(int id) {
        return products.stream().filter(p -> p.getId()==id).findFirst().orElseThrow();
    }

    public List getAllProducts(){
        return products;
    }
}

