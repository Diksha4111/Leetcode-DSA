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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        TreeNode node = root;
        if(node == null){
            return list;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
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
            list.add(tempList);
        }
        for(int i=list.size() -1 ; i>=0 ; i--){
            ans.add(list.remove(i));
        }
        return ans;
    }
}
