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
    int sum = 0;
    public int findTilt(TreeNode root) {
        postorder(root);
        return sum;
    }
    public int postorder(TreeNode root){
        if(root == null) return 0;

        int left = postorder(root.left);
        int right = postorder(root.right);

        sum += Math.abs(left - right);

        return root.val + left + right;
    }
}
