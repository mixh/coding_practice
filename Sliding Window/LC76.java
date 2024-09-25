// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

import java.util.HashMap;

public class LC76 {
    public static String minWindow(String s, String t){

        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> windowMap = new HashMap<>();
        
        for(char x : t.toCharArray()){
            tMap.put(x, tMap.getOrDefault(x, 0)+1);
        }

        int left = 0;
        int right = 0;
        int count = 0; // keep count of characters covered by window
        int minWindow = Integer.MAX_VALUE;
        int startWindow = 0; // pointer where the window starts

        while (right < s.length()){
            char rightChar = s.charAt(right);
            windowMap.put(rightChar,windowMap.getOrDefault(rightChar,0)+1);

            if(tMap.containsKey(rightChar) && windowMap.get(rightChar) <= tMap.get(rightChar)){
                count++;
            }
            
                            while(count == t.length()){
                                
                                if(minWindow > right-left+1){
                                    minWindow = right - left + 1;
                                    startWindow = left;
                                }
            
                                char leftChar = s.charAt(left);
                                windowMap.put(leftChar, windowMap.get(leftChar)-1);
            
                                if(tMap.containsKey(leftChar) && windowMap.get(leftChar) < tMap.get(leftChar)){
                                    count--;
                                }
                                left++;
                            }

            right++;
        }

        if(minWindow == Integer.MAX_VALUE){
            return "";
        }

        return s.substring(startWindow, startWindow+minWindow);

    }

    public static void main(String[] args) {
        String strS = "ADOBECODEBANC";
        String strT = "ABC";
        System.out.println(LC76.minWindow(strS, strT));
    }
}
