package com.dairy.training.api;


import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public interface TrainingDairyService {

    List<Exercise> getTrainingExercises(String login, LocalDate date);

    List<TrainingDay> getTrainingDays(String login, LocalDate fromDate, LocalDate toDate);
}
