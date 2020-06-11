/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 */
public class SearchMatrix {
    public static void main(String[] args) {
        SearchMatrix searchMatrix = new SearchMatrix();
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println("t: true; my: " + searchMatrix.searchMatrix(matrix, 3));
        System.out.println("t: false; my: " + searchMatrix.searchMatrix(matrix, 13));
        int[][] matrix2 = {{}};
        System.out.println("t: false; my: " + searchMatrix.searchMatrix(matrix2, 1));
        int[][] matrix3 = {{1}};
        System.out.println("t: true; my: " + searchMatrix.searchMatrix(matrix3, 1));
    }

    public boolean mySearchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int left = 0;
        int right = matrix.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid].length == 0) {
                right--;
            } else if ((matrix[mid][0] <= target) && matrix[mid][matrix[mid].length - 1] >= target) {
                int l = 0;
                int r = matrix[mid].length - 1;
                while (l <= r) {
                    int m = l + (r - l) / 2;
                    if (matrix[mid][m] == target) {
                        return true;
                    } else if (matrix[mid][m] < target) {
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                }
                return false;
            } else if (matrix[mid][0] < target) {
                left = mid + 1;
            } else if (matrix[mid][matrix[mid].length - 1] > target) {
                right = mid - 1;
            }
        }
        return false;
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int element = matrix[mid / n][mid % n];
            if (element == target) {
                return true;
            } else if (element < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
