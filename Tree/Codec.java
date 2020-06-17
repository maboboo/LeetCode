import com.sun.deploy.util.StringUtils;

import java.util.*;

/**
 * @author myb
 * @date 2020/6/16 21:45
 * @description Codec
 * <p>
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public static void main(String[] args) {
        TreeNode t_1 = new TreeNode(1);
        TreeNode t_2 = new TreeNode(2);
        t_1.left = t_2;

        TreeNode t_3 = new TreeNode(3);
        t_1.right = t_3;
        TreeNode t_4 = new TreeNode(4);
        TreeNode t_5 = new TreeNode(5);
        t_3.left = t_4;
        t_3.right = t_5;


        Codec codec = new Codec();
        System.out.println(codec.serialize(t_1));

        String s = "[1,2,3,null,null,4,5]";
        System.out.println(codec.serialize(codec.deserialize(s)));

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[null]";

        LinkedList<Object> queue = new LinkedList<>();
        queue.add(root);
        List<String> nodes = new ArrayList<>();
        boolean hasNext = true;
        while (!queue.isEmpty()) {
            int count = queue.size();
            if (hasNext) {
                hasNext = false;
                while (count > 0) {
                    count--;
                    root = (TreeNode) queue.poll();
                    if (root == null) {
                        nodes.add(null);
                    } else {
                        nodes.add(String.valueOf(root.val));
                        queue.add(root.left);
                        queue.add(root.right);
                        if (root.left != null || root.right != null) hasNext = true;
                    }

                }
            } else {
                break;
            }
        }
        StringBuffer sb = new StringBuffer("[");
        for (int i = 0; i < nodes.size(); i++) {
            sb.append(nodes.get(i));
            if (i != nodes.size() - 1) sb.append(",");

        }
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        if (data == null || data.equals("") || data.equals("[null]")) return null;
//        String[] nodes = data.substring(1, data.length() - 2).split(",");
//        return builder(nodes, 0);
//    }
//
//    private TreeNode builder(String[] nodes, Integer index) {
//        if (index > nodes.length - 1) return null;
//        if (nodes[index].equals("null")) return null;
//
//        TreeNode root = new TreeNode(Integer.parseInt(nodes[index]));
//        root.left = builder(nodes, index + 1);
//        root.right = builder(nodes, index + 2);
//        return root;
//    }
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("") || data.equals("[null]")) return null;
        String[] nodes = data.substring(1, data.length() - 1).split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = null;
        for (int i = 0; i < nodes.length; i++) {
            if (i == 0) {
                if (!nodes[i].equals("null")) {
                    root = new TreeNode(Integer.parseInt(nodes[i]));
                    queue.add(root);
                }
            } else {

                TreeNode parent = queue.poll();
                if (!nodes[i].equals("null")) {
                    parent.left = new TreeNode(Integer.parseInt(nodes[i]));
                    queue.add(parent.left);
                }
                if (i + 1 < nodes.length) {
                    if (!nodes[i + 1].equals("null")) {
                        parent.right = new TreeNode(Integer.parseInt(nodes[i + 1]));
                        queue.add(parent.right);
                    }
                    i++;
                }

            }
        }
        return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
