package dp;

public class LongestPalindromicSubsequence {
    //动态规划解法
    public int longestPalindromeSubseq(String s) {
        char[] ss = s.toCharArray();
        int n = ss.length;
        int[][] f = new int[n][n];
        for(int i = 0; i < n; i++){
            f[i][i] = 1;
        }
        for(int i = 0; i < n - 1; i++){
            f[i][i + 1] = ss[i] == ss[i + 1] ? 2 : 1;
        }
        for(int len = 3; len < n + 1; len++){
            for(int i = 0; i < n -len + 1; i++){
                if(ss[i] == ss[i + len - 1]){
                    f[i][i + len - 1] = f[i + 1][i + len - 2] + 2;
                }else{
                    f[i][i + len - 1] = Math.max(f[i + 1][i + len - 1], f[i][i + len - 2]);
                }
            }
        }
        return f[0][n - 1];
    }
}
