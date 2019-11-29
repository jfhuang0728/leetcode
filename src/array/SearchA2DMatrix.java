package array;

public class SearchA2DMatrix {
    public boolean searchMatrixMethodOne(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        while(rowEnd - rowStart > 1){
            int mid = rowStart + (rowEnd - rowStart)/2;
            if(matrix[mid][0] > target){
                rowEnd = mid;
            }else if(matrix[mid][0] < target){
                rowStart = mid;
            }else{
                return true;
            }
        }
        if(matrix[rowStart][0] == target){
            return true;
        }
        if(matrix[rowEnd][0] == target){
            return true;
        }
        if(matrix[rowEnd][0] < target){
            rowStart = rowEnd;
        }
        while(colEnd - colStart > 1){
            int mid = colStart + (colEnd - colStart)/2;
            if(matrix[rowStart][mid] > target){
                colEnd = mid;
            }else if(matrix[rowStart][mid] < target){
                colStart = mid;
            }else{
                return true;
            }
        }
        if(matrix[rowStart][colStart] == target){
            return true;
        }
        if(matrix[rowStart][colEnd] == target){
            return true;
        }
        return false;
    }
    public boolean searchMatrixMethodTwo(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int start = 0;
        int end = rowLength * colLength - 1;
        while(end - start > 1){
            int mid = start + (end - start)/2;
            if(matrix[mid / colLength][mid % colLength] > target){
                end = mid;
            }else if(matrix[mid / colLength][mid % colLength] < target){
                start = mid;
            }else{
                return true;
            }
        }
        if(matrix[start / colLength][start % colLength] == target){
            return true;
        }
        if(matrix[end / colLength][end % colLength] == target){
            return true;
        }
        return false;
    }
}
