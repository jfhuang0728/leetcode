package dp;

public class HouseRobberII {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 0){
            return 0;
        }
        int startFromSecond = robWithLinear(nums, 1, nums.length);
        int endWithSecondEnd = robWithLinear(nums, 0, nums.length - 1);
        return startFromSecond > endWithSecondEnd ? startFromSecond : endWithSecondEnd;
    }
    private int robWithLinear(int[] nums, int start, int end){
        int[] total = new int[nums.length + 2];
        total[0] = 0;
        total[1] = 0;
        for(int i = 2; i < total.length; i++){
            if(start == 1 && i == 2){
                total[i] = 0;
                continue;
            }
            total[i] = Math.max(total[i - 1], total[i - 2] + nums[i - 2]);
        }
        if(end == nums.length - 1){
            return total[total.length - 2];
        }
        return total[total.length - 1];
    }
}
