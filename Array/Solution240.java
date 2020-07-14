/**
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author myb
 * @date 2020/7/12 11:48
 * @description Solution240
 */
public class Solution240 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int[][] matrix1 = {{-5}};
        System.out.println(new Solution240().searchMatrix(matrix1, -5));

    }
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if(find(matrix, i, target)){
                return true;
            }
        }
        return false;
    }

    private boolean find(int[][] matrix, int row, int target){
        int l = 0 , r = matrix[row].length - 1;
        while (l <= r){
            int mid = (l + r) / 2;
            int num = matrix[row][mid];
            if(num == target){
                return true;
            }else if(num > target){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return false;
    }
}
