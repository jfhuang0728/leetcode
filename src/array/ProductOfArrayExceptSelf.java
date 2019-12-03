package array;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int k = 1;
        int[] returnArray = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            returnArray[i] = k;
            k *= nums[i];
        }
        k = 1;
        for(int i = nums.length - 1; i >=0; i--){
            returnArray[i] *= k;
            k *= nums[i];
        }
        return returnArray;
    }
}
