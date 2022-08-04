public class Cafe {
    public static void main(String[] args) {
        Orders cafeOrders = new Orders();

        int testRewards = cafeOrders.getStreakGoal(12);
        System.out.println(testRewards);
        double testOrderTotal = cafeOrders.getOrderTotal({2.25,1.50});
        System.out.println(testOrderTotal);
    }
}