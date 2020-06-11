import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * <p>
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class SearchRange {

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println("t: 3, 4: my:");
        Arrays.stream(searchRange.mySearchRange(nums, 8)).forEach(System.out::println);
        System.out.println("t: -1, -1: my:");
        Arrays.stream(searchRange.mySearchRange(nums, 6)).forEach(System.out::println);

    }

    public int[] mySearchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                int l = left;
                int r = mid;
                while (l <= r) {
                    int m = l + (r - l) / 2;
                    if (nums[m] < target) {
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                }
                result[0] = l;

                l = mid;
                r = right;
                while (l <= r) {
                    int m = l + (r - l) / 2;
                    if (nums[m] > target) {
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
                result[1] = r;
                return result;

            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
