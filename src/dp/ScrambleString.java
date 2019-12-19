package dp;

public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();
        int n = ss1.length;
        if(ss2.length != n){
            return false;
        }
        boolean[][][] f = new boolean[n][n][n + 1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                f[i][j][1] = ss1[i] == ss2[j];
            }
        }
        for(int k = 2; k < n + 1; k++){
            for(int i = 0; i < n - k + 1; i++){
                for(int j = 0; j < n - k + 1; j++){
                    f[i][j][k] = false;
                    for(int w = 1; w < k; w++){
                        if(f[i][j][w] && f[i + w][j + w][k - w]){
                            f[i][j][k] = true;
                            break;
                        }
                        if(f[i][j + k - w][w] && f[i + w][j][k - w]){
                            f[i][j][k] = true;
                            break;
                        }

                    }
                }
            }
        }
        return f[0][0][n];
    }
}
