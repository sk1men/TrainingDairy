package com.dairy.training.service;


import com.dairy.training.api.Exercise;
import com.dairy.training.api.TrainingDairyService;
import com.dairy.training.api.TrainingDay;

import java.time.LocalDate;
import java.util.List;

public class Test {

    public static void main(String... args) {

        TrainingDairyService tdsi = new TrainingDairyServiceImpl();
        List<TrainingDay> trainingDays = tdsi.getTrainingDays("user1", LocalDate.of(2016, 8, 1), LocalDate.of(2016, 8, 7));

        for (TrainingDay trainingDay : trainingDays) {
            List<Exercise> traningDaysExercises = tdsi.getTrainingExercises("user1", trainingDay.date);

            System.out.println("" + trainingDay + traningDaysExercises);
//            System.out.println("" + trainingDay + traningDaysExercises.get(0) + traningDaysExercises.get(1) + traningDaysExercises.get(2));
        }
    }

}
