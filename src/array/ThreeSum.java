package array;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.*;

public class ThreeSum {
    //时间复杂度n^2logn
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> returnList = new ArrayList<>();
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[i] > 0){
//                break;
//            }
//            for(int j = i + 1; j < nums.length; j++){
//                if(nums[i] + nums[j] > 0){
//                    break;
//                }
//                Integer searchResult = Arrays.binarySearch(nums, j+1, nums.length, -(nums[i] + nums[j]));
//                if (searchResult < 0){
//                    continue;
//                }else{
//                    List<Integer> returnElement = Arrays.asList(nums[i], nums[j], nums[searchResult]);
//                    if (!returnList.contains(returnElement)){
//                        returnList.add(returnElement);
//                    }
//                }
//                if (nums[i] ==0 && nums[nums.length - 1] == 0){
//                    break;
//                }
//            }
//        }
//        return returnList;
//    }
    public List<List<Integer>> threeSum(int[] nums) {

            if (nums.length < 3){
                return new ArrayList();
            }
            Arrays.sort(nums);
            List<List<Integer>> returnList = new ArrayList<>();
            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]){
                    continue;
                }
                int leftIndex = i + 1;
                int rightIndex = nums.length - 1;
                while (rightIndex > leftIndex){
                    int sum = nums[i] + nums[leftIndex] + nums[rightIndex];
                    if (sum == 0){
                        returnList.add(Arrays.asList(nums[i], nums[leftIndex], nums[rightIndex]));
                        while(leftIndex < rightIndex && nums[leftIndex]  ==  nums[leftIndex + 1]){
                            leftIndex++;
                        }
                        while (leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex - 1]){
                            rightIndex--;
                        }
                        leftIndex++;
                        rightIndex--;
                    }else if (sum < 0){
                        leftIndex++;
                    }else {
                        rightIndex--;
                    }
                }
            }
            return returnList;

    }

    public static void main(String[] args) {
        int[] input = {-2,0,0,2,2};
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> results = threeSum.threeSum(input);
        for (List<Integer> list:results){
            System.out.println(list);
        }
    }
}
