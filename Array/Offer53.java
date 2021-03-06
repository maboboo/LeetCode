/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * 示例 1:
 * 输入: [0,1,3]
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 * <p>
 * 限制：
 * 1 <= 数组长度 <= 10000
 */
public class Offer53 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 9};
//        int[] nums = {0, 1};
        System.out.println(new Offer53().missingNumber2(nums));
    }

    /**
     * 暴力遍历
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 二分遍历
     *
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (nums[mid] > mid){
                right = mid -1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}
