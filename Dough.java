package OOP.Encapsulation.pizza;

public class Dough {
    private String flourType;
    private double weight;
    private String bakingTechnique;

    public Dough(String type, String bakingTechnique, double weight) {
        this.setFlourType(type);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (!flourType.equals("White") && !flourType.equals("Wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }


    private void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechnique.equals("Crispy") && !bakingTechnique.equals("Chewy") && !bakingTechnique.equals("Homemade")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }
    private double getTypeModifier() {
        switch (this.flourType) {
            case "white":
                return  1.5;

            case "Wholegrain":
                return  1.0;
        }
        return 0;
    }

    private double getTechniqueModifier() {
        switch (this.bakingTechnique) {
            case "Crispy":
                return  0.9;

            case "Chewy":
                return 1.1;

            case "Homemade":
                return  1.0;
        }
        return 0;
    }
    public double calculateCalories() {
        return (weight * 2) * getTypeModifier() * getTechniqueModifier();
    }
}


