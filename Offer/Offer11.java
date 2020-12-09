import java.util.Arrays;

/**
 * @author myb
 * @date 2020/7/22 23:33
 * @description Offer11
 */
public class Offer11 {

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(new Offer11().minArray2(nums));

    }

    public int minArray1(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0];
    }

    public int minArray2(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[i - 1]) {
                return numbers[i];
            }
        }
        return numbers[0];
    }

}
