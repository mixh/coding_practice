// Given two strings s1 and s2, return true if s2 contains the permutation of s1
// Input: s1 = "ab", s2 = "eidbaooo"
// Output: true
// Explanation: s2 contains one permutation of s1 ("ba").

import java.util.HashMap;

public class permutation {
    public static boolean checkInclusion(String s1, String s2) {

        HashMap<Character, Integer> s1Map = new HashMap<>();
        HashMap<Character, Integer> s2Map = new HashMap<>();

        for(int i = 0; i < s1.length(); i++){
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0)+1);
        }

        int windowStart = 0;
        for(int windowEnd = 0; windowEnd < s2.length(); windowEnd++){
            s2Map.put(s2.charAt(windowEnd), s2Map.getOrDefault(s2.charAt(windowEnd), 0)+1);

            if (windowEnd >= s1.length() - 1){
                if(matches(s1Map, s2Map)){
                    return true;
                }
                char leftChar = s2.charAt(windowStart);
                s2Map.put(leftChar, s2Map.get(leftChar) - 1);
                if(s2Map.get(leftChar) == 0){
                    s2Map.remove(leftChar);
                }
                windowStart++;
            }
        }

        return false;
    }

    public static boolean matches(HashMap<Character, Integer> s1Map, HashMap<Character, Integer> s2Map ){
        for(char x : s1Map.keySet()){
            if(s1Map.get(x) - s2Map.getOrDefault(x, -1) != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidboaoo";
        System.out.println(permutation.checkInclusion(s1, s2));
    }
    
}
