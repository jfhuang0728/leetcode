package dp;

public class CountingBits {
    public int[] countBits(int num) {
        int[] count = new int[num + 1];
        count[0] = 0;
        for(int i = 1; i < num + 1; i++){
            count[i] = count[i >> 1] + i % 2;
        }
        return count;
    }
}
