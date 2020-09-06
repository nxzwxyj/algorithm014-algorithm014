package lemonadeChange;

/**
 * @author JunG
 * @create 2020-09-06 16:50
 */
public class LemonadeChangeSolution {
    public Boolean lemonadeChange(int[] bills){
        //定义十元货币和五元货币的数量
        int five = 0;
        int ten = 0;
        //遍历bills数组
        for(int bill : bills){
            if(bill == 5){
                five++;
            }else if(bill == 10){
                ten++;
                five--;
            }else if(ten > 0){
                ten--;
                five--;
            }else{
                five -= 3;
            }
            if(five < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LemonadeChangeSolution lemonadeChangeSolution = new LemonadeChangeSolution();
        int[] bills = new int[]{5,5,10,20,5,5,10,20,20,20};
        System.out.println(lemonadeChangeSolution.lemonadeChange(bills));
    }
}
