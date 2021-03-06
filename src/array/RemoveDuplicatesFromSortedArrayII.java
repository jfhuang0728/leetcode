package array;

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int slow = 0;
        for(int fast = 1; fast < nums.length; fast++){
            if(nums[slow] != nums[fast] || slow == 0){
                slow++;
                nums[slow] = nums[fast];
            }else if (slow > 0 && nums[slow] == nums[fast] && nums[slow] != nums[slow - 1]){
                slow++;
                nums[slow] = nums[fast];
            }

        }
        return slow + 1;
    }
}
