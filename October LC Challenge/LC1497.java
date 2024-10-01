// Given an array of integers arr of even length n and an integer k.
// We want to divide the array into exactly n / 2 pairs such that the sum of each pair is divisible by k.
// Return true If you can find a way to do that or false otherwise.

public class LC1497 {
    public static  boolean canArrange(int[] arr, int k) {
        return true;
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,10,6,7,8,9};
        int k = 5;
        System.out.println(LC1497.canArrange(arr, k));
    }
}
