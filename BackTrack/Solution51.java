import com.sun.org.apache.xml.internal.utils.StringBufferPool;

import java.util.*;

/**
 * 51. N皇后
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 回溯框架：
 * def backtrack(...):
 *      for 选则 in 选则列表:
 *      执行选则
 *      backtrack(...)
 *      撤销选则
 *
 * @author myb
 * @date 2020/7/6 10:12
 * @description Solution51
 */
public class Solution51 {
    public static void main(String[] args) {
        new Solution51().solveNQueens(4).forEach(System.out::println);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new LinkedList<>();
        String[][] board = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = "."; 
            }
        }
        backtrack(board, 0, res);
        return res;

    }

    /**
     * 路径：board 中小于 row 的那些行都已经成功放置了皇后
     * 选择列表：第 row 行的所有列都是放置皇后的选择
     * 结束条件：row 超过 board 的最后一行
     *
     * @param board
     * @param row
     * @param res
     */
    private void backtrack(String[][] board, int row, List<List<String>> res) {
        if (row >= board.length) {

            res.add(track(board));
            return;
        }
        // 做选择
        for (int col = 0; col < board.length; col++) {
            if (!isOk(board, row, col)) {
                continue;
            }
            board[row][col] = "Q";

            //
            backtrack(board, row + 1, res);

            // 清空最后一行
            board[row][col] = ".";
        }
    }

    /**
     * 判断某个皇后是否合法
     *
     * @return
     */
    private boolean isOk(String[][] board, int row, int col) {
        int n = board.length;
        // 检查列是否有皇后互相冲突
        for (int i = 0; i < n; i++) {
            if (board[i][col].equals("Q"))
                return false;
        }
        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j].equals("Q"))
                return false;
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1;i >= 0 && j >= 0; i--, j--) {
            if (board[i][j].equals("Q"))
                return false;
        }
        return true;
    }

    //将int类型棋盘转换成输出格式
    private List<String> track(String[][] board) {
        List<String> list=new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder temp=new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                temp.append(board[i][j]);
            }
            list.add(temp.toString());
        }
        return list;
    }
}
