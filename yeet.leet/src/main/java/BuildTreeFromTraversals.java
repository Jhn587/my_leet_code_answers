import java.util.HashMap;
import java.util.Map;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * Medium
 *
 * 1804
 *
 * 50
 *
 * Favorite
 *
 * Share
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class BuildTreeFromTraversals {
    public static void main(String[] args) {
        int[] pre = {3, 9, 10, 11, 20};
        int[] in = {10, 9, 11, 3, 20};
        TreeNode node = new BuildTreeFromTraversals().buildTree(pre, in);
        System.out.println("node = " + node);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> valueToPreorderIndex = new HashMap<>();
        for (int i = 0; i < preorder.length; i++) {
            valueToPreorderIndex.put(preorder[i], i);
        }

        Map<Integer, Integer> valueToInorderIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valueToInorderIndex.put(inorder[i], i);
        }

        Map<Integer, TreeNode> valueToNodeMap = new HashMap<>();
        TreeNode root = new TreeNode(preorder[0]);
        valueToNodeMap.put(preorder[0], root);

        TreeNode prev = root;
        for (int i = 1; i < preorder.length; i++) {
            TreeNode current = new TreeNode(preorder[i]);
            valueToNodeMap.put(preorder[i], current);
            Integer inorderIndexOfPrevValue = valueToInorderIndex.get(preorder[i - 1]);
            Integer inorderIndexOfCurrentValue = valueToInorderIndex.get(preorder[i]);
            if (inorderIndexOfCurrentValue < inorderIndexOfPrevValue) {
                prev.left = current;
            } else {
                int indexOfLastValueInOrder = inorderIndexOfCurrentValue - 1;
                int lastInorderValue = inorder[indexOfLastValueInOrder];
                TreeNode lastInorder = valueToNodeMap.get(lastInorderValue);

                while(lastInorder == null) {
                    lastInorderValue = inorder[--indexOfLastValueInOrder];
                    lastInorder = valueToNodeMap.get(lastInorderValue);


                }
                lastInorder.right = current;
            }
            prev = current;
        }

        return root;
    }
}
