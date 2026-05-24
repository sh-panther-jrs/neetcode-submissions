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
    static boolean isHeightBalanced = true;
    public boolean isBalanced(TreeNode root) {
        isHeightBalanced=true;
        helper(root);
        return isHeightBalanced;
    }

    private int helper(TreeNode root) {
        if(root==null) {
            return 0;
        }
        int lh = helper(root.left);
        int rh = helper(root.right);

        if(Math.abs(lh-rh)>1) {
            isHeightBalanced = false;
        }

        return Math.max(lh,rh)+1;
    }
    

}
