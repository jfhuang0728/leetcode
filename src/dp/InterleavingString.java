package dp;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();
        char[] ss3 = s3.toCharArray();
        int a = ss1.length;
        int b = ss2.length;
        int c = ss3.length;
        if(a + b != c){
            return false;
        }
        boolean[][] f = new boolean[a + 1][b + 1];
        for(int i = 0; i < a + 1; i++){
            for(int j = 0; j < b + 1; j++){
                if(i == 0 && j == 0){
                    f[0][0] = true;
                    continue;
                }
                f[i][j] = false;
                if(i > 0 && ss3[i + j - 1] == ss1[i - 1]){
                    f[i][j] |= f[i - 1][j];
                }
                if(j > 0 && ss3[i + j - 1] == ss2[j - 1]){
                    f[i][j] |= f[i][j - 1];
                }
            }
        }
        return f[a][b];
    }
}
