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
    int sum;
    public int sumOfLeftLeaves(TreeNode root) {
        return getSumofLeftLeaves(root);
    }
    public int getSumofLeftLeaves(TreeNode root){
        if(root == null) return 0;
   
        if(root.left != null){
            if(root.left.left == null && root.left.right == null){
                sum += root.left.val;
            }
        }

        getSumofLeftLeaves(root.left);
        getSumofLeftLeaves(root.right);

        return sum;
    }
}
