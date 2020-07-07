import java.util.HashMap;

/**
 * 160. 相交链表
 *
 * @author myb
 * @date 2020/7/7 20:02
 * @description Solution160
 */
public class Solution160 {

    /**
     * 方法一： 暴力法
     * 双重循环判断
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode temp = headB;
        while (headA != null){
            while (headB != null){
                if(headA == headB){
                    return headA;
                }
                headB = headB.next;
            }
            headA = headA.next;
            headB = temp;
        }
        return null;
    }


    /**
     * 方法二： hash 表存储
     * 时间复杂度 O(m + n)
     * 空间复杂度 O(m) 或 O(n)
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        HashMap<ListNode, ListNode> map = new HashMap<>();
        while (headA != null) {
            map.put(headA, null);
            headA = headA.next;
        }
        while (headB != null) {
            if (map.containsKey(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /**
     * 方法三： 双指针
     */
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
