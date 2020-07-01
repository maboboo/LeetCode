/**
 * 83. 删除排序链表中的重复元素
 *
 * @author myb
 * @date 2020/7/1 23:46
 * @description Solution83
 */
public class Solution83 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(1);
        listNode.next = listNode1;
        ListNode listNode2 = new ListNode(1);
        listNode1.next = listNode2;
        new Solution83().deleteDuplicates(listNode);
    }

    public ListNode deleteDuplicates(ListNode head) {

        ListNode current = head;
        while (current != null && current.next != null) {
            if(current.val == current.next.val){
                current.next = current.next.next;
                continue;
            }
            current = current.next;
        }
        return head;
    }
}
