package array;

import java.util.Arrays;
import java.util.HashSet;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (end - start > 1){
            int mid = start + (end - start)/2;
            if (nums[mid] > target){
                end = mid;
            }else if (nums[mid] < target){
                start = mid;
            }else {
                int returnStart = mid;
                int returnEnd = mid;

                return findIndexLowAndUp(nums, returnStart, returnEnd, target);
            }
        }
        if (nums[start] == target){
            return findIndexLowAndUp(nums, start, start, target);
        }
        if (nums[end] == target){
            return findIndexLowAndUp(nums, end, end, target);
        }
        return new int[]{-1,-1};
    }
    private int[] findIndexLowAndUp(int[] nums, int returnStart, int returnEnd, int target){
        while (nums[returnStart] == target && returnStart >= 0){
            returnStart--;
        }
        while (nums[returnEnd] == target && returnEnd < nums.length){
            returnEnd++;
        }
        int[] returnRange = {returnStart, returnEnd};
        return returnRange;
    }
}
