import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author myb
 * @date 2020/7/30 22:31
 * @description HelloWorld
 */
public class HelloWorld {
    public static void main(String[] args) {
        int[][] a = {{2, 5, 8, 12, 9}};
        System.out.println(findNumberIn2DArray(a, 5));
        System.out.println(replaceSpace("We are happy"));

        LinkedList<Integer> integers = new LinkedList<>();
        integers.pollLast();
    }
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {
            if (find(matrix, target, i) == true) {
                return true;
            }
        }
        return false;

    }

    public static boolean find(int[][] matrix, int target, int row) {
        int l = 0, r = matrix[row].length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                r = mid - 1;

            } else {
                l = mid + 1;

            }
        }
        return false;
    }

    public static String replaceSpace(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                sb.append("%20");
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
