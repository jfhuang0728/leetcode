package dp;

public class BackPackV {
        /**
         * @param nums: an integer array and all positive numbers
         * @param target: An integer
         * @return: An integer
         */
        public int backPackV(int[] nums, int target) {
            // write your code here
            int[][] f = new int[1][target + 1];
            f[0][0] = 1;
            for (int i = 1; i < target + 1; i++) {
                f[0][i] = 0;
            }
            for (int i = 1; i < nums.length + 1; i++) {
                for (int j = target; j >= 0; j--) {
                    f[0][j] = f[0][j];
                    if (j - nums[i - 1] >= 0) {
                        f[0][j] = f[0][j] + f[0][j - nums[i - 1]];
                    }
                }
            }
            return f[0][target];
        }
}
