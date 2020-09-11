package algorithm015.test.Week_01;

import algorithm015.Week_01.ThreeSum;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ThreeSumTest {

    @Test
    void threeSum() {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List result = threeSum.threeSum(nums);
        assertTrue(result.size()==2);

    }
}