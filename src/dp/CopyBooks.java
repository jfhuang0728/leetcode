package dp;

public class CopyBooks {
    public int copyBooks(int[] pages, int k) {
        if(k == 0){
            return -1;
        }
        if(pages.length == 0){
            return 0;
        }
        int[][] f = new int[k + 1][pages.length + 1];
        f[0][0] = 0;
        for(int i = 1; i < pages.length + 1; i++){
            f[0][i] = Integer.MAX_VALUE;
        }
        for(int K = 1; K <= k; K++){
            f[K][0] = 0;
            for(int i = 1; i < pages.length + 1; i++){
                f[K][i] = Integer.MAX_VALUE;
                int sum = 0;
                for(int j = i; j >= 0; j--){
                    f[K][i] = Math.min(f[K][i], Math.max(f[K - 1][j], sum));
                    if(j > 0){
                        sum += pages[j - 1];
                    }

                }
            }
        }
        return f[k][pages.length];
    }
}
