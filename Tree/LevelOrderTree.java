import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * @author myb
 * @date 2020/6/14 21:36
 * @description LevelOrderTree
 */
public class LevelOrderTree {


    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> nodes = new ArrayList<>();
        if (root == null) {
            return nodes;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 外层循环层数， 每次循环时，队列中的元素数量即为每层的 node 数
            int count = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                // 内层循环每一层 循环时，把下一层再加入到队列中农
                root = queue.poll();
                level.add(root.val);
                if (root.left != null) queue.add(root.left);
                if (root.right != null) queue.add(root.right);
            }
            nodes.add(level);
        }
        return nodes;
    }
}
