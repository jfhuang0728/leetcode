package dfs;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> returnList = new ArrayList<>();
        dfs(0, target - candidates[0], new ArrayList<>(), candidates, returnList);
        return returnList;
    }
    private void dfs(int startIndex, int distance, List<Integer> resultsElement, int[] candidates, List<List<Integer>> returnList){
        if (distance == 0){
            returnList.add(new ArrayList<>(resultsElement));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++){
            if (distance < 0){
                break;
            }
            dfs(i, distance - candidates[i], resultsElement, candidates, returnList);
            resultsElement.remove(resultsElement.size() - 1);
        }
    }
}
