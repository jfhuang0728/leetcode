package array;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        int x = grid.length;
        int y = grid[0].length;
        int[][] sumInGrid = new int[x][y];

        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                if(i == 0 && j == 0){
                    sumInGrid[i][j] = grid[i][j];
                    continue;
                }
                if(i == 0 && j > 0){
                    sumInGrid[i][j] = sumInGrid[i][j - 1] + grid[i][j];
                    continue;
                }
                if(j == 0 && i > 0){
                    sumInGrid[i][j] = sumInGrid[i - 1][j] + grid[i][j];
                    continue;
                }

                sumInGrid[i][j] = Math.min(sumInGrid[i - 1][j], sumInGrid[i][j - 1]) + grid[i][j];
            }
        }
        return sumInGrid[x - 1][y - 1];
    }
}
