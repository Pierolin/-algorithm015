package algorithm015.Week_01;

public class IsUnique {
    public boolean isUnique(String astr) {
        // 方法一：计算唯一字符数
        return astr.chars().distinct().count() == astr.length();

        // 方法二：bool 数组
        /*
        int[] chars = new int[26];
        for(int i=0;i<astr.length();i++) {
            int c = astr.charAt(i)-'a';
            if(chars[c]==1){
                return false;
            }
            else{
                chars[c]=1;
            }
        }
        return true;
        */

        // 方法三： indexOf 和 lastIndexOf 时间复杂度 O(n)
        /*
        for(int i=0;i<astr.length();i++){
            char c = astr.charAt(i);
            if(astr.indexOf(c) != astr.lastIndexOf(c)){
                return false;
            }
        }
        return true;
        */


        // 方法四： 双指针，时间复杂度 O(n^2)
        /*
        String temp = "";
        for(char c:str.toCharArray()){
            if(temp.indexOf(c)>-1) {
                return false;
            }
            else{
                temp += c;
            }
        }
       */

    }

    public static void main(String[] args) {
        IsUnique unique = new IsUnique();
        String str = "aFbacdef";
        boolean isUnique = unique.isUnique(str);
        System.out.println(isUnique);

    }
}
