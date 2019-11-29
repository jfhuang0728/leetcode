package array;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        if(n == 0){
            return new int[][]{{}};
        }
        int[][] resultsArray = new int[n][n];
        boolean[][] isVisited =new boolean[n][n];
        int[] xMoveSet = {0, 1, 0, -1};
        int[] yMoveSet = {1, 0, -1, 0};
        int moveIndex = 0;
        int xIndex = 0;
        int yIndex = 0;
        int i = 0;
        while(i < n * n){
            resultsArray[xIndex][yIndex] = ++i;
            isVisited[xIndex][yIndex] = true;
            if(xIndex + xMoveSet[moveIndex] < n &&
                    xIndex + xMoveSet[moveIndex] >=0 &&
                    yIndex + yMoveSet[moveIndex] < n &&
                    yIndex + yMoveSet[moveIndex] >= 0 &&
                    !isVisited[xIndex + xMoveSet[moveIndex]][yIndex + yMoveSet[moveIndex]])
            {
                xIndex = xIndex + xMoveSet[moveIndex];
                yIndex = yIndex + yMoveSet[moveIndex];
            }else{
                moveIndex = (moveIndex + 1) % 4;
                xIndex = xIndex + xMoveSet[moveIndex];
                yIndex = yIndex + yMoveSet[moveIndex];
            }
        }
        return resultsArray;
    }

    public static void main(String[] args) {
        SpiralMatrixII spiralMatrixII = new SpiralMatrixII();
        int[][] results = spiralMatrixII.generateMatrix(3);
    }
}
