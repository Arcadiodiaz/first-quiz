package org.velezreyes.quiz.question6;

public class KarenTea implements Drink {
    @Override
    public String getName() {
        return "KarenTea";
    }

    @Override
    public boolean isFizzy() {
        return false;
    }

    public int getPriceInCents() {
        return 100;
    }
}