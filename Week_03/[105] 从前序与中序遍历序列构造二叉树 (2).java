package Tree.buildTree;

import java.util.HashMap;

/**
 * @author JunG
 * @create 2020-08-31 23:48
 */
public class buildTreeSolution1 {
    public TreeNode buildTree(int[] preorder, int[] inorder){
        //将中序遍历数组遍历，将全部节点及其索引存储到hashmap中
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }

    private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end, HashMap<Integer, Integer> map) {
        //判断树是不是为空
        if(p_start == p_end){
            return null;
        }
        //定义根节点
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        //定义根节点的索引下标
        int i_root_index = map.get(root_val);
        //左子树节点的数量
        int leftNum = i_root_index - i_start;
        //构造左子树
        root.left = buildTreeHelper(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, i_root_index, map);
        root.right = buildTreeHelper(preorder, p_start + leftNum + 1, p_end, inorder, i_root_index + 1, i_end, map);
        return root;
    }

    public static void main(String[] args) {
        buildTreeSolution1 buildTreeSolution1 = new buildTreeSolution1();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{3, 9, 20, 15, 7};
        System.out.println(buildTreeSolution1.buildTree(preorder, inorder));
    }
}
