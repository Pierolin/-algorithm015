package algorithm015.Week_03;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class GetKthMagicNumber {
    /**
     * 方法二：三指针 + 动态规划
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * 解题思路：1. 任何一个数都是其前面某个数 *3 或 *5 或 *7 所得；
     *         2. 为何只要把当前指针往后移一个就可以确保其值大于上一个数？
     */
    public int getKthMagicNumber_2(int k) {
        int[] numbers = new int[k];
        numbers[0] = 1;
        int j3 = 0,j5=0,j7 = 0;
        for (int i = 1; i < k; i++) {
            if (numbers[j3] * 3 <= numbers[i - 1])  j3++;
            if (numbers[j5] * 5 <= numbers[i - 1])  j5++;
            if (numbers[j7] * 7 <= numbers[i - 1])  j7++;
            numbers[i] = Math.min(numbers[j3] * 3, Math.min(numbers[j5] * 5, numbers[j7] * 7));
        }
        return numbers[k - 1];
    }
    /**
     * 方法二：堆实现
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * 解题思路：使用 Heap 来获取当前计算因子，使用 Hash 来去重
     */
    public int getKthMagicNumber_1(int k) {
        Set<Long> values = new HashSet<Long>();
        Queue<Long> queue = new PriorityQueue();
        queue.add(1L);

        while (true) {
            Long value = queue.poll();
            if (!values.contains(value)) {
                values.add(value);
                queue.add(value * 3);
                queue.add(value * 5);
                queue.add(value * 7);
            }
            if (values.size() == k) {
                return value.intValue();
            }
        }

    }



    public static void main(String[] args) {
        GetKthMagicNumber getKthMagicNumber = new GetKthMagicNumber();
        getKthMagicNumber.getKthMagicNumber_1(20);
        getKthMagicNumber.getKthMagicNumber_2(20);
    }
}
