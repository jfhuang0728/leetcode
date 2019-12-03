package array;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> returnList = new ArrayList<>();
        if(nums.length == 0){
            return returnList;
        }
        int candidateA = nums[0];
        int candidateB = nums[0];
        int countA = 0;
        int countB = 0;
        for(int num : nums){
            if(num == candidateA){
                countA++;
            }else if(num == candidateB){
                countB++;
            }else if(countA == 0){
                countA++;
                candidateA = num;
            }else if(countB == 0){
                countB++;
                candidateB = num;
            }else{
                countA--;
                countB--;
            }
        }

        countA = 0;
        countB = 0;
        for(int num : nums){
            if(num == candidateA){
                countA++;
            }else if(num == candidateB){
                countB++;
            }
        }
        if(countA > nums.length/3){
            returnList.add(candidateA);
        }
        if(countB > nums.length/3){
            returnList.add(candidateB);
        }
        return returnList;
    }
}
