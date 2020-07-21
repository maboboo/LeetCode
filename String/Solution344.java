/**
 * 344. 反转字符串
 * @author myb
 * @date 2020/7/21 22:45
 * @description Solution344
 */
public class Solution344 {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while(l < r){
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}
