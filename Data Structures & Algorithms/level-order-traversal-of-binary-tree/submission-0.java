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
    public List<List<Integer>> levelOrder(TreeNode root) {
        TreeMap<Integer, List<Integer>> output = new TreeMap<>();
        populate(output, root, 0);
        List<List<Integer>> f=new ArrayList<>();
        for(Map.Entry<Integer, List<Integer>> entry:output.entrySet()) {
            f.add(entry.getValue());
        }
        return f;
    }

    private void populate(TreeMap<Integer, List<Integer>> output,TreeNode root, int level) {
        if (root==null) {
            return;
        }
        output.putIfAbsent(level+1, new ArrayList<Integer>());
        output.get(level+1).add(root.val);
        populate(output, root.left, level+1);
        populate(output, root.right, level+1);
    }
}
