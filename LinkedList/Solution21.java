/**
 * @author myb
 * @date 2020/7/1 23:35
 * @description Solution21
 */
public class Solution21 {
    public static void main(String[] args) {
        System.out.println(new Solution21().mergeTwoLists(new ListNode(1), null));
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode header = new ListNode(0);
        ListNode node = header;
        while (l1 != null || l2 != null) {
            if(l1 == null){
                header.next = l2;
                break;
            }
            if(l2 == null){
                header.next = l1;
                break;
            }
            if (l1.val <= l2.val) {
                node.next = new ListNode(l1.val);
                l1 = l1.next;
            }else {
                node.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            node = node.next;
        }
        return header.next;
    }
}
