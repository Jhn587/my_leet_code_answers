import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuildTreeFromTraversalsTest {

    @Test
    public void buildTree() {
        int[] pre = {3, 9, 10, 11, 20};
        int[] in = {10, 9, 11, 3, 20};
        TreeNode node = new BuildTreeFromTraversals().buildTree(pre, in);
        Assert.assertEquals("TreeNode{val=3, left=TreeNode{val=9, left=TreeNode{val=10, left=null, right=null}, right=TreeNode{val=11, left=null, right=null}}, right=TreeNode{val=20, left=null, right=null}}", node.toString());
    }

    @Test
    public void buildTreeSecond() {
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        TreeNode node = new BuildTreeFromTraversals().buildTree(pre, in);
        Assert.assertEquals("TreeNode{val=3, left=TreeNode{val=9, left=null, right=null}, right=TreeNode{val=20, left=TreeNode{val=15, left=null, right=null}, right=TreeNode{val=7, left=null, right=null}}}", node.toString());
    }
}