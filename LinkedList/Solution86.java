import javax.sound.sampled.LineUnavailableException;

/**
 * 86. 分隔链表
 *
 * @author myb
 * @date 2020/7/2 22:37
 * @description Solution86
 */
public class Solution86 {

    public static void main(String[] args) {
        Integer[] array = {1, 4, 3, 2, 5, 2};
        ListNode listNode = ListNodeUtils.initListNode(array);
        Solution86 solution86 = new Solution86();
        ListNode partition = solution86.partition1(listNode, 3);
        ListNodeUtils.printListNode(partition);


    }


    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode empty = new ListNode(0);
        empty.next = head;
        ListNode current = empty;
        ListNode largeHead = new ListNode(0);
        ListNode largeCurrent = null;
        while (current.next != null) {
            if (current.next.val >= x) {
                ListNode large = current.next;
                current.next = current.next.next;
                large.next = null;
                if (largeCurrent == null) {
                    largeCurrent = large;
                    largeHead.next = largeCurrent;
                } else {
                    largeCurrent.next = large;
                    largeCurrent = largeCurrent.next;
                }
            } else {
                current = current.next;
            }
        }
        current.next = largeHead.next;
        return empty.next;
    }

    /**
     *  遍历链表，将链表分为两组，大的一组，小的一组，循环结束后， 大的跟在小的后边，并且把大的最后的元素截断 next。
     * @param head
     * @param x
     * @return
     */
    public ListNode partition1(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0);
        ListNode before = beforeHead;
        ListNode afterHead = new ListNode(0);
        ListNode after = afterHead;

        while (head != null) {
            if (head.val < x){
                before.next = head;
                before = before.next;
            }else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;
        before.next = afterHead.next;
        return beforeHead.next;
    }
}

