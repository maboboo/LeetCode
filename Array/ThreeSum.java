import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum {

    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        for (List<Integer> item : new ThreeSum().threeSum2(nums)) {
            System.out.println(item);
        }
        System.out.println("=====");
        for (List<Integer> item : new ThreeSum().threeSum(nums)) {
            System.out.println(item);
        }
    }

    /**
     * 暴力破解， 当传入数组为 n 多个 0 时，超时。
     * Set 比 HashMap 慢， 用 HashMap 时，不会超时
     *
     * @param nums
     * @return
     */
//    public List<List<Integer>> threeSum(int[] nums) {
//        Set<List<Integer>> result = new HashSet<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            int target = -nums[i];
//            Set<Integer> integers = new HashSet<>();
//            for (int j = i + 1; j < nums.length; j++) {
//                if (integers.contains(target-nums[j])) {
//                    List<Integer> list = Arrays.asList(nums[i], target-nums[j], nums[j]);
//                    list.sort(Comparator.naturalOrder());
//                    result.add(list);
//                } else {
//                    integers.add(nums[j]);
//                }
//            }
//        }
//        return new ArrayList<>(result);
//    }
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            Map<Integer, Integer> integers = new HashMap<>(nums.length - i);
            for (int j = i + 1; j < nums.length; j++) {
                if (integers.containsKey(target - nums[j])) {
                    List<Integer> list = Arrays.asList(nums[i], target - nums[j], nums[j]);
                    list.sort(Comparator.naturalOrder());
                    result.add(list);
                } else {
                    integers.put(nums[j], nums[j]);
                }
            }
        }
        return new ArrayList<>(result);
    }

    /**
     * 1. 先进行排序
     * 2. 排序后，选定一个数 nums[i], 再使用双指针，指向 nums[i] 后边数的左右两端
     * 3. 如果 nums[i] > 0 则，没有结果， 因为 nums[i] <= nums[left] <= nums[right], nums[i] 最小。
     * 如果 nums[i] == nums[i-1] 说明结果重复 continue
     * 4. 如果 nums[i] + nums[left] +  nums[right] < 0 则，left +1 。
     * 5. 如果 nums[i] + nums[left] + nums[right] > 0 则，right -1 。
     * 6. 如果 nums[i] + nums[left] + nums[right] = 0  时：
     * 1). sum = 0 时， 如果 nums[left] == nums[left + 1] 结果会重复 left++
     * 2). sum = 0 时， 如果 nums[right] == nums[right - 1] 结果会重复 right--
     * 3). 添加  nums[i] + nums[left] + nums[right]
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);   // 排序

        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 0) {                          // 减少遍历
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {      // 去重
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    List<Integer> list = Arrays.asList(nums[i], nums[left], nums[right]);
                    lists.add(list);
                    while (left < right && nums[left] == nums[left + 1]) {    // 去重
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {    // 去重
                        right--;
                    }
                    left++;
                    right--;
                }

            }
        }
        return lists;

    }

}
