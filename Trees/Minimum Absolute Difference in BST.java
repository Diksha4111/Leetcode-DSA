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

/*     TC  =  O(N)  
       SC  =  O(N)     */
class Solution {
    public int getMinimumDifference(TreeNode root) {
        //passing temp by reference
        int[] temp = new int[1];
        temp[0] = Integer.MAX_VALUE;
        //passing ans by reference
        int[] ans = new int[1];
        ans[0] = Integer.MAX_VALUE;

        inorder(root , temp , ans);

        return ans[0];
    }
    //using inorder traversal because inorder is always sorted and 
    //therefore the min. difference between any two nodes will be b/w any two consecutive ones
    //therefore a pointer temp is used to compute abs. difference b/w the nodes
    public void inorder(TreeNode root , int[] temp , int[] ans){
        if(root == null) return;

        //left
        inorder(root.left , temp , ans);
        //root
        ans[0] = Math.min(ans[0] , Math.abs(root.val - temp[0]));
        temp[0] = root.val;
        //right
        inorder(root.right , temp , ans);

    } 
}
