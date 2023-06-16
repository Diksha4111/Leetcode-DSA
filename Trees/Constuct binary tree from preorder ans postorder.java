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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer,Integer> postMap = new HashMap<Integer,Integer>();
        //storing postorder values in postMap
        for(int i=0 ; i<postorder.length ; i++){ 
            postMap.put(postorder[i] , i);
        }

        TreeNode root = BuildTree(preorder, 0, preorder.length-1, postorder,0, postorder.length-1, postMap);

        return root;
    }
    public TreeNode BuildTree(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer,Integer> postMap){
        //to tell that there is no node left, so return null
        if(preStart > preEnd || postStart > postEnd){
            return null;
        }

        //taking root node from preorder (first elemnt of preorder)
        TreeNode root = new TreeNode(preorder[preStart]);
        
        //when we get array of size 1, then we simply return the root itself because no child node is present
        if(preStart == preEnd) return root;

        //finding index of root of left sub-tree in postMap taking
        int postLeftRoot = postMap.get(preorder[preStart+1]);

        //calculating number of nodes in the left sub-tree
        int numsLeft = postLeftRoot - postStart + 1;

        //calling BuildTree recusively to build left sub-tree
        root.left = BuildTree(preorder, preStart+1, preStart+numsLeft, postorder, postStart, postLeftRoot, postMap);

        //calling BuildTree recusively to build right sub-tree
        root.right = BuildTree(preorder, preStart+numsLeft+1, preEnd, postorder, postLeftRoot+1, postEnd-1, postMap);

        return root;




    }
}
