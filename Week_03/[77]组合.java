package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author JunG
 * @create 2020-09-01 23:03
 */
public class combineSolution {

    //定义一个ArrayList存储结果集
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k){
        if(n <= 0 || k <= 0 || n < k){
            return res;
        }
        combineHelper(n, k, 1, new Stack<Integer>());
        return res;
    }

    private void combineHelper(int n, int k, int start, Stack<Integer> pre) {
        if(pre.size() == k){
            res.add(new ArrayList<Integer>(pre));
            return;
        }

        for(int i = start; i <= n - (k - pre.size()) + 1; i++){
            pre.add(i);
            combineHelper(n, k, i + 1, pre);
            pre.pop();
        }
    }

    public static void main(String[] args) {
        combineSolution combineSolution = new combineSolution();
        System.out.println(combineSolution.combine(4, 2));
    }
}
