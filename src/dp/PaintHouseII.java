package dp;

public class PaintHouseII {
    public int minCostII(int[][] costs) {
        // write your code here
        if(costs.length == 0){
            return 0;
        }
        int n = costs.length;
        int k = costs[0].length;
        int[][] total = new int[n + 1][k];
        int minimum;
        int secMini;
        for(int i = 0; i < k; i++){
            total[0][i] = 0;
        }
        for(int i = 1; i < n + 1; i++){
            minimum = -1;
            secMini = -1;
            for(int j = 0; j < k; j++){
                if(minimum == -1 || total[i - 1][j] < total[i - 1][minimum]){
                    secMini = minimum;
                    minimum = j;
                }else if(secMini == -1 || total[i - 1][j] < total[i - 1][secMini]){
                    secMini = j;
                }
            }
            for(int m = 0; m < k; m++){
                if(m == minimum){
                    total[i][m] = total[i - 1][secMini] + costs[i - 1][m];
                }else{
                    total[i][m] = total[i - 1][minimum] + costs[i - 1][m];
                }
            }
        }
        int returnInt = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++){
            returnInt = Math.min(returnInt, total[n][i]);
        }
        return returnInt;
    }
}
