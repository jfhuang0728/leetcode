package array;

public class MinimumSizeSubarraySum {
    //双指针：每次移动慢指针
    public int minSubArrayLenMethodOne(int s, int[] nums) {
        if(nums.length == 0 || s == 0){
            return 0;
        }
        int fast = 0;
        int returnInt = Integer.MAX_VALUE;
        int sum = nums[0];
        for(int slow = 0; slow < nums.length - 1; slow++){
            while(fast < nums.length - 1 && sum < s){
                sum += nums[++fast];
            }
            if(sum >= s && fast - slow + 1 < returnInt){
                returnInt = fast - slow + 1;
            }
            sum -= nums[slow];
        }
        return returnInt == Integer.MAX_VALUE ? 0:returnInt;
    }
    //方法二：每次移动快指针
    public int minSubArrayLenMethodTwo(int s, int[] nums) {
        if(nums.length == 0 || s == 0){
            return 0;
        }
        int slow= 0;
        int returnInt = Integer.MAX_VALUE;
        int sum = 0;
        for(int fast = 0; fast < nums.length; fast++){
            sum = sum + nums[fast];
            while(sum >= s){
                returnInt = Math.min(returnInt, fast - slow + 1);
                sum -= nums[slow++];
            }
        }
        return returnInt == Integer.MAX_VALUE ? 0:returnInt;
    }
}
