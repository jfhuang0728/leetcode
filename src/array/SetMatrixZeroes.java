package array;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeroes {
    public void setZeroesMethodOne(int[][] matrix) {
        if(matrix.length == 0){
            return;
        }
        List<int[]> zeroPlaces = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    zeroPlaces.add(new int[]{i, j});
                }
            }
        }

        for(int[] place : zeroPlaces){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][place[1]] = 0;
            }
            for(int j = 0; j < matrix[0].length; j++){
                matrix[place[0]][j] = 0;
            }
        }
    }
    public void setZeroesMethodTwo(int[][] matrix) {
        if(matrix.length == 0){
            return;
        }
        boolean isRow = false;
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = 0; i < col; i++){
            if(matrix[0][i] == 0){
                isRow = true;
            }
            for(int j = 1; j < row; j++){
                if(matrix[j][i] == 0){
                    matrix[0][i] = 0;
                    matrix[j][0] = 0;
                }
            }
        }

        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(matrix[0][0] == 0){
            for(int i = 0; i < row; i++){
                matrix[i][0] = 0;
            }
        }
        if(isRow){
            for(int i = 0; i < col; i++){
                matrix[0][i] = 0;
            }
        }
    }
}
