package leetcode;

import java.util.Arrays;
import java.util.HashMap;


public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int[] ans = two_sum2(arr,9);
        System.out.println(Arrays.toString(ans));
    }
    //Broote force approach..
    public static int[] two_sum1(int[] nums, int target){
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    return new int[] {i, j};
                }
            }

        }
        return new int[] {};
    }


    // optimized approach.
    public static int[] two_sum2(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // copy all the array items into the hashMap..
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i){
                return new int[] {i, map.get(complement)};
            }
        }
        return new int[] {};

    }
}
