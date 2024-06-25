package unam.mx.leetcode;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 *
 * @author miguel
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        // [7, 1, 5, 3, 6, 4]

        // output 5
        // iterate over the array
        // during iteration, we want to keep the value of the day that is the minimum value to buy the product
        // and compare this value with others in the future to see if we can get some profit
        // that could be the maximum.
        // minVal = prices[0]
        // profit = 0
        // for i = 1; i < N; i++:
        //    if prices[i] < minVal:
        //        minVal = prices[i]
        //    else if profit < prices[i] - minVal:
        //        profit = prices[i] - prices[i - 1]
        int minVal = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minVal) {
                minVal = prices[i];
            } else if (profit < (prices[i] - minVal)) {
                profit = prices[i] - minVal;
            }
        }
        return profit;
    }

}
