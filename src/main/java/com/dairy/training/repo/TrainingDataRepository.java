package com.dairy.training.repo;

import com.dairy.training.api.Exercise;
import com.dairy.training.api.IntervalExercise;
import com.dairy.training.api.IteratedExercise;
import com.dairy.training.api.TrainingDay;
import com.dairy.training.service.TrainingDairyServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.*;

public class TrainingDataRepository {

    private Map<TrainingDay, List<Exercise>> repo;
    private Logger LOGGER = LoggerFactory.getLogger(TrainingDairyServiceImpl.class);

    public TrainingDataRepository() {

        repo = new HashMap<>();

        TrainingDay trainingDay1 = new TrainingDay(LocalDate.of(2016, Month.AUGUST, 1), true, "Відпрацьовую техніку", "Легке тренування", "user1");
        TrainingDay trainingDay2 = new TrainingDay(LocalDate.of(2016, Month.AUGUST, 3), true, "Силове тренування", "Важке тренування", "user1");
        TrainingDay trainingDay3 = new TrainingDay(LocalDate.of(2016, Month.AUGUST, 5), false, "Відпрацьовую техніку", "Легке тренування", "user1");

        Exercise exercises1 = new IteratedExercise("Жим", 50, 10, 4);
        Exercise exercises2 = new IntervalExercise("Біг", Duration.ofSeconds(150), (float) 3);
        Exercise exercises3 = new IteratedExercise("Підтягування", 80, 8, 4);
        Exercise exercises4 = new IteratedExercise("Присід", 100, 10, 4);
        Exercise exercises5 = new IteratedExercise("Присід фронтальний", 80, 12, 2);
        Exercise exercises6 = new IntervalExercise("Кардію", Duration.ofSeconds(60), (float) 3.0);
        Exercise exercises7 = new IteratedExercise("Тяга верхнього блоку", 60, 10, 6);
        Exercise exercises8 = new IntervalExercise("Хотьба", Duration.ofSeconds(1050), (float) 10);
        Exercise exercises9 = new IteratedExercise("Махи перед собою", 12, 10, 5);

        repo.put(trainingDay1, Arrays.asList(exercises1, exercises2, exercises3));
        repo.put(trainingDay2, Arrays.asList(exercises4, exercises5, exercises6));
        repo.put(trainingDay3, Arrays.asList(exercises7, exercises8, exercises9));

        trainingDay2.getUser();
    }

    public List<TrainingDay> getTrainingDays(String login, LocalDate fromDate, LocalDate toDate) {
        String user;
        LocalDate dateTrainingDay;
        List<TrainingDay> listTrainingDayGetCurrentUser = new ArrayList<>();
        Collection<TrainingDay> getTrainingDaysFromRepository = this.repo.keySet();

        for (TrainingDay trainingDay : getTrainingDaysFromRepository) {
            user = trainingDay.user;
            dateTrainingDay = trainingDay.date;
            LOGGER.info("Юзер " + user + " Тренировочный день " + dateTrainingDay);

            if (user.equals(login) && (dateTrainingDay.isAfter(fromDate.minusDays(1)) && dateTrainingDay.isBefore(toDate))) {
                listTrainingDayGetCurrentUser.add(trainingDay);
            } else if (listTrainingDayGetCurrentUser.size() == 0) {
                LOGGER.info("Немає ніяких даних по " + login);
                return null;
            }
        }


        return listTrainingDayGetCurrentUser;
    }

    public List<Exercise> getTrainingDaysExercises(LocalDate date) {
        List<Exercise> exercise = new ArrayList<>();
        for (TrainingDay trainingDay : this.repo.keySet()) {
            if (date.equals(trainingDay.date)) exercise = this.repo.get(trainingDay);
        }
        return exercise;
    }

}
