public class LC1004 {

    public static int longestOnes(int[] nums, int k) {
        int result = 0;
        int zeroCount = 0;
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j]==0){
                zeroCount++;
            }
            while(zeroCount > k){
                if(nums[i] == 0){
                    zeroCount--;
                }
                i++;
            }
            result = Math.max(result, j-i+1);
        }
        return result;
    }

    public static void main(String[] args) {
        int [] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(LC1004.longestOnes(nums, k));
    }
    
}
