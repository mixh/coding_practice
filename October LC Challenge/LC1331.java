import java.util.Arrays;
import java.util.HashMap;

public class LC1331 {

    public static int[] arrayRankTransform(int[] arr) {
        HashMap<Integer, Integer> numToRank  = new HashMap<>();
        int [] sortedArray = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArray);
        int rank = 1;
        for(int i = 0; i < arr.length ; i++){
            if(i > 0 && sortedArray[i] > sortedArray[i-1]){
                rank++;
            }
            numToRank.put(sortedArray[i], rank);
        }
                for (int i = 0; i < arr.length; i++) {
            arr[i] = numToRank.get(arr[i]);
        }
        return arr;

    }
    public static void main(String[] args) {
        int [] arr = {40,10,20,30}; 
        System.out.println(LC1331.arrayRankTransform(arr));
    }
    
}
