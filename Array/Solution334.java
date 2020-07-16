/**
 * @author myb
 * @date 2020/7/16 23:12
 * @description Solution334
 */
class Solution334 {
    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 0, 4, 6};
        System.out.println(new Solution334().increasingTriplet(nums));
    }

    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int min = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) {
                min = num;
            }else if(num <= second){
                second = num;
            }else {
                return true;
            }
        }
        return false;
    }
}
