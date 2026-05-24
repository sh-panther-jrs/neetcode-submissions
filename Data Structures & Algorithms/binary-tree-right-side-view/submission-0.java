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
    public List<Integer> rightSideView(TreeNode root) {
        return getRightView(root);

    }

    private List<Integer> getRightView(TreeNode root) {
        if (root ==null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> output = new ArrayList<>();
        while(!queue.isEmpty()) {
            Queue<TreeNode> tempQueue = new LinkedList<>();
            TreeNode lastNode=null;
            while(!queue.isEmpty()) {
                lastNode = queue.remove();
                if (lastNode.left!=null) {
                    tempQueue.add(lastNode.left);
                }
                if (lastNode.right!=null) {
                    tempQueue.add(lastNode.right);
                }
            }
            if (lastNode!=null) {
                output.add(lastNode.val);
            }
            queue=tempQueue;
        }
        return output;
    }
}
