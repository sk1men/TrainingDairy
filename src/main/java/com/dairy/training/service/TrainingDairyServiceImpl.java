package com.dairy.training.service;

import com.dairy.training.api.Exercise;
import com.dairy.training.api.TrainingDairyService;

import java.time.LocalDate;
import java.util.List;

import com.dairy.training.api.TrainingDay;
import com.dairy.training.repo.TrainingDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TrainingDairyServiceImpl implements TrainingDairyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrainingDairyServiceImpl.class);
    private TrainingDataRepository tdr = new TrainingDataRepository();

    @Override
    public List<TrainingDay> getTrainingDays(String login, LocalDate fromDate, LocalDate toDate) {
        return tdr.getTrainingDays(login, fromDate, toDate);
    }

    @Override
    public List<Exercise> getTrainingExercises(String login, LocalDate date) {

        LOGGER.debug("LOGGER.debug", login, date);
        Logger logger = LoggerFactory.getLogger(TrainingDairyServiceImpl.class);
        logger.info("logger.info");

        return tdr.getTrainingDaysExercises(date);
    }
}

