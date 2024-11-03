import java.util.ArrayList;

public class Client {

    public static void main(String[] args) {

        // Initialize MenyRegister
        MenyRegister menyRegister = new MenyRegister();

        // Register dishes in the food list
        menyRegister.registerNewDish("Rice with raw salmon x 2", "Starter", 89, "Rice, salmon, kikkoman.");
        menyRegister.registerNewDish("Literal raw chicken", "Main course", 279, "Raw chicken with salmonella.");
        menyRegister.registerNewDish("Soy sauce", "Sauce/Misc", 19, "Soy sauce.");
        menyRegister.registerNewDish("Caeser Salad", "Main course", 249, "Leaves idfk.");
        menyRegister.registerNewDish("Some drink", "Beverage", 120, "Something.");
        menyRegister.registerNewDish("Fries", "Starter", 49, "Potato, oil, salt.");
        menyRegister.registerNewDish("Big Mac", "Main course", 49, "Beef, bread, pickles, ketchup, etc.");
        menyRegister.registerNewDish("Chocolate Milkshake", "Beverage", 49, "Some crazy stuff.");
        menyRegister.registerNewDish("Ham Sandwich", "Lunch", 129, "Bread, ham, butter, lettuce, cucumber.");
        menyRegister.registerNewDish("Apple Juice", "Beverage", 49, "Organic apple juice.");

        // Create menus by referencing the dishes from the central foodList

        // Menu 1 (Sushi-deal)
        ArrayList<MenyRegister.Dish> sushiDealDishes = new ArrayList<>();                       // New array with dynamic size for the dishes
        sushiDealDishes.add(menyRegister.findDishByName("Rice with raw salmon x 2"));  // Adds specific dishes to array
        sushiDealDishes.add(menyRegister.findDishByName("Literal raw chicken"));
        sushiDealDishes.add(menyRegister.findDishByName("Soy sauce"));
        menyRegister.createNewMenu(sushiDealDishes, "Sushi-deal");                     // Creates new menu from array with unique name

        // Menu 2 (Salad-deal)
        ArrayList<MenyRegister.Dish> saladDealDishes = new ArrayList<>();
        saladDealDishes.add(menyRegister.findDishByName("Caeser Salad"));
        saladDealDishes.add(menyRegister.findDishByName("Some drink"));
        menyRegister.createNewMenu(saladDealDishes, "Salad-deal");

        // Menu 3 (McDonalds-deal)
        ArrayList<MenyRegister.Dish> mcDonaldsDealDishes = new ArrayList<>();
        mcDonaldsDealDishes.add(menyRegister.findDishByName("Fries"));
        mcDonaldsDealDishes.add(menyRegister.findDishByName("Big Mac"));
        mcDonaldsDealDishes.add(menyRegister.findDishByName("Chocolate Milkshake"));
        menyRegister.createNewMenu(mcDonaldsDealDishes, "McDonalds-deal");

        // Menu 4 (Lunch-deal)
        ArrayList<MenyRegister.Dish> lunchDealDishes = new ArrayList<>();
        lunchDealDishes.add(menyRegister.findDishByName("Ham Sandwich"));
        lunchDealDishes.add(menyRegister.findDishByName("Apple Juice"));
        menyRegister.createNewMenu(lunchDealDishes, "Lunch-deal");

        // Search for menus within a price range
        double minimumPrice = 150;
        double maximumPrice = 300;

        String[] matchingMenus = menyRegister.findMenusByPriceRange(minimumPrice, maximumPrice); // Fills an array with Strings (menus) within price range.

        System.out.println("Menus priced between " + minimumPrice + " NOK and " + maximumPrice + " NOK:"); 
        for (String menuDetails : matchingMenus) { // Prints the info of each menu within range.
            System.out.println(menuDetails);
        }

        // Test finding a specific dish by name
        String wantedDish = "Big Sushi";
        System.out.println("\nFinding dish " + wantedDish + ".");
        MenyRegister.Dish foundDish = menyRegister.findDishByName(wantedDish);
        if (foundDish != null) {
            System.out.println("Found dish: " + foundDish.toString());
        } else {
            System.out.println("Dish " + wantedDish + " not found.");
        }
    }
}
