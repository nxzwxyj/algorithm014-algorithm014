package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JunG
 * @create 2020-09-02 22:49
 */
public class PermuteSolution {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums){
        dfs(nums, new ArrayList<>());
        return res;
    }

    public void dfs(int[] nums, List<Integer> temp){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
        }else{
            for(int num : nums){
                if(!temp.contains(num)){
                    temp.add(num);
                    dfs(nums, temp);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        PermuteSolution permuteSolution = new PermuteSolution();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(permuteSolution.permute(nums));
    }
}
