/**
 * @author myb
 * @date 2020/6/12 17:52
 * @description IsSymmetric
 */
public class IsSymmetric {

    public static void main(String[] args) {
        TreeNode t_1 = new TreeNode(1);
        TreeNode t_2_l = new TreeNode(2);
        TreeNode t_2_r = new TreeNode(2);
        TreeNode t_3_1 = new TreeNode(3);
        TreeNode t_3_2 = new TreeNode(3);
        t_1.left = t_2_l;
        t_1.right = t_2_r;
        t_2_l.right = t_3_1;
        t_2_r.right = t_3_2;

        IsSymmetric isSymmetric = new IsSymmetric();
        System.out.println(isSymmetric.isSymmetric(t_1));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null) return false;
        boolean s =  compare(l.left, r.right) && compare(l.right, r.left);
        return l.val == r.val && s;
    }
}
