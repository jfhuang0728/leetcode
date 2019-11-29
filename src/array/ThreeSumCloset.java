package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumCloset {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3){
            throw  new IllegalArgumentException();
        }
        Double distance = Double.POSITIVE_INFINITY;
        Arrays.sort(nums);
        int returnInt = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int leftIndex = i + 1;
            int rightIndex = nums.length - 1;
            while (rightIndex > leftIndex){
                int sum = nums[i] + nums[leftIndex] + nums[rightIndex];
                if ((target - sum) > 0){
                    while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex + 1]){
                        leftIndex++;
                    }
                    if (Math.abs(target - sum) < distance){
                        distance = Double.valueOf(Math.abs(target - sum));
                        returnInt = nums[i] + nums[leftIndex] + nums[rightIndex];
                    }
                    leftIndex++;
                }else if ((target - sum) < 0){
                    while (rightIndex > leftIndex && nums[rightIndex] == nums[rightIndex - 1]){
                        rightIndex--;
                    }
                    if (Math.abs(target - sum) < distance){
                        distance = Double.valueOf(Math.abs(target - sum));
                        returnInt = nums[i] + nums[leftIndex] + nums[rightIndex];
                    }
                    rightIndex--;
                }else{
                    return target;
                }
            }
        }
        return returnInt;
    }
    public static void main(String[] args) {
        int[] input = {-1,2,1,-4};
        ThreeSumCloset threeSumCloset = new ThreeSumCloset();;
        int result =  threeSumCloset.threeSumClosest(input, 1);
        System.out.println(result);
    }
}
