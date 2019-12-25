package dp;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] AA = text1.toCharArray();
        char[] BB = text2.toCharArray();
        int m = AA.length;
        int n = BB.length;
        int[][] f = new int[m + 1][n + 1];
        for(int i = 0; i < m + 1; i++){
            f[i][0] = 0;
        }
        for(int j = 0; j < n + 1; j++){
            f[0][j] = 0;
        }
        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if(AA[i - 1] == BB[j - 1]){
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
                }
            }
        }
        return f[m][n];
    }
}
