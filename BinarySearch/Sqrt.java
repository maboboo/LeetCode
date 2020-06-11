/**
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * 输入: 4
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * @author myb
 * @date 2020/6/11 12:39
 * @description Sqrt
 */
public class Sqrt {
    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
//        System.out.println("t 2, my:" + sqrt.mySqrt(4));
//        System.out.println("t 2, my:" + sqrt.mySqrt(8));
//        System.out.println("t 3, my:" + sqrt.mySqrt(9));
//        System.out.println("t 3, my:" + sqrt.mySqrt(15));
//        System.out.println("t 4, my:" + sqrt.mySqrt(17));

        // (mid * mid) < x   mid * mid 会导致数值溢出
        System.out.println("t 4, my:" + sqrt.mySqrt(2147395599));
        System.out.println("t 0, my:" + sqrt.mySqrt(0));
    }

    public int mySqrt(int x) {
        if (x<=1){
            return x;
        }
        int left = 0;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid < (x / mid)) {
                left = mid + 1;
            } else if (mid > (x / mid)) {
                right = mid - 1;
            }
        }
        return right;
    }
}
