public class Orders {

    public int getStreakGoal(int weeks) {
        int sum = 0;
        for(int i = 0; i <= weeks; i++) {
            sum += i;
        }
        return sum;

    public double getOrderTotal(double[] prices) {
        double sum = 0;
        for(int i = 0; i < prices.length(); i++) {
            sum += prices[i];
            }
        return sum;
        }
    }
}