package com.dairy.training.api;


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
}
