import java.util.ArrayList;

public class Orders {

    public int getStreakGoal(int weeks) {
        int sum = 0;
        for(int i = 0; i <= weeks; i++) {
            sum += i;
        }
        return sum;
    }
    
    public double getOrderTotal(double[] prices) {
        double total = 0;
        for(double price : prices) {
            total += price;
            }
        return total;
        }

    public void displayMenu(ArrayList<String> menuItems) {
        for(String items : menuItems) {
            System.out.println(items);
        }
    }

    public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices) {
        if(menuItems.size() != prices.size()) {
            return false;
        }
        int quantity = 0;
        for(int i = 0; i < menuItems.size(); i++) {
            quantity ++;
            System.out.printf("%d - %s", quantity, menuItems.get(i));
                for(int j = 0; j < prices.size(); j++) {
                    if(i == j) {
                        System.out.printf("--$%.2f", prices.get(j));
                        System.out.println("\n");
                    }
                }
        }
        return true;
    }

    public void addCustomer(ArrayList<String> customers) {
        String customerName = System.console().readLine();
        System.out.printf("Hello, %s!", customerName);
        System.out.printf("You have %d customers in front of you.", customers.size());
        customers.add(customerName);
        System.out.println(customers);
    }

    public void printPriceChart(String product, double price, int maxQuantity) {
        System.out.println(product.toUpperCase());
        int quantity = 0;
        for(int i = 0; i < maxQuantity; i++) {
            quantity++;
            double prices = price * quantity;
            System.out.printf("%d - $%.2f", quantity, prices);
            System.out.println("\n");
        }

    }
}