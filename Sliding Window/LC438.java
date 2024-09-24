// Input: s = "cbaebabacd", p = "abc"
// Output: [0,6]
// Explanation:
// The substring with start index = 0 is "cba", which is an anagram of "abc".
// The substring with start index = 6 is "bac", which is an anagram of "abc".

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC438 {
    public static List<Integer> findAnagrams(String p, String s){

        List <Integer> ans = new ArrayList();

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> pMap = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0)+1);
        }

        int startWindow = 0;
        for(int endWindow = 0; endWindow < p.length(); endWindow++){
            pMap.put(p.charAt(endWindow), pMap.getOrDefault(p.charAt(endWindow), 0)+1);


            if(endWindow >= s.length() - 1){

                if(matches(sMap, pMap)){
                    ans.add(endWindow-s.length()+1);
                }

                pMap.put(p.charAt(startWindow), pMap.get(p.charAt(startWindow))-1);
                if(pMap.get(p.charAt(startWindow)) == 0){
                    pMap.remove(p.charAt(startWindow));
                }
                startWindow++;
            }

        }

        return ans;


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
        String s = "abab", p = "ab";
        System.out.println(LC438.findAnagrams(s, p));
    }
}
