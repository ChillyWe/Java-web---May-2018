package org.softuni.models;

public class Product {

    private String name;

    private String description;

    private Enum<Type> type;

    public Product(String name, String description, Enum<Type> type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Enum<Type> getType() {
        return this.type;
    }

    public void setType(Enum<Type> type) {
        this.type = type;
    }
}