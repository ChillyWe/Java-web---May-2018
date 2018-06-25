package org.softuni.fdmc.data.repos;

import org.softuni.fdmc.data.models.Cat;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CatRepository {
    private Set<Cat> cats;

    public CatRepository() {
        this.cats = new HashSet<>();
    }

    public Cat getByName(String catName) {
        return this.cats
                .stream()
                .filter(x -> x.getName().equals(catName))
                .findFirst()
                .orElse(null);
    }

    public Set<Cat> getAllCats() {
        return Collections.unmodifiableSet(this.cats);
    }

    public void addCat(Cat cat) {
        this.cats.add(cat);
    }

    public List<Cat> getAllCatsSorted() {
        List<Cat> collect = this.cats.stream()
                .sorted((a, b) -> b.getViewsCount().compareTo(a.getViewsCount()))
                .collect(Collectors.toList());
        return Collections.unmodifiableList(collect);
    }
}