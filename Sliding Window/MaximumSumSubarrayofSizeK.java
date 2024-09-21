
// Given an array of positive numbers and a positive number k. 
// find the maximum sum of any contiguous subarray of size k 

//Input: [2, 1, 5, 1, 3, 2], k=3 
// Output: 9
// Explanation: Subarray with maximum sum is [5, 1, 3].

public class MaximumSumSubarrayofSizeK {
    public static int MaxSum(int [] arr, int k){
        int maxSum = 0;
        int windowSum = 0;
        int windowStart = 0;
        for(int i = 0; i< arr.length; i++){
            windowSum += arr[i];
            if (i >= k-1){
                maxSum = Math.max(windowSum, maxSum);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return maxSum;

    }
    public static void main(String[] args) {
        int [] input_array = {2,1,5,1,3,2};
        int k = 3;
        System.out.println(MaxSum(input_array, k));
    }
}
