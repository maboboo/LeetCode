import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数, 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如, 给定数组 nums = [-1, 2, 1, -4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * <p>
 * <p>
 * 1. 对数组进行排序
 * 2. 排序后, 选定一个数 nums[i], 再使用双指针, 指向 nums[i] 后边数的左右两端
 * 3. 初始化 interval， 等于无穷大
 * 4. int sum = nums[i] + nums[left] + nums[right]
 *
 * @author myb
 * @date 2020/5/29 16:42
 * @description ThreeSumRecently
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums1 = {-1, 2, 1, -4};   //1,  2
        System.out.println("result:2, cal:" + new ThreeSumClosest().threeSumClosest1(nums1, 1));
        int[] nums2 = {1, 1, 1, 0};  // -100, 2
        System.out.println("result: 2, cal:" + new ThreeSumClosest().threeSumClosest1(nums2, -100));

        int[] nums3 = {0, 2, 1, -3}; //-1 ,  0
        System.out.println("result: 0, cal:" + new ThreeSumClosest().threeSumClosest1(nums3, 1));

        int[] nums4 = {1, 2, 4, 8, 16, 32, 64, 128};
        System.out.println("result: 82, cal:" + new ThreeSumClosest().threeSumClosest1(nums4, 82));

    }

    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int interval = (int) Double.POSITIVE_INFINITY;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (interval < Math.abs(target - sum)) {

                    if (sum == target) {
                        result = sum;
                        return result;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                } else {
                    if (sum == target) {
                        result = sum;
                        return result;
                    } else if (sum < target) {
                        interval = Math.abs(target - sum);
                        result = sum;
                        left++;
                    } else {
                        interval = Math.abs(sum - target);
                        result = sum;
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public int threeSumClosest1(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int sum = nums[i] + nums[left] + nums[right];
            while (left<right){
                if (Math.abs(target - sum) < Math.abs(target - result)){
                    result = sum;
                }
                if (sum < target){
                    left++;
                }else if(sum>target){
                    right--;
                }else {
                    return sum;
                }
            }
        }
        return result;
    }

}
