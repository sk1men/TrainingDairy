package com.dairy.training.coach;

import com.dairy.training.athlete.Athlete;
import com.dairy.training.athlete.Goal;
import com.dairy.training.schedule.TrainingSchedule;

public interface Coach {

    public TrainingSchedule getSchedule(Athlete athlete, Goal goal);
}
