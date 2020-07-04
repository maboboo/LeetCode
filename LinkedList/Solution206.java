/**
 *
 * 206. 反转链表
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @author myb
 * @date 2020/7/3 17:52
 * @description Solution206
 */
public class Solution206 {
    public static void main(String[] args) {

    }

    /**
     * 遍历：
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode resultHeader = new ListNode(0);
        while (head!=null){
            ListNode node = head;
            head = head.next;
            node.next = resultHeader.next;
            resultHeader.next = node;
        }
        return resultHeader.next;
    }

    /**
     *  递归：
     *  反转定义： 输入一个 head , 将以 head 为头的链表反转， 并返回反转之后的链表头。
     *
     *  ListNode last = reverse(head.next);    last 即为反转之后的链表头。
     *
     *
     */
    public ListNode reverse(ListNode head){
        if(head.next == null) return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
