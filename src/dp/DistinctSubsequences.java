package dp;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int n = ss.length;
        int m = tt.length;
        if(n < m){
            return 0;
        }
        int[][] f = new int[n + 1][m + 1];
        for(int i = 0; i < n + 1; i++){
            for(int j = 0; j < m + 1; j++){
                if(j == 0){
                    f[i][0] = 1;
                    continue;
                }
                if(i == 0){
                    f[0][j] = 0;
                    continue;
                }
                f[i][j] = f[i - 1][j];
                if(ss[i - 1] == tt[j - 1]){
                    f[i][j] = f[i - 1][j - 1] + f[i][j];
                }
            }
        }
        return f[n][m];
    }
}
