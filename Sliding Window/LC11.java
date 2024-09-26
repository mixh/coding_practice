
// You are given a string s and an array of strings words of the same length. Return all starting indices of 
// substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.

// Input: s = "barfoothefoobarman", words = ["foo","bar"]
// Output: [0,9]
// Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
// The output order does not matter, returning [9,0] is fine too.

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

class LC11 {
    public static List<Integer> findSubstring(String s, String[] words) {
        final HashMap<String, Integer> counts = new HashMap<>();

        for (final String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        final List<Integer> indexes = new ArrayList<>();
        final int StringLength = s.length(), arrayLength = words.length, Charcount = words[0].length();
        for (int i = 0; i < StringLength - arrayLength * Charcount + 1; i++) {
            final HashMap<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < arrayLength) {
                final String word = s.substring(i + j * Charcount, i + (j + 1) * Charcount);
                if (counts.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    if (seen.get(word) > counts.getOrDefault(word, 0)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == arrayLength) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = { "foo", "bar" };

        System.out.println(LC11.findSubstring(s, words));
    }
}