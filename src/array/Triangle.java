package array;

import java.util.List;

public class Triangle {
    //空间复杂度O(N^2)
    public int minimumTotalMethodOne(List<List<Integer>> triangle) {
        if(triangle.size() == 0){
            return 0;
        }
        int[][] shortestPath = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        int returnInt = Integer.MAX_VALUE;
        shortestPath[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < triangle.size(); i++){
            for(int j = 0; j < triangle.get(i).size(); j++){
                if(j == 0){
                    shortestPath[i][j] = triangle.get(i).get(j) + shortestPath[i - 1][0];
                }else if(j == triangle.get(i).size() - 1){
                    shortestPath[i][j] = triangle.get(i).get(j) + shortestPath[i - 1][triangle.get(i - 1).size() - 1];
                }else {
                    shortestPath[i][j] = Math.min(shortestPath[i - 1][j - 1], shortestPath[i - 1][j]) + triangle.get(i).get(j);
                }
            }
        }
        for(int i = 0; i < triangle.get(triangle.size() - 1).size(); i++){
            if(shortestPath[triangle.size() - 1][i]   < returnInt){
                returnInt = shortestPath[triangle.size() - 1][i];
            }
        }
        return returnInt;
    }
    //空间复杂度O（N)
    public int minimumTotalMethodTwo(List<List<Integer>> triangle) {
        if(triangle.size() == 0){
            return 0;
        }
        int[] shortestPath = new int[triangle.size()];
        int returnInt = Integer.MAX_VALUE;
        shortestPath[0] = triangle.get(0).get(0);
        for(int i = 1; i < triangle.size(); i++){
            for(int j = triangle.get(i).size() - 1; j >= 0 ; j--){
                if(j == triangle.get(i).size() - 1){
                    shortestPath[j] = shortestPath[j - 1] + triangle.get(i).get(j);
                }else if(j == 0){

                    shortestPath[j] = shortestPath[j] + triangle.get(i).get(j);
                }else {
                    shortestPath[j] = Math.min(shortestPath[j - 1], shortestPath[j]) + triangle.get(i).get(j);
                }
            }
        }
        for(int i = 0; i < triangle.get(triangle.size() - 1).size(); i++){
            if(shortestPath[i]   < returnInt){
                returnInt = shortestPath[i];
            }
        }
        return returnInt;
    }
}
