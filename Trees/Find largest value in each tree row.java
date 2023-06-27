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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            //finding size of queue for level-order-traversal
            int s = q.size();
            int max = Integer.MIN_VALUE;
            //Iterating over elements present in the same level
            for(int i=0 ; i<s ; i++){
                //removing the first element of queue
                TreeNode curr = q.poll();

                //putting in queue if left and right of the current node exits
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);

                //finding max element of the level
                max = Math.max(max , curr.val);
            }
            //add the max elemnt of the level in the list
            ans.add(max);
        }
        return ans;
    }
}
