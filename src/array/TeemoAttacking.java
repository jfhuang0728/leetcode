package array;

import java.util.LinkedList;
import java.util.Queue;

public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length == 0){
            return 0;
        }
        int totalTime = 0;
        for(int i = 1; i < timeSeries.length; i++){
            int preTime = timeSeries[i - 1];
            int nextTime = timeSeries[i];
            if(nextTime - preTime >= duration){
                totalTime += duration;
            }else{
                totalTime += nextTime - preTime;
            }
        }
        totalTime += duration;
        return totalTime;
    }
}
