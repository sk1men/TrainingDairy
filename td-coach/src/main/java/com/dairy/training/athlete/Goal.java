package com.dairy.training.athlete;

import java.time.LocalDate;

public class Goal {

    FunctionalGoal functionalGoal;
    WeightGoal weightGoal;

    int achieveGoalTime;
    LocalDate start;
    LocalDate end;

    public Goal(FunctionalGoal functionalGoal, WeightGoal weightGoal, int achieveGoalTime) {
        this.functionalGoal = functionalGoal;
        this.weightGoal = weightGoal;
        this.achieveGoalTime = achieveGoalTime;
    }

    public Goal(FunctionalGoal functionalGoal, WeightGoal weightGoal, LocalDate start, LocalDate end) {
        this.functionalGoal = functionalGoal;
        this.weightGoal = weightGoal;
        this.achieveGoalTime = achieveGoalTime(end, start);
        this.start = start;
        this.end = end;
    }

    private int achieveGoalTime(LocalDate end, LocalDate start) {

        if (end.getDayOfYear() > start.getDayOfYear()) {
            return end.getDayOfYear() - start.getDayOfYear();
        } else return start.getDayOfYear() - end.getDayOfYear();
    }

    public FunctionalGoal getFunctionalGoal() {
        return functionalGoal;
    }

    public WeightGoal getWeightGoal() {
        return weightGoal;
    }

    public int getAchieveGoalTime() {
        return achieveGoalTime;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }
}
