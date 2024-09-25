import java.util.HashMap;

public class LC762 {
    
    public static String minWindow(String s, String t){

        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> windowMap = new HashMap<>();
        
        for(int i =0 ; i< t.length(); i++){
            tMap.put(s.charAt(i), tMap.getOrDefault(s.charAt(i), 0)+1);
        }

        int left = 0;
        int right = 0;
        int count = 0; // keep count if no of letters in t that are covered by our window
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0; // the start index for our sliding window

        while (right < s.length()){

            char currentChar = s.charAt(right);
            windowMap.put(currentChar, windowMap.getOrDefault(currentChar,0)+1);

            if(tMap.containsKey(currentChar) && windowMap.get(currentChar) <= tMap.get(currentChar)){
                count++;
            }

            while (count == t.length()){
                if (minLength > right-left+1){
                    minLength = right - left + 1;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar)-1);
                if(tMap.containsKey(leftChar) && windowMap.get(leftChar) < tMap.get(leftChar));{
                    count--;
                }
                left++;
            }

            right++;
        }
        if(minLength == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(startIndex, startIndex+minLength);

    }

    public static void main(String[] args) {
        String strS = "ADOBECODEBANC";
        String strT = "ABC";
        System.out.println(LC76.minWindow(strS, strT));
    }
}
