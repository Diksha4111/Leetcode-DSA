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
class Tuple{
    TreeNode node;
    int vertical;
    int level;
    public Tuple(TreeNode node, int vertical, int level){
        this.node = node;
        this.vertical = vertical;
        this.level = level;
    }
} 
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<Tuple>();
        q.offer(new Tuple(root,0,0));
        while(!q.isEmpty()){
            //extracting first element of queue
            Tuple t = q.poll();
            TreeNode node = t.node;
            int vertical = t.vertical;
            int level = t.level;

            //putting node value according to vertical and level in treemap 
            if(!map.containsKey(vertical)){
                map.put(vertical, new TreeMap<>());
            }
            if(!map.get(vertical).containsKey(level)){
                map.get(vertical).put(level, new PriorityQueue<>());
            }
            map.get(vertical).get(level).offer(node.val);

            //Checking for further nodes (left ans right nodes of the popped node)
            if(node.left != null){
                q.offer(new Tuple(node.left, vertical-1, level+1));
            }
            if(node.right != null){
                q.offer(new Tuple(node.right, vertical+1 , level+1));
            }
        }

        //Creating list of list of integers i.e. list of verticals containing list of nodes present in those verticals 
        List<List<Integer>> list = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> v : map.values()){ //iterating throught every vertical
            list.add(new ArrayList<>()); //adding empty list for every vertical
            for(PriorityQueue<Integer> nodes : v.values()){ //iterating through pq for nodes for adding them in the created empty list
                while(!nodes.isEmpty()){                    
                    list.get(list.size() -1).add(nodes.poll()); //add nodes falling under each vertical at the end of the list
                }
            }
        }    
        return list;
    }
}
