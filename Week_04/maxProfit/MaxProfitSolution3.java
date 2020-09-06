package maxProfit;

/**
 * @author JunG
 * @create 2020-09-06 21:41
 * 动态规划的优化
 */
public class MaxProfitSolution3 {
    public int maxProfit(int[] prices){
        int len = prices.length;
        if(len < 2){
            return 0;
        }

        // cash：持有现金
        // hold：持有股票
        // 状态数组
        // 状态转移：cash → hold → cash → hold → cash → hold → cash
        int[] cash = new int[len];
        int[] hold = new int[len];

        cash[0] = 0;
        hold[0] = -prices[0];

        for(int i = 1; i < len; i++){
            cash[i] = Math.max(cash[i - 1], hold[i - 1] + prices[i]);
            hold[i] = Math.max(hold[i - 1], cash[i - 1] - prices[i]);
        }
        return cash[len - 1];
    }

    public static void main(String[] args) {
        MaxProfitSolution3 maxProfitSolution3 = new MaxProfitSolution3();
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfitSolution3.maxProfit(prices));
    }
}
