package dp;

public class PaintHouse {
    //使用二维数组，空间复杂度为O(n)
    public int minCostOne(int[][] costs) {
        // write your code here
        if(costs.length == 0){
            return 0;
        }
        int[][] total = new int[costs.length + 1][costs[0].length];
        total[0][0] = total[0][1] = total[0][2] = 0;
        for(int i = 1; i < total.length; i++){
            for(int j = 0; j < 3; j++){
                total[i][j] = Integer.MAX_VALUE;
                for(int k = 0; k < 3; k++){
                    if(k != j && total[i - 1][k] + costs[i - 1][j] < total[i][j]){
                        total[i][j] = total[i - 1][k] + costs[i - 1][j];
                    }
                }
            }
        }
        return Math.min(total[total.length - 1][0], Math.min(total[total.length - 1][1], total[total.length - 1][2]));
    }
    //使用滚动数组优化，空间复杂度O(1)
    public int minCostTwo(int[][] costs) {
        // write your code here
        if(costs.length == 0){
            return 0;
        }
        int[][] total = new int[2][costs[0].length];
        int old = 0, now = 0;
        total[old][0] = total[old][1] = total[old][2] = 0;
        for(int i = 1; i < costs.length + 1; i++){
            old = now;
            now = 1 - old;
            for(int j = 0; j < 3; j++){
                total[now][j] = Integer.MAX_VALUE;
                for(int k = 0; k < 3; k++){
                    if(k != j && total[old][k] + costs[i - 1][j] < total[now][j]){
                        total[now][j] = total[old][k] + costs[i - 1][j];
                    }
                }
            }

        }
        return Math.min(total[now][0], Math.min(total[now][1], total[now][2]));
    }
}
