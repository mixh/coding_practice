// Given a string, find the length of the longest substring in it with no more than K distinct characters.

// Input: String="araaci", K=2
// Output: 4
// Explanation: The longest substring with no more 
// than '2' distinct characters is "araa".

// basically find the longest substring with only k distinct characters 

import java.util.HashMap;

public class LongestSubstringwithKDistinctCharacters {
    
    public static int LongestSubstringwithKDistinctChars(String s, int k){
        int maxLen = 0;
        int startWindow = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++){
            char c = s.charAt(windowEnd);
            hm.put(c, hm.getOrDefault(c, 0)+1);
            if(hm.size() > k){
                char left = s.charAt(startWindow);
                hm.put(left, hm.get(left)-1);
                if(hm.get(left) == 0){
                    hm.remove(left);
                }
                startWindow++;
            }
            maxLen = Math.max(maxLen, windowEnd-startWindow+1);
        }

        return maxLen;
    }

    // THOUGHTS
    // 1. Maintain a frequency map for the characters in the string
    // 2. Check the map to find out if characters are more than needed 'k'
    // 3. update the frequency map when sliding window

    public static void main(String[] args) {
        String s = "araaci";
        int k=1;
        System.out.println(LongestSubstringwithKDistinctCharacters.LongestSubstringwithKDistinctChars(s,k));
    }
}
