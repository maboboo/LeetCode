/**
 *
 * 328. 奇偶链表
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author myb
 * @date 2020/7/8 23:21
 * @description Solution238
 */
public class Solution238 {

    /**
     * 解法一：
     * 指针每次迭代一步，判断下是奇数偶数， 分别加到对应的链表，最后再把两个链表合并
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        ListNode a = new ListNode(0);
        ListNode a_current = null;


        ListNode b = new ListNode(0);
        ListNode b_current = null;

        int i = 1;
        while(head!=null){
            ListNode tempNode = head;
            head = head.next;
            tempNode.next = null;
            if(i%2 == 1){
                if(a_current == null){
                    a_current = tempNode;
                    a.next = a_current;
                }else{
                    a_current.next = tempNode;
                    a_current = a_current.next;
                }
            }else{
                if(b_current == null){
                    b_current = tempNode;
                    b.next = b_current;
                }else{
                    b_current.next = tempNode;
                    b_current = b_current.next;
                }
            }
            i++;
        }

        if(a_current != null){
            a_current.next = b.next;
        }
        return a.next;
    }

    // TODO 解法二：每次迭代两步

}
