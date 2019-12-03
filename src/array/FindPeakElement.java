package array;

public class FindPeakElement {
        public int findPeakElement(int[] nums) {
            if(nums.length == 0){
                return -1;
            }
            int start = 0;
            int end = nums.length - 1;
            while(end - start > 1){
                int mid = start + (end -start)/2;
                if(nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]){
                    start = mid;
                }else if(nums[mid] < nums[mid - 1] && nums[mid] > nums[mid + 1]){
                    end = mid;
                }else if(nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]){
                    end = mid;
                }else if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
                    return mid;
                }
            }
            if(nums[start] > nums[end]){
                return start;
            }
            return end;
        }
}
