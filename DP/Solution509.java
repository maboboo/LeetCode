/**
 * @author myb
 * @date 2020/7/24 09:58
 * @description Solution509
 */
public class Solution509 {
    public static void main(String[] args) {
        System.out.println(new Solution509().fib(6));
    }
    public int fib(int N) {
        if(N == 0) return 0;
        if(N == 1|| N == 2) return 1;
        int prev = 1, current = 1;
        for(int i = 3; i <= N; i++){
            int temp = current;
            current = prev + current;
            prev = temp;
        }
        return current;
    }
}
