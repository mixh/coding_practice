// Given an integer array nums sorted in non-decreasing order,
// return an array of the squares of each number sorted 
// in non-decreasing order.

// Example 1:

// Input: nums = [-4,-1,0,3,10]
// Output: [0,1,9,16,100]
// Explanation: After squaring, the array becomes [16,1,0,9,100].
// After sorting, it becomes [0,1,9,16,100].

import java.util.Arrays;

public class LC977 {
    public static int[] sortedSquares(int[] nums) {
        
        int N = nums.length;
        int [] ans = new int[N];

        int i = 0; int j = N-1;
        for(int x = j; x>=0; x--){
            int y = Math.abs(nums[i]);
            int z = Math.abs(nums[j]);
            if(y > z){
                ans[x] = y*y;
                i++;
            } else{
                ans[x] = z*z;
                j--;
            }
        }
       
        return ans;
    }

    public static void main(String[] args) {
        int [] nums = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(LC977.sortedSquares(nums)));
    }
}