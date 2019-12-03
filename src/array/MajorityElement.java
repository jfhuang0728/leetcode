package array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    //使用HashMap
    public int majorityElementMethodOne(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) > nums.length / 2) {
                return key;
            }
        }
        return -1;
    }

    //使用分治算法
    public int majorityElementMethodTwo(int[] nums) {
        return findMajority(nums, 0, nums.length - 1);
    }

    private int findMajority(int[] nums, int start, int end) {
        if (end - start == 0) {
            return nums[end];
        }
        int mid = start + (end - start) / 2;
        int leftMajority = findMajority(nums, start, mid);
        int rightMajority = findMajority(nums, mid + 1, end);
        if (leftMajority == rightMajority) {
            return leftMajority;
        }

        return countMajority(nums, start, end, leftMajority) > countMajority(nums, start, end, rightMajority) ? leftMajority : rightMajority;
    }

    private int countMajority(int nums[], int start, int end, int ref) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] == ref) {
                count++;
            }
        }
        return count;
    }

    //使用Boyer-Moore 投票算法
    public int majorityElementMethodThree(int[] nums) {
        int count = 0;
        int majority = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                majority = nums[i];
            }
            if (nums[i] == majority) {
                count += 1;
            } else {
                count -= 1;
            }
        }
        return majority;
    }
}