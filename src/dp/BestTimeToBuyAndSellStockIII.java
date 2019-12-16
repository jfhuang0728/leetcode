package dp;

public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if(prices.length < 2){
            return 0;
        }
        int[][] f = new int[prices.length + 1][5 + 1];
        f[0][1] = 0;
        for(int i = 2; i < 6; i++){
            f[0][i] = Integer.MIN_VALUE;
        }
        for(int i = 1; i <= prices.length; i++){
            for(int j = 1; j < 6; j += 2){
                f[i][j] = f[i - 1][j];
                if(j - 1 >= 1 && i - 2 >= 0 && f[i - 1][j - 1] != Integer.MIN_VALUE){
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + prices[i - 1] - prices[i - 2]);
                }
            }
            for(int j = 2; j < 6; j += 2){
                f[i][j] = f[i - 1][j - 1];
                if(i - 2 >= 0 && f[i - 1][j] != Integer.MIN_VALUE){
                    f[i][j] = Math.max(f[i][j], f[i - 1][j] + prices[i - 1] - prices[i - 2]);
                }
            }
        }
        return Math.max(f[prices.length][1], Math.max(f[prices.length][3], f[prices.length][5]));
    }
}
