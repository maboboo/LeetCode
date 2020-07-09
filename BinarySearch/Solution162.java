/**
 *
 * 162. 寻找峰值
 * @author myb
 * @date 2020/7/9 11:31
 * @description Solution162
 */
public class Solution162 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(new Solution162().findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid+1]) {
                r = mid ;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
