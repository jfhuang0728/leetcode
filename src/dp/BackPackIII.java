package dp;

//此时背包里每个元素都可以取无穷多次
public class BackPackIII {
    public int backPackIII(int m, int[] A, int[] V) {
        int n = A.length;
        if(n == 0) {
            return 0;
        }
        int[][] f = new int[n + 1][m + 1];
        f[0][0] = 0;
        for(int i = 1; i < m + 1; i++){
            f[0][i] = -1;
        }
        for(int i = 1; i < n + 1; i++){
            f[i][0] = 0;
            for(int j = 0; j < m + 1; j++){
                f[i][j] = f[i - 1][j];
                if(j - A[i - 1] >= 0 && f[i - 1][j - A[i - 1]] != -1){
                    f[i][j] = Math.max(f[i][j], f[i][j - A[i - 1]] + V[i - 1]);
                }
            }
        }
        int returnInt = 0;
        for(int i = 0; i < m + 1; i++){
            if(f[n][i] != -1){
                returnInt = Math.max(returnInt, f[n][i]);
            }
        }
        return returnInt;
    }

}
