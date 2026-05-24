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
    public int goodNodes(TreeNode root) {
        return helper(root, -101);
    }

    private int helper(TreeNode node, int maxValue) {
        if(node==null) {
            return 0;
        }
        
        int left = helper(node.left, Math.max(node.val, maxValue));
        int right = helper(node.right, Math.max(node.val, maxValue));
        if(node.val>=maxValue) {
            return 1 + left + right;
        }
        return left+right;
    }

}









