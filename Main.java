package pizza;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Pizza
        String[] pizzaDetails = scanner.nextLine().split("\\s+");
        String pizzaName = pizzaDetails[1];
        int numberOfToppings = Integer.parseInt(pizzaDetails[2]);
        //Dough
        String[] doughDetails = scanner.nextLine().split("\\s+");
        String doughType = doughDetails[1];
        String doughBakingTechnique = doughDetails[2];
        double doughGrams = Double.parseDouble(doughDetails[3]);


        //Making the pizza
        try {
            Pizza pizza = new Pizza(pizzaName, numberOfToppings);
            Dough dough = new Dough(doughType, doughBakingTechnique, doughGrams);
            pizza.setDough(dough);
            String input = scanner.nextLine();
            //Reading and acquiring toppings
            while (!input.equals("END")) {
                String[] toppingDetails = input.split("\\s+");
                String toppingType = toppingDetails[1];
                double grams = Double.parseDouble(toppingDetails[2]);

                Topping topping = new Topping(toppingType, grams);
                pizza.addTopping(topping);

                input = scanner.nextLine();
            }
            System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
