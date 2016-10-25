package com.dairy.training.api;


import java.util.Objects;

public class IteratedExercise extends Exercise {

    public int weight;

    public int sets;
    public int reps;

    public IteratedExercise(String name, int weight, int sets, int reps) {
        super.name = name;
        this.weight = weight;
        this.sets = sets;
        this.reps = reps;
    }

    @Override
    public String toString() {
        return super.name + " " + weight +
                "кг " + sets +
                "x" + reps + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IteratedExercise that = (IteratedExercise) o;
        return weight == that.weight &&
                sets == that.sets &&
                reps == that.reps;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, sets, reps);
    }
}
