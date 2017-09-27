package com.dairy.training.schedule;

import java.time.LocalTime;
import java.util.List;

public class Meal {// прийом їжі

    LocalTime time;
    List<MealCourse> mealCourses;

    public int kсal;
    public int protein;
    public int fat;
    public int carbohydrates;

    public Meal(LocalTime time, List<MealCourse> mealCourses) {
        this.time = time;
        this.mealCourses = mealCourses;
    }

    public LocalTime getTime() {
        return time;
    }

    public List<MealCourse> getMealCourses() {
        return mealCourses;
    }

    public int getKсal() {
        return kсal;
    }

    public int getProtein() {
        return protein;
    }

    public int getFat() {
        return fat;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }
}
