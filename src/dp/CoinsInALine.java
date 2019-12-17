package dp;

public class CoinsInALine {
    public boolean firstWillWin(int n) {
        // write your code here
        if(n == 0){
            return false;
        }
        boolean[] f = new boolean[n + 1];
        f[0] = false;
        f[1] = true;
        for(int i = 2; i < n + 1; i++){
            f[i] = !(f[i - 1] && f[i - 2]);
        }
        return f[n];
    }
}
