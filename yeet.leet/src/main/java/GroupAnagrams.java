import java.util.*;
import java.util.stream.Collectors;

/**
 * Group Anagrams
 * https://leetcode.com/problems/group-anagrams/
 *   Go to Discuss
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *
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
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> keyToAnagrams = Arrays.stream(strs).collect(Collectors.groupingBy(this::sortedWord));
        return new ArrayList<>(keyToAnagrams.values());
    }

    private String sortedWord(String word) {
        char[] chars = word.toCharArray();

        Arrays.sort(chars);
        return new String(chars);
    }
}
