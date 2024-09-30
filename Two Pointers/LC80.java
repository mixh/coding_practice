// Input: nums = [1,1,1,2,2,3]
// Output: 5, nums = [1,1,2,2,3,_]

public class LC80 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n <=2){
            return n; 
        }

        int j = 2;
        for(int i = 2; i<n; i++){
            if (nums[i] != nums[j-2]){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
