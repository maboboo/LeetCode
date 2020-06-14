import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author myb
 * @date 2020/6/14 14:40
 * @description MaxDeep
 */
public class MaxDeep {
    public static void main(String[] args) {
        TreeNode t_1 = new TreeNode(1);
        TreeNode t_2 = new TreeNode(2);
        TreeNode t_3 = new TreeNode(3);
        t_1.right = t_2;
        t_2.left = t_3;

        MaxDeep maxDeep = new MaxDeep();
        System.out.println(maxDeep.maxDepth2(t_1));

    }

    // 自己写的 递归时，把深度传进去。
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return traversal(root, 1);
    }

    private Integer traversal(TreeNode root, Integer deep) {
        if (root == null) {
            return deep;
        }
        if (root.left != null || root.right != null) {
            deep++;
        }
        return Math.max(traversal(root.left, deep), traversal(root.right, deep));
    }

    // 官方解答 每递归一次，深度就加 1
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }


    // 迭代解答 深度优先
    public int maxDepth2(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root != null) {
            stack.add(new Pair<>(root, 1));
        }
        int max_deep = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.pop();
            root = current.getKey();
            int current_deep = current.getValue();
            // 对比 max_deep 与 current_deep 取大的那一个。
            max_deep = Math.max(max_deep, current_deep);

            // 如果有下一层，就把下层加入到栈中， 下一层的 deep 为 current_deep + 1
            if (root.left != null) stack.add(new Pair(root.left, current_deep + 1));
            if (root.right != null) stack.add(new Pair(root.right, current_deep + 1));
        }
        return max_deep;
    }
}
