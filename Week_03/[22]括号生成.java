//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1264 👎 0


import java.lang.reflect.Array;
import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n == 0){
            return result;
        }
        helper(result, "", n, n);
        return result;
    }

    public void helper(List<String> result, String s, int left, int right){
        if(right == 0){
            result.add(s);
        }

        if(left > 0){
            helper(result, s + "(", left - 1, right);
        }

        if(left < right){
            helper(result, s + ")", left, right - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
