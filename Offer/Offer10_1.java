/**
 * @author myb
 * @date 2020/8/14 15:19
 * @description Offer10_1
 */
public class Offer10_1 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 0; i < 47; i++) {
            System.out.println(solution.fib(i));
        }
    }

    static class Solution {
        public int fib(int n) {
            if (n == 0) {
                return 0;
            } else if (n > 0 && n < 2) {
                return 1;
            }
            int result = 1, preview = 1;
            for (int i = 2; i < n; i++) {
                int temp = result;
                result = (result + preview) % 1000000007;
                preview = temp;
            }
            return result;
        }
    }
}
