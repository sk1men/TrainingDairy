package com.dairy.training.nutritionist;


import com.dairy.training.athlete.Athlete;
import com.dairy.training.athlete.Goal;
import com.dairy.training.schedule.TrainingSchedule;

public interface Nutritionist {

    public TrainingSchedule getNutritionist(Athlete athlete, Goal goal);
}
