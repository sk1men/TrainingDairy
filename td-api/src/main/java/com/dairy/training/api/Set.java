package com.dairy.training.api;

public class Set {

    public int weight;
    int set;
    int rep;
    float percent;

    public Set(int weight, int set, int rep) {
        this.weight = weight;
        this.set = set;
        this.rep = rep;
    }

    public Set(float percent, int set, int rep) {
        this.percent = percent;
        this.set = set;
        this.rep = rep;
    }
}
