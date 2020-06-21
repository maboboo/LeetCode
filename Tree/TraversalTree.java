import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * <p>
 * 输入: [1,null,2,3]
 *    1
 *      \
 *      2
 *    /
 * 3
 * <p>
 * 输出: [1,3,2]
 *
 * @author myb
 * @date 2020/6/14 10:59
 * @description TraversalTree
 */
public class TraversalTree {

    public static void main(String[] args) {
        TreeNode t_1 = new TreeNode(1);
        TreeNode t_2 = new TreeNode(2);
        TreeNode t_3 = new TreeNode(3);
        TreeNode t_4 = new TreeNode(4);
        t_1.left = t_2;
        t_1.right = t_3;
        t_3.left = t_4;
        TraversalTree traversalTree = new TraversalTree();
        traversalTree.preTraversal(t_1).forEach(System.out::println);

    }


    // 递归算法中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> integers = new ArrayList<>();
        traversal(root, integers);
        return integers;
    }

    private void traversal(TreeNode root, List<Integer> integers) {
        if (root == null) {
            return;
        }
        integers.add(root.val);
        traversal(root.left, integers);
        traversal(root.right, integers);
    }


    // 迭代算法前序遍历  宽度优先， 从根节点开始，每次迭代弹出当前栈顶元素，并将其孩子节点压入栈中，先压右孩子再压左孩子。
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        if(root==null) return integers;
        s.add(root);
        while (!s.empty()) {
            TreeNode node = s.pop();
            integers.add(node.val);
            if (node.right != null) {
                s.add(node.right);
            }
            if (node.left != null) {
                s.add(node.left);
            }
        }
        return integers;
    }

    // 迭代法前序遍历2  深度优先，
    public List<Integer> preTraversal(TreeNode root){
        List<Integer> integers = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null){
            while (root != null){
                integers.add(root.val);
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return integers;
    }

    // 迭代算法中序遍历   深度优先
    public List<Integer> inorderTraversalMy2(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode current = root;
        while ( !s.empty() || current != null){
            while (current!=null){
                s.push(current);
                current = current.left;
            }
            current = s.pop();
            integers.add(current.val);
            current = current.right;
        }
        return integers;
    }

    // 迭代算法后序遍历 宽度优先，
    // 从根节点开始，每次迭代弹出当前栈顶元素，将栈顶元素值添加值 List 第一个位置。 并将其孩子节点压入栈中，先压左孩子再压右孩子。
    public List<Integer> postTraversal(TreeNode root) {
        // LinkedList 往首位添加元素效率高
        LinkedList<Integer> integers = new LinkedList<>();
        if(root == null) return integers;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            root = stack.pop();
            integers.addFirst(root.val);
            if (root.left != null) stack.add(root.left);
            if (root.right != null) stack.add(root.right);
        }
        return integers;
    }
}
