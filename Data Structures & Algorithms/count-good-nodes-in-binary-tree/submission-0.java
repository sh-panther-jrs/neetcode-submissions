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
        return 1 + get(root.left, root.val) + get(root.right, root.val);
    }

    private int get(TreeNode root, int maxVal) {
        if (root==null) {
            return 0;
        }
        int lh = get(root.left, Math.max(root.val, maxVal));
        int rh = get(root.right, Math.max(root.val, maxVal));
        if (root.val>=maxVal) {
            return 1+lh+rh;   
        } 
        return lh+rh;

    }
}
