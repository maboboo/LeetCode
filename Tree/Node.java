import java.util.List;

/**
 * @author myb
 * @date 2020/6/14 16:30
 * @description Node
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
