package array;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] arriveWays = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m;j++){
                if(i == 0 || j == 0){
                    arriveWays[i][j] = 1;
                    continue;
                }
                arriveWays[i][j] = arriveWays[i - 1][j] + arriveWays[i][j - 1];
            }
        }
        return arriveWays[n - 1][m - 1];
    }
}
