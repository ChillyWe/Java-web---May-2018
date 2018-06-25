package org.softuni.examPrep.repos;

import org.softuni.examPrep.models.Tube;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TubeRepository {
    private Set<Tube> tubes;

    public TubeRepository() {
        this.tubes = new HashSet<>();
    }

    public Tube getByTitle(final String title) {
        return this.tubes
                .stream()
                .filter(x -> x.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }

    public Set<Tube> getAllTubes() {
        return Collections.unmodifiableSet(this.tubes);
    }

    public void addTube(Tube tube) {
        this.tubes.add(tube);
    }
}
