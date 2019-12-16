package dp;

public class PalindromePartitioningII {
    public int minCut(String s) {
        char[] ss = s.toCharArray();
        int[] f = new int[ss.length + 1];
        boolean[][] isPalin = calPalin(ss);
        f[0] = 0;
        for(int i = 1; i < ss.length + 1; i++){
            f[i] = Integer.MAX_VALUE;
            for(int k = 0; k < i; k++){
                if(isPalin[k][i - 1]){
                    f[i] = Math.min(f[i], f[k] + 1);
                }
            }
        }
        return f[ss.length] - 1;
    }
    private boolean[][] calPalin(char[] ss){
        boolean[][] isPalin = new boolean[ss.length][ss.length];
        for(int i = 0; i < ss.length; i++){
            for(int j = 0; j < ss.length; j++){
                isPalin[i][j] = false;
            }
        }
        int start, end;
        for(int c = 0; c < ss.length; c++){
            start = end = c;
            while(start >=0 && end < ss.length && ss[start] == ss[end]){
                isPalin[start][end] = true;
                start--;
                end++;
            }
        }
        for(int c = 0; c < ss.length - 1; c++){
            start = c;
            end = c + 1;
            while(start >=0 && end < ss.length && ss[start] == ss[end]){
                isPalin[start][end] = true;
                start--;
                end++;
            }
        }
        return isPalin;
    }
}
