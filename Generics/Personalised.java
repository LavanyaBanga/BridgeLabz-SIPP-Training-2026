interface MealPlan {
    void generatePlan();
}

class VegetarianMeal implements MealPlan {
    public void generatePlan() {
        System.out.println("Vegetarian Meal Plan: Paneer, Dal, Rice, Salad");
    }
}

class VeganMeal implements MealPlan {
    public void generatePlan() {
        System.out.println("Vegan Meal Plan: Tofu, Fruits, Vegetables");
    }
}

class KetoMeal implements MealPlan {
    public void generatePlan() {
        System.out.println("Keto Meal Plan: Eggs, Avocado, Nuts");
    }
}

class HighProteinMeal implements MealPlan {
    public void generatePlan() {
        System.out.println("High Protein Meal Plan: Chicken, Eggs, Pulses");
    }
}

class Meal<T extends MealPlan> {
    T mealPlan;

    Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    void showPlan() {
        mealPlan.generatePlan();
    }
}

public class Main {
    static <T extends MealPlan> void validateAndGenerate(T meal) {
        System.out.println("Meal plan validated successfully.");
        meal.generatePlan();
    }

    public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeal = new Meal<>(new VegetarianMeal());
        vegMeal.showPlan();

        validateAndGenerate(new VeganMeal());
        validateAndGenerate(new KetoMeal());
    }
}
