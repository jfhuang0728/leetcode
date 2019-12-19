package dp;

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int n  = nums.length;
        if(n == 0){
            return 0;
        }
        int[] ballons = new int[n + 2];
        ballons[0] = 1;
        for(int i = 1; i < n + 1; i++){
            ballons[i] = nums[i - 1];
        }
        ballons[n + 1] = 1;
        n += 2;
        int[][] f = new int[n][n];
        for(int i = 0; i < n - 1; i++){
            f[i][i + 1] = 0;
        }
        for(int len = 3; len < n + 1; len++){
            for(int i = 0; i < n - len + 1; i++){
                int j = i + len - 1;
                f[i][j] = Integer.MIN_VALUE;
                for(int k = i + 1; k < j; k++){
                    f[i][j] = Math.max(f[i][j], f[i][k] + f[k][j] + ballons[i]*ballons[j]*ballons[k]);
                }
            }
        }
        return f[0][n - 1];
    }
}
