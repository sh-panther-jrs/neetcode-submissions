/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) {
 *         this.val = val;
 *     }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int preOrderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preOrder, int[] inorder, int inOrderStartIndex, int inOrderEndIndex) {
        if (inOrderStartIndex > inOrderEndIndex) {
            return null;
        }
        
        TreeNode node = new TreeNode(preOrder[preOrderIndex]);
        preOrderIndex++;
        
        int indexInorder = findIndexInPreOrder(inOrderStartIndex, inOrderEndIndex, inorder, node.val);
        
        node.left = buildTreeHelper(preOrder, inorder, inOrderStartIndex, indexInorder - 1);
        node.right = buildTreeHelper(preOrder, inorder, indexInorder + 1, inOrderEndIndex);
        
        return node;
    }

    int findIndexInPreOrder(int start, int end, int[] inorder, int val) {
        for (int index = start; index <= end; index++) {
            if (inorder[index] == val) {
                return index;
            }
        }
        return -1;
    }
}