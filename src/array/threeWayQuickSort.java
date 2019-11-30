package array;

public class threeWayQuickSort {
    public void sortColors(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }
    private void sort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        int lt = left;
        int gt = right;
        int ref = nums[left];
        int i = left + 1;
        while(i <= gt){
            int compare = nums[i];
            if(compare < ref){
                exchange(nums, lt++, i++);
            }else if(compare > ref){
                exchange(nums, gt--, i);
            }else{
                i++;
            }
        }
        sort(nums, left, lt - 1);
        sort(nums, gt + 1, right);
    }
    private void exchange(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
