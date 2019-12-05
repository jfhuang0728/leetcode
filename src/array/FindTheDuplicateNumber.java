package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class FindTheDuplicateNumber {
    public int findDuplicateMethodOne(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int left = 1;
        int right = nums.length - 1;
        while(right - left > 1){
            int mid = left + (right - left)/2;
            int count = 0;
            for(int num : nums){
                if(num < mid){
                    count++;
                }
            }
            if(count >= mid){
                right = mid;
            }else{
                left =  mid;
            }
        }
        int rightCount = 0;
        for(int num : nums){
            if(num == right){
                rightCount++;
            }
        }
        return rightCount > 1 ? right : left;
    }

    public int findDuplicateMethodTwo(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];
        do{
            fast = nums[nums[fast]];
            slow = nums[slow];
        }while(fast != slow);

        int pointer1 = slow;
        int pointer2 = nums[0];
        while(pointer1 != pointer2){
            pointer1 = nums[pointer1];
            pointer2 = nums[pointer2];
        }
        return pointer2;
    }
}
