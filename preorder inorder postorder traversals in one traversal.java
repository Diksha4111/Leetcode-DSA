import java.util.* ;
import java.io.*; 
/************************************************************

	Following is the Binary Tree node structure:

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}

************************************************************/
class Pair{
	BinaryTreeNode node;
	int num;
	public Pair(BinaryTreeNode node, int num){
		this.node = node;
		this.num = num;
	}
}
public class Solution {
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        // Write your code here.
		ArrayList<Integer> preorder = new ArrayList<Integer>();
		ArrayList<Integer> inorder = new ArrayList<Integer>();
		ArrayList<Integer> postorder = new ArrayList<Integer>();
		List<List<Integer>> ans = new LinkedList<List<Integer>>();
		Stack<Pair> st = new Stack<Pair>();
		st.push(new Pair(root,1));
		if(root == null){
			return ans;
		}
		while(!st.isEmpty()){
			Pair i = st.pop();
			if(i.num == 1){
				preorder.add(i.node.data);
				i.num++;
				st.push(i);
				if(i.node.left != null){
					st.push(new Pair(i.node.left,1));
				}
			}
			if(i.num == 2){
				inorder.add(i.node.data);
				i.num++;
				st.push(i);
				if(i.node.right != null){
					st.push(new Pair(i.node.right,2));
				}
			}
			else{
				postorder.add(i.node.data);
			}

		}
		ans.add(preorder);
		ans.add(inorder);
		ans.add(postorder);

		return ans;

    }
}
