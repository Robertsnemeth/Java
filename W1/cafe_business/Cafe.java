import java.util.ArrayList;

public class Cafe {
    public static void main(String[] args) {
        Orders cafeOrders = new Orders();

        System.out.println("=====How many weeks to get your rewards======");
        int testRewards = cafeOrders.getStreakGoal(10);
        System.out.println(testRewards);

        System.out.println("=====Order Total=====");
        double[] orderTotals = {2.25, 1.50};
        double testOrderTotal = cafeOrders.getOrderTotal(orderTotals);
        System.out.println(testOrderTotal);

        System.out.println("======Our Menu=====");
        ArrayList<String> items = new ArrayList<String>();
        items.add("Mocha");
        items.add("Drip");
        items.add("Capuccino");
        items.add("Latte");
        // cafeOrders.displayMenu(items);
        ArrayList<Double> prices = new ArrayList<Double>();
        prices.add(1.50);
        prices.add(3.50);
        prices.add(4.50);
        prices.add(3.50);
        cafeOrders.displayMenu(items, prices);

        // System.out.println("=====Customer=====");
        // ArrayList<String> customers = new ArrayList<>();
        // for (int i = 0; i < 3; i++) {
        //     cafeOrders.addCustomer(customers);
        //     System.out.println("\n");
        // }

        System.out.println("======Price Chart=====");
        cafeOrders.printPriceChart("Columbian Coffe Grounds", 15.00, 3);
    }
}