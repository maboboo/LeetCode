import java.util.HashSet;

/**
 * @author myb
 * @date 2020/6/29 23:16
 * @description Solution142
 */
public class Solution142 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        Solution142 solution142 = new Solution142();
        System.out.println(solution142.detectCycle1(listNode));
    }
    /**
     * 解法一： 用 set 存储已经访问过的节点，当访问到已经存在的一个节点是，表示重复访问了，即开始入环的第一个节点
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        HashSet<ListNode> set = new HashSet<>();
        ListNode node = head;
        while (node.next != null){
            if(set.contains(node)){
                return node;
            }
            set.add(node);
            node = node.next;
        }
        return null;
    }

    /**
     * 解法二： 先判断是否相交，如果相交，把慢指针指到链表头，然后快慢指针相同速度往后迭代，再次相交时，即为入环的阶段
     * @param head
     * @return
     */
    public ListNode detectCycle1(ListNode head) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        Boolean hasCycle = false;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }
        if(hasCycle){
            slow = head;
            while (fast!=slow){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }else {
            return null;
        }
    }

}
