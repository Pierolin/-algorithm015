package algorithm015.test.Week_03;

import algorithm015.Week_03.TwoSum;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    @org.junit.jupiter.api.Test
    void twoSum() {
        TwoSum twoSum = new TwoSum();
        int[] input = new int[]{2, 7, 11, 15};
        int sum = 17;
        int[] actual = twoSum.twoSum(input, sum);
        int[] expect = new int[]{0, 3};

        assertTrue(Arrays.equals(expect, actual));

    }
}