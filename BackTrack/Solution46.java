import com.sun.tools.corba.se.idl.IncludeGen;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * 46. 全排列
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 参考： https://labuladong.gitbook.io/algo/suan-fa-si-wei-xi-lie/hui-su-suan-fa-xiang-jie-xiu-ding-ban
 *
 *
 * @author myb
 * @date 2020/7/5 23:38
 * @description Solution
 */
public class Solution46 {
    public static void main(String[] args) {
        int [] nums = {1, 2, 3};
        new Solution46().permute(nums).stream().forEach(System.out::println);
    }

    /**
     * 主函数，输入一组不重复的数字，返回它们的全排列
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> trace = new LinkedList<>();
        backTrack(nums, trace, res);
        return res;
    }

    /**
     * 路径： 记录在 trace 中
     * 选则列表： nums 中不存在 trace 中的那些元素
     * 结束条件： nums 中的元素都在 track 中出现
     *
     * @param nums
     * @param trace
     */
    private void backTrack(int[] nums, LinkedList<Integer> trace, List<List<Integer>> res){
        // 触发结束条件
        if(nums.length == trace.size()){
            res.add(new LinkedList(trace));
            return;
        }

        for (int num : nums) {
            // 排除不合法的选择
            if (trace.contains(num)) {
                continue;
            }
            // 做选择
            trace.add(num);
            backTrack(nums, trace, res);
            // 取消选则
            trace.removeLast();
        }
    }
}
