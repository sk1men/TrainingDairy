package com.dairy.training.schedule;

import com.dairy.training.api.Exercise;
import com.dairy.training.api.TrainingDay;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class TrainingSchedule {

    public Map<TrainingDay, List<Exercise>> schedule;
    public Map<LocalDate,List<Meal>> diet;


}
