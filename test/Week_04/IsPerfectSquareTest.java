package algorithm015.test.Week_04;

import algorithm015.Week_04.IsPerfectSquare;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsPerfectSquareTest {

    @Test
    void isPerfectSquare() {
        IsPerfectSquare isPerfectSquare = new IsPerfectSquare();
        int num = 63;
        boolean flag = isPerfectSquare.isPerfectSquare(num);
        assertTrue(flag);
    }
}