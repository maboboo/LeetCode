import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 1,6,7,9,8,7,6,5 -> 1,6,8,5,6,7,7,9
 *
 * @author myb
 * @date 2020/6/8 16:10
 * @description NextPermutation
 */
public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
//        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums1 = {5, 4, 3, 2, 1};
//        int[] nums1 = {1, 5, 4, 3, 2, 1};
        nextPermutation.nextPermutation(nums1);
        Arrays.stream(nums1).forEach(System.out::println);
    }


    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = i;
            while (j < nums.length - 1 && nums[i] < nums[j + 1]) {
                j++;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
