package org.softuni.fdmc.data.models;

import java.time.LocalDateTime;

public class Order {

    private User client;
    private Cat cat;
    private LocalDateTime madeOn;

    public Order(User client, Cat cat, LocalDateTime madeOn) {
        this.setClient(client);
        this.setCat(cat);
        this.setMadeOn(madeOn);
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public LocalDateTime getMadeOn() {
        return madeOn;
    }

    public void setMadeOn(LocalDateTime madeOn) {
        this.madeOn = madeOn;
    }
}