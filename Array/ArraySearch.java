import java.util.Arrays;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * <p>
 * 示例 2:
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * @author myb
 * @date 2020/6/9 10:38
 * @description ArraySearch
 */
public class ArraySearch {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        ArraySearch arraySearch = new ArraySearch();
        System.out.println(arraySearch.search(nums, 0));
//
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(arraySearch.search(nums2, 3));

        // 边界判断，左边或右边相等条件没有判断

        int[] nums3 = {1, 3};
        System.out.println(arraySearch.search(nums3, 3));  // 预期 1


        int[] nums4 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(arraySearch.search(nums4, 5)); //   预期 1


    }

    /**
     * 数组部分有序， 算法时间复杂度必须是 O(log n) 级别。 so 采用二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[right]) {       //   右边有序，
                if ((nums[mid] < target) && target < nums[right]) {      // 位于右边
                    left = mid + 1;
                } else if (nums[right] == target) {
                    return right;
                } else {
                    right = mid - 1;
                }
            } else {                                  //    右边无序， 左边有序
                if ((nums[left] < target && target < nums[mid])) {    // 位于左边
                    right = mid - 1;
                } else if (nums[left] == target) {
                    return left;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }


    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
