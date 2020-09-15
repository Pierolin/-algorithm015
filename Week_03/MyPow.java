package algorithm015.Week_03;

public class MyPow {

    /**
     * 方法一：分治 + 递归
     * TC: O(logn)
     * SC: O(logn)
     * 关键思路：折半相乘，或 n 为奇数，则转化为 x * x^(n-1)
     */
    public double myPow_2(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        if (n % 2 != 0) return x * myPow_2(x, n - 1);
        return myPow_2(x * x, n / 2);
    }

    /**
     * 方法二：分治 + 迭代
     * TC: O(logn)
     * SC: O(1)
     * 关键思路：折半相乘，或 n 为奇数，则补乘于一个 x
     */
    public double myPow_3(double x, int n) {
        double result = 1.0;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        for (int i = n; i > 0; i /= 2) {
            if (i % 2 != 0) result *= x;
            x *= x;
        }
        return result;
    }

    /**
     * 方法三：暴力求解
     * TC: O(n)
     * SC: O(1)
     */
    public double myPow_1(double x, int n) {
        double result = 1;
        for (int i = 0; i < n; i++) {
            result *= x;
        }
        return result;
    }


    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        double result = myPow.myPow_3(2, 8);
        System.out.println(result);
    }
}
