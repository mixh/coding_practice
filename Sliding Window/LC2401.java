public class LC2401 {
    public static int longestNiceSubarray(int[] nums) {
        int result = 0;
        int currentAnd = 0;
        int startWindow = 0;
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++){
            while ((nums[windowEnd] & currentAnd) != 0){
                currentAnd ^= nums[startWindow];
                startWindow++;
            }
            currentAnd = currentAnd | nums[windowEnd];
            result = Math.max(result, windowEnd - startWindow + 1);
        }
        return result;
    }
    public static void main(String[] args) {
        int [] arr =  {1,2,8,48,10};
        System.out.println(LC2401.longestNiceSubarray(arr));
    }
}
