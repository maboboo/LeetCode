import java.util.Random;

/**
 *
 * 384. 打乱数组
 *
 * @author myb
 * @date 2020/7/11 16:30
 * @description Solution384
 */
public class Solution384 {

    private int [] nums = null;
    private int [] initNums = null;
    public Solution384(int[] nums) {
        initNums = nums;
        this.nums = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return initNums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int r = random.nextInt(nums.length - i) + i;
            nums[i] = nums[r];
            nums[r] = temp;
        }
        return nums;
    }
}
