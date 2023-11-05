package org.velezreyes.quiz.question6;

import java.util.HashMap;
import java.util.Map;

public class VendingMachineImpl implements VendingMachine {
    private int moneyInserted;
    private Map<String, Drink> drinks;

    public VendingMachineImpl() {
        moneyInserted = 0;
        drinks = new HashMap<>();
        // Agrega las bebidas disponibles aquí
        drinks.put("ScottCola", new ScottCola());
        drinks.put("KarenTea", new KarenTea());
    }

    public static VendingMachine getInstance() {
        return new VendingMachineImpl();
    }

    @Override
    public void insertQuarter() {
        moneyInserted += 25;
    }

    @Override
    public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException {
        Drink drink = drinks.get(name);
        if (drink == null) {
            throw new UnknownDrinkException("Unknown drink: " + name);
        }

        if (moneyInserted >= drink.getPriceInCents()) {
            moneyInserted -= drink.getPriceInCents();
            return drink;
        } else {
            throw new NotEnoughMoneyException("Not enough money inserted.");
        }
    }
}
