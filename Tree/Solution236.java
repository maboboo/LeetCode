import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * 236. 二叉树的最近公共祖先
 * @author myb
 * @date 2020/7/9 17:10
 * @description Solution236
 */
public class Solution236 {

    /**
     * 解法一：
     * 1. 先遍历二叉树，通过 Hashmap 记录每个节点的父节点
     * 2. 遍历 p 的父节点，记录到 hashmap 中
     * 3. 遍历 q 的父节点，当 q 的父节点第一次在 p 的 父节点中出现时，即为最近公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();

        HashSet<TreeNode> visited = new HashSet<>();

        traverse(root, parents);

        while (p != null){
            visited.add(p);
            p = parents.get(p);
        }

        while (q != null){
            if(visited.contains(q)){
                return q;
            }
            q = parents.get(q);
        }
        return null;
    }

    private void traverse(TreeNode root, HashMap<TreeNode, TreeNode> parents){
        if(root.left != null){
            parents.put(root.left, root);
            traverse(root.left, parents);
        }
        if(root.right != null){
            parents.put(root.right, root);
            traverse(root.right, parents);
        }
    }
}
