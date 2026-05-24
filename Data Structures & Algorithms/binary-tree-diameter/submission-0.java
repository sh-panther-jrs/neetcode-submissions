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

        if (isLeaf(root)) {
            return 1;
        }
        int leftMaxHeight = helper(root.left);
        int rightMaxHeight = helper(root.right);
        maxDia = Math.max(leftMaxHeight+rightMaxHeight, maxDia);
        return 1+Math.max(leftMaxHeight, rightMaxHeight);

    }

    private boolean isLeaf(TreeNode root) {
        return root!=null && root.left ==null && root.right==null;
    }
}
