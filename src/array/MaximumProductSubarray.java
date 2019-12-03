package array;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int size = nums.length;
        int[][] maxAndMin = new int[size][2];
        maxAndMin[0] = new int[]{nums[0], nums[0]};
        int returnInt = maxAndMin[0][0];
        for(int i = 1; i < size; i++){
            if(nums[i] > 0){
                maxAndMin[i][0] = Math.max(nums[i] * maxAndMin[i - 1][0], nums[i]);
                maxAndMin[i][1] = Math.min(nums[i] * maxAndMin[i - 1][1], nums[i]);
            }else if(nums[i] < 0){
                maxAndMin[i][0] = Math.max(nums[i] * maxAndMin[i - 1][1], nums[i]);
                maxAndMin[i][1] = Math.min(nums[i] * maxAndMin[i - 1][0], nums[i]);
            }else{
                maxAndMin[i][0] = 0;
                maxAndMin[i][1] = 0;
            }
            if(maxAndMin[i][0] > returnInt){
                returnInt = maxAndMin[i][0];
            }
        }
        return returnInt;
    }
}
