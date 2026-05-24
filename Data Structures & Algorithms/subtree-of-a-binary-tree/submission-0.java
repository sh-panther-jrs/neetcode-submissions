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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String inorRoot = inOrder(root);
        String inorSubRoot = inOrder(subRoot);
        return inorRoot.indexOf(inorSubRoot)>=0;
    }

    private String inOrder(TreeNode root) {
        if (root==null) {
            return "null";
        }
        String ro = root.val+"";
        String l = inOrder(root.left);
        String r = inOrder(root.right);
        return ro + "," + l + "," + r;
    }
}
