package com.dairy.training.repo;

import com.dairy.training.api.Exercise;
import com.dairy.training.api.IntervalExercise;
import com.dairy.training.api.IteratedExercise;
import com.dairy.training.api.TrainingDay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Deprecated
public class TrainingDataRepository implements TrainingRepository{

    private final static Logger LOGGER = LoggerFactory.getLogger(TrainingDataRepository.class);

    private Map<TrainingDay, List<Exercise>> repo;

    public TrainingDataRepository() {
        this.repo = new HashMap<>();
        fillRepoByTestData();
    }

    @Override
    public List<TrainingDay> getTrainingDays(String login, LocalDate fromDate, LocalDate toDate) {
        LOGGER.debug("Fetching training days for user {} for period {} - {} ", login, fromDate, toDate);

        List<TrainingDay> trainingDayList = repo.keySet().stream()
                .filter(isUserDataFromPeriod(login, fromDate, toDate))
                .collect(Collectors.toList());

        LOGGER.info("Fetched {} training days for user {} for period {} - {}", trainingDayList.size(), login, fromDate, toDate);

        return trainingDayList;
    }

    private Predicate<TrainingDay> isUserDataFromPeriod(String login, LocalDate fromDate, LocalDate toDate) {
        return trainingDay -> trainingDay.user.equals(login)
                && (trainingDay.date.isAfter(fromDate.minusDays(1))
                && trainingDay.date.isBefore(toDate));
    }

    @Override
    public List<Exercise> getTrainingDaysExercises(String login, LocalDate date) {
        LOGGER.debug("Fetching exercises for user {} for date {} ", login, date);

        List<Exercise> exerciseList = repo.keySet().stream()
                .filter(byData(date))
                .findFirst()
                .map((trainingDay) -> repo.get(trainingDay))
                .orElse(Collections.emptyList());

        LOGGER.info("Fetched {} exercises for user {} for date {} ",exerciseList.size(), login, date);

        return exerciseList;

    }

    private Predicate<TrainingDay> byData(LocalDate date) {
        return (trainingDay) -> date.equals(trainingDay.date);
    }

    private void fillRepoByTestData() {
        TrainingDay trainingDay1 = new TrainingDay(LocalDate.of(2016, Month.AUGUST, 1), true, "Відпрацьовую техніку", "Легке тренування", "user1");
        TrainingDay trainingDay2 = new TrainingDay(LocalDate.of(2016, Month.AUGUST, 3), true, "Силове тренування", "Важке тренування", "user1");
        TrainingDay trainingDay3 = new TrainingDay(LocalDate.of(2016, Month.AUGUST, 5), false, "Відпрацьовую техніку", "Легке тренування", "user1");

        Exercise exercises1 = new IteratedExercise("Жим", 50, 10, 4);
        Exercise exercises2 = new IntervalExercise("Біг", Duration.ofSeconds(150), 3f);
        Exercise exercises3 = new IteratedExercise("Підтягування", 80, 8, 4);
        Exercise exercises4 = new IteratedExercise("Присід", 100, 10, 4);
        Exercise exercises5 = new IteratedExercise("Присід фронтальний", 80, 12, 2);
        Exercise exercises6 = new IntervalExercise("Кардіо", Duration.ofSeconds(60), 4f);
        Exercise exercises7 = new IteratedExercise("Тяга верхнього блоку", 60, 10, 6);
        Exercise exercises8 = new IntervalExercise("Хотьба", Duration.ofSeconds(1050), 5f);
        Exercise exercises9 = new IteratedExercise("Махи перед собою", 12, 10, 5);

        repo.put(trainingDay1, Arrays.asList(exercises1, exercises2, exercises3));
        repo.put(trainingDay2, Arrays.asList(exercises4, exercises5, exercises6));
        repo.put(trainingDay3, Arrays.asList(exercises7, exercises8, exercises9));
    }

}
