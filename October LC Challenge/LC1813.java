// example,

// s1 = "Hello Jane" and s2 = "Hello my name is Jane" can be made equal by inserting "my name is" between "Hello" and "Jane" in s1.
// s1 = "Frog cool" and s2 = "Frogs are cool" are not similar, since although there is a sentence "s are" inserted into s1, it is not separated from "Frog" by a space.
// Given two sentences sentence1 and sentence2, return true if sentence1 and sentence2 are similar. Otherwise, return false.

class LC1813 {

    public boolean areSentencesSimilar(String s1, String s2) {
        // Split the words in sentences and store it in a string array.
        String[] s1Words = s1.split(" "), s2Words = s2.split(" ");
        int start = 0, ends1 = s1Words.length - 1, ends2 =
            s2Words.length - 1, s1WordsLength = s1Words.length, s2WordsLength =
            s2Words.length;

        // If words in s1 are more than s2, swap them and return the answer.
        if (s1WordsLength > s2WordsLength) {
            return areSentencesSimilar(s2, s1);
        }

        // Find the maximum words matching from the beginning.
        while (start < s1WordsLength && s1Words[start].equals(s2Words[start])) {
            ++start;
        }
        // Find the maximum words matching in the end.
        while (ends1 >= 0 && s1Words[ends1].equals(s2Words[ends2])) {
            --ends1;
            --ends2;
        }

        // If i reaches the end of the array, then we return true.
        return ends1 < start;
    }
}