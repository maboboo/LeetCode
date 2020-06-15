/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] strs = {"flower", "flow", "flight"};
        System.out.println("t: fl, my:" + longestCommonPrefix.longestCommonPrefix(strs));
        String[] strs2 = {};
        System.out.println("t: , my:" + longestCommonPrefix.longestCommonPrefix(strs2));

        String[] strs3 = {"aa", "a"};
        System.out.println("t:a , my:" + longestCommonPrefix.longestCommonPrefix(strs3));
    }

    // 暴力解法， 对每个字符串 从 下标 0 开始往后判断， 不一致或者 StringIndexOutOfBoundsException 时，即可得到最长子串。
    public String myLongestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        char temp = ' ';
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (j == 0) {
                    try {
                        temp = strs[j].charAt(i);
                    } catch (StringIndexOutOfBoundsException e) {
                        e.printStackTrace();
                        return sb.toString();
                    }
                } else {
                    try {
                        if (strs[j].charAt(i) == temp) {
                        } else {
                            return sb.toString();
                        }
                    } catch (StringIndexOutOfBoundsException e) {
                        e.printStackTrace();
                        return sb.toString();
                    }
                }
            }
            sb.append(temp);
        }
        return sb.toString();
    }


    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 0; i < strs.length; i++) {
            if(i == 0) continue;
            prefix = prefix.substring(0, Math.min(prefix.length(), strs[i].length()));

            //Math.min(prefix.length(), strs[i].length())   这里要实时的获取，因为循环会改变 prefix 的长度
            for (int j = 0; j < Math.min(prefix.length(), strs[i].length()); j++) {
                if(prefix.charAt(j)!= strs[i].charAt(j)){
                    prefix = prefix.substring(0, j);
                }
            }
        }
        return prefix;
    }
}
