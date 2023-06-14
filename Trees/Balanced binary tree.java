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
    public boolean isBalanced(TreeNode root) {
        int ans = calcHeight(root);
        if(ans == -1){
            return false;
        }
        else{
            return true;
        }
    }
    public int calcHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        int lH = calcHeight(root.left);
        int rH = calcHeight(root.right);

        if(lH == -1 || rH == -1) return -1;
        if(Math.abs(lH-rH)>1) return -1;

        return 1+Math.max(lH,rH);
    } 
}
