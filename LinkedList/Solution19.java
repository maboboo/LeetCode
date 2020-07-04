import java.util.ArrayList;

/**
 * 19. 删除链表的倒数第N个节点
 * @author myb
 * @date 2020/7/4 21:55
 * @description Solution19
 */
public class Solution19 {

    public static void main(String[] args) {
        Integer [] array = {1, 2, 3, 4, 5};
        ListNode node = ListNodeUtils.initListNode(array);
        ListNode listNode = new Solution19().removeNthFromEnd2(node, 2);
        ListNodeUtils.printListNode(listNode);
    }

    /**
     * 遍历一次，但是需要额外存储空间 O(n)
     * 1. 给链表加一个空头 empty，遍历链表，把链表存储到数组中。
     * 2. 倒数第 n 个元素，即为 array.size - n
     * 3. 把 array[array.size - n - 1] 的指针，指向 array[array.size - n - 1].next.next
     * 4. 返回 empty.next
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        ListNode empty = new ListNode(0);
        empty.next = head;
        head = empty;
        ArrayList<ListNode> listNodes = new ArrayList<>();
        while (head != null ){
            listNodes.add(head);
            head = head.next;
        }
        listNodes.get(listNodes.size() - n - 1).next = listNodes.get(listNodes.size() - n - 1).next.next;
        return empty.next;
    }

    /**
     *  遍历两次
     *  1. 第一次遍历，获取链表的长度。
     *  2. 第二次遍历到 length - n 时，为要删除的上一个节点。
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if(head == null) return head;
        ListNode empty = new ListNode(0);
        empty.next = head;

        // 第一次遍历 获取到数组长度
        int length = 0;
        while (head != null ){
            length++;
            head = head.next;
        }

        // 计算第二次遍历次数。
        length = length - n;
        head = empty;
        while (length > 0){
            length --;
            head = head.next;
        }
        // 第二次遍历结束，即找到要删除的节点的上一个节点。
        head.next = head.next.next;
        return empty.next;
    }

    /**
     *  遍历一次：借用双指针
     *  1. 快指针先向前走 n 步
     *  2. 快指针走完 n 步后，快慢指针一起走， 当快指针走到 null 时，慢指针指向要删除的元素
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if(head == null) return head;
        ListNode empty = new ListNode(0);
        empty.next = head;

        ListNode fast = empty;
        ListNode slow = empty;
        while (n > 0){
            n--;
            fast =fast.next;
        }

        // 当快指针走到 null 时，慢指针指向要删除的元素。
        // 因此 根据 fast.next != null 确定停止条件，此时，slow 为要删除的上一个节点
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return empty.next;
    }
}
