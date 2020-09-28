package algorithm015.Week_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReplaceSpace {
    public String replaceSpace_1(String s) {

        /**
         * 方法一：扩大数组
         * TC: O(n)
         * SC: O(n)
         */
        int length = s.length();
        char[] newS = new char[length * 3];
        int i = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                newS[i++] = '%';
                newS[i++] = '2';
                newS[i++] = '0';
            } else {
                newS[i++] = c;
            }
        }
        return String.valueOf(newS, 0, i);
    }

    /**
     * 方法二：使用 StringBuilder
     * TC: O(n)
     * SC: O(1)
     */
    public String replaceSpace_2(String s) {


        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public  String replaceSpace_3(String s){
        List<String> list = new ArrayList<String>();
        for (char c:s.toCharArray()) {
            if (c == ' ') {
                list.add("%20");
            } else {
                list.add(String.valueOf(c));
            }
        }
        return String.join("",list);
    }



    public static void main(String[] args) {
        ReplaceSpace replaceSpace = new ReplaceSpace();
        String str = "Hello world, Piero";
        String result = replaceSpace.replaceSpace_3(str);
        System.out.println(result);
    }
}
