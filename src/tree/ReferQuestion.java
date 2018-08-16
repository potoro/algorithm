package tree;

public class ReferQuestion {
	
	TreeNode tochange = new TreeNode(5);
	TreeNode left = new TreeNode(6);
	public void modify(TreeNode node){
		node.left = left;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReferQuestion test = new ReferQuestion();
		TreeNode change = new TreeNode(1);
		test.modify(change);
	}

}
