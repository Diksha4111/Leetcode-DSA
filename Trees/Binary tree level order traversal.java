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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> ansList = new LinkedList<List<Integer>>();
        TreeNode node = root;
        if(node == null){
            return ansList;
        }
        q.offer(node);
        while(!q.isEmpty()){
            int s = q.size();
            ArrayList<Integer> tempList = new ArrayList<Integer>();
            for(int i=0 ; i<s ; i++){
                node = q.poll();
                tempList.add(node.val);
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            ansList.add(tempList);
        }
        return ansList;

    }
}
