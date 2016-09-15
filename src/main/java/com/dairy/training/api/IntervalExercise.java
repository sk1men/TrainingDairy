package com.dairy.training.api;


import java.time.Duration;

public class IntervalExercise extends Exercise {

    public Duration time;
    public float quantity;

    public IntervalExercise(String name, Duration time, float quantity) {
        super.name = name;
        this.time = time;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return super.name + " " + time.getSeconds() +
                "хв " + quantity + " крг\n";
    }

}
