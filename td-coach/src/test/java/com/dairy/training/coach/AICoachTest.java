package com.dairy.training.coach;

import com.dairy.training.api.Exercise;
import com.dairy.training.api.IntervalExercise;
import com.dairy.training.api.IteratedExercise;
import com.dairy.training.api.TrainingDay;
import com.dairy.training.athlete.*;
import com.dairy.training.schedule.Meal;
import com.dairy.training.schedule.MealCourse;
import com.dairy.training.schedule.TrainingSchedule;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class AICoachTest {

    @Test
    public void getSchedule_looseWeight_male() throws Exception {


        TrainingDay trainingDayW1d1 = new TrainingDay(LocalDate.of(2016, Month.DECEMBER, 1), false, "goal", "Легкая", "user1");//короткий опис вправ
        TrainingDay trainingDayW1d2 = new TrainingDay(LocalDate.of(2016, Month.DECEMBER, 3), false, "goal", "Легкая", "user1");
        TrainingDay trainingDayW1d3 = new TrainingDay(LocalDate.of(2016, Month.DECEMBER, 6), false, "goal", "Легкая", "user1");

        TrainingDay trainingDayW2d1 = new TrainingDay(LocalDate.of(2016, Month.DECEMBER, 8), false, "goal", "Средняя", "user1");
        TrainingDay trainingDayW2d2 = new TrainingDay(LocalDate.of(2016, Month.DECEMBER, 10), false, "goal", "Легкая", "user1");
        TrainingDay trainingDayW2d3 = new TrainingDay(LocalDate.of(2016, Month.DECEMBER, 13), false, "goal", "Легкая", "user1");

        TrainingDay trainingDayW3d1 = new TrainingDay(LocalDate.of(2016, Month.DECEMBER, 15), false, "goal", "Средняя", "user1");
        TrainingDay trainingDayW3d2 = new TrainingDay(LocalDate.of(2016, Month.DECEMBER, 17), false, "goal", "Средняя", "user1");
        TrainingDay trainingDayW3d3 = new TrainingDay(LocalDate.of(2016, Month.DECEMBER, 20), false, "goal", "Легкая", "user1");

        TrainingDay trainingDayW4d1 = new TrainingDay(LocalDate.of(2016, Month.DECEMBER, 22), false, "goal", "Средняя", "user1");
        TrainingDay trainingDayW4d2 = new TrainingDay(LocalDate.of(2016, Month.DECEMBER, 24), false, "goal", "Легкая", "user1");
        TrainingDay trainingDayW4d3 = new TrainingDay(LocalDate.of(2016, Month.DECEMBER, 26), false, "goal", "Средняя", "user1");

        TrainingDay trainingDayW5d1 = new TrainingDay(LocalDate.of(2016, Month.DECEMBER, 29), false, "goal", "Легкая", "user1");
        TrainingDay trainingDayW5d2 = new TrainingDay(LocalDate.of(2017, Month.JANUARY, 31), false, "goal", "Тяжелая", "user1");
        TrainingDay trainingDayW5d3 = new TrainingDay(LocalDate.of(2017, Month.JANUARY, 3), false, "goal", "Легкая", "user1");

        TrainingDay trainingDayW6d1 = new TrainingDay(LocalDate.of(2017, Month.JANUARY, 5), false, "goal", "Средняя", "user1");
        TrainingDay trainingDayW6d2 = new TrainingDay(LocalDate.of(2017, Month.JANUARY, 7), false, "goal", "Легкая", "user1");
        TrainingDay trainingDayW6d3 = new TrainingDay(LocalDate.of(2017, Month.JANUARY, 10), false, "goal", "Тяжелая", "user1");

        TrainingDay trainingDayW7d1 = new TrainingDay(LocalDate.of(2017, Month.JANUARY, 12), false, "goal", "Легкая", "user1");
        TrainingDay trainingDayW7d2 = new TrainingDay(LocalDate.of(2017, Month.JANUARY, 14), false, "goal", "Легкая", "user1");
        TrainingDay trainingDayW7d3 = new TrainingDay(LocalDate.of(2017, Month.JANUARY, 17), false, "goal", "Средняя", "user1");

        TrainingDay trainingDayW8d1 = new TrainingDay(LocalDate.of(2017, Month.JANUARY, 19), false, "goal", "Тяжелая", "user1");
        TrainingDay trainingDayW8d2 = new TrainingDay(LocalDate.of(2017, Month.JANUARY, 21), false, "goal", "Легкая", "user1");
        TrainingDay trainingDayW8d3 = new TrainingDay(LocalDate.of(2017, Month.JANUARY, 24), false, "goal", "Средняя", "user1");

        TrainingDay trainingDayW9d1 = new TrainingDay(LocalDate.of(2017, Month.JANUARY, 26), false, "goal", "Легкая", "user1");
        TrainingDay trainingDayW9d2 = new TrainingDay(LocalDate.of(2017, Month.JANUARY, 28), false, "goal", "Тяжелая", "user1");
        TrainingDay trainingDayW9d3 = new TrainingDay(LocalDate.of(2017, Month.JANUARY, 31), false, "goal", "Легкая", "user1");

        TrainingDay trainingDayW10d1 = new TrainingDay(LocalDate.of(2017, Month.FEBRUARY, 2), false, "goal", "Средняя", "user1");
        TrainingDay trainingDayW10d2 = new TrainingDay(LocalDate.of(2017, Month.FEBRUARY, 4), false, "goal", "Средняя", "user1");
        TrainingDay trainingDayW10d3 = new TrainingDay(LocalDate.of(2017, Month.FEBRUARY, 7), false, "goal", "Легкая", "user1");

        //3 expected
        TrainingSchedule expectedSchedule = new TrainingSchedule();
        expectedSchedule.schedule = new HashMap<>();
        expectedSchedule.schedule.put(trainingDayW1d1, Arrays.asList(
                new IteratedExercise("Жим", 30, 10, 5),
                new IteratedExercise("Жим 30", 25, 12, 4),
                new IteratedExercise("Трицепс на блоке", 15, 15, 4),
                new IteratedExercise("Бицепс стоя", 20, 10, 3),
                new IteratedExercise("Бицепс гантелями", 7, 12, 4),
                new IteratedExercise("Разгибание ног", 15, 8, 5),
                new IntervalExercise("Хотьба по леснице", Duration.ofSeconds(600), 1f)));
        expectedSchedule.schedule.put(trainingDayW1d2, Arrays.asList(
                new IteratedExercise("Гиперэкстензии", 5, 12, 4),
                new IteratedExercise("Наклоны", 20, 10, 4),
                new IteratedExercise("Сгибание ног", 15, 10, 4),
                new IteratedExercise("Тяга верхнего блока", 20, 10, 4),
                new IteratedExercise("Тяга нижнего блока", 25, 10, 4),
                new IteratedExercise("Шраги", 40, 15, 3),
                new IntervalExercise("Канат", Duration.ofSeconds(15), 4f)));
        expectedSchedule.schedule.put(trainingDayW1d3, Arrays.asList(
                new IteratedExercise("Жим стоя", 15, 10, 5),
                new IteratedExercise("Жим 45", 25, 10, 4),
                new IteratedExercise("Махи перед собой", 6, 12, 4),
                new IteratedExercise("Жим ногами", 80, 8, 5),
                new IteratedExercise("Разгибание ног", 25, 12, 4),
                new IntervalExercise("Велотренажер", Duration.ofSeconds(600), 1f)));

        expectedSchedule.schedule.put(trainingDayW2d1, Arrays.asList(
                new IteratedExercise("Жим", 35, 12, 4),
                new IteratedExercise("Жим 30", 20, 12, 4),
                new IteratedExercise("Трицепс на блоке", 15, 15, 4),
                new IteratedExercise("Бицепс стоя", 25, 8, 4),
                new IteratedExercise("Бицепс гантелями", 6, 15, 4),
                new IteratedExercise("Присед", 20, 5, 5),
                new IntervalExercise("Хотьба по леснице", Duration.ofSeconds(600), 1f)));
        expectedSchedule.schedule.put(trainingDayW2d2, Arrays.asList(
                new IteratedExercise("Гиперэкстензии", 5, 12, 4),
                new IteratedExercise("Наклоны", 20, 12, 4),
                new IteratedExercise("Сгибание ног", 15, 10, 4),
                new IteratedExercise("Тяга верхнего блока", 25, 12, 3),
                new IteratedExercise("Тяга нижнего блока", 25, 12, 3),
                new IteratedExercise("Шраги", 45, 15, 4),
                new IntervalExercise("Канат", Duration.ofSeconds(15), 4f)));
        expectedSchedule.schedule.put(trainingDayW2d3, Arrays.asList(
                new IteratedExercise("Жим стоя", 25, 10, 5),
                new IteratedExercise("Жим 45", 25, 10, 4),
                new IteratedExercise("Махи перед собой", 7, 10, 4),
                new IteratedExercise("Присед", 30, 8, 5),
                new IteratedExercise("Жим ногами", 80, 8, 5),
                new IntervalExercise("Велотренажер", Duration.ofSeconds(600), 1f)));

        expectedSchedule.schedule.put(trainingDayW3d1, Arrays.asList(
                new IteratedExercise("Жим", 40, 10, 4),
                new IteratedExercise("Жим 30", 30, 12, 3),
                new IteratedExercise("Трицепс на блоке", 15, 10, 4),
                new IteratedExercise("Бицепс стоя", 20, 10, 5),
                new IteratedExercise("Бицепс гантелями", 8, 12, 2),
                new IteratedExercise("Разгибание ног", 15, 10, 4),
                new IntervalExercise("Хотьба по леснице", Duration.ofSeconds(600), 1f)));
        expectedSchedule.schedule.put(trainingDayW3d2, Arrays.asList(
                new IteratedExercise("Гиперэкстензии", 5, 12, 4),
                new IteratedExercise("Тяга классическая", 30, 8, 5),
                new IteratedExercise("Наклоны", 20, 10, 4),
                new IteratedExercise("Сгибание ног", 20, 15, 3),
                new IteratedExercise("Тяга верхнего блока", 25, 12, 4),
                new IteratedExercise("Подтягивания", 35, 8, 4),
                new IteratedExercise("Шраги", 60, 8, 4),
                new IntervalExercise("Канат", Duration.ofSeconds(60), 4f)));
        expectedSchedule.schedule.put(trainingDayW3d3, Arrays.asList(
                new IteratedExercise("Жим стоя", 20, 12, 5),
                new IteratedExercise("Жим 45", 30, 10, 4),
                new IteratedExercise("Махи в сторону", 5, 12, 5),
                new IteratedExercise("Присед", 35, 10, 5),
                new IteratedExercise("Разгибание ног", 20, 12, 4),
                new IntervalExercise("Велотренажер", Duration.ofSeconds(900), 1f)));

        expectedSchedule.schedule.put(trainingDayW4d1, Arrays.asList(
                new IteratedExercise("Жим", 30, 12, 4),
                new IteratedExercise("Жим 30", 30, 12, 4),
                new IteratedExercise("Трицепс на блоке", 20, 8, 4),
                new IteratedExercise("Бицепс стоя", 25, 10, 4),
                new IteratedExercise("Бицепс гантелями", 8, 12, 3),
                new IteratedExercise("Присед", 20, 8, 4),
                new IntervalExercise("Хотьба по леснице", Duration.ofSeconds(600), 1f)));
        expectedSchedule.schedule.put(trainingDayW4d2, Arrays.asList(
                new IteratedExercise("Гиперэкстензии", 5, 12, 4),
                new IteratedExercise("Тяга классическая", 35, 10, 5),
                new IteratedExercise("Наклоны", 20, 10, 4),
                new IteratedExercise("Сгибание ног", 20, 8, 4),
                new IteratedExercise("Тяга верхнего блока", 30, 10, 4),
                new IteratedExercise("Подтягивания", 40, 10, 5),
                new IteratedExercise("Шраги", 60, 10, 3),
                new IntervalExercise("Канат", Duration.ofSeconds(60), 4f)));
        expectedSchedule.schedule.put(trainingDayW4d3, Arrays.asList(
                new IteratedExercise("Жим стоя", 25, 10, 4),
                new IteratedExercise("Жим из-за головы", 25, 10, 3),
                new IteratedExercise("Жим 45", 25, 12, 4),
                new IteratedExercise("Махи перед собой", 8, 12, 4),
                new IteratedExercise("Жим ногами", 80, 8, 5),
                new IteratedExercise("Присед", 40, 6, 6),
                new IteratedExercise("Разгибание ног", 25, 12, 4),
                new IntervalExercise("Велотренажер", Duration.ofSeconds(900), 1f)));

        expectedSchedule.schedule.put(trainingDayW5d1, Arrays.asList(
                new IteratedExercise("Жим", 40, 10, 4),
                new IteratedExercise("Жим 30", 30, 8, 4),
                new IteratedExercise("Французкий жим", 15, 12, 4),
                new IteratedExercise("Бицепс стоя", 30, 10, 4),
                new IteratedExercise("Бицепс гантелями", 10, 12, 3),
                new IteratedExercise("Присед", 30, 6, 6),
                new IntervalExercise("Хотьба по леснице", Duration.ofSeconds(600), 1f)));
        expectedSchedule.schedule.put(trainingDayW5d2, Arrays.asList(
                new IteratedExercise("Гиперэкстензии", 10, 12, 3),
                new IteratedExercise("Тяга классическая", 50, 8, 5),
                new IteratedExercise("Наклоны", 30, 10, 3),
                new IteratedExercise("Сгибание ног", 20, 15, 2),
                new IteratedExercise("Подтягивания на гравитоне", 30, 6, 5),
                new IteratedExercise("Тяга нижнего блока", 30, 10, 4),
                new IteratedExercise("Шраги", 60, 10, 4),
                new IntervalExercise("Канат", Duration.ofSeconds(60), 4f)));
        expectedSchedule.schedule.put(trainingDayW5d3, Arrays.asList(
                new IteratedExercise("Жим стоя", 30, 10, 3),
                new IteratedExercise("Жим из-за головы", 35, 10, 3),
                new IteratedExercise("Жим 45", 40, 6, 5),
                new IteratedExercise("Махи перед собой", 8, 12, 4),
                new IteratedExercise("Присед", 40, 10, 4),
                new IteratedExercise("Жим ногами", 150, 12, 3),
                new IntervalExercise("Велотренажер", Duration.ofSeconds(900), 1f)));

        expectedSchedule.schedule.put(trainingDayW6d1, Arrays.asList(
                new IteratedExercise("Жим", 50, 8, 4),
                new IteratedExercise("Жим 30", 40, 8, 3),
                new IteratedExercise("Трицепс на блоке", 25, 12, 3),
                new IteratedExercise("Бицепс стоя", 35, 8, 4),
                new IteratedExercise("Бицепс гантелями", 12, 12, 3),
                new IteratedExercise("Присед", 20, 6, 6),
                new IntervalExercise("Хотьба по леснице", Duration.ofSeconds(600), 1f)));
        expectedSchedule.schedule.put(trainingDayW6d2, Arrays.asList(
                new IteratedExercise("Сгибание ног", 30, 8, 4),
                new IteratedExercise("Тяга классическая", 55, 8, 4),
                new IteratedExercise("Наклоны", 30, 8, 4),
                new IteratedExercise("Подтягивания на гравитоне", 40, 8, 4),
                new IteratedExercise("Тяга нижнего блока", 40, 10, 4),
                new IteratedExercise("Шраги", 70, 8, 4),
                new IntervalExercise("Канат", Duration.ofSeconds(60), 4f)));
        expectedSchedule.schedule.put(trainingDayW6d3, Arrays.asList(
                new IteratedExercise("Жим стоя", 30, 6, 4),
                new IteratedExercise("Жим из-за головы", 40, 6, 5),
                new IteratedExercise("Махи в сторону", 7, 12, 4),
                new IteratedExercise("Присед", 50, 8, 5),
                new IteratedExercise("Разгибание ног", 30, 12, 4),
                new IntervalExercise("Велотренажер", Duration.ofSeconds(900), 1f)));

        expectedSchedule.schedule.put(trainingDayW7d1, Arrays.asList(
                new IteratedExercise("Жим", 40, 12, 4),
                new IteratedExercise("Жим 30", 35, 12, 3),
                new IteratedExercise("Французкий жим", 20, 10, 4),
                new IteratedExercise("Бицепс стоя", 30, 12, 4),
                new IteratedExercise("Бицепс гантелями", 14, 8, 4),
                new IteratedExercise("Присед", 35, 6, 5),
                new IntervalExercise("Хотьба по леснице", Duration.ofSeconds(600), 1f)));
        expectedSchedule.schedule.put(trainingDayW7d2, Arrays.asList(
                new IteratedExercise("Сгибание ног", 20, 8, 4),
                new IteratedExercise("Тяга классическая", 60, 8, 4),
                new IteratedExercise("Наклоны", 25, 8, 4),
                new IteratedExercise("Подтягивания на гравитоне", 30, 12, 6),
                new IteratedExercise("Тяга нижнего блока", 30, 20, 2),
                new IteratedExercise("Шраги", 50, 15, 3),
                new IntervalExercise("Канат", Duration.ofSeconds(60), 4f)));
        expectedSchedule.schedule.put(trainingDayW7d3, Arrays.asList(
                new IteratedExercise("Жим стоя", 35, 6, 5),
                new IteratedExercise("Жим из-за головы", 30, 8, 3),
                new IteratedExercise("Махи в сторону", 6, 12, 4),
                new IteratedExercise("Присед", 40, 12, 4),
                new IteratedExercise("Разгибание ног", 20, 12, 3),
                new IntervalExercise("Велотренажер", Duration.ofSeconds(900), 1f)));

        expectedSchedule.schedule.put(trainingDayW8d1, Arrays.asList(
                new IteratedExercise("Жим", 45, 10, 4),
                new IteratedExercise("Жим 30", 30, 10, 4),
                new IteratedExercise("Французкий жим", 20, 12, 4),
                new IteratedExercise("Бицепс стоя", 35, 10, 3),
                new IteratedExercise("Бицепс гантелями", 12, 10, 4),
                new IteratedExercise("Присед", 20, 8, 4),
                new IntervalExercise("Хотьба по леснице", Duration.ofSeconds(600), 1f)));
        expectedSchedule.schedule.put(trainingDayW8d2, Arrays.asList(
                new IteratedExercise("Гиперэкстензии", 10, 12, 4),
                new IteratedExercise("Тяга классическая", 50, 12, 4),
                new IteratedExercise("Наклоны", 20, 12, 2),
                new IteratedExercise("Сгибание ног", 30, 8, 4),
                new IteratedExercise("Тяга верхнего блока", 25, 12, 5),
                new IteratedExercise("Тяга нижнего блока", 30, 12, 3),
                new IteratedExercise("Шраги", 60, 15, 3),
                new IntervalExercise("Канат", Duration.ofSeconds(60), 4f)));
        expectedSchedule.schedule.put(trainingDayW8d3, Arrays.asList(
                new IteratedExercise("Жим стоя", 30, 8, 4),
                new IteratedExercise("Жим 45", 40, 10, 4),
                new IteratedExercise("Махи перед собой", 9, 12, 4),
                new IteratedExercise("Присед", 50, 10, 4),
                new IteratedExercise("Разгибание ног", 30, 8, 4),
                new IntervalExercise("Велотренажер", Duration.ofSeconds(900), 1f)));

        expectedSchedule.schedule.put(trainingDayW9d1, Arrays.asList(
                new IteratedExercise("Жим", 50, 8, 4),
                new IteratedExercise("Жим 30", 35, 10, 4),
                new IteratedExercise("Жим гантелей", 14, 12, 4),
                new IteratedExercise("Бицепс стоя", 30, 10, 4),
                new IteratedExercise("Бицепс гантелями", 12, 12, 3),
                new IteratedExercise("Присед", 20, 8, 4),
                new IntervalExercise("Хотьба по леснице", Duration.ofSeconds(600), 1f)));
        expectedSchedule.schedule.put(trainingDayW9d2, Arrays.asList(
                new IteratedExercise("Гиперэкстензии", 10, 12, 4),
                new IteratedExercise("Наклоны", 40, 10, 4),
                new IteratedExercise("Сгибание ног", 30, 12, 4),
                new IteratedExercise("Подтягивания", 60, 4, 6),
                new IteratedExercise("Тяга нижнего блока", 30, 10, 4),
                new IteratedExercise("Шраги", 60, 15, 3),
                new IntervalExercise("Канат", Duration.ofSeconds(60), 4f)));
        expectedSchedule.schedule.put(trainingDayW9d3, Arrays.asList(
                new IteratedExercise("Жим стоя", 35, 8, 4),
                new IteratedExercise("Жим 45", 40, 12, 4),
                new IteratedExercise("Махи перед собой", 8, 12, 4),
                new IteratedExercise("Присед", 60, 8, 4),
                new IteratedExercise("Жим ногами", 150, 12, 4),
                new IntervalExercise("Велотренажер", Duration.ofSeconds(900), 1f)));

        expectedSchedule.schedule.put(trainingDayW10d1, Arrays.asList(
                new IteratedExercise("Жим", 45, 12, 4),
                new IteratedExercise("Жим 30", 40, 12, 2),
                new IteratedExercise("Жим гантелей", 16, 12, 3),
                new IteratedExercise("Бицепс стоя", 40, 6, 5),
                new IteratedExercise("Бицепс гантелями", 12, 15, 3),
                new IteratedExercise("Присед", 20, 8, 4),
                new IntervalExercise("Хотьба по леснице", Duration.ofSeconds(600), 1f)));
        expectedSchedule.schedule.put(trainingDayW10d2, Arrays.asList(
                new IteratedExercise("Гиперэкстензии", 5, 12, 4),
                new IteratedExercise("Тяга классическая", 80, 8, 4),
                new IteratedExercise("Сгибание ног", 20, 8, 4),
                new IteratedExercise("Тяга верхнего блока", 30, 12, 4),
                new IteratedExercise("Тяга нижнего блока", 45, 12, 4),
                new IteratedExercise("Шраги", 70, 8, 3),
                new IntervalExercise("Канат", Duration.ofSeconds(60), 4f)));
        expectedSchedule.schedule.put(trainingDayW10d3, Arrays.asList(
                new IteratedExercise("Жим стоя", 25, 12, 4),
                new IteratedExercise("Жим 45", 30, 12, 4),
                new IteratedExercise("Махи перед собой", 10, 12, 4),
                new IteratedExercise("Присед", 40, 12, 4),
                new IteratedExercise("Жим ногами", 200, 12, 4),
                new IntervalExercise("Велотренажер", Duration.ofSeconds(900), 1f)));

        TrainingSchedule expectedDiet = new TrainingSchedule();
        expectedSchedule.diet = new HashMap<>();

        List<Meal> weekend = Arrays.asList(
                new Meal(LocalTime.of(8, 0),Arrays.asList(
                        new MealCourse("Творог с курагою",400),
                        new MealCourse("Конфеты",400))),
                new Meal(LocalTime.of(12, 0),Arrays.asList(
                        new MealCourse("Пица",250),
                        new MealCourse("Жаренная курица",350),
                        new MealCourse("Жаренная картошка",200))),
                new Meal(LocalTime.of(16, 0),Arrays.asList(
                        new MealCourse("Говядина",20),
                        new MealCourse("Салат",250))),
                new Meal(LocalTime.of(21, 0),Arrays.asList(
                        new MealCourse("Омлет",20),
                        new MealCourse("Салат",250))));

        List<Meal> usualDay = Arrays.asList(
                new Meal(LocalTime.of(8, 0),Arrays.asList(
                        new MealCourse("Творог с курагою",400),
                        new MealCourse("Хлеб",150))),
                new Meal(LocalTime.of(11, 0),Arrays.asList(
                        new MealCourse("Творог",400))),
                new Meal(LocalTime.of(14, 0),Arrays.asList(
                        new MealCourse("Гречка",250),
                        new MealCourse("Курятина",300))),
                new Meal(LocalTime.of(16, 0),Arrays.asList(
                        new MealCourse("Омлет",250),
                        new MealCourse("Салат",250))),
                new Meal(LocalTime.of(21, 0),Arrays.asList(
                        new MealCourse("Омлет",250),
                        new MealCourse("Салат",250))));

//todo Meal переписати з використанням цього класу
        expectedSchedule.diet.put(LocalDate.of(2016, Month.DECEMBER, 1), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2016, Month.DECEMBER, 2), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2016, Month.DECEMBER, 3), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2016, Month.DECEMBER, 4), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2016, Month.DECEMBER, 5), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2016, Month.DECEMBER, 6), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2016, Month.DECEMBER, 7), weekend);

        expectedSchedule.diet.put(LocalDate.of(2016, Month.DECEMBER, 8), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2016, Month.DECEMBER, 9), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2016, Month.DECEMBER, 10), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2016, Month.DECEMBER, 11), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2016, Month.DECEMBER, 12), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2016, Month.DECEMBER, 13), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2016, Month.DECEMBER, 14), weekend);

        expectedSchedule.diet.put(LocalDate.of(2016, Month.DECEMBER, 15), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2016, Month.DECEMBER, 16), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2016, Month.DECEMBER, 17), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2016, Month.DECEMBER, 18), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2016, Month.DECEMBER, 19), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2016, Month.DECEMBER, 20), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2016, Month.DECEMBER, 21), weekend);

        expectedSchedule.diet.put(LocalDate.of(2016, Month.DECEMBER, 22), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2016, Month.DECEMBER, 23), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2016, Month.DECEMBER, 24), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2016, Month.DECEMBER, 25), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2016, Month.DECEMBER, 26), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2016, Month.DECEMBER, 27), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2016, Month.DECEMBER, 28), weekend);

        expectedSchedule.diet.put(LocalDate.of(2016, Month.DECEMBER, 29), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2016, Month.DECEMBER, 30), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2016, Month.DECEMBER, 31), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2017, Month.JANUARY, 1), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2017, Month.JANUARY, 2), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2017, Month.JANUARY, 3), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2017, Month.JANUARY, 4), weekend);

        expectedSchedule.diet.put(LocalDate.of(2017, Month.JANUARY, 5), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2017, Month.JANUARY, 6), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2017, Month.JANUARY, 7), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2017, Month.JANUARY, 8), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2017, Month.JANUARY, 9), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2017, Month.JANUARY, 10), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2017, Month.JANUARY, 11), weekend);

        expectedSchedule.diet.put(LocalDate.of(2017, Month.JANUARY, 12), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2017, Month.JANUARY, 13), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2017, Month.JANUARY, 14), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2017, Month.JANUARY, 15), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2017, Month.JANUARY, 16), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2017, Month.JANUARY, 17), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2017, Month.JANUARY, 18), weekend);

        expectedSchedule.diet.put(LocalDate.of(2017, Month.JANUARY, 19), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2017, Month.JANUARY, 20), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2017, Month.JANUARY, 21), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2017, Month.JANUARY, 22), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2017, Month.JANUARY, 23), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2017, Month.JANUARY, 24), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2017, Month.JANUARY, 25), weekend);

        expectedSchedule.diet.put(LocalDate.of(2017, Month.JANUARY, 26), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2017, Month.JANUARY, 27), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2017, Month.JANUARY, 28), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2017, Month.JANUARY, 29), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2017, Month.JANUARY, 30), usualDay);
        expectedSchedule.diet.put(LocalDate.of(2017, Month.JANUARY, 31), usualDay);

        //2 given
        Goal goal = new Goal(FunctionalGoal.BE_ENDURANCE, new WeightGoal(WeightGoal.Goal.LOSE_WEIGHT, -7), 12);
        Athlete athlete = new Athlete(Sex.MALE, 29,109,187,0.20f, PhysicalCondition.STRONG,5, LifeStyle.LOW, Steroids.NO_STEROIDS);
        //4 when Mockito
        //1 then

        TrainingSchedule actualSchedule = new AICoach().getSchedule(athlete, goal);
        Assert.assertEquals(expectedSchedule, actualSchedule);

        TrainingSchedule actualDiet = new AICoach().getNutritionist(athlete, goal);
        Assert.assertEquals(expectedDiet, actualDiet);
    }

    @Test
    public void getSchedule_looseWeight_male2() throws Exception {

        //3 expected
        TrainingDay trainingDay1 = new TrainingDay(LocalDate.of(2016, Month.AUGUST, 1), true, "Відпрацьовую техніку", "Легке тренування", "user1");
        Exercise exercise11 = new Exercise();
        Exercise exercise12 = new Exercise();
        TrainingDay trainingDay2 = new TrainingDay(LocalDate.of(2016, Month.AUGUST, 3), true, "Силове тренування", "Середнє тренування", "user1");
        Exercise exercise21 = new Exercise();
        Exercise exercise22 = new Exercise();
        TrainingDay trainingDay3 = new TrainingDay(LocalDate.of(2016, Month.AUGUST, 5), false, "Відпрацьовую техніку", "Легке тренування", "user1");
        Exercise exercise31 = new Exercise();
        Exercise exercise32 = new Exercise();

        TrainingSchedule expected = new TrainingSchedule();
        expected.schedule.put(trainingDay1, Arrays.asList(exercise11, exercise12));
        expected.schedule.put(trainingDay2, Arrays.asList(exercise21, exercise22));
        expected.schedule.put(trainingDay3, Arrays.asList(exercise31, exercise32));

        //2 given
        Goal goal = new Goal(FunctionalGoal.BE_ENDURANCE, new WeightGoal(WeightGoal.Goal.LOSE_WEIGHT, -10), 12);
        Athlete athlete = new Athlete(Sex.MALE, 29,109,187,0.20f, PhysicalCondition.STRONG,5, LifeStyle.LOW, Steroids.NO_STEROIDS);
        //4 when Mockito
        //1 then
        TrainingSchedule actual = new AICoach().getSchedule(athlete, goal);
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void getSchedule_gainWeight_male() throws Exception {

        //3 expected
        TrainingDay trainingDay1 = new TrainingDay(LocalDate.of(2016, Month.AUGUST, 1), true, "Відпрацьовую техніку", "Легке тренування", "user1");
        Exercise exercise11 = new Exercise();
        Exercise exercise12 = new Exercise();

        TrainingSchedule expected = new TrainingSchedule();
        expected.schedule.put(trainingDay1, Arrays.asList(exercise11, exercise12));

        //2 given
        Goal goal = new Goal(FunctionalGoal.BE_ENDURANCE, new WeightGoal(WeightGoal.Goal.LOSE_WEIGHT, -10), 12);
        Athlete athlete = new Athlete(Sex.MALE, 29,109,187,0.20f, PhysicalCondition.STRONG,5, LifeStyle.LOW, Steroids.NO_STEROIDS);
        //4 when Mockito
        //1 then
        TrainingSchedule actual = new AICoach().getSchedule(athlete, goal);
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void getSchedule_gainWeight_female() throws Exception {

        //3 expected
        TrainingDay trainingDay1 = new TrainingDay(LocalDate.of(2016, Month.AUGUST, 1), true, "Відпрацьовую техніку", "Легке тренування", "user1");
        Exercise exercise11 = new Exercise();
        Exercise exercise12 = new Exercise();
        TrainingSchedule expected = new TrainingSchedule();
        expected.schedule.put(trainingDay1, Arrays.asList(exercise11, exercise12));

        //2 given
        Goal goal = new Goal(FunctionalGoal.BE_ENDURANCE, new WeightGoal(WeightGoal.Goal.LOSE_WEIGHT, -10), 12);
        Athlete athlete = new Athlete(Sex.MALE, 29,109,187,0.20f, PhysicalCondition.STRONG,5, LifeStyle.LOW, Steroids.NO_STEROIDS);
        //4 when Mockito
        //1 then
        TrainingSchedule actual = new AICoach().getSchedule(athlete, goal);
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void getSchedule_beStronger_female() throws Exception {

        //3 expected
        TrainingDay trainingDay1 = new TrainingDay(LocalDate.of(2016, Month.AUGUST, 1), true, "Відпрацьовую техніку", "Легке тренування", "user1");
        Exercise exercise11 = new Exercise();
        Exercise exercise12 = new Exercise();
        TrainingSchedule expected = new TrainingSchedule();
        expected.schedule.put(trainingDay1, Arrays.asList(exercise11, exercise12));

        //2 given
        Goal goal = new Goal(FunctionalGoal.BE_ENDURANCE, new WeightGoal(WeightGoal.Goal.LOSE_WEIGHT, -10), 12);
        Athlete athlete = new Athlete(Sex.MALE, 29,109,187,0.20f, PhysicalCondition.STRONG,5, LifeStyle.LOW, Steroids.NO_STEROIDS);
        //4 when Mockito
        //1 then
        TrainingSchedule actual = new AICoach().getSchedule(athlete, goal);
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void getSchedule_beStronger_male() throws Exception {

        //3 expected
        TrainingDay trainingDay1 = new TrainingDay(LocalDate.of(2016, Month.AUGUST, 1), true, "Відпрацьовую техніку", "Легке тренування", "user1");
        Exercise exercise11 = new Exercise();
        Exercise exercise12 = new Exercise();

        TrainingSchedule expected = new TrainingSchedule();
        expected.schedule.put(trainingDay1, Arrays.asList(exercise11, exercise12));

        //2 given
        Goal goal = new Goal(FunctionalGoal.BE_ENDURANCE, new WeightGoal(WeightGoal.Goal.LOSE_WEIGHT, -10), 12);
        Athlete athlete = new Athlete(Sex.MALE, 29,109,187,0.20f, PhysicalCondition.STRONG,5, LifeStyle.LOW, Steroids.NO_STEROIDS);
        //4 when Mockito
        //1 then
        TrainingSchedule actual = new AICoach().getSchedule(athlete, goal);
        Assert.assertEquals(expected, actual);
    }

}