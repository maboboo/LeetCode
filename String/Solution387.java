import java.util.HashMap;

/**
 *
 * 387. 字符串中的第一个唯一字符
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 * @author myb
 * @date 2020/7/21 22:57
 * @description Solution387
 */
public class Solution387 {
    public int firstUniqChar(String s) {
        // 遍历数组 使用 map 存储每个字符出现的次数
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        // 再次遍历数组， 从 map 中获取字符出现的次数，等于 1 时，就返回下标
        for(int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}
