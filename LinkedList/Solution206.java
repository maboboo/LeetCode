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
}
