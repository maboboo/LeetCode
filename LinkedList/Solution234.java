import java.util.ArrayList;

/**
 *
 * 234. 回文链表
 *
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * @author myb
 * @date 2020/7/7 22:50
 * @description Solution234
 */
public class Solution234 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        System.out.println(new Solution234().isPalindrome1(listNode));
    }
    /**
     * 方法一: 复制链表到数组中，进行判断
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     * @param head
     * @return
     */
    public boolean isPalindrome1(ListNode head) {
        ArrayList<ListNode> listNodes = new ArrayList<>();
        while (head!=null){
            listNodes.add(head);
            head = head.next;
        }

        int left = 0, right = listNodes.size() - 1;
        while (left <= right){
            if(listNodes.get(left) != listNodes.get(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
