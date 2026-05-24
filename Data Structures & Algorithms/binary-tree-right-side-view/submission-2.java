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
        List<Integer> output = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null) {
            return output;
        }
        queue.offer(root);
        while(!queue.isEmpty()) {
            int length = queue.size();
            int i =0;
            while(i<length-1) {
                TreeNode curr = queue.poll();
                if(curr.left!=null) {
                    queue.offer(curr.left);
                }
                if(curr.right!=null) {
                    queue.offer(curr.right);
                }
                i++;
            }
            if(queue.size()>0) {
                TreeNode curr = queue.poll();
                if(curr.left!=null) {
                    queue.offer(curr.left);
                }
                if(curr.right!=null) {
                    queue.offer(curr.right);
                }
                output.add(curr.val);
            }
        }
        return output;
    }
}
