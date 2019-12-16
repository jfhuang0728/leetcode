package dp;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }
        int[] benefit = new int[prices.length];
        int returnInt = 0;
        benefit[0] = 0;
        for(int i = 1; i < prices.length; i++){
            benefit[i] = Math.max(0, benefit[i - 1] + prices[i] - prices[i - 1]);
            returnInt = Math.max(benefit[i], returnInt);
        }
        return returnInt;
    }
}
