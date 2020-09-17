package algorithm015.Week_04;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int bill5 = 0;
        int bill10 = 0;
        for (int bill : bills) {
            switch (bill) {
                case 5:
                    bill5++;
                    break;
                case 10:
                    if (bill5 == 0) return false;
                    bill10++;
                    bill5--;
                    break;
                case 20:
                    if (bill10 > 0 && bill5 > 0) {
                        bill10--;
                        bill5--;
                    } else if (bill5 > 2) {
                        bill5 -= 3;
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}
