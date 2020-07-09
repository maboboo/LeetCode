import java.util.LinkedList;

/**
 *
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author myb
 * @date 2020/7/9 15:16
 * @description Solution
 */
public class Solution230 {
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        node5.left = node3;
        node3.left = node2;
        node2.left = node1;
        node3.right = node4;

        System.out.println(new Solution230().kthSmallest(node5, 3));
    }

    /**
     * 解法一： 中序遍历二叉搜索树， 访问到的第 k 个元素即为结果。
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {

        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode current = root;
        int i = 0;
        while(!queue.isEmpty() || current != null){
            while(current != null){
                queue.add(current);
                current = current.left;
            }
            current = queue.pollLast();
            i++;
            if(i == k) return current.val;
            System.out.println(current.val);
            current = current.right;
        }
        return -1;
    }

    // TODO 解法二： 递归遍历
}
