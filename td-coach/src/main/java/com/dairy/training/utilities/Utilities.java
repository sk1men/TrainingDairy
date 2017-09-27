package com.dairy.training.utilities;

public final class Utilities {

    private Utilities() {}

    public static float tonnage(float weight, int numbOfLift) {
        return weight * (float)numbOfLift;
    }

    public static int numbOfLift(int sets, int reps) {
        return sets * reps;
    }

    public static float calculateTime() {
        return Float.parseFloat(null);
    }//todo

    public static float averageWeight(float tonnage, int numbOfLift) {
        return tonnage/numbOfLift;
    }

    public static float relativeIntensity(float maxWeight, float averageWeight) {
        return averageWeight/maxWeight;
    }

    public static int FBIntensity(float maxWeight, float averageWeight) {
        return Integer.parseInt(null);
    }//todo интенсивность фунтиков

    public static float calculatePercent(float maxWeight, float currentWeight) {
        return currentWeight/maxWeight;
    }

    public static float calculateWeight(float maxWeight, float percent) {
        return maxWeight * percent;
    }


}
