package array;

public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        int returnInt = 0;
        for(int i = 0; i < nums.length; i++){
            int size = 0;
            if(nums[i] != Integer.MAX_VALUE){
                int start = nums[i];

                while(nums[start] != Integer.MAX_VALUE){
                    int temp = start;
                    size++;
                    start = nums[start];
                    nums[temp] = Integer.MAX_VALUE;
                }
            }
            returnInt = Math.max(returnInt, size);
        }
        return returnInt;
    }
}
