package com.dairy.training.athlete;


import com.dairy.training.nutritionist.utilities.MealGroupName;
import com.dairy.training.schedule.MealCourse;

import java.time.LocalDate;
import java.util.List;

public class WeightGoal {

    private Goal goal;
    private float weight;

    private final int kcall;
    private final int ppotPerst;
    private final int fatPerst;
    private final int carbPerst;
    private final LocalDate end;
    private final LocalDate start;
    private final List<MealCourse> mealGroupName;

    public WeightGoal(Goal goal, float weight, int kcall, int ppotPerst, int fatPerst, int carbPerst, LocalDate end, LocalDate start, List<MealGroupName> mealGroupName) {
        this.goal = goal;
        this.weight = weight;
        this.kcall = kcall;
        this.ppotPerst = ppotPerst;
        this.fatPerst = fatPerst;
        this.carbPerst = carbPerst;
        this.end = end;
        this.start = start;
        this.mealGroupName = mealGroupName;
    }

    public static enum Goal {
        LOSE_WEIGHT, GAIN_WEIGHT, BE_SAME, GET_HEALTHY_DIET, CREATE_OWN_DIET;

    }

    public Goal getGoal() {
        return goal;
    }

    public float getWeight() {
        return weight;
    }

    public int getKcall() {
        return kcall;
    }

    public int getPpotPerst() {
        return ppotPerst;
    }

    public int getFatPerst() {
        return fatPerst;
    }

    public int getCarbPerst() {
        return carbPerst;
    }

    public LocalDate getEnd() {
        return end;
    }

    public LocalDate getStart() {
        return start;
    }

    public List<MealCourse> getMealGroupName() {
        return mealGroupName;
    }
}
