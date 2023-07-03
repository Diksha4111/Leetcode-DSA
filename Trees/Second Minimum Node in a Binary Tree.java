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
    int firstMin = Integer.MAX_VALUE;
    int secondMin = Integer.MAX_VALUE;
    boolean isSecondMin = false;
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) return -1;
        helper(root);
        if(isSecondMin) return secondMin;
        return -1;
    }
    public void helper(TreeNode root){
        //returning back if root is found to be null
        if(root == null) return;

        //calculating second minimum
        if(root.val < firstMin) firstMin = root.val;
        else if(root.val > firstMin && root.val <= secondMin){
            secondMin = root.val;
            isSecondMin = true;
        } 

        //recursively moving left
        helper(root.left);
        //recursively moving right
        helper(root.right);

    }
}
