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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> pathList = new ArrayList();
        List<List<Integer>> ansList = new ArrayList();
        findPath(root , 0 , targetSum , pathList , ansList);
        return ansList;
    }
    public List<List<Integer>> findPath(TreeNode root, int sum , int targetSum , List<Integer> pathList , List<List<Integer>> ansList){
        if(root == null) return ansList;
        pathList.add(root.val); //if the node is not null add it in the pathList

        //if you reach leaf node and the current sum becomes equal to the target sum, simply add the pathList to the end of the ansList
        if(root.left == null && root.right == null){
            sum += root.val;
            if(sum == targetSum){
                ansList.add(new ArrayList<>(pathList));
            }
        }

        //recursively find path in left sub-tree
        findPath(root.left , sum+root.val , targetSum , pathList , ansList);
        //recursively find path in right sub-tree
        findPath(root.right , sum+root.val , targetSum , pathList , ansList);

        //removing current node to backtrack -> meaning to return back from the current node for going up in the recursive call 
        pathList.remove(pathList.size() - 1);

        return ansList;
    }
}
