import java.util.HashMap;

public class LC3 {
        public static int lengthOfLongestSubstring(String s) {
        int maxResult = 0;
        int startWindow = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++){
            char x = s.charAt(windowEnd);
            hm.put(x, hm.getOrDefault(x,0)+1);
            while(hm.get(x) > 1){
                char a = s.charAt(startWindow);
                hm.put(a, hm.get(a)-1);
                if(hm.get(a) == 0){
                    hm.remove(a);
                }
                startWindow++;
            }
            maxResult = Math.max(maxResult, windowEnd - startWindow + 1);
        }
        return maxResult;
    }
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(LC3.lengthOfLongestSubstring(s));
    }
    
}
