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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ansList = new ArrayList<Double>();
        if(root == null) return ansList;
        Queue<TreeNode> q  = new LinkedList<TreeNode>();
        q.offer(root);
        //continue the proess until queue becomes empty
        while(!q.isEmpty()){
            int s = q.size();
            double levelavg = 0;
            //running loop for each level
            for(int i=0 ; i<s ; i++){
                //removing first element of queue - taking it as current node
                TreeNode cur = q.poll();
                //adding nodes values of each level
                levelavg += (double)cur.val;
                //if left and right node of the current node exists the add them in the queue
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }
            //calculating avg of each level 
            levelavg = levelavg / s;
            //adding avg of leach level to the list
            ansList.add(levelavg);
        }
        return ansList;
    }
}
