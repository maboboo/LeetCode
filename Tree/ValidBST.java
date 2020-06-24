import java.util.Stack;

/**
 * 98. 验证二叉搜索树
 * @author myb
 * @date 2020/6/23 21:13
 * @description ValidBST
 */
public class ValidBST {
    // 递归
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        return valid(root, null, null);
    }
    public boolean valid(TreeNode root, Integer max, Integer min){
        if(root == null){
            return true;
        }
        if( max!= null && root.val >= max){
            return false;
        }
        if(min!=null && root.val <= min){
            return false;
        }
        return valid(root.left, root.val, min) && valid(root.right, max, root.val);
    }


    // 中序遍历：  中序遍历时，当前数一定比上一个数大，如果小，则不是二叉搜索树
    public boolean isValidBST1(TreeNode root){
        if(root == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        long preview = Long.MIN_VALUE;
        while (!stack.isEmpty() || current != null){
            while (current != null){
                stack.add(current);
                current = current.left;
            }
            current = stack.pop();
            if(current.val <= preview) return false;
            preview = (long) current.val;
            current = current.right;
        }
        return true;
    }
}
