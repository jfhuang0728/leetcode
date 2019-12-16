package dp;

public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if(prices.length < 2){
            return 0;
        }
        if(k > prices.length/2){
            int returnInt = 0;
            for(int i = 0; i < prices.length - 1; i++){
                if(prices[i] < prices[i + 1]){
                    returnInt += prices[i + 1] - prices[i];
                }
            }
            return returnInt;
        }
        int[][] f = new int[2][2*k + 2];
        int old, now = 0;
        f[0][1] = 0;
        for(int i = 2; i < 2*k + 2; i++){
            f[now][i] = Integer.MIN_VALUE;
        }
        for(int i = 1; i <= prices.length; i++){
            old = now;
            now = 1 - old;
            for(int j = 1; j < 2*k + 2; j += 2){
                f[now][j] = f[old][j];
                if(j - 1 >= 1 && i - 2 >= 0 && f[old][j - 1] != Integer.MIN_VALUE){
                    f[now][j] = Math.max(f[now][j], f[old][j - 1] + prices[i - 1] - prices[i - 2]);
                }
            }
            for(int j = 2; j < 2*k + 2; j += 2){
                f[now][j] = f[old][j - 1];
                if(i - 2 >= 0 && f[old][j] != Integer.MIN_VALUE){
                    f[now][j] = Math.max(f[now][j], f[old][j] + prices[i - 1] - prices[i - 2]);
                }
            }
        }
        int returnInt = Integer.MIN_VALUE;
        for(int i = 1; i < 2*k + 2; i += 2){
            returnInt = Math.max(returnInt, f[now][i]);
        }
        return returnInt;
    }
}
