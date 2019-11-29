package array;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums.length < 2){
            return;
        }
        for (int i = nums.length - 1; i >= 0 ; i--) {
            if (nums[i] > nums[i - 1]){
                for (int j = nums.length - 1; j > i - 1 ; j--) {
                    int nextHead = nums[i - 1];
                    if (nextHead < nums[j]){
                        swap(nums, i - 1, j);
                        break;
                    }
                }
                for (int j= i, k = nums.length - 1; j < k; j++, k--){
                    swap(nums, j, k);
                }
                return;
            }
            if (i == 1){
                for (int j = 0, k = nums.length - 1; j < k; j++, k--){
                    swap(nums, j, k);
                }
                return;
            }
        }
    }
    private void swap(int[] nums, int indexBehind, int indexFront){
        int temp = nums[indexFront];
        nums[indexFront] = nums[indexBehind];
        nums[indexBehind] = temp;
    }

}
