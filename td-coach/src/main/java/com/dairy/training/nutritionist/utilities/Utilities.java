package com.dairy.training.nutritionist.utilities;

import com.dairy.training.athlete.Athlete;
import com.dairy.training.athlete.Sex;
import com.dairy.training.schedule.Meal;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Utilities {
    //белки – 15-35%, жиры – 20-35%, углеводы – 40-65%

// А теперь рассчитываем стандарт БЖУ, чтобы похудеть (берем за основу калорийность в 1200 ккал):
// 30-35% всего рациона отводим белкам (360 ккал или 90 г минимум),
// 10-15% «отдаем» жирам (120 ккал или 13 г минимум),
// 45-50% – углеводы (480 ккал или 120 г минимум).

    public final static int PROTEIN_KCAL = 4;
    public final static int CARBOHYDRATES_KCAL = 4;
    public final static int FAT_KCAL = 9;

    public final static float PROTEIN_LW = 0.4f;
    public final static float PROTEIN_GW = 0.4f;
    public final static float PROTEIN_BS = 0.3f;

    public final static float FAT__LW = 0.1f;
    public final static float FAT_GW = 0.2f;
    public final static float FAT_BS = 0.2f;

    public final static float CARBOHYDRATES__LW = 0.4f;
    public final static float CARBOHYDRATES_GW = 0.60f;
    public final static float CARBOHYDRATES_BS = 0.5f;

    // todo список блюда -пыдбрати пропорц-кылькысть прийомыв-розбити на часи прийому.
    static int calculateKcalHarrisBenedkt(Athlete athlete) {
        //- робили в 1911 для молодих худих людей в холодних лабораторіях 3 місце видає більше калорій чим треба
//     todo  = (66 + (13.7 * 109) + (5 + 187)  - (6.76 * 29) )* 1.2 = 2757
        int bmr = 0;
        if (athlete.getSex() == Sex.MALE) {
            bmr = (int) (66 + (13.7 * athlete.getWeight()) + (5 * athlete.getHeight()) - (6.76 * athlete.getAge()));
        } else {
            bmr = (int) (655 + (9.6 * athlete.getWeight()) + (1.8 * athlete.getHeight()) - (4.7 * athlete.getAge()));
        }
        return bmr;

//http://fitfan.ru/novichkam/795-bmr.html
//        Для мужчин: BMR = 66 + [13.7 x вес (кг)] + [5 x рост (см)] - [6.76 x возраст (в годах)]
//        Для женщин: BMR = 655 + [9.6 x вес (кг)] + [1.8 x рост (см)] - [4.7 x возраст (в годах)]
//   http://sportwiki.to/%D0%9A%D0%B0%D0%BB%D0%BE%D1%80%D0%B8%D0%B9%D0%BD%D0%BE%D1%81%D1%82%D1%8C_%D1%80%D0%B0%D1%86%D0%B8%D0%BE%D0%BD%D0%B0_%D1%81%D0%BF%D0%BE%D1%80%D1%82%D1%81%D0%BC%D0%B5%D0%BD%D0%B0
    }

    static int countKcalMifflinSanCzhenor(Athlete athlete) {//Миффлина - Сан Жеора
        //todo стан атлета як правильно задавати, кожен місяць він змінюється, як його задавати? наприклад вага, чи писати лише ті що є по факту і строрити в БД  таблицю дата-атлет і брати звідти?
        // не враховує процент жиру 2 місце
        int bmr = 0;
        switch (athlete.getSex()) {
            case MALE:
                bmr = (int) (9.99 * athlete.getWeight() + 6.25 * athlete.getHeight()
                        - 4.92 * athlete.getAge() + 5);//величина основного обмена
                break;
            case FEMALE:
                bmr = (int) (9.99 * athlete.getWeight() + 6.25 * athlete.getHeight()
                        - 4.92 * athlete.getAge() - 161);
                break;
        }
        return bmr;

        //todo = (9,99 * 109) + (6.25 * 187) – (4,92 * 29) + 5 x 1,2 = 2120

//        2. Доработанный вариант формулы Миффлина-Сан Жеора
//        Для мужчины: (9,99 * вес (кг)) + (6.25 * рост (см)) – (4,92 * возраст) + 5 x A
//        Для женщины:  (9,99 * вес(кг)) + (6.25 * рост (см)) – (4,92 * возраст) – 161 x A

//        ВОО = 9,99 * 65,5 (кг) + 6.25 * 166 (см) – 4,92 * 38 – 161 = 1344 кКал
//                СДД = ВОО * 0,1 = 134,4 кКал
//                СПК = (1344 + 134,4) * 1,375 = 2032,8 кКал.
//        http://forum.hiki-soft.ru/viewtopic.php?f=49&t=386

//   суточная норма калорий не должна быть меньше: вес (кг) ÷ 0,450 х 8.
//        -нужная калорийность/4*0,25 = количество белка (г)
//      — нужная калорийность/9*0,35 = количество жира (г)
//      — нужная калорийность/4*0,4 = количество углеводов (г)

//        Для мужчин:
//% = 495 / (1,0324-0,19077(log(талия-шея)) + 0,15456(log(рост))) - 450
//
//        Для женщин:
//% = 495/(1,29579-0,35004(log(талия+бедра -шея))+0.22100(log(рост))) - 450
//        http://beregifiguru.ru/%D0%9A%D0%B0%D0%BB%D1%8C%D0%BA%D1%83%D0%BB%D1%8F%D1%82%D0%BE%D1%80%D1%8B/%D0%A0%D0%B0%D1%81%D1%87%D0%B5%D1%82-%D0%BF%D1%80%D0%BE%D1%86%D0%B5%D0%BD%D1%82%D0%B0-%D0%B6%D0%B8%D1%80%D0%B0
        //http://beregifiguru.ru/%D0%9A%D0%B0%D0%BB%D1%8C%D0%BA%D1%83%D0%BB%D1%8F%D1%82%D0%BE%D1%80%D1%8B/%D0%A0%D0%B0%D1%81%D1%87%D0%B5%D1%82-%D0%BA%D0%B0%D0%BB%D0%BE%D1%80%D0%B8%D0%B9
    }

    static int countKcalKetchMacArdl(Athlete athlete) {//Кэтча - МакАрдла
// с большей точностью показывает суточную потребность в калориях (СПК) для очень мускулистых или, наоборот, страдающих ожирением людей.
        //BMR(мужчины или женщины) = (370 + (21.6 x LBM))*lifeStyleIndex
        //todo = (370 + (21.6 x 87.2))*1.2 = 2703    87 = 109-20%

        float lbm = athlete.getWeight() - (athlete.getWeight() * athlete.getFatPercent());
        int bmr = (int) (370 + (21.6 * lbm));

        return bmr;
    }

    public static int allNeededKcal(Athlete athlete, CalculateKcal formula) {
        int bmr = 0;
        switch (formula) {
            case HARRISBENEDKT:
                bmr = calculateKcalHarrisBenedkt(athlete);
                break;
            case MIFFLINSANCZHENOR:
                bmr = countKcalMifflinSanCzhenor(athlete);
                break;
            case KETCHMACARDL:
                bmr = countKcalKetchMacArdl(athlete);
                break;
        }
        int sdd = (int) (bmr + (bmr * 0.1));//специфическое динамическое действие
        return (int) (sdd * athlete.getLifeStyle().getCoef());//Суточная потребность в калориях
    }

    public static int maxDeficitKcal(float percent) {
        // минимум на 500, но не более, чем на 1000
        return (int) (percent * 100 * 31);
    }

    public static int minKcal(Athlete athlete) {
        //не рекомендует опускать уровень калорий ниже 1200 в день для женщин, и 1800 в день для мужчин.
        return (int) (toPound(athlete.getWeight()) * 8);
    }

    public static float toPound(float kg) {
        return (float) (kg / 0.453592);
    }

    public static int calcGrammNutr(int kcal, int percent, int nutr) {
        return (kcal * percent / 100) / nutr;
    }

    public static int calcNutrFromMeal(List<Meal> meals, Nutritions nutritions) {
        float nutr = 0;

        return meals.stream().mapToInt((Meal meal) -> {
            switch (nutritions) {
                case PROTEIN:
                    return meal.getProtein();
                case CARBOHYDRATES:
                    return meal.getCarbohydrates();
                case FAT:
                    return meal.getFat();
                case KCAL:
                    return meal.getKсal();
            }
            return 0;
        }).sum();

    }

    public static int calcNutrFromDiet(Map<LocalDate, List<Meal>> meals, Nutritions nutritions) {
        return meals.values().stream().mapToInt(e -> Utilities.calcNutrFromMeal(e, nutritions)).sum();
//        return meals.values().stream().flatMap(Collection::stream).mapToInt(
//                meal -> {
//                    switch (nutritions) {
//                        case PROTEIN:
//                            return meal.getProtein();
//                        case CARBOHYDRATES:
//                            return meal.getCarbohydrates();
//                        case FAT:
//                            return meal.getFat();
//                        case KCAL:
//                            return meal.getKсal();
//                    }
//                    return 0;
//                }
//        ).sum();
    }


}
//  Value Object — это полноценный член вашей доменной модели https://habrahabr.ru/post/268371/#comment_8604041
//