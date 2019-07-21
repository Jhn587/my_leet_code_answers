import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 187. Repeated DNA Sequences
 * Medium
 * https://leetcode.com/problems/repeated-dna-sequences/
 * 465
 * <p>
 * 191
 * <p>
 * Favorite
 * <p>
 * Share
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * <p>
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * <p>
 * Example:
 * <p>
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * <p>
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 */

public class RepeatedDNASequences {
    private Set<String> seenDNASequences = new HashSet<>();

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seenSequences = new HashSet<>();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 10; i <= sb.length(); i++) {
            String substring = sb.substring(i - 10, i);
            if (seenDNASequences.contains(substring)) {
                seenSequences.add(substring);
            } else {
                seenDNASequences.add(substring);
            }
        }
        return new ArrayList<>(seenSequences);
    }

}
