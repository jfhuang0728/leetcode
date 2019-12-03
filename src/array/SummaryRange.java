package array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRange {
        public List<String> summaryRanges(int[] nums) {
            if(nums.length == 0){
                return new ArrayList();
            }
            List<String> returnList = new ArrayList<>();
            int i = 0;
            for(int j = i; j < nums.length; ){
                while(j < nums.length - 1 && nums[j] + 1 == nums[j + 1]){
                    j++;
                }
                if(i == j){
                    returnList.add(new String("" + nums[i]));
                }else{
                    returnList.add(new String(nums[i] + "->" + nums[j]));
                }

                i = ++j;

            }
            return returnList;
        }
}
