package array;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums[0] <= nums[nums.length - 1]){
            return nums[0];
        }
        int start = 0;
        int end = nums.length - 1;
        int returnInt = nums[start];
        while(end - start > 1){
            int mid = start + (end - start)/2;
            if(nums[mid] < returnInt){
                returnInt = nums[mid];
                end = mid;
            }else{
                start = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
}
