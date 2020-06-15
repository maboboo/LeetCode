/**
 * 108. 将有序数组转换为二叉搜索树
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 *
 * @author myb
 * @date 2020/6/15 11:22
 * @description SortedArrayToBST
 */
public class SortedArrayToBST {
    public static void main(String[] args) {

    }

    // 中序遍历
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int left, int right) {
        if(right < left) return null;

        // 选择中间位置左边元素作为根节点
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, left, mid-1);
        root.right = buildTree(nums, mid + 1, right);
       return root;
    }


}
