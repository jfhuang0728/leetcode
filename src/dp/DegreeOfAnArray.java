package dp;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(left.get(nums[i]) == null){
                left.put(nums[i], i);
            }
            right.put(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1) ;
        }
        int degree = Collections.max(count.values());
        int returnInt = nums.length;
        for(int key : count.keySet()){
            if(count.get(key) == degree){
                returnInt = Math.min(returnInt, right.get(key) - left.get(key) + 1);
            }
        }
        return returnInt;
    }
}
