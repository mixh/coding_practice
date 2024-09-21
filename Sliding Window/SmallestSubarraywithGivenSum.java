
// Given an array of positive numbers and a positive number S find the length of the smallest contiguous subarray whose sum is greater than or equal to S.
// Input: [2, 1, 5, 2, 3, 2], S=7
// Output: 2
// Explanation: The smallest subarray with a sum greater than 
// or equal to '7' is [5, 2].

public class SmallestSubarraywithGivenSum {

    public static int SmallestWindow(int [] arr, int s){
        int ans = Integer.MAX_VALUE;
        int startWindow = 0;
        int windowSum = 0;
        
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            windowSum += arr[windowEnd];
            while(windowSum >= s){
                ans = Math.min(ans, windowEnd - startWindow + 1);
                windowSum = windowSum - arr[startWindow];
                startWindow++;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int [] arr = {2,1,5,2,3,2};
        int s = 7;
        System.out.println(SmallestSubarraywithGivenSum.SmallestWindow(arr, s));
    }

    
}