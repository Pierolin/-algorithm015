package algorithm015.Week_02;

import java.util.Arrays;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        /*int length = nums.length;
        for(int i=0;i<length;i++){
            if(nums[i]==0){
                for(int j=i+1;j< length;j++){
                    if(nums[j]!=0) {
                        nums[i] = nums[j];
                        for(int n=j;n<length-1;n++){
                            nums[n] = nums[n+1];
                        }
                        nums[length-1] = 0;
                        length--;
                        break;
                    }
                }
            }
        }*/
        int i =0;
        int j= nums.length-1;
        for(int num:nums){
            if(num!=0){
                nums[i++] = num;
            }

        }
        while(i<=j){
            nums[i++] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums = new int[]{0,8,0,1};
        moveZeroes.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

    }
}
