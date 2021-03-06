package dp;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        int n = ss.length;
        int m = pp.length;
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for(int i = 1; i < n + 1; i++){
            f[i][0] = false;
        }
        for(int i = 0; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++){
                f[i][j] = false;
                if(i > 0 && (pp[j - 1] == ss[i - 1] || pp[j - 1] == '.')){
                    f[i][j] |= f[i - 1][j - 1];
                }
                if(pp[j - 1] == '*'){

                    if(j > 1){
                        f[i][j] |= f[i][j - 2];
                        if(i > 0 && (ss[i - 1] == pp[j - 2] || pp[j - 2] == '.')){
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }
        return f[n][m];
    }
}
