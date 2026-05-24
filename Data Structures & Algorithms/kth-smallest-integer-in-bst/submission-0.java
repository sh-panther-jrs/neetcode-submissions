/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int output = 0;
    public int kthSmallest(TreeNode root, int k) {
        TreeNode outNode = get(root, k);
        if (outNode!=null) {
            return outNode.val;
        }
        return -1;
    }

    private TreeNode get(TreeNode node, int k) {
        if (node==null) {
            return null;
        }
        if (output==k) {
            return node;
        }
        TreeNode left = get(node.left, k);
        if (left!=null) {
            return left;
        }
        output++;
        if (output==k) {
            return node;
        }
        TreeNode right = get(node.right, k);
        if (right!=null) {
            return right;
        }
        return null;
    }
}
