package org.softuni.fdmc.data.repos;

import org.softuni.fdmc.data.models.Cat;

import java.util.*;
import java.util.stream.Collectors;

public class CatRepository {
    private List<Cat> cats;

    public CatRepository() {
        this.cats = new ArrayList<>();
    }

    public Cat getByName(String catName) {
        return this.cats
                .stream()
                .filter(x -> x.getName().equals(catName))
                .findFirst()
                .orElse(null);
    }

    public List<Cat> getAllCats() {
        return Collections.unmodifiableList(this.cats.stream()
                .sorted((x, y) -> y.getViews().compareTo(x.getViews()))
                .collect(Collectors.toList()));
    }

    public void addCat(Cat cat) {
        this.cats.add(cat);
    }
}
