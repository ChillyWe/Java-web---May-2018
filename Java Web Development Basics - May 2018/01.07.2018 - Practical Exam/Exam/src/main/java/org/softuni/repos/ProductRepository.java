package org.softuni.repos;

import org.softuni.models.Product;
import org.softuni.models.Type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductRepository {
    private List<Product> products;

    public ProductRepository() {
        this.products = new ArrayList<>() {{
            add(new Product("Chushkopek", "A universal tool for …", Type.Domestic));
            add(new Product("Injektoplqktor", "Dunno what this is…", Type.Cosmetic));
            add(new Product("Plumbus", "A domestic tool for everything", Type.Food));
        }};
    }

    public Product getByName(String name) {
        return this.products
                .stream()
                .filter(x -> x.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(this.products);
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }
}