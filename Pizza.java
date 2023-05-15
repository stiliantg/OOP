package OOP.Encapsulation.pizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private List<Topping> toppings;
    private Dough dough;


    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
    }

    private void setName(String name) {
        if (name.equals("") || name.equals(" ") || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    private void setToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>();
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return this.name;
    }

    public void addTopping(Topping topping) {
        if (!topping.getToppingType().equals("Meat") && !topping.getToppingType().equals("Veggies") && !topping.getToppingType().equals("Cheese") && !topping.getToppingType().equals("Sauce")) {
            throw new IllegalArgumentException("Cannot place " + topping.getToppingType() + " on top of your pizza.");
        }
        this.toppings.add(topping);
    }


    public double getOverallCalories() {
        return dough.calculateCalories() + toppings.stream().mapToDouble(Topping::calculateCalories).sum();
    }
}
