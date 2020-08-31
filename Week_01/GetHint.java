package algorithm015.Week_01;

public class GetHint {
    public String getHint(String secret, String guess) {
        // 方法一：一个循环即可
        int bulls = 0;
        int cows = 0;
        int[] temp = new int[10];

        char[] guesses = guess.toCharArray();

        for (int i = 0; i < guesses.length; i++) {
            int guessNumber = guesses[i]-'0';
            int secretNumber = secret.charAt(i)-'0';
            if (guessNumber == secretNumber) {
                bulls++;
            }
            else{
                if(temp[guessNumber]<0) cows++;
                if(temp[secretNumber]>0) cows++;
                temp[guessNumber]++;
                temp[secretNumber]--;
            }
        }

        return bulls + "A" + cows + "B";

        // 方法二：创建两个数组分别统计
        /*
        int bulls = 0, cows = 0;
        char[] chars = guess.toCharArray();
        int[] secrets = new int[10];
        int[] guesses = new int[10];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == secret.charAt(i)) {
                bulls++;
            } else {
                guesses[chars[i] - '0']++;
                secrets[secret.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (secrets[i] > 0 && guesses[i] > 0) {
                cows = secrets[i] > guesses[i] ? guesses[i] : secrets[i];
            }
        }
        return bulls + "A" + cows + "B";
        */
    }

    public static void main(String[] args) {
        GetHint hint = new GetHint();
        // isUnique
        /*
        String str = "abacdef";
        boolean isUnique = solution.isUnique(str);
        System.out.println(isUnique);
        */

        // wordPattern
        /*
        String pattern = "abba";
        String str = "dog cat cat dog";
        boolean flag = solution.wordPattern(pattern, str);
        System.out.println(flag);
        */

        // getHint
        /*
        String secret = "1807";
        String guess ="7810";
        */
        String secret = "1123";
        String guess = "0111";
        String result = hint.getHint(secret, guess);
        System.out.println(result);
    }
}
