package array;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int x = obstacleGrid.length;
        int y = obstacleGrid[0].length;
        int[][] arriveWays = new int[x][y];
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                if(obstacleGrid[i][j] == 1){
                    arriveWays[i][j] = 0;
                    continue;
                }
                if(i == 0 && j > 0){
                    arriveWays[i][j] = arriveWays[i][j - 1];
                    continue;
                }
                if(j == 0 && i > 0){
                    arriveWays[i][j] = arriveWays[i - 1][j];
                    continue;
                }
                if(i == 0 && j == 0){
                    arriveWays[i][j] = 1;
                    continue;
                }
                arriveWays[i][j] = arriveWays[i - 1][j] + arriveWays[i][j - 1];
            }
        }
        return arriveWays[x - 1][y - 1];
    }
}
