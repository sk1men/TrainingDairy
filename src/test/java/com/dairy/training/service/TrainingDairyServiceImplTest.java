package com.dairy.training.service;

import com.dairy.training.api.*;
import com.dairy.training.repo.TrainingDataRepository;
import com.dairy.training.repo.TrainingRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

import org.mockito.Mockito;
import sun.plugin.javascript.navig.Array;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class TrainingDairyServiceImplTest {

    @Test
    public void getTrainingDays_optimistic() throws Exception {

        // expected
        TrainingDay expectedDay1 = new TrainingDay(LocalDate.of(2016, 9, 1), true, "Відпрацьовую техніку", "Легке тренування", "user1");
        TrainingDay expectedDay2 = new TrainingDay(LocalDate.of(2016, 9, 3), true, "Силове тренування", "Важке тренування", "user1");
        List<TrainingDay> expected = Arrays.asList(expectedDay1, expectedDay2);

        // given
        String givenLogin = "user1";
        LocalDate givenDateFrom = LocalDate.of(2016, 9, 1);
        LocalDate givenDateTo = LocalDate.of(2016, 9, 7);

        // when
        TrainingRepository mockRepo = Mockito.mock(TrainingRepository.class);
        TrainingDay day1 = new TrainingDay(LocalDate.of(2016, 9, 1), true, "Відпрацьовую техніку", "Легке тренування", "user1");
        TrainingDay day2 = new TrainingDay(LocalDate.of(2016, 9, 3), true, "Силове тренування", "Важке тренування", "user1");
        Mockito.when(mockRepo.getTrainingDays("user1", LocalDate.of(2016, 9, 1), LocalDate.of(2016, 9, 7)))
                .thenReturn(Arrays.asList(day1, day2));

        // then
        TrainingDairyServiceImpl target = new TrainingDairyServiceImpl(mockRepo);
        List<TrainingDay> actual = target.getTrainingDays(givenLogin, givenDateFrom, givenDateTo);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTrainingDays_notFound() throws Exception {

        // expected
        List<TrainingDay> expected = Collections.emptyList();

        // given
        String givenLogin = "user1";
        LocalDate givenDateFrom = LocalDate.of(2016, 9, 1);
        LocalDate givenDateTo = LocalDate.of(2016, 9, 7);

        // when
        TrainingRepository mockRepo = Mockito.mock(TrainingRepository.class);

        // then
        TrainingDairyServiceImpl target = new TrainingDairyServiceImpl(mockRepo);
        List<TrainingDay> actual = target.getTrainingDays(givenLogin, givenDateFrom, givenDateTo);

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void getTrainingDays_nullRepo() throws Exception {

        // given
        String givenLogin = "user1";
        LocalDate givenDateFrom = LocalDate.of(2016, 9, 1);
        LocalDate givenDateTo = LocalDate.of(2016, 9, 7);

        // then
        TrainingDairyServiceImpl target = new TrainingDairyServiceImpl(null);
        target.getTrainingDays(givenLogin, givenDateFrom, givenDateTo);

    }

    @Test
    public void getTrainingExercises_optimistic() throws Exception {

        //3 expected
        Exercise expectedExercise1 = new IteratedExercise("Жим", 50, 10, 4);
        Exercise expectedExercise2 = new IntervalExercise("Біг", Duration.ofSeconds(150), 3f);
        List<Exercise> expected = Arrays.asList(expectedExercise1, expectedExercise2);

        //2 given
        String givenLogin = "user1";
        LocalDate givenDate = LocalDate.of(2016, 9, 1);

        //4 when
        TrainingRepository mockRepo = Mockito.mock(TrainingRepository.class);
        Exercise exercise1 = new IteratedExercise("Жим", 50, 10, 4);
        Exercise exercise2 = new IntervalExercise("Біг", Duration.ofSeconds(150), 3f);
        Mockito.when(mockRepo.getTrainingDaysExercises("user1", LocalDate.of(2016, 9, 1)))
                .thenReturn(Arrays.asList(exercise1, exercise2));

        //1 then
        TrainingDairyService target = new TrainingDairyServiceImpl(mockRepo);
        List<Exercise> actual = target.getTrainingExercises(givenLogin, givenDate);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTrainingExercises_notFound() throws Exception {

        //3 expected
        List<Exercise> expected = Collections.emptyList();

        //2 given
        String givenLogin = "user1";
        LocalDate givenDate = LocalDate.of(2016, 9, 1);

        //4 when
        TrainingRepository mockRepo = Mockito.mock(TrainingRepository.class);

        //1 then
        TrainingDairyService target = new TrainingDairyServiceImpl(mockRepo);
        List<Exercise> actual = target.getTrainingExercises(givenLogin, givenDate);

        Assert.assertEquals(expected, actual);
    }
}
