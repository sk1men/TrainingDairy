package com.dairy.training.coach;

import com.dairy.training.api.Exercise;
import com.dairy.training.api.TrainingDay;
import com.dairy.training.athlete.Athlete;
import com.dairy.training.athlete.Goal;
import com.dairy.training.schedule.TrainingSchedule;

import java.util.List;
import java.util.Map;

public class AICoach implements Coach {

    public Map<TrainingDay, List<Exercise>> schedule;

    @Override
    public TrainingSchedule getSchedule(Athlete athlete, Goal goal) {
        return null;
    }

}
