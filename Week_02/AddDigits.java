package algorithm015.Week_02;

public class AddDigits {
    public int addDigits(int num) {
        // 方法一：模 9 法
        return (num - 1) % 9 + 1;

        // 方法二：迭代法
        /*
        while (num > 9) {
            num = num % 10 + num / 10;
        }
        return num;
        */

        // 方法三：递归法
        /*
        if(num<10) return num;
        int sum = 0;
        while(num>0){
            sum += num%10;
            num =  num/10;
        }
        return addDigits(sum);
        */
    }

    public static void main(String[] args) {
        AddDigits addDigits = new AddDigits();
        int num = 38;
        System.out.println(addDigits.addDigits(38));
    }
}
