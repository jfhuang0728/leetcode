package array;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int returnInt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            nums[i] = sum;
        }
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i] - k)){
                returnInt += map.get(nums[i] - k);
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return returnInt;
    }
}
