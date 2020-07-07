/**
 *
 * 237. 删除链表中的节点
 * @author myb
 * @date 2020/7/7 23:00
 * @description Solution237
 */
public class Solution237 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
