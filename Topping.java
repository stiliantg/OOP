package OOP.Encapsulation.pizza;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String type, double grams) {
        this.setToppingType(type);
        this.weight = grams;
        this.setWeight(grams);
    }


    private void setToppingType(String toppingType) {
        this.toppingType = toppingType;
    }

    private void setWeight(double grams) {
        if (grams < 1 || grams > 50) {
            throw new IllegalArgumentException("Topping " + toppingType + "weight should be in the range [1..50].");
        }
        this.weight = grams;
    }

    private double getModifier() {
        switch (toppingType) {
            case "Meat":
                return 1.2;

            case "Veggies":
                return  0.8;

            case "Cheese":
                return  1.1;

            case "Sauce":
                return  0.9;
        }
        return 0;
    }

    public double calculateCalories() {
        return (weight * 2) * getModifier();
    }

    public String getToppingType() {
        return toppingType;
    }
}
