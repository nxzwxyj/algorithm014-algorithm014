package maxProfit;

/**
 * @author JunG
 * @create 2020-09-06 21:10
 * 动态规划
 *
 * 状态 dp[i][j] 定义如下
 *
 * 第一维 i 表示索引为 i 的那一天（具有前缀性质，即考虑了之前天数的收益）能获得的最大利润；
 * 第二维 j 表示索引为 i 的那一天是持有股票，还是持有现金。这里 0 表示持有现金（cash），1 表示持有股票（stock）。
 */
public class MaxProfitSolution2 {
    public int maxProfit(int[] prices){
        int len = prices.length;
        if(len < 2){
            return 0;
        }

        // 0表示持有现金
        // 1表示持有股票
        // 状态转移：0 -> 1 -> 0 -> 1 -> 0 -> 1 -> 0
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for(int i = 1; i < len; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
    public static void main(String[] args) {
        MaxProfitSolution2 maxProfitSolution2 = new MaxProfitSolution2();
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfitSolution2.maxProfit(prices));
    }
}
