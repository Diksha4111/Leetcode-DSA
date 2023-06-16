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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inMap = new HashMap<Integer,Integer>();
        for(int i=0 ; i<inorder.length ; i++){ //inserting inorder values in map to find root easily
            inMap.put(inorder[i] ,  i);
        }

        TreeNode root = BuildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inMap);

        return root; 
    }
    public TreeNode BuildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer,Integer> inMap){

        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]); //finding root in preorder
        int inRoot = inMap.get(root.val); //finding root in inorder
        int numsLeft = inRoot - inStart; //calculating nums in left of inRoot to calculate new inorder

        //recursively calling BuildTree to create left and right sub tree
        root.left = BuildTree(preorder, preStart+1, preStart+numsLeft, inorder, inStart, inRoot-1, inMap);
        root.right = BuildTree(preorder, preStart+numsLeft+1, preEnd, inorder, inRoot+1, inEnd, inMap);

        return root;
    }
}
