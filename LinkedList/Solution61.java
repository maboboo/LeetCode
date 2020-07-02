import java.util.ArrayList;

/**
 *
 * 61. 旋转链表
 * @author myb
 * @date 2020/7/2 18:08
 * @description Solution61
 */
public class Solution61 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);

        new Solution61().rotateRight(listNode, 2);
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        ListNode current = head;
        ArrayList<ListNode> listNodes = new ArrayList<>();
        while (current!=null){
            listNodes.add(current);
            if(current.next == null){
                current.next = head;
                break;
            }
            current = current.next;
        }
        if(listNodes.size() <= 1){
            head.next = null;
            return head;
        }
        int i = k % listNodes.size();
        listNodes.get(listNodes.size() - i - 1).next = null;
        return listNodes.get((listNodes.size() - i) % listNodes.size());
    }
}
