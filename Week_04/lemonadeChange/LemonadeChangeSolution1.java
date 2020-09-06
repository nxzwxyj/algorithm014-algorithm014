package lemonadeChange;

/**
 * @author JunG
 * @create 2020-09-06 17:33
 */
public class LemonadeChangeSolution1 {
    public Boolean lemonadeChange(int[] bills){
        int fives = 0, tens = 0;
        if(bills.length < 1){
            return true;
        }
        if(bills[0] != 5){
            return false;
        }
        for(int bill : bills){
            if(bill == 5){
                fives++;
            }else if(bill == 10){
                if(fives < 0){
                    return false;
                }
                fives--;
                tens++;
            }else{
                if(tens < 0 && fives < 1){
                    return false;
                }else if(fives > 2){
                    fives -= 3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        LemonadeChangeSolution1 lemonadeChangeSolution1 = new LemonadeChangeSolution1();
        int[] bills = new int[]{5,5,5,10,5,5,5,10,20,20,20};
        System.out.println(lemonadeChangeSolution1.lemonadeChange(bills));
    }
}
