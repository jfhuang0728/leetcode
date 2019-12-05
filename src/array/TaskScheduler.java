package array;

import java.util.Arrays;

public class TaskScheduler {
    public int leastIntervalMethodOne(char[] tasks, int n) {
        int time = 0;
        int[] nums = new int[26];
        for(char c : tasks){
            nums[c - 'A']++;
        }
        Arrays.sort(nums);
        while(nums[25] > 0){
            int i = 0;
            while(i <= n){
                if(nums[25] == 0){
                    break;
                }
                if(i < 26 && nums[25 - i] > 0){
                    nums[25 - i]--;
                }
                i++;
                time++;
            }
            Arrays.sort(nums);
        }
        return time;
    }
}
