/**
 * 2. 两数相加
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author myb
 * @date 2020/7/1 21:53
 * @description Solution2
 */
public class Solution2 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(5);
        ListNode listNode2 = new ListNode(5);

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.addTwoNumbers(listNode1, listNode2).val);

//        [1], [9,9]
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(9);
        listNode4.next = new ListNode(9);
        System.out.println(solution2.addTwoNumbers(listNode3, listNode4).val);

        // [3,7] [9,2]

        ListNode listNode10 = new ListNode(3);
        listNode10.next = new ListNode(7);
        ListNode listNode11 = new ListNode(9);
        listNode11.next = new ListNode(2);
        solution2.addTwoNumbers(listNode10, listNode11);


    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode node = result;
        boolean flag = false;
        while (l1 != null && l2 != null) {
            int o = flag ? (l1.val + l2.val + 1) % 10 : (l1.val + l2.val) % 10;
            node.next = new ListNode(o);
            if ((flag ? (l1.val + l2.val + 1) : l1.val + l2.val) >= 10) {
                flag = true;
            } else {
                flag = false;
            }

            l1 = l1.next;
            l2 = l2.next;
            node = node.next;
        }
        if (l1 != null || l2 != null) {
            l1 = l1 != null ? l1 : l2;
            while (l1 != null) {
                int o = flag ? l1.val + 1 : l1.val;
                node.next = new ListNode(o % 10);
                node = node.next;
                if (flag && (l1.val + 1) < 10) {
                    flag = false;
                }
                l1 = l1.next;
            }
        }
        if (flag) {
            node.next = new ListNode(1);
        }
        return result.next;
    }
}
