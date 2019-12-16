package dp;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] maxSum = new int[nums.length];
        int returnInt = nums[0];
        maxSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            maxSum[i] = Math.max(maxSum[i - 1] + nums[i], nums[i]);
            if(maxSum[i] > returnInt){
                returnInt = maxSum[i];
            }
        }
        return returnInt;
    }
}
