package algorithm015.Week_08;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqChar {
    public int firstUniqChar_1(String s) {
        if (s == null || s.equals("")) return -1;
        int[] count = new int[26];
        Arrays.fill(count, -1);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int j = chars[i] - 'a';
            if (count[j] == -1) {
                count[j] = i;
            } else if (count[j] > -1) {
                count[j] = -2;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > -1) min = Math.min(min, count[i]);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], -1);
            } else {
                map.put(chars[i], i);
            }
        }

        int min = Integer.MAX_VALUE;
        for (char i = 'a'; i <= 'z'; i++) {
            if (map.containsKey(i) && map.get(i) > -1) {
                min = Math.min(min, map.get(i));
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }


}
