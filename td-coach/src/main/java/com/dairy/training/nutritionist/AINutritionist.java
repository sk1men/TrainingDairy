package com.dairy.training.nutritionist;

import com.dairy.training.athlete.Athlete;
import com.dairy.training.athlete.Goal;
import com.dairy.training.athlete.WeightGoal;
import com.dairy.training.nutritionist.utilities.Utilities;
import com.dairy.training.schedule.Meal;
import com.dairy.training.schedule.MealCourse;
import com.dairy.training.schedule.TrainingSchedule;

import java.time.LocalDate;
import java.util.*;

public class AINutritionist implements Nutritionist {

    public Map<LocalDate, List<Meal>> diet;
    // получити шаблон дієти (БД з продуками и складниками(приоритетність), задати пропоції)
    //редагувати шаблон
    //на вход я даю свої улюблені продукти, і часи або рази прийому  і з них скласти дієту під ціль
    //аналізувати.

    @Override
    public TrainingSchedule getNutritionist(Athlete athlete, Goal goal) {
        WeightGoal weightGoal = goal.getWeightGoal();
        switch (weightGoal.getGoal()) {
            case CREATE_OWN_DIET:
                createOwnDiet(weightGoal.getKcall(), weightGoal.getPpotPerst(), weightGoal.getFatPerst(), weightGoal.getCarbPerst(),
                        weightGoal.getEnd(), weightGoal.getStart(), weightGoal.getMealGroupName());
                break;
            case LOSE_WEIGHT:
                loseWeight(athlete);
                break;
            case GAIN_WEIGHT:
                gainWeight(athlete);
                break;
            case GET_HEALTHY_DIET:
                getHealthyDiet(athlete);
                break;
            default:
                System.out.println("Invalid goal");
                break;
        }
        return null;
    }

    public static Map<LocalDate, List<Meal>> createOwnDiet(int kcall, int potPerst, int fatPerst, int carbPerst, LocalDate end, LocalDate start, List<MealCourse> mealGroupName) {
        int prot = Utilities.calcGrammNutr(kcall, potPerst, Utilities.PROTEIN_KCAL);
        int fat = Utilities.calcGrammNutr(kcall, fatPerst, Utilities.FAT_KCAL);
        int carb = Utilities.calcGrammNutr(kcall, carbPerst, Utilities.CARBOHYDRATES_KCAL);

        for (MealCourse mealCourse : mealGroupName) {

//            Set yourHashSet = new HashSet<mealCourse>());
//
//            List sortedList = new ArrayList(yourHashSet);
//            Collections.sort(sortedList);

           /* HashSet myHashSet = new HashSet();
            myHashSet.add(45);
            myHashSet.add(12);

            TreeSet myTreeSet = new TreeSet();
            myTreeSet.addAll(myHashSet);
            System.out.println(myTreeSet);*/

//
//            TreeSet<FullName> names = new TreeSet<FullName>(new SortByLastName());

            TreeSet<mealGroupName> як відсортувати список.Друга структура
            if (mealCourse.proteinAll >)

//                // TreeSet
//                Set<ObjectName> sortedSet = new TreeSet<ObjectName>(new Comparator<ObjectName>() {
//                    public int compare(ObjectName o1, ObjectName o2) {
//                        return o1.toString().compareTo(o2.toString());
//                    }
//                });
//            sortedSet.addAll(unsortedSet);

        }
        // получити блюда і перебирати вагу і нутрієнти + 3 продукти БЖУ
        // придумати аглогитм... є кількість нутрієнтів знайти - вагу продуктів

        // Знайти загальну вагу нутрієнтів а потім розбити її на прийоми
        // Відсортувати що зранку а що ввечері приймати


        return null;
    }


    private TrainingSchedule getHealthyDiet(Athlete athlete) {
        return null;
    }

    private TrainingSchedule beSame(Athlete athlete) {
        return null;
    }

    private TrainingSchedule gainWeight(Athlete athlete) {
        return null;
    }

    private TrainingSchedule loseWeight(Athlete athlete) {
        return null;
    }

}


public class SortByNutr implements Comparator<MealCourse> {
    @Override
    public int compare(MealCourse mc1, MealCourse mc2) {
        return mc1.getProteinAll().compareTo(mc2.getProteinAll());
    }
}

//        class Main {
//            public static void main(String[] args) {
//                java.util.Random rand = new java.util.Random();
//                MyClass[] a = new MyClass[10];
//                for(int i = 0; i < 10; i++)
//                {
//                    a[i] = new MyClass();
//                    a[i].x = rand.nextInt(100);
//                }
//                java.util.Arrays.sort(a);
//                for(int i = 0; i < 10; i++)
//                    System.out.println(a[i].x);
//            }
//        }
//
//        class MyClass implements Comparable<Object>{
//            int x;
//            public int compareTo(Object o) {
//                return x - ((MyClass)o).x;
//            }
//        }


   /* public List<Element> getMainList() {
        ArrayList<Element> birthDateList = new ArrayList<Element>(getMainMap().values());
        Collections.sort(birthDateList, new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o1.getBirthDate().compareTo(o2.getBirthDate());
            }
        });
        return birthDateList;
    }*/

//    public List<Element> getMainList() {
//        List<Element> valueList = new ArrayList<Element>(getMainMap().values());
//        Collections.sort(valueList, new Comparator<Element>() {
//            @Override
//            public int compare(Element o1, Element o2) {
//                return o1.getBirthDate().compareTo(o2.getBirthDate());
//            }
//        });
//        return valueList;
//    }

//   map.entrySet().stream()
//           .sorted((a, b) -> a.getValue().getBirthDate().compareTo(b.getValue().getBirthDate()))
//           .collect(Collectors.toList());

//class Item {
//    Object key;
//    Object value;
//    Item(Object k, Object v) {
//        key = k; value = v;
//    }
//}
//    List<Item> list = new ArrayList<Item>();
//list.add(new Item("A", "a"));
//        list.add(new Item("B", "b"));
//        list.add(new Item("B", "c"));
//        list.add(new Item("C", "c"));

//        Collections.sort(list, new Comparator<Item>() {
//        int compare(Item o1, Item o2) {
//        return o1.key.compareTo(o2.key);
//        }
//        });