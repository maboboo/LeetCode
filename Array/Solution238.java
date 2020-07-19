import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 *
 * @author myb
 * @date 2020/7/19 16:20
 * @description Solution238
 */
public class Solution238 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Arrays.stream(new Solution238().productExceptSelf(nums)).forEach(System.out::println);
    }

    public int[] productExceptSelf(int[] nums) {
        // 创建结果数组
        int[] result = new int[nums.length];
        // 最左边的元素左侧没有元素，result 设为1
        result[0] = 1;

        // 第一次循环，把左侧的乘积结果记入到 result 中
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }

        // 定义 R 为右侧乘积
        int R = 1;
        // 第二次循环 把右侧的乘积 跟左侧的乘积合并即为结果
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * R;
            R = R * nums[i];
        }
        return result;
    }

}
