import java.util.HashMap;

/**
 * 13. 罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * https://leetcode-cn.com/problems/roman-to-integer/
 *
 * @author myb
 * @date 2020/6/12 13:59
 * @description RomanToInt
 */
public class RomanToInt {
    public static void main(String[] args) {
        RomanToInt romanToInt = new RomanToInt();
        System.out.println(": " + romanToInt.myRomanToInt(""));
        System.out.println("III: " + romanToInt.myRomanToInt("III"));
        System.out.println("IV: " + romanToInt.myRomanToInt("IV"));
        System.out.println("IX: " + romanToInt.romanToInt("IX"));
        System.out.println("LVIII: " + romanToInt.myRomanToInt("LVIII"));
        System.out.println("MCMXCIV: " + romanToInt.romanToInt("MCMXCIV"));
    }

    public int myRomanToInt(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        char pre = ' ';
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            boolean flag = false;
            switch (c) {
                case 'I':
                    if (pre == 'V' || pre == 'X') {
                        sum -= hashMap.get(c);

                    } else {
                        sum += hashMap.get(c);
                    }
                    pre = c;
                    break;
                case 'X':
                    if (pre == 'L' || pre == 'C') {
                        sum -= hashMap.get(c);
                    } else {
                        sum += hashMap.get(c);
                    }
                    pre = c;
                    break;
                case 'C':
                    if (pre == 'D' || pre == 'M') {
                        sum -= hashMap.get(c);
                    } else {
                        sum += hashMap.get(c);
                    }
                    pre = c;
                    break;
                case 'V':
                case 'L':
                case 'D':
                case 'M':
                    sum += hashMap.get(c);
                    pre = c;
                    break;
            }
        }
        return sum;
    }

    public int romanToInt(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);
        int sum = 0;
        int pre = 0;
        for (int i = s.length() -1 ; i >= 0; i--) {
            if (pre < hashMap.get(s.charAt(i))) {
                sum += hashMap.get(s.charAt(i));
            } else {
                sum -= hashMap.get(s.charAt(i));
            }
            pre = hashMap.get(s.charAt(i));
        }
        return sum;
    }
}
