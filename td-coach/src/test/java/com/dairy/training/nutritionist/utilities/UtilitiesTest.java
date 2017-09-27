package com.dairy.training.nutritionist.utilities;

import com.dairy.training.athlete.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class UtilitiesTest {

    private Athlete dima;
    private Athlete zhenia;
    private Athlete nasta;
    private Athlete mama;

    @Before
    public void prepareAthletes() throws Exception {
        dima = new Athlete("Dima", Sex.MALE, 29, 109, 187, 0.20f, LifeStyle.LOW);
        zhenia = new Athlete("Zhenia", Sex.MALE, 32, 80, 175, 0.20f, LifeStyle.MIDDLE);
        nasta = new Athlete("Anastasiia", Sex.FEMALE, 26, 57, 167, 0.15f, LifeStyle.LOW);
        mama = new Athlete("Mama", Sex.FEMALE, 51, 109, 157, 0.45f, LifeStyle.LOW);
    }

    @Test
    public void minKcal_male() {
        System.out.print("\nМін ккал  " + Utilities.minKcal(dima));
        Assert.assertEquals(1922,Utilities.minKcal(dima));
    }

    @Test
    public void minKcal_female() {
        System.out.print("\nМін ккал  " + Utilities.minKcal(nasta));
        Assert.assertEquals(1005,Utilities.minKcal(nasta));
    }

    @Test
    public void maxDeficitKcal_male() {
        System.out.print("\nmaxDeficitKcal  " + Utilities.maxDeficitKcal(dima.getFatPercent()));
        Assert.assertEquals(620,Utilities.maxDeficitKcal(dima.getFatPercent()));

    }

    @Test
    public void maxDeficitKcal_female() {
        System.out.print("\nmaxDeficitKcal  " + Utilities.maxDeficitKcal(nasta.getFatPercent()));
        Assert.assertEquals(465,Utilities.maxDeficitKcal(nasta.getFatPercent()));

    }

    @Test
    public void calcNutrToGrammNutr() {

        System.out.print("\nПротеїн " + Utilities.calcGrammNutr(3000, 30, Utilities.PROTEIN_KCAL));
        System.out.print("\nВуглеводи " + Utilities.calcGrammNutr(3000, 15, Utilities.CARBOHYDRATES_KCAL));
        System.out.print("\nЖири " + Utilities.calcGrammNutr(1000, 30, Utilities.FAT_KCAL));

        Assert.assertEquals(245,Utilities.calcGrammNutr(2800, 35, Utilities.PROTEIN_KCAL));
        Assert.assertEquals(140,Utilities.calcGrammNutr(2800, 20, Utilities.CARBOHYDRATES_KCAL));
        Assert.assertEquals(93,Utilities.calcGrammNutr(2800, 30, Utilities.FAT_KCAL));

    }

    @Test
    public void allNeededKcal_male() {
        int kcal1 = Utilities.allNeededKcal(dima, CalculateKcal.HARRISBENEDKT);
        int kcal2 = Utilities.allNeededKcal(dima, CalculateKcal.MIFFLINSANCZHENOR);
        int kcal3 = Utilities.allNeededKcal(dima, CalculateKcal.KETCHMACARDL);

        System.out.print(dima.getName() + "\n" + kcal1 + " \n");
        System.out.print(kcal2 + " \n");
        System.out.print(kcal3 + " \n");

        Assert.assertEquals(3032,kcal1);
        Assert.assertEquals(2796,kcal2);
        Assert.assertEquals(2973,kcal3);
    }

    @Test
    public void allNeededKcal_female() {
        int kcal1 = Utilities.allNeededKcal(nasta, CalculateKcal.HARRISBENEDKT);
        int kcal2 = Utilities.allNeededKcal(nasta, CalculateKcal.MIFFLINSANCZHENOR);
        int kcal3 = Utilities.allNeededKcal(nasta, CalculateKcal.KETCHMACARDL);

        System.out.print(nasta.getName() + "\n" + kcal1 + " \n");
        System.out.print(kcal2 + " \n");
        System.out.print(kcal3 + " \n");

        Assert.assertEquals(3032,kcal1);
        Assert.assertEquals(2796,kcal2);
        Assert.assertEquals(2973,kcal3);
    }


}