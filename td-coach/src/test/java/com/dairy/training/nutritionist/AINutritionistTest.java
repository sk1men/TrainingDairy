package com.dairy.training.nutritionist;

import com.dairy.training.nutritionist.utilities.Nutritions;
import com.dairy.training.nutritionist.utilities.Utilities;
import com.dairy.training.schedule.Meal;
import com.dairy.training.schedule.MealCourse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.time.Month.DECEMBER;
import static java.time.Month.JANUARY;

public class AINutritionistTest {

    Map<LocalDate, List<Meal>> actualDiet = new HashMap<>();
    int kcall = 0;
    int potPerst = 0;
    int fatPerst = 0;
    int carbPerst = 0;
    LocalDate end = null;
    LocalDate start = null;
    List<MealCourse> mealGroupName = null;

    List<Meal> weekend = Arrays.asList(
            new Meal(LocalTime.of(8, 0), Arrays.asList(
                    new MealCourse("Творог с курагою", 400),
                    new MealCourse("Конфеты", 400))),
            new Meal(LocalTime.of(12, 0), Arrays.asList(
                    new MealCourse("Пица", 250),
                    new MealCourse("Жаренная курица", 350),
                    new MealCourse("Жаренная картошка", 200))),
            new Meal(LocalTime.of(16, 0), Arrays.asList(
                    new MealCourse("Говядина", 20),
                    new MealCourse("Салат", 250))),
            new Meal(LocalTime.of(21, 0), Arrays.asList(
                    new MealCourse("Омлет", 20),
                    new MealCourse("Салат", 250))));

    List<Meal> usualDay = Arrays.asList(
            new Meal(LocalTime.of(8, 0), Arrays.asList(
                    new MealCourse("Творог с курагою", 400),
                    new MealCourse("Хлеб", 150))),
            new Meal(LocalTime.of(11, 0), Arrays.asList(
                    new MealCourse("Творог", 400))),
            new Meal(LocalTime.of(14, 0), Arrays.asList(
                    new MealCourse("Гречка", 250),
                    new MealCourse("Курятина", 300))),
            new Meal(LocalTime.of(16, 0), Arrays.asList(
                    new MealCourse("Омлет", 250),
                    new MealCourse("Салат", 250))),
            new Meal(LocalTime.of(21, 0), Arrays.asList(
                    new MealCourse("Омлет", 250),
                    new MealCourse("Салат", 250))));

    @Before
    public void prepareDiet() throws Exception {
        kcall = 0;
        potPerst = 0;
        fatPerst = 0;
        carbPerst = 0;
        end = LocalDate.of(2016, DECEMBER, 1);
        start = LocalDate.of(2017, JANUARY, 31);
        mealGroupName = Arrays.asList(new MealCourse("Творог с курагою"),
                new MealCourse("Творог с курагою"),
                new MealCourse("Творог"),
                new MealCourse("Гречка"),
                new MealCourse("Курятина"),
                new MealCourse("Омлет"),
                new MealCourse("Салат"),
                new MealCourse("Хлеб"),
                new MealCourse("Конфеты"),
                new MealCourse("Пица"),
                new MealCourse("Жаренная курица"),
                new MealCourse("Жаренная картошка"),
                new MealCourse("Говядина"));
    }


