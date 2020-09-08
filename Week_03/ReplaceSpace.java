package algorithm015.Week_03;

import java.util.Arrays;

public class ReplaceSpace {
    public String replaceSpace(String s){
        // 方法一：使用新建 char 数组再转 String

        int length = s.length();
        char[] newS = new char[length*3];
        int i = 0;
        for(char c:s.toCharArray()){
            if(c==' '){
                newS[i++] = '%';
                newS[i++] = '2';
                newS[i++] = '0';
            }
            else{
                newS[i++] = c;
            }
        }
        return String.valueOf(newS,0,i);

        //方法二：使用 StringBuilder
        /*
        StringBuilder sb = new StringBuilder();
        for(char c:s.toCharArray()){
            if(c == ' '){
                sb.append("%20");
            }
            else{
                sb.append(c);
            }
        }
        return sb.toString();
        */

        //方法三： 使用自带的 replaceAll 函数
        //return s.replaceAll(" ","%20");


    }

    public static void main(String[] args) {
        ReplaceSpace replaceSpace = new ReplaceSpace();
        String str = "Hello world, Piero";
        String result = replaceSpace.replaceSpace(str);
        System.out.println(result);
    }
}
