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

/* TC = O(n) -> Traversing N nodes
   SC = O(n) -> Auxillary stack space used by recursion  */
class Solution {
    public int maxPathSum(TreeNode root) {
        int[] maxm = new int[1]; //because we have to pass maxm by refrence
        maxm[0] = Integer.MIN_VALUE;
        getMaxPathSum(root , maxm);
        return maxm[0];
    }
    public int getMaxPathSum(TreeNode root , int[] maxm){
        if(root == null) return 0;

        //using 0 to avoid the case of negative path in order to obtain max path sum
        int left = Math.max(0 , getMaxPathSum(root.left , maxm));
        int right = Math.max(0 , getMaxPathSum(root.right , maxm));

        //computing max path sum
        maxm[0] = Math.max(maxm[0] , root.val + left + right);

        /*return max value of either left or right 
        in order to know the path which results in maximum sum*/
        return root.val + Math.max(left , right);
    }
}
