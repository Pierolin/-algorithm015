package algorithm015.Week_02;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList();
        for (int i = 1; i <= n; i++) {
            if (i % (3*5) == 0) {
                list.add("FizzBuzz");
                continue;
            }
            if (i % 3 == 0) {
                list.add("Fizz");
                continue;
            }
            if (i % 5 == 0) {
                list.add("Buzz");
                continue;
            }
            list.add(Integer.toString(i));

        }
        return list;
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        int n = 30;
        List str = fizzBuzz.fizzBuzz(n);
        System.out.println(str.toString());
    }
}
