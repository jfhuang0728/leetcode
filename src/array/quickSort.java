package array;

public class quickSort {
    public void sortColors(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }
    private void sort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        int i = partition(nums, left, right);
        sort(nums, left, i - 1);
        sort(nums, i + 1, right);
    }
    private int partition(int[] nums, int left, int right){
        int i = left;
        int j = right + 1;
        int ref = nums[left];
        while(true){
            while(nums[++i] < ref){
                if(i == right){
                    break;
                }
            }
            while(nums[--j] > ref){
                if(j == left){
                    break;
                }
            }
            if(i >= j){
                break;
            }
            exchange(nums, i, j);
        }
        exchange(nums, j, left);
        return j;
    }
    private void exchange(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
