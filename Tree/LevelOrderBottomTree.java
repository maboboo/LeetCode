import java.util.*;


/**
 * 107. 二叉树的层次遍历 II
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 *
 * @author myb
 * @date 2020/6/15 10:20
 * @description LevelOrderBottomTree
 */
public class LevelOrderBottomTree {

    /**
     *  层序遍历， 从上往下， 从左往右，每一层为一个数组，进行遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> nodes = new LinkedList<>();
        if (root == null) {
            return nodes;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> integers = new ArrayList<>();
            while (count > 0) {
                root = queue.poll();
                integers.add(root.val);
                if (root.left != null) queue.add(root.left);
                if (root.right != null) queue.add(root.right);
                count--;
            }
            nodes.add(integers);
        }
        return nodes;
    }

    /**
     * 返回二叉树自底向上的层次遍历，（即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> nodes = levelOrder(root);
        Collections.reverse(nodes);
        return nodes;
    }

    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        LinkedList<List<Integer>> nodes = new LinkedList<>();
        if (root == null) {
            return nodes;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> integers = new ArrayList<>();
            while (count > 0) {
                root = queue.poll();
                integers.add(root.val);
                if (root.left != null) queue.add(root.left);
                if (root.right != null) queue.add(root.right);
                count--;
            }
            nodes.addFirst(integers);
        }
        return nodes;
    }
}
