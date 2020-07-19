import java.util.Arrays;
import java.util.HashMap;

/**
 * 350. 两个数组的交集 II
 *
 * @author myb
 * @date 2020/7/19 15:17
 * @description Solution350
 */
public class Solution350 {

    public static void main(String[] args) {
        int [] nums1 = {1,2,2,1};
        int [] nums2 = {2, 2};
        Arrays.stream(new Solution350().intersect(nums1, nums2)).forEach(System.out::println);

    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int v1 : nums1) {
            if (!map.containsKey(v1)) {
                map.put(v1, 1);
            } else {
                int m = map.get(v1);

                map.put(v1, ++m);
            }
        }
        int[] result = new int[nums1.length];
        int index = 0;
        for (int v2 : nums2) {
            int count = map.getOrDefault(v2, 0);
            if (count > 0) {
                result[index] = v2;
                index++;
            }
            count--;
            if (count > 0) {
                map.put(v2, count);
            } else {
                map.remove(v2);
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }
}
