package org.softuni.data;

public class Cat {

    private String name;
    private String breed;
    private String color;
    private Integer numberOfLegs;

    public Cat(String name, String breed, String color, Integer numberOfLegs) {
        setName(name);
        setBreed(breed);
        setColor(color);
        setNumberOfLegs(numberOfLegs);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return this.breed;
    }

    private void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return this.color;
    }

    private void setColor(String color) {
        this.color = color;
    }

    public Integer getNumberOfLegs() {
        return this.numberOfLegs;
    }

    private void setNumberOfLegs(Integer numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }
}