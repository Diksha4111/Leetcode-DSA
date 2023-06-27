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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        //constructing lists containing leaf nodes for tree1 and tree2 
        helper(root1 , list1);
        helper(root2 , list2);
        //comparing two lists
        if(list1.size() != list2.size()) return false;

        for(int i=0 ; i<list1.size() ; i++){
            if(list1.get(i) != list2.get(i)) return false;
        }

        return true;
    }
    public void helper(TreeNode root, ArrayList<Integer> list){
        //return back if node is null
        if(root == null) return;

        //adding leaf node in the list
        if(root.left == null && root.right==null){
            list.add(root.val);
        }
        //recursively traversing left and right sub-tree
        helper(root.left , list);
        helper(root.right , list);
    }
}
