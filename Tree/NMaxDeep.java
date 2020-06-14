/**
 *
 * 559. N叉树的最大深度
 *
 *
 * @author myb
 * @date 2020/6/14 16:29
 * @description NMaxDeep
 */
public class NMaxDeep {

    // 递归计算 n 叉树，求最大深度
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        int current = 0;
        for (int i = 0; i < root.children.size(); i++) {
            current = Math.max(maxDepth(root.children.get(i)), current);
        }
        return current + 1;
    }


}
