import java.util.Arrays;

/**
 * 283. 移动零
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author myb
 * @date 2020/7/11 15:43
 * @description Solution183
 */
public class Solution283 {


    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
//        int[] nums = {0,0,0,0};
        new Solution283().moveZeroes(nums);
        Arrays.stream(nums).forEach(System.out::println);

    }

    public void moveZeroes(int[] nums) {
        int zero = -1;
        for (int i = 0; i < nums.length; i++) {

            if(nums[i] == 0){
                // 寻找第一个 0;
                if(zero < 0){
                    zero = i;
                }
            }else {
                // 说明该数前边没有 0
                if (zero >= 0) {
                   nums[zero] = nums[i];
                   nums[i] = 0;
                   zero++;
                }
            }
        }
    }
}
