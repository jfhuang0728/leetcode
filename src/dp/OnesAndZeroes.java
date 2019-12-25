package dp;

public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] f = new int[strs.length + 1][m + 1][n + 1];
        for(int i = 0; i < m + 1; i++){
            for(int j = 0; j < n + 1; j++){
                f[0][i][j] = 0;
            }
        }

        for(int k = 1; k < strs.length + 1; k++){
            int a0 = 0;
            int a1 = 0;
            for(int i = 0; i < strs[k - 1].length(); i++){
                if(strs[k - 1].charAt(i) == '0'){
                    a0++;
                }else{
                    a1++;
                }
            }
            for(int i = 0; i < m + 1; i++){
                for(int j = 0; j < n + 1; j++){
                    f[k][i][j] = f[k - 1][i][j];
                    if(i >= a0 && j >= a1){
                        f[k][i][j] = Math.max(f[k][i][j], f[k - 1][i - a0][j - a1] + 1);
                    }
                }
            }
        }
        return f[strs.length][m][n];
    }
}
