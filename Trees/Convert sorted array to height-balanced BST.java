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
    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums , 0, nums.length-1);
    }
    public TreeNode createBST(int[] nums , int low, int high){
        //base condition for recursion to stop 
        if(low > high) return null;

        // find mid root everytime and make it the root
        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        //find mid for left sub-tree
        root.left = createBST(nums , low , mid-1);
        //find mid for right sub-tree
        root.right = createBST(nums, mid+1 , high);

        //return root of the tree
        return root;
    }
}
