import java.util.Arrays;

/**
 * 215. 数组中的第K个最大元素
 *
 * @author myb
 * @date 2020/6/29 20:24
 * @description Solution215
 */
public class Solution215 {

    public static void main(String[] args) {

        Solution215 solution215 = new Solution215();
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        System.out.println(solution215.findKthLargest(nums1, 2));

        int[] nums2 = {1};
        System.out.println(solution215.findKthLargest(nums2, 1));



        int[] nums3 = {1,2};
        System.out.println(solution215.findKthLargest(nums3, 2));

        int[] nums4 = {0,0,0,1};
        System.out.println(solution215.findKthLargest(nums4, 2));

        int[] nums5 = {3,2,3,1,2,4,5,5,6};
        System.out.println("4" + solution215.findKthLargest(nums5, 4));


    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
