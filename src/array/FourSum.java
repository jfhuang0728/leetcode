package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4){
            return new ArrayList();
        }
        Arrays.sort(nums);
        List<List<Integer>> returnList = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for (int j = i + 1; j < nums.length; j++){
                if (j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }

                int leftIndex = j + 1;
                int rightIndex = nums.length - 1;
                while (leftIndex < rightIndex){
                    int sum = nums[i] + nums[j] + nums[leftIndex] + nums[rightIndex];
                    if (sum < target){

                        leftIndex++;
                    }else if (sum > target){

                        rightIndex--;
                    }else{
                        returnList.add(Arrays.asList(nums[i], nums[j], nums[leftIndex], nums[rightIndex]));
                        while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex + 1]){
                            leftIndex++;
                        }
                        while (rightIndex > leftIndex && nums[rightIndex] == nums[rightIndex - 1]){
                            rightIndex--;
                        }
                        leftIndex++;
                        rightIndex--;
                    }
                }
            }
        }
        return returnList;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        int[] input = {-1,0,-5,-2,-2,-4,0,1,-2};
        int target = -9;
        List<List<Integer>> lists = fourSum.fourSum(input, target);
        for (List list:lists){
            System.out.println(list);
        }
    }
}
