/**
 * @author myb
 * @date 2020/7/2 22:52
 * @description ListNodeUtils
 */
public class ListNodeUtils {

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3};
        ListNode listNode = ListNodeUtils.initListNode(array);
        System.out.println(listNode);
        ListNodeUtils.printListNode(listNode);
    }

    public static ListNode initListNode(Integer[] array) {
        ListNode listNode = new ListNode(0);
        ListNode current = null;
        for (Integer integer : array) {
            if (current == null) {
                current = new ListNode(integer);
                listNode.next = current;
            } else {
                current.next = new ListNode(integer);
                current = current.next;
            }
        }
        return listNode.next;
    }

    public static void printListNode(ListNode listNode) {
        System.out.println("begin --- ");
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
