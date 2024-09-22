
// Given an array of characters where each character represnets a fruit tree
// you are given two baskets and your goal is to put max number of fruits in each basket


// Input: Fruit=['A', 'B', 'C', 'A', 'C']
// Output: 3
// Explanation: We can put 2 'C' in one basket and one 'A' in 
// the other from the subarray ['C', 'A', 'C']

// LC - 904
// THOUGHTS
// sliding window maintain a frequency map to update max fruit
// how to update 

import java.util.HashMap;
public class FruitsIntoBaskets {

    public static int totalFruit(char[] fruits) {
    int maxFruit = 0;
    int startWindow = 0;

    HashMap<Character, Integer> hm = new HashMap<>();

    for (int windowEnd = 0; windowEnd < fruits.length; windowEnd++) {
        char c = fruits[windowEnd];
        hm.put(c, hm.getOrDefault(c, 0) + 1);

        while (hm.size() > 2) {
            char leftFruit = fruits[startWindow];
            hm.put(leftFruit, hm.get(leftFruit) - 1); // Decrease count of the leftmost fruit
            if (hm.get(leftFruit) == 0) {
                hm.remove(leftFruit); // Remove the fruit if its count drops to zero
            }
            startWindow++;
        }

        maxFruit = Math.max(maxFruit, windowEnd - startWindow + 1);
    }

    return maxFruit;
}

    public static void main(String[] args) {
        char [] x = {'A', 'B', 'C', 'B', 'B', 'C'}; 
        System.out.println(FruitsIntoBaskets.totalFruit(x));
    }
    
}
