package com.dairy.training.repo;


import com.dairy.training.api.Exercise;
import com.dairy.training.api.TrainingDay;

import java.time.LocalDate;
import java.util.List;

public interface TrainingRepository {
    List<TrainingDay> getTrainingDays(String login, LocalDate fromDate, LocalDate toDate);

    List<Exercise> getTrainingDaysExercises(String login, LocalDate date);
}
