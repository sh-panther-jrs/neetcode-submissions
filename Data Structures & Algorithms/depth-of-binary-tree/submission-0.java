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

    public int maxDepth(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int heightTillNow) {
        if (root==null) {
            return heightTillNow;
        }
        int heightLeft = helper(root.left, heightTillNow+1);
        int heightRight = helper(root.right, heightTillNow+1);
        return Math.max(heightLeft, heightRight);
    }
}
