package array;

public class RotateImage {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        middleLineFold(matrix);
    }
    private void transpose(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = i; j < matrix.length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    private void middleLineFold(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j - 1];
                matrix[i][matrix.length - j - 1] = temp;

            }
        }
    }

    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();
        int[][] input = {{1,2,3},{4,5,6},{7,8,9}};
        rotateImage.rotate(input);
        System.out.println();
    }
}
