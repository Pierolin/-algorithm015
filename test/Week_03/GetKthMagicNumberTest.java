package algorithm015.test.Week_03;

import algorithm015.Week_03.GetKthMagicNumber;

import static org.junit.jupiter.api.Assertions.*;

class GetKthMagicNumberTest {

    @org.junit.jupiter.api.Test
    void getKthMagicNumber() {
        GetKthMagicNumber getKthMagicNumber = new GetKthMagicNumber();
        int result = getKthMagicNumber.getKthMagicNumber_1(5);
        assertEquals(9,result);
    }
}