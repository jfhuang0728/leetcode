package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0){
            return new ArrayList();
        }
        List<Integer> returnList = new ArrayList<>();
        int xSize = matrix.length;
        int ySize = matrix[0].length;
        boolean[][] visitFlag = new boolean[xSize][ySize];
        int[] xMoveArray = {0, 1, 0, -1};
        int[] yMoveArray = {1, 0, -1, 0};
        int moveIndex = 0;
        int x = 0;
        int y = 0;
        for(int i = 0; i < xSize*ySize; i++){
            returnList.add(matrix[x][y]);
            visitFlag[x][y] = true;
            int nextX = x + xMoveArray[moveIndex];
            int nextY = y + yMoveArray[moveIndex];
            if((nextX <= xSize - 1) && (nextX >= 0) && (nextY <= ySize - 1) && (nextY >= 0) && !visitFlag[nextX][nextY]){
                x = nextX;
                y = nextY;
            }else{
                moveIndex = (moveIndex + 1)%4;
                x = x + xMoveArray[moveIndex];
                y = y + yMoveArray[moveIndex];
            }
        }
        return returnList;

    }
}
