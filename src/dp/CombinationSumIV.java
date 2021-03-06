package dp;

public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] f = new int[target + 1];
        f[0] = 1;
        for(int i = 1; i < target + 1; i++){
            f[i] = 0;
            for(int j = 0; j < nums.length; j++){
                if(i - nums[j] >= 0){
                    f[i] += f[i - nums[j]];
                }
            }
        }
        return f[target];
    }
}
