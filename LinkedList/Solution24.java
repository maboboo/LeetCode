/**
 * 24. 两两交换链表中的节点
 * @author myb
 * @date 2020/7/2 15:54
 * @description Solution24
 */
public class Solution24 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;


        ListNode listNode = new Solution24().swapPairs1(listNode4);
        System.out.println(listNode);
    }

    public ListNode swapPairs(ListNode head) {

        ListNode emptyNode = new ListNode(0);
        emptyNode.next = head;

        ListNode previewNode = emptyNode;
        while (head != null && head.next != null) {
            // 准备工作
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // 开始交换
            previewNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // 迭代指针
            previewNode = firstNode;
            head = firstNode.next;
        }
        return emptyNode.next;
    }


    public ListNode swapPairs1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        // 准备工作
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        //交换
        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        return secondNode;
    }
}
