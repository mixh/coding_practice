// You are given a string s and an array of strings words of the same length. Return all starting indices of 
// substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.

// Input: s = "barfoothefoobarman", words = ["foo","bar"]
// Output: [0,9]
// Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
// The output order does not matter, returning [9,0] is fine too.

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class L2C11 {
    public static List<Integer> findSubstring(String s, String[] words) {

        HashMap<String, Integer> wordsMap = new HashMap<>();
        for(String x : words){
            wordsMap.put(x, wordsMap.getOrDefault(x, 0)+1);
        }

        ArrayList<Integer> indexes = new ArrayList<>();

        int wordsLength = words.length;
        int num = words[0].length();
        int stringLength = s.length();

        for(int i = 0; i < stringLength - wordsLength * num + 1; i++){

            HashMap<String, Integer> seen = new HashMap<>();
            int j = 0;

            while (j < wordsLength){
                String word = s.substring(i+j*num, i+(j+1)*num);
                if(wordsMap.containsKey(word)){
                    seen.put(word, seen.getOrDefault(word, 0)+1);
                    if(seen.get(word) > wordsMap.getOrDefault(word, 0)){
                        break;
                    }
                } else{
                    break;
                }
                j++;
            }
            if(j == wordsLength){
                indexes.add(i);
            }
        }

        return indexes;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = { "foo", "bar" };

        System.out.println(L2C11.findSubstring(s, words));
    }    
}