    @Test
    public void createOwnDiet() throws Exception {

        actualDiet.put(LocalDate.of(2016, DECEMBER, 1), usualDay);
        actualDiet.put(LocalDate.of(2016, DECEMBER, 2), usualDay);
        actualDiet.put(LocalDate.of(2016, DECEMBER, 3), usualDay);
        actualDiet.put(LocalDate.of(2016, DECEMBER, 4), usualDay);
        actualDiet.put(LocalDate.of(2016, DECEMBER, 5), usualDay);
        actualDiet.put(LocalDate.of(2016, DECEMBER, 6), usualDay);
        actualDiet.put(LocalDate.of(2016, DECEMBER, 7), weekend);

        actualDiet.put(LocalDate.of(2016, DECEMBER, 8), usualDay);
        actualDiet.put(LocalDate.of(2016, DECEMBER, 9), usualDay);
        actualDiet.put(LocalDate.of(2016, DECEMBER, 10), usualDay);
        actualDiet.put(LocalDate.of(2016, DECEMBER, 11), usualDay);
        actualDiet.put(LocalDate.of(2016, DECEMBER, 12), usualDay);
        actualDiet.put(LocalDate.of(2016, DECEMBER, 13), usualDay);
        actualDiet.put(LocalDate.of(2016, DECEMBER, 14), weekend);

        actualDiet.put(LocalDate.of(2016, DECEMBER, 15), usualDay);
        actualDiet.put(LocalDate.of(2016, DECEMBER, 16), usualDay);
        actualDiet.put(LocalDate.of(2016, DECEMBER, 17), usualDay);
        actualDiet.put(LocalDate.of(2016, DECEMBER, 18), usualDay);
        actualDiet.put(LocalDate.of(2016, DECEMBER, 19), usualDay);
        actualDiet.put(LocalDate.of(2016, DECEMBER, 20), usualDay);
        actualDiet.put(LocalDate.of(2016, DECEMBER, 21), weekend);

        actualDiet.put(LocalDate.of(2016, DECEMBER, 22), usualDay);
        actualDiet.put(LocalDate.of(2016, DECEMBER, 23), usualDay);
        actualDiet.put(LocalDate.of(2016, DECEMBER, 24), usualDay);
        actualDiet.put(LocalDate.of(2016, DECEMBER, 25), usualDay);
        actualDiet.put(LocalDate.of(2016, DECEMBER, 26), usualDay);
        actualDiet.put(LocalDate.of(2016, DECEMBER, 27), usualDay);
        actualDiet.put(LocalDate.of(2016, DECEMBER, 28), weekend);

        actualDiet.put(LocalDate.of(2016, DECEMBER, 29), usualDay);
        actualDiet.put(LocalDate.of(2016, DECEMBER, 30), usualDay);
        actualDiet.put(LocalDate.of(2016, DECEMBER, 31), usualDay);
        actualDiet.put(LocalDate.of(2017, JANUARY, 1), usualDay);
        actualDiet.put(LocalDate.of(2017, JANUARY, 2), usualDay);
        actualDiet.put(LocalDate.of(2017, JANUARY, 3), usualDay);
        actualDiet.put(LocalDate.of(2017, JANUARY, 4), weekend);

        actualDiet.put(LocalDate.of(2017, JANUARY, 5), usualDay);
        actualDiet.put(LocalDate.of(2017, JANUARY, 6), usualDay);
        actualDiet.put(LocalDate.of(2017, JANUARY, 7), usualDay);
        actualDiet.put(LocalDate.of(2017, JANUARY, 8), usualDay);
        actualDiet.put(LocalDate.of(2017, JANUARY, 9), usualDay);
        actualDiet.put(LocalDate.of(2017, JANUARY, 10), usualDay);
        actualDiet.put(LocalDate.of(2017, JANUARY, 11), weekend);

        actualDiet.put(LocalDate.of(2017, JANUARY, 12), usualDay);
        actualDiet.put(LocalDate.of(2017, JANUARY, 13), usualDay);
        actualDiet.put(LocalDate.of(2017, JANUARY, 14), usualDay);
        actualDiet.put(LocalDate.of(2017, JANUARY, 15), usualDay);
        actualDiet.put(LocalDate.of(2017, JANUARY, 16), usualDay);
        actualDiet.put(LocalDate.of(2017, JANUARY, 17), usualDay);
        actualDiet.put(LocalDate.of(2017, JANUARY, 18), weekend);

        actualDiet.put(LocalDate.of(2017, JANUARY, 19), usualDay);
        actualDiet.put(LocalDate.of(2017, JANUARY, 20), usualDay);
        actualDiet.put(LocalDate.of(2017, JANUARY, 21), usualDay);
        actualDiet.put(LocalDate.of(2017, JANUARY, 22), usualDay);
        actualDiet.put(LocalDate.of(2017, JANUARY, 23), usualDay);
        actualDiet.put(LocalDate.of(2017, JANUARY, 24), usualDay);
        actualDiet.put(LocalDate.of(2017, JANUARY, 25), weekend);

        actualDiet.put(LocalDate.of(2017, JANUARY, 26), usualDay);
        actualDiet.put(LocalDate.of(2017, JANUARY, 27), usualDay);
        actualDiet.put(LocalDate.of(2017, JANUARY, 28), usualDay);
        actualDiet.put(LocalDate.of(2017, JANUARY, 29), usualDay);
        actualDiet.put(LocalDate.of(2017, JANUARY, 30), usualDay);
        actualDiet.put(LocalDate.of(2017, JANUARY, 31), usualDay);

        Map<LocalDate, List<Meal>> expectedDiet = AINutritionist.createOwnDiet(kcall, potPerst, fatPerst, carbPerst, end, start, mealGroupName);

        int actualKcal = Utilities.calcNutrFromDiet(actualDiet, Nutritions.KCAL);
        int expectedKcal = Utilities.calcNutrFromDiet(expectedDiet, Nutritions.KCAL);
        int actualProtein = Utilities.calcNutrFromDiet(actualDiet, Nutritions.PROTEIN);
        int expectedProtein = Utilities.calcNutrFromDiet(expectedDiet, Nutritions.PROTEIN);
        int actualFat = Utilities.calcNutrFromDiet(actualDiet, Nutritions.FAT);
        int expectedFat = Utilities.calcNutrFromDiet(expectedDiet, Nutritions.FAT);
        int actualCarbohydrates = Utilities.calcNutrFromDiet(actualDiet, Nutritions.CARBOHYDRATES);
        int expectedCarbohydrates = Utilities.calcNutrFromDiet(expectedDiet, Nutritions.CARBOHYDRATES);

        Assert.assertTrue(actualKcal <= expectedKcal + 200 && actualKcal >= expectedKcal - 200);
        Assert.assertTrue(actualProtein <= expectedProtein + 15 && actualProtein >= expectedProtein - 15);
        Assert.assertTrue(actualFat <= expectedFat + 15 && actualFat >= expectedFat - 15);
        Assert.assertTrue(actualCarbohydrates <= expectedCarbohydrates + 15 && actualCarbohydrates >= expectedCarbohydrates - 15);


        //щоб вишло +-200ккал і +-15 грамм в БЖУ
        //createOwnDiet(weightGoal.getKcall(), weightGoal.getPpotPerst(),
        // weightGoal.getFatPerst(), weightGoal.getCarbPerst(),
        //weightGoal.getEnd(), weightGoal.getStart(), weightGoal.getMealGroupName());


    }

}