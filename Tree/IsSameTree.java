/**
 * @author myb
 * @date 2020/6/12 17:36
 * @description IsSameTree
 */
public class IsSameTree {

    public static void main(String[] args) {

    }

    public boolean myIsSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (q == null || p == null) return false;
        if (p.val != q.val){
            return false;
        }else {
            return myIsSameTree(p.left, q.right) && myIsSameTree(p.right, q.left);
        }
    }

}

