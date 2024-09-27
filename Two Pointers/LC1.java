// Given an array of integers nums and an integer target, 
// return indices of the two numbers such that they add up to target.

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Output: Because nums[0] + nums[1] == 9, we return [0, 1].

import java.util.Arrays;
import java.util.HashMap;

public class LC1 {
    public static int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i = 0; i < nums.length; i++){

            int remainder = target - nums[i];
            if(hm.containsKey(remainder)){
                return new int[] {hm.get(remainder), i};
            }
            hm.put(nums[i],i);
        }

        return new int[]{};
    }
    public static void main(String[] args) {
        int [] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(LC1.twoSum(nums, target)));
    }
}
