package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length == 0){
            return new ArrayList();
        }
        Arrays.sort(nums);
        List<Integer> resultElement = new ArrayList<>();
        List<List<Integer>> returnList = new ArrayList<>();
        dfs(resultElement, returnList, nums, 0);
        return returnList;
    }
    private void dfs(List<Integer> resultElement, List<List<Integer>> returnList, int[] nums, int startIndex){
        returnList.add(new ArrayList(resultElement));
        System.out.println(resultElement);
        for(int i = startIndex; i < nums.length; i++){

            if(i != startIndex && nums[i] == nums[i - 1]){
                continue;
            }
            resultElement.add(nums[i]);

            dfs(resultElement, returnList, nums, i + 1);

            resultElement.remove(resultElement.size() - 1);
        }
    }
}
