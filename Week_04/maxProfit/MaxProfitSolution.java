package maxProfit;

/**
 * @author JunG
 * @create 2020-09-06 20:29
 * 暴力搜索方法：递归
 */
public class MaxProfitSolution {
    /**
     * 定义一个变量来记录结果
     */
    private int res;
    public int maxProfit(int[] prices){
        int len = prices.length;
        //特殊值判断
        if(len < 2){
            return 0;
        }
        //初始化结果值
        this.res = 0;
        helper(prices, 0, len, 0, res);
        return res;
    }

    /**
     *
     * @param prices 股价数组
     * @param index 当前是第几天，从0开始
     * @param len 数组长度
     * @param status 记录是否持有股票，0表示不持有股票，1表示持有股票
     * @param profit 当前收益
     */
    private void helper(int[] prices, int index, int len, int status, int profit) {
        //表示递归的终止条件
        if(index == len){
            this.res = Math.max(res, profit);
            return ;
        }

        //向下递归
        helper(prices, index + 1, len, status, profit);

        //业务逻辑
        if(status == 0){
            //此时可以转向1
            helper(prices, index + 1, len, 1, profit - prices[index]);
        }
        if(status == 1){
            //此时可以转向0
            helper(prices, index + 1, len, 0, profit + prices[index]);
        }
    }

    public static void main(String[] args) {
        MaxProfitSolution maxProfitSolution = new MaxProfitSolution();
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfitSolution.maxProfit(prices));
    }
}
