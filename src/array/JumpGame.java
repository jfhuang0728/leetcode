package array;

public class JumpGame {
    public boolean canJumpMethodOne(int[] nums) {
        //动态规划
        boolean[] canArrive = new boolean[nums.length];
        canArrive[0] = true;
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(canArrive[j] == true && nums[j] + j >= i){
                    canArrive[i] = true;
                    break;
                }
            }
        }
        return canArrive[nums.length - 1];
    }
    public boolean canJumpMethodTwo(int[] nums) {
        //贪心算法
        if(nums == null || nums.length == 0){
            return false;
        }
        int fastest = nums[0];
        for(int i = 1;i < nums.length;i++){
            if(fastest >= i && (nums[i] + i > fastest)){
                fastest = nums[i] + i;
            }else if(fastest < i){
                return false;
            }
        }
        return true;
    }
}
