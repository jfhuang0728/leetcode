package dp;

public class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] total = new int[nums.length + 2];
        total[0] = 0;
        total[1] = 0;
        for(int i = 2; i < total.length; i++){
            total[i] = Math.max(total[i - 1], total[i - 2] + nums[i - 2]);
        }
        return total[total.length - 1];
    }
}
