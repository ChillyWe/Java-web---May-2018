package org.softuni.data;

public class Cat {
    private String name;
    private String breed;
    private String color;
    private int numberOfLegs;

    public Cat() {
    }

    public Cat(String name, String breed, String color, int numberOfLegs) {
        this.name = name;
        this.breed = breed;
        this.color = color;
        this.numberOfLegs = numberOfLegs;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return this.breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumberOfLegs() {
        return this.numberOfLegs;
    }

    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }
}