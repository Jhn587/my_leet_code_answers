import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class GroupAnagramsTest {

    //Input
//    ["eat", "tea", "tan", "ate", "nat", "bat"],
//Output:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
    @Test
    public void groupAnagrams() {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new GroupAnagrams().groupAnagrams(strings);
        Set<Set<String>> collect = lists.stream().map(HashSet::new).collect(Collectors.toSet());
        Set<Set<String>> expectedGroupings = new HashSet<>();
        expectedGroupings.add(new HashSet<>(Arrays.asList("ate", "eat", "tea")));
        expectedGroupings.add(new HashSet<>(Arrays.asList("nat", "tan")));
        expectedGroupings.add(new HashSet<>(Arrays.asList("bat")));
        Assert.assertEquals(expectedGroupings, collect);
    }
}