import java.util.HashMap;

/**
 * 138. 复制带随机指针的链表
 * @author myb
 * @date 2020/7/7 09:59
 * @description Solution138
 */
public class Solution138 {
    private HashMap<Node, Node> visitMap = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        if(visitMap.containsKey(head)){
            return visitMap.get(head);
        }
        Node newHead = new Node(head.val);
        visitMap.put(head, newHead);
        Node next = copyRandomList(head.next);
        Node random = copyRandomList(head.random);
        newHead.next = next;
        newHead.random = random;

        return newHead;
    }
}
