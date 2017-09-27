package com.dairy.training.schedule;

import com.dairy.training.nutritionist.utilities.MealGroupName;

public class MealCourse {//Блюдо

    MealGroupName mealGroupName;
    String name;
    int weight;

    public int kсal;
    public float proteinAll;
    public float proteinA;
    public float proteinV;
    public float fatAll;
    public float fatA;
    public float fatV;
    public float carbohydrates;
    public int gi;

    public MealCourse(MealGroupName mealGroupName, String name, int weight, int kсal,
                      float proteinAll, float proteinA, float proteinV,
                      float fatAll, float fatA, float fatV,
                      float carbohydrates, int gi) {
        this.mealGroupName = mealGroupName;
        this.name = name;
        this.weight = weight;
        this.kсal = kсal;
        this.proteinAll = proteinAll;
        this.proteinA = proteinA;
        this.proteinV = proteinV;
        this.fatAll = fatAll;
        this.fatA = fatA;
        this.fatV = fatV;
        this.carbohydrates = carbohydrates;
        this.gi = gi;
    }

    public MealCourse(String name) {
        this.name = name;
    }

    public MealCourse(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public MealCourse(String name, int weight, int kсal) {
        this.name = name;
        this.weight = weight;
        this.kсal = kсal;
    }

    public MealGroupName getMealGroupName() {
        return mealGroupName;
    }

    public int getProteinAll() {//todo
        return (int) proteinAll;
    }

    public float getFatAll() {
        return fatAll;
    }

    public float getCarbohydrates() {
        return carbohydrates;
    }
}
