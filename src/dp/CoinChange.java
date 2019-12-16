package dp;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0){
            return 0;
        }
        int[] nums = new int[amount + 1];
        nums[0] = 0;
        for(int i = 1; i <= amount; i++){
            nums[i] = -1;
            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] >= 0 && nums[i - coins[j]] != -1){
                    if(nums[i] == -1 | nums[i - coins[j]] + 1 < nums[i]){
                        nums[i] = nums[i - coins[j]] + 1;
                    }
                }
            }
        }
        return nums[amount];
    }
}
