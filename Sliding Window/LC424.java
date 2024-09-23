// Input: s = "ABAB", k = 2
// Output: 4
// Explanation: Replace the two 'A's with two 'B's or vice versa.


public class LC424{

    public static int characterReplacement(String s, int k){
      int result = 0;
      int left = 0;
      int [] freq = new int[26];
      int mostFreqChar = 0;

      for (int right = 0; right < s.length(); right++){
        freq[s.charAt(right) - 'A']++;
        mostFreqChar = Math.max(mostFreqChar, freq[s.charAt(right) - 'A']);

        int charToReplace = (right-left+1) - mostFreqChar;
        if(charToReplace > k){
            freq[s.charAt(left) - 'A']--;
            left++;
        }

        result = Math.max(result, right-left+1);
      }

      return result;
    }

    public static void main(String[] args) {
        String str  = "ABAB";
        int k = 2;
        System.out.println(LC424.characterReplacement(str, k));
    }
}