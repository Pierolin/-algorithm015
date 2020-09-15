package algorithm015.Week_03;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    /**
     * 递归算法
     * TC: O(2^n)
     * SC: O(n)
     * 关键思路：计算比较左右括号数量
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        int right = 0;
        int left = 0;
        generate(list, n, "", left, right);
        return list;
    }

    private void generate(List<String> list, int n, String s, int left, int right) {
        if (left == n && right == n) {
            list.add(s);
            return;
        }

        if (left < n) {
            generate(list, n, s + "(", left + 1, right);
        }

        if (left > right) {
            generate(list, n, s + ")", left, right + 1);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        System.out.println(generateParenthesis.generateParenthesis(0).toString());
    }
}
