import java.util.*;
import java.util.stream.Collectors;

/**
 * Group Anagrams
 * https://leetcode.com/problems/group-anagrams/
 * Go to Discuss
 * Given an array of strings, group anagrams together.
 * <p>
 * Example:
 * <p>
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note:
 * <p>
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class GroupAnagrams {
    //Input
//    ["eat", "tea", "tan", "ate", "nat", "bat"],
//Output:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
    public static void main(String[] args) {

        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new GroupAnagrams().groupAnagrams(strings);
        System.out.println("lists = " + lists);
    }

    /**
     * Thoughts are that i can sort the words as a kind of key
     * Group by that key
     * Could be faster if we grouped by a character frequency map instead of sorting words
     * could be faster if we did not use streams
     * Leet Code says that frequency map is slower than sorting the words
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> keyToAnagrams = Arrays
                .stream(strs)
                .collect(
                        Collectors.groupingBy(
                                this::letterFrequency
                        )
                );
        return new ArrayList<>(keyToAnagrams.values());
    }

    private String sortedWord(String word) {
        char[] chars = word.toCharArray();

        Arrays.sort(chars);
        return new String(chars);
    }

    private Map<Character, Integer> letterFrequency(String s) {
        HashMap<Character, Integer> letterFrequencyMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char currentLetter = s.charAt(i);
            letterFrequencyMap.put(currentLetter, 1 + letterFrequencyMap.getOrDefault(currentLetter, 0));
        }
        return letterFrequencyMap;
    }
}
