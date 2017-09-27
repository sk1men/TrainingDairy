package com.dairy.training.athlete;

public class Athlete {
    //todo  ЧИ потрібно залишити в пакеті цей клас а інше винести в окремий? типу LifeStyle і інші допоміжні?
    //fixme  заперти в пыдпакети
    //todo якщо в мене я щоденик і дані міняться з дати до дати, мені краще створити клас щоденик чи тут зробити поле дата
    //fixme  зробити имя и класс щоденик в тренера де тримати стан атлету

    String name;
    Sex sex;
    int age;
    float weight;
    float height;

//    Anthropometry anthropometry;

    PhysicalCondition physicalCondition;
    float fatPercent;
    float experience;
    LifeStyle lifeStyle;
    Steroids useSteroids;

    public Athlete(String name, Sex sex, int age, float weight, float height, float fatPercent, LifeStyle lifeStyle){
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.fatPercent = fatPercent;
        this.lifeStyle = lifeStyle;
    }

    public Athlete(Sex sex, int age, float weight, float height, float fatPercent,/* Anthropometry anthropometry,*/ PhysicalCondition physicalCondition, float experience, LifeStyle lifeStyle, Steroids useSteroids) {
        this.sex = sex;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.fatPercent = fatPercent;
//        this.anthropometry = anthropometry;
        this.physicalCondition = physicalCondition;
        this.experience = experience;
        this.lifeStyle = lifeStyle;
        this.useSteroids = useSteroids;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public float getWeight() {
        return weight;
    }

    public float getHeight() {
        return height;
    }

    public LifeStyle getLifeStyle() {
        return lifeStyle;
    }

    public float getFatPercent() {
        return fatPercent;
    }
}
