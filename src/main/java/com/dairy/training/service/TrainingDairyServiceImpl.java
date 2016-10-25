package com.dairy.training.service;

import com.dairy.training.api.Exercise;
import com.dairy.training.api.TrainingDairyService;

import java.time.LocalDate;
import java.util.List;

import com.dairy.training.api.TrainingDay;
import com.dairy.training.repo.TrainingDataRepository;
import com.dairy.training.repo.TrainingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TrainingDairyServiceImpl implements TrainingDairyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrainingDairyServiceImpl.class);

    private final TrainingRepository trainingDataRepository;

    public TrainingDairyServiceImpl(TrainingRepository trainingDataRepository) {
        this.trainingDataRepository = trainingDataRepository;
    }

    @Override
    public List<TrainingDay> getTrainingDays(String login, LocalDate fromDate, LocalDate toDate) {
        LOGGER.debug("Fetching training days for user {} for period {} - {} ", login, fromDate, toDate);
        return trainingDataRepository.getTrainingDays(login, fromDate, toDate);
    }

    @Override
    public List<Exercise> getTrainingExercises(String login, LocalDate date) {
        LOGGER.debug("Fetching training exercises for user {} for {} ",login , date);
        return trainingDataRepository.getTrainingDaysExercises(login, date);
    }
}

