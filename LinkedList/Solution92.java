/**
 * 92. 反转链表 II
 * <p>
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author myb
 * @date 2020/7/3 21:54
 * @description Solution92
 */
public class Solution92 {
    private ListNode successor = null;

    /**
     *  迭代实现：
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m - n == 0) return head;
        ListNode prev = null;
        ListNode curr = head;

        // 指针迭代到 curr 指向第 m 个元素
        while (m > 1){
            prev = curr;
            curr = curr.next;
            m--;
            n--;
        }

        // 初始化辅助指针
        ListNode con = prev;   // 开始反转链表前一个
        ListNode tail = curr;  // 反转部分的链表尾部

        // 开始反转
        while (n > 0){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            n--;
        }

        // 反转结束后，修正指针
        if(con == null){
            // 从第一个开始反转，即： m = 1;
            head = prev;
        }else {
            con.next = prev;
        }
        tail.next = curr;
        return head;
    }

    /**
     * 递归实现：
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween2(ListNode head, int m, int n){
        // base case
        if(m == 1){
            // 当 m 等于 1 时： 为反转 reverseN 。
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween2(head.next, m - 1, n - 1);
        return head;
    }

    /**
     * 反转以 head 为起点的 n 个节点， 返回新的头节点
     * @param head
     * @param n
     * @return
     */
    private ListNode reverseN(ListNode head, int n){
        if(n == 1){
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点， 需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n-1);
        head.next.next = head;

        // 反转之后的 head 节点和后面的节点连起来。
        head.next = successor;
        return last;
    }
}
