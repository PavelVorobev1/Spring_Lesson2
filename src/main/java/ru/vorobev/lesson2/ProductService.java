package ru.vorobev.lesson2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public String getTitleById(int id) {
        return repository.findById(id).getTitle();
    }

    public void showAllProducts() {
        System.out.println(repository.getAllProducts().toString() + "\n");
    }



}
