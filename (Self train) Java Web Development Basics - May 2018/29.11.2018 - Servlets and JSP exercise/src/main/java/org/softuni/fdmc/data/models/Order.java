package org.softuni.fdmc.data.models;

import java.time.LocalDateTime;

public class Order {

    private User client;

    private Cat Cat;

    private LocalDateTime madeOn;

    public Order() {
        LocalDateTime now = LocalDateTime.now();
        String debug = "";
        this.setMadeOn(now);
    }

    public void Order(User client, Cat cat) {
        this.setClient(client);
        this.setCat(cat);
        this.setMadeOn(LocalDateTime.now());
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public org.softuni.fdmc.data.models.Cat getCat() {
        return Cat;
    }

    public void setCat(org.softuni.fdmc.data.models.Cat cat) {
        Cat = cat;
    }

    public LocalDateTime getMadeOn() {
        return madeOn;
    }

    public void setMadeOn(LocalDateTime madeOn) {
        this.madeOn = madeOn;
    }
}
