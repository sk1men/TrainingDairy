package com.dairy.training.api;


import java.util.List;
import java.util.Objects;

public class IteratedExercise extends Exercise {

    float MW;
    List<Set> set;

    public IteratedExercise(String name, int weight, int set, int rep) {
        super.name = name;
        this.set.add(new Set(weight, set, rep));
    }

    public IteratedExercise(String name, float percent, int set, int rep) {
        super.name = name;
        this.set.add(new Set(percent, set, rep));
    }


    @Override
    public String toString() {
        return "IteratedExercise{" +
                " set=" + set +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IteratedExercise that = (IteratedExercise) o;
        return Objects.equals(set, that.set);
    }

    @Override
    public int hashCode() {
        return Objects.hash(set);
    }
}
