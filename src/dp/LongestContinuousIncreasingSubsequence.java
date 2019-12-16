package dp;

public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int pre = 1;
        int cur = 1;
        int returnInt = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] < nums[i]){
                cur = pre + 1;
                pre = cur;
            }else{
                cur = 1;
                pre = 1;
            }
            returnInt = Math.max(returnInt, cur);
        }
        return returnInt;
    }

}
