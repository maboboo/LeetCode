import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * 103. 二叉树的锯齿形层次遍历
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * @author myb
 * @date 2020/6/15 17:42
 * @description ZigzagLevelOrder
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        if(root == null){
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        // 在层序遍历基础上添加一个是否倒序添加数据的标记
        boolean reverse = false;
        queue.add(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            LinkedList<Integer> integers = new LinkedList<>();
            for (int i = 0; i < count; i++) {
                root = queue.poll();
                if (reverse){
                    integers.addFirst(root.val);
                }else {
                    integers.add(root.val);
                }

                if(root.left != null) queue.add(root.left);
                if(root.right != null) queue.add(root.right);
            }
            lists.add(integers);
            reverse = !reverse;
        }
        return lists;
    }
}
