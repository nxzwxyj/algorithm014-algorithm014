package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JunG
 * @create 2020-09-03 0:00
 */
public class PermuteSolution1 {
    public List<List<Integer>> premute (int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        int[] visited = new int[nums.length];
        backtrack(ans, nums, new ArrayList<Integer>(), visited);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, int[] nums, ArrayList<Integer> tempList, int[] visited) {
        if(tempList.size() == nums.length){
            ans.add(new ArrayList<Integer>(tempList));
            return ;
        }else{
            for(int i = 0; i < nums.length; i++){
                if(visited[i] == 1){
                    continue;
                }
                visited[i] = 1;
                tempList.add(nums[i]);
                backtrack(ans, nums, tempList, visited);
                visited[i] = 0;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        PermuteSolution1 permuteSolution1 = new PermuteSolution1();
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(permuteSolution1.premute(nums));
    }

}
