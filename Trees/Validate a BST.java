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
    public boolean isValidBST(TreeNode root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean checkBST(TreeNode root, long minm, long maxm){
        if(root == null) return true;
        if(root.val >= maxm || root.val <= minm) return false;
        return checkBST(root.left, minm, root.val) && checkBST(root.right, root.val, maxm);

    }
}
