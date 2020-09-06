package maxProfit;

/**
 * @author JunG
 * @create 2020-09-06 21:59
 */
public class MaxProfitSolution4 {
    public int maxProfit(int[] prices){
        int len = prices.length;
        if(len < 2){
            return 0;
        }

        // cash：持有现金
        // hold：持有股票
        // 状态转移：cash → hold → cash → hold → cash → hold → cash

        int cash = 0;
        int hold = -prices[0];

        int preCash = cash;
        int preHold = hold;

        for(int i = 1; i < len; i++){
            cash = Math.max(preCash, preHold + prices[i]);
            hold = Math.max(preHold, preCash - prices[i]);
            preCash = cash;
            preHold = hold;
        }
        return cash;
    }

    public static void main(String[] args) {
        MaxProfitSolution4 maxProfitSolution4 = new MaxProfitSolution4();
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfitSolution4.maxProfit(prices));
    }
}
