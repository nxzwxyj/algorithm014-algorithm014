package maxProfit;

/**
 * @author JunG
 * @create 2020-09-06 20:55
 * 贪心算法
 */
public class MaxProfitSolution1 {
    public int maxProfit(int[] prices){
        int res = 0;
        int len = prices.length;
        for(int i = 0; i < len - 1; i++){
            res += Math.max(prices[i + 1] - prices[i], 0);
        }
        return res;
    }

    public static void main(String[] args) {
        MaxProfitSolution1 maxProfitSolution1 = new MaxProfitSolution1();
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfitSolution1.maxProfit(prices));
    }
}
