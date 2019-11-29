package array;

public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
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
                return mid;
            }
        }
        if (nums[start] == target){
            return start;
        }
        if (nums[end] == target){
            return end;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input = {4,5,6,7,0,1,2};
        int target = 3;
        int search = search(input, target);
        System.out.println(search);
    }
}
