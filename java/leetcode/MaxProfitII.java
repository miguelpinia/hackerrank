package unam.mx.leetcode;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * @author miguel
 */
public class MaxProfitII {

    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int min = prices[0];
        int previousProfit = 0;
        int profit = 0;
        int i = 1;
        do {
            previousProfit += profit;
            if (min > prices[i]) {
                min = prices[i++];
            }
            while (i < prices.length && prices[i] > prices[i - 1]) {
                profit = prices[i++] - min;
            }
            if (i < prices.length) {
                min = prices[i++];
            }
        } while (i < prices.length);
        return profit + previousProfit;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 2, 1, 0, 0, 1};
        MaxProfitII mp = new MaxProfitII();
        System.out.println("result: " + mp.maxProfit(arr));
    }

}
