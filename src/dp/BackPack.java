package dp;

public class BackPack {
    public int backPack(int m, int[] A) {
        // write your code here
        boolean[][] f = new boolean[A.length + 1][m + 1];
        f[0][0] = true;
        for(int i = 1; i < m + 1; i++){
            f[0][i] = false;
        }
        for(int i = 1; i < A.length + 1; i++){
            f[i][0] = true;
            for(int j = 1; j < m + 1; j++){
                f[i][j] = f[i - 1][j];
                if(j - A[i - 1] >= 0){
                    f[i][j] |= f[i - 1][j - A[i - 1]];
                }

            }
        }
        int returnInt = 0;
        for(int i = 0; i < m + 1; i++){
            if(f[f.length - 1][i]){
                returnInt = i;
            }

        }
        return returnInt;
    }
}
