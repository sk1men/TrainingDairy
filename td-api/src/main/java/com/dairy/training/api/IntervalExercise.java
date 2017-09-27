package com.dairy.training.api;


import java.time.Duration;
import java.util.Objects;

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
                " sec " + quantity + " qnt \n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntervalExercise that = (IntervalExercise) o;
        return Float.compare(that.quantity, quantity) == 0 &&
                Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, quantity);
    }
}
