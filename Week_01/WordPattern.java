package algorithm015.Week_01;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        char[] chars = pattern.toCharArray();
        String[] words = str.split(" ");

        if (chars.length != words.length) return false;
        Map<Character, String> map = new HashMap<Character, String>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (map.containsKey(c)) {
                if (!map.get(c).equals(words[i])) return false;
            } else {
                if (map.containsValue(words[i])) return false;
                map.put(c, words[i]);
            }
        }

        return true;

    }

    public static void main(String[] args) {
        WordPattern word = new WordPattern();

        // wordPattern
        String pattern = "abba";
        String str = "dog cat cat dog";
        boolean flag = word.wordPattern(pattern, str);
        System.out.println(flag);

    }

}
