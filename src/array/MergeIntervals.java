package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        ArrayList<Integer[]> results = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] > o2[0] ? 1 : -1;
            }
        });
        int i = 0;
        while(i < intervals.length){
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < intervals.length - 1 && right > intervals[i + 1][0]){
                i++;
                right = Math.max(right, intervals[i + 1][1]);
            }
            results.add(new Integer[]{left, right});
        }
        return results.toArray(new int[0][0]);
    }
}
