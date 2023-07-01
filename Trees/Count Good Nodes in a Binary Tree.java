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

******* | |     MICROSOFT     | | *******

/* TC = O(N) -> traversing N nodes */
/* SC = O(N) -> aux. stack space used by recursion */  
class Solution {
    int count = 0;
    public int goodNodes(TreeNode root) {
        if(root == null) return count;
        int maxm = root.val;
        helper(root , maxm);
        return count; 
    }
    public void helper(TreeNode root , int maxm){
        //if root is null, simply return back
        if(root == null) return;

        //if(current node's value is greater than maxm, the update the count by 1 
        //and maxm with the current node's value
        if(root.val >= maxm){
            count++;
            maxm = root.val;
        }

        //recursively check the same thing for left and right node of the current node
        helper(root.left , maxm);
        helper(root.right , maxm);

    }
}
