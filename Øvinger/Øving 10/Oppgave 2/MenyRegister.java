import java.util.ArrayList;

/**
 * Class representing a restaurant's menu register. This class stores a central list of all dishes
 * and allows creating menus that reference those dishes. It also provides methods to search for
 * dishes by name or type across all dishes.
 * Did this so theyre searchable across menus.
 * @author Dennis Moe
 */
public class MenyRegister {

    private final ArrayList<Dish> foodList; // Central list of all dishes. 
                // ^ ArrayList<> is a dynamic array, i.e. does not have a static size.
    private final ArrayList<Meny> menus; // List of all menus.

    /**
     * Constructor for creating the MenyRegister with an empty dish list and menu list.
     */
    public MenyRegister() {
        this.foodList = new ArrayList<>();
        this.menus = new ArrayList<>();
    }

    /**
     * Registers a new dish and adds it to the central foodList.
     * 
     * @param foodName  The name of the dish.
     * @param foodType  The type of the dish (Starter, Main Course, Dessert, etc.).
     * @param foodPrice The price of the dish.
     * @param foodRecipe The recipe of the dish.
     */
    public void registerNewDish(String foodName, String foodType, double foodPrice, String foodRecipe) {
        foodList.add(new Dish(foodName, foodType, foodPrice, foodRecipe)); // Adds it to foodlist.
    }

    /**
     * Creates a new menu consisting of selected dishes from the foodList.
     * 
     * @param selectedDishes The dishes that make up the new menu. Dynamic array size.
     * @param menuName       The name of the new menu.
     */
    public void createNewMenu(ArrayList<Dish> selectedDishes, String menuName) {
        menus.add(new Meny(selectedDishes, menuName));
    }

    /**
     * Searches for a dish by name in the central foodList.
     * 
     * @param foodName The name of the dish to find.
     * @return The dish if found, otherwise null.
     */
    public Dish findDishByName(String foodName) {
        for (Dish dish : foodList) {
            if (dish.getFoodName().equalsIgnoreCase(foodName)) {
                return dish;
            }
        }
        return null; // Dish not found
    }

    /**
     * Finds all dishes of a given type (e.g., "Starter", "Main Course") in the central foodList.
     * 
     * @param foodType The type of dish to find.
     * @return An ArrayList of matching dishes.
     */
    public ArrayList<Dish> findDishesByType(String foodType) {
        ArrayList<Dish> matchingDishes = new ArrayList<>();
        for (Dish dish : foodList) {
            if (dish.getFoodType().equalsIgnoreCase(foodType)) {
                matchingDishes.add(dish);
            }
        }
        return matchingDishes;
    }

    /**
     * Searches for menus whose total price falls within a given range.
     * 
     * @param minPrice The minimum price of the menus to find.
     * @param maxPrice The maximum price of the menus to find.
     * @return An array of menu names and their total prices.
     */
    public String[] findMenusByPriceRange(double minPrice, double maxPrice) {
        ArrayList<String> matchingMenus = new ArrayList<>();
        for (Meny menu : menus) {
            double totalCost = menu.calculateTotalCost();
            if (totalCost >= minPrice && totalCost <= maxPrice) {
                matchingMenus.add(menu.getMenuName() + " costs: " + totalCost + " NOK");
            }
        }
        return matchingMenus.toArray(new String[0]);
    }

    /**
     * Inner class representing a dish.
     */
    public static class Dish {
        private final String foodName;
        private final String foodType;
        private final double foodPrice;
        private final String foodRecipe;

        /**
         * Constructor for creating a new dish.
         * 
         * @param foodName  The name of the dish.
         * @param foodType  The type of the dish.
         * @param foodPrice The price of the dish.
         * @param foodRecipe The recipe for the dish.
         */
        public Dish(String foodName, String foodType, double foodPrice, String foodRecipe) {
            this.foodName = foodName;
            this.foodType = foodType;
            this.foodPrice = foodPrice;
            this.foodRecipe = foodRecipe;
        }

        // Getters
        public String getFoodName() {
            return foodName;
        }

        public String getFoodType() {
            return foodType;
        }

        public double getFoodPrice() {
            return foodPrice;
        }

        public String getFoodRecipe() {
            return foodRecipe;
        }

        // Override toString
        @Override
        public String toString() {
            return "Dish: " + foodName + ", Type: " + foodType + ", Price: " + foodPrice + " NOK, Recipe: " + foodRecipe;
        }
    }

    /**
     * Inner class representing a menu that consists of multiple dishes.
     */
    public static class Meny {
        private final ArrayList<Dish> selectedDishes;
        private final String menuName;

        /**
         * Constructor for creating a new menu.
         * 
         * @param selectedDishes The list of dishes that make up the menu.
         * @param menuName       The name of the menu.
         */
        public Meny(ArrayList<Dish> selectedDishes, String menuName) {
            this.selectedDishes = selectedDishes;
            this.menuName = menuName;
        }

        /**
         * Calculates the total cost of all dishes in the menu.
         * 
         * @return The total cost of the menu.
         */
        public double calculateTotalCost() {
            double totalCost = 0;
            for (Dish dish : selectedDishes) {
                totalCost += dish.getFoodPrice();
            }
            return totalCost;
        }

        // Getter for the menu name
        public String getMenuName() {
            return menuName;
        }

        // Override toString to display menu contents
        @Override
        public String toString() {
            StringBuilder result = new StringBuilder("Menu: " + menuName + "\n");
            for (Dish dish : selectedDishes) {
                result.append(dish.toString()).append("\n");
            }
            return result.toString();
        }
    }
}