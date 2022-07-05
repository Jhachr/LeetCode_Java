package no1_two_sum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSumMethod1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public int[] twoSumMethod2(int[] nums, int target) {
        for(int i = 0; i< nums.length -1  ; i++){
            for(int j = i+1; j<nums.length ; j++){
                if(target - nums[i] == nums[j]){
                    return new int [] {i,j};
                }
            }
        }
        return null;
    }


}
