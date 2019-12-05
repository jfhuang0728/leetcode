package array;

import java.util.Arrays;

public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length - 2; i++){
            int k = i + 2;
            for(int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++){
                k = binarySearch(nums, k - 1, nums.length - 1, nums[i] + nums[j]);
                count = count + k - j;
            }
        }
        return count;
    }
    private int binarySearch(int[] nums, int left, int right, int target){
        while(right - left > 1){
            int mid = left + (right - left)/2;
            if(nums[mid] < target){
                left = mid;
            }else{
                right = mid;
            }
        }
        if(nums[right] >= target){
            return left;
        }else{
            return right;
        }
    }
}
