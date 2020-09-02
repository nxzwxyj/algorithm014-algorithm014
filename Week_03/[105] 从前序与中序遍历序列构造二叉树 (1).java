package Tree.buildTree;

/**
 * @author JunG
 * @create 2020-08-31 22:21
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class buildTreeSolution {
    public TreeNode buildTree(int[] preorder, int[] inorder){
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        //判断树是否为空
        if(p_start == p_end){
            return null;
        }

        //构造树的根节点
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);

        int i_root_index = 0;

        //遍历中序数组，寻找根节点
        for(int i = i_start; i < i_end; i++){
            if(root_val == inorder[i]){
                i_root_index = i;
                break;
            }
        }

        //左子树的节点数目
        int leftNum = i_root_index - i_start;

        //构建左子树
        root.left = buildTreeHelper(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, i_root_index);
        root.right = buildTreeHelper(preorder, p_start + leftNum + 1, p_end, inorder, i_root_index + 1, i_end);
        return root;
    }

    public static void main(String[] args) {
        buildTreeSolution buildTreeSolution = new buildTreeSolution();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        System.out.println(buildTreeSolution.buildTree(preorder, inorder));
    }
}

