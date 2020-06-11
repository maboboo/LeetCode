/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 示例 1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */
public class Pow {
    public static void main(String[] args) {
        Pow pow = new Pow();
//        System.out.println("t 1024.0, my:" + pow.myPow(2.00000, 10));
//        System.out.println("t 9.26100, my:" + pow.myPow(2.10000, 3));
//        System.out.println("t 0.25000, my:" + pow.myPow(2.0000, -2));
        System.out.println("t 1.0, my:" + pow.myPow1(1, -2147483648));
    }

    // -2147483648 正数超过 int 类型最大值
    public Double myPow(double x, int n) {
        if (n < 0){
            return 1/myPow(x, -n);
        } else if (n == 0){
            return 1.0;
        } else if (n == 1){
            return x;
        } else {
            double t = myPow(x, n/2);
            return n % 2 == 0 ? t * t : t * t * x;
        }

    }

    public Double myPow1(double x, int n) {
        if (n < 0){
            return 1/quickPow(x, -n);
        } else {
            return quickPow(x, n);
        }

    }
    public Double quickPow(double x, long n){
        if (n == 0){
            return 1.0;
        }else {
            double t = quickPow(x, n/2);
            return n % 2 == 0 ? t * t : t * t * x;
        }
    }
}
