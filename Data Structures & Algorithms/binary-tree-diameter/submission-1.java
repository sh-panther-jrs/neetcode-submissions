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
    static int maxDia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDia = 0;
        helper(root);
        return maxDia;
    }
    private int helper(TreeNode root){
        if (root==null) {
            return 0;
        }

        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);
        maxDia = Math.max(leftHeight+rightHeight, maxDia);
        return 1+Math.max(leftHeight, rightHeight);

    }
}
