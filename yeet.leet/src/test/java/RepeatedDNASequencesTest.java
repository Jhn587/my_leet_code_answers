import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RepeatedDNASequencesTest {

// * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
// * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
    @Test
    public void findRepeatedDnaSequences() {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        RepeatedDNASequences repeatedDNASequences = new RepeatedDNASequences();
        List<String> actualRepeated = repeatedDNASequences.findRepeatedDnaSequences(s);

        Assert.assertEquals(Arrays.asList("AAAAACCCCC", "CCCCCAAAAA"), actualRepeated);
    }

    //Input "AAAAAAAAAAA"
    //Output ["AAAAAAAAAA"]
    @Test
    public void findRepeatedDnaSequencesSecondExample() {
        String s = "AAAAAAAAAAA";
        RepeatedDNASequences repeatedDNASequences = new RepeatedDNASequences();
        List<String> actualRepeated = repeatedDNASequences.findRepeatedDnaSequences(s);

        Assert.assertEquals(Collections.singletonList("AAAAAAAAAA"), actualRepeated);
    }
}