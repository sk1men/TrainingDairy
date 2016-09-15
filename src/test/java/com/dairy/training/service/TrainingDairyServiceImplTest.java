package com.dairy.training.service;

import com.dairy.training.api.TrainingDay;
import org.junit.Test;
import static org.junit.Assert.*;

import com.dairy.training.api.Exercise;
import java.time.LocalDate;
import java.util.List;


public class TrainingDairyServiceImplTest {
    @Test
    public void getTrainingExercises() throws Exception {

        List<TrainingDay> expected = new TrainingDairyServiceImpl().getTrainingDays("user", LocalDate.of(2016, 8, 1), LocalDate.of(2016, 8, 7));
        List<TrainingDay> result = new TrainingDairyServiceImpl().getTrainingDays("user",LocalDate.of(2016, 8, 4), LocalDate.of(2016, 8, 7));
//        assertSame(expected, result);
        assertFalse(expected.equals(result));
//        System.out.print(expected.equals(result));
//        assertFalse(actual);
//        assertFalse(false);

    }
}