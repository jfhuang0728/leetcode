package array;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int rightIndex = height.length - 1;
        int maxArea = 0;
        int leftIndex = 0;
        for(int i = 0, j = height.length - 1; j - i >= 1; i++, j--){
            maxArea = Math.max(maxArea, Math.min(height[i], height[j])*(j - i));
            if(height[i] <= height[j]){
                j++;
            }else{
                i--;
            }
        }
        return maxArea;
    }
    private int findLowerValue(int a, int b){
        return a<b?a:b;
    }
}
