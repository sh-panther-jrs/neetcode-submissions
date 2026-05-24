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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) {
            return null;
        }
        if (root.val==p.val || root.val==q.val) {
            return root;
        }

        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);
        if (left==null) {
            return right;
        }
        if (right==null) {
            return left;
        }
        if ((left.val==p.val && right.val==q.val) || (left.val==q.val && right.val==p.val)) {
            return root;
        }

        return null;
    }
}
