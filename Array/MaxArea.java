/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * 示例：
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 *
 * @author myb
 * @date 2020/6/1 17:12
 * @description MaxArea
 */
public class MaxArea {
    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        int[] nums1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("e:49, c:" + maxArea.maxArea1(nums1));
    }

    public int maxArea(int[] height) {

        int area = Math.min(height[0], height[1]);
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                area = Math.max(area, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return area;

    }


    /**
     *  双指针遍历
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        while (left < right) {
            area = Math.max(area, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }
}
