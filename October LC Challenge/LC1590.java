// Given an array of positive integers nums, remove the smallest subarray (possibly empty) such that the sum of the remaining elements is divisible by p.
// It is not allowed to remove the whole array.
// Return the length of the smallest subarray that you need to remove, or -1 if it's impossible.
// A subarray is defined as a contiguous block of elements in the array.

// Input: nums = [6,3,5,2], p = 9
// Output: 2
// Explanation: We cannot remove a single element to get a sum divisible by 9. The best way is to remove the subarray [5,2], leaving us with [6,3] with sum 9.

import java.util.HashMap;

class LC1590 {

    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int totalSum = 0;

        // Step 1: Calculate total sum and target remainder
        for (int num : nums) {
            totalSum = (totalSum + num) % p;
        }

        int target = totalSum % p;
        if (target == 0) {
            return 0; // The array is already divisible by p
        }

        // Step 2: Use a hash map to track prefix sum mod p
        HashMap<Integer, Integer> modMap = new HashMap<>();
        modMap.put(0, -1); // To handle the case where the whole prefix is the answer
        int currentSum = 0;
        int minLen = n;

        // Step 3: Iterate over the array
        for (int i = 0; i < n; ++i) {
            currentSum = (currentSum + nums[i]) % p;

            // Calculate what we need to remove
            int needed = (currentSum - target + p) % p;

            // If we have seen the needed remainder, we can consider this subarray
            if (modMap.containsKey(needed)) {
                minLen = Math.min(minLen, i - modMap.get(needed));
            }

            // Store the current remainder and index
            modMap.put(currentSum, i);
        }

        // Step 4: Return result
        return minLen == n ? -1 : minLen;
    }
}