import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 *
 * @author myb
 * @date 2020/6/14 10:59
 * @description TraversalTree
 */
public class TraversalTree {

    public static void main(String[] args) {
        TreeNode t_1 = new TreeNode(1);
        TreeNode t_2 = new TreeNode(2);
        TreeNode t_3 = new TreeNode(3);
        t_1.right = t_2;
        t_2.left = t_3;
        TraversalTree traversalTree = new TraversalTree();
        traversalTree.inorderTraversalMy2(t_1).forEach(System.out::println);

    }


    // 递归算法中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> integers = new ArrayList<>();
        traversal(root, integers);
        return integers;
    }

    private void traversal(TreeNode root, List<Integer> integers) {
        if (root == null) {
            return;
        }
        traversal(root.left, integers);
        integers.add(root.val);
        traversal(root.right, integers);
    }


    // 迭代算法前序遍历
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        s.add(root);
        while (!s.empty()) {
            TreeNode node = s.pop();
            integers.add(node.val);
            if (node.right != null) {
                s.add(node.right);
            }
            if (node.left != null) {
                s.add(node.left);
            }
        }
        return integers;
    }

    // 迭代算法中序遍历

    public List<Integer> inorderTraversalMy2(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode current = root;
        while ( !s.empty() || current != null){
            while (current!=null){
                s.push(current);
                current = current.left;
            }
            current = s.pop();
            integers.add(current.val);
            current = current.right;
        }
        return integers;
    }
}
