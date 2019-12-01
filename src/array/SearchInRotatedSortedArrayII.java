package array;

public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0){
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        while (end > start + 1){
            int mid = start + (end - start)/2;
            if (nums[mid] < nums[start] && (target < nums[mid] || target >= nums[start])){
                end = mid;
            }else if (nums[mid] < nums[start] && target > nums[mid] &&  target < nums[start]){
                start = mid;
            }else if (nums[mid] > nums[start] && target < nums[mid] && target >= nums[start]){
                end = mid;
            }else if (nums[mid] > nums[start] && (target > nums[mid] || target < nums[start])){
                start = mid;
            }else if (nums[mid] == target){
                return true;
            }else if(nums[mid] == nums[start]){
                start++;
            }
        }
        if (nums[start] == target){
            return true;
        }
        if (nums[end] == target){
            return true;
        }
        return false;
    }
}
