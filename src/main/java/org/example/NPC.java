package org.example;

import java.util.Random;

import static org.example.NPC.GRADE.*;

public class NPC {

    enum GRADE {
        NONE, D, C, B, A, S
    }

    private int level;

    private final GRADE[][] gradeGrid = {
         // 60%40%10% 5% 1%
            {D, C, B, A, S},  //15-35 лвл
            {C, D, B, A, S},  //36-55 лвл
            {B, C, A, D, S},  //56-65 лвл
            {B, A, S, C, D},  //66-79 лвл
            {A, S, B, C, D},  //80-85 лвл
    };

    public NPC(int level) {
        this.level = level;
    }

    public GRADE onKill() {
        int lvl = this.level;
        if (lvl >= 15 && lvl < 35) {
            return getRandomDrop(gradeGrid[0]);
        } else if (lvl >= 35 && lvl < 55) {
            return getRandomDrop(gradeGrid[1]);
        } else if (lvl >= 55 && lvl < 65) {
            return getRandomDrop(gradeGrid[2]);
        } else if (lvl >= 65 && lvl < 79) {
            return getRandomDrop(gradeGrid[3]);
        } else if (lvl >= 79) {
            return getRandomDrop(gradeGrid[4]);
        }
        return NONE;
    }

    private GRADE getRandomDrop(GRADE[] comb) {
        int rnd = (int) (Math.random() * 100);
        if (rnd <= 1) {
            return drop(comb[4]);
        } else if (rnd <= 5) {
            return drop(comb[3]);
        } else if (rnd <= 10) {
            return drop(comb[2]);
        } else if (rnd <= 40) {
            return drop(comb[1]);
        } else {
            return drop(comb[0]);
        }
    }

    private GRADE drop(GRADE grade) {
        return grade;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
