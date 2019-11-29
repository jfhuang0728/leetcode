package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> returnList = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, returnList, new ArrayList());
        return returnList;
    }
    private void dfs(int[] candidates, int distance, int startIndex, List<List<Integer>> returnList, List<Integer> resultsElement){
        if(distance == 0){
            if(!returnList.contains(resultsElement)){
                returnList.add(new ArrayList(resultsElement));
            }

            return;
        }
        for(int i = startIndex; i < candidates.length; i++){
            if(distance < candidates[i]){
                break;
            }
            resultsElement.add(candidates[i]);
            dfs(candidates, distance - candidates[i], i + 1, returnList, resultsElement);
            resultsElement.remove(resultsElement.size() - 1);
        }
    }
}
