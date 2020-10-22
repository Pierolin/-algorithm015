package algorithm015.Week_08;

import java.util.Arrays;

/**
 * 387. 字符串中的第一个唯一字符
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        Arrays.fill(count, -1);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int j = chars[i] - 'a';
            if (count[j] == -1) {
                count[j] = i;
            }
            if (count[j] > -1) {
                count[j] = -2;
            }
        }

        int min = Integer.MIN_VALUE;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > -1) min = Math.min(min, chars[i]);
        }
        return min;
    }
}
