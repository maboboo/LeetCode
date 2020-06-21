import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 590. N叉树的后序遍历
 *
 * @author myb
 * @date 2020/6/18 15:59
 * @description PostOrderNTree
 */
public class PostOrderNTree {

    /**
     * 递归遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postOrder(Node root) {
        List<Integer> integers = new ArrayList<>();
        traverse(root, integers);
        return integers;
    }

    public void traverse(Node root, List<Integer> integers) {
        if (root != null) {
            for (Node r : root.children) {
                traverse(r, integers);
            }
            integers.add(root.val);
        }
    }


    /**
     * 迭代遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postOrder2(Node root) {
        LinkedList<Integer> integers = new LinkedList<>();
        LinkedList<Node> queue = new LinkedList<>();
        if (root == null) return integers;

        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count > 0) {
                count--;
                root = queue.poll();
                for (int i = root.children.size() - 1; i >= 0; i--) {
                    if (root.children.get(i) != null) {
                        queue.add(root.children.get(i));
                    }
                }
                integers.addFirst(root.val);
            }
        }
        return integers;
    }
}
