package algorithm015.Week_02;

public class RemoveOuterParentheses {
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') count++;
            if (c == ')') count--;
            if (count == 0 && c == ')' || count == 1 && c == '(') continue;
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveOuterParentheses removeOuterParentheses = new RemoveOuterParentheses();
        String s = "(()())(())";
        String result = removeOuterParentheses.removeOuterParentheses(s);
        System.out.println(result);
    }
}
