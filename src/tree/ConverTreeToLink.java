package tree;
class TreeNode{
	int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;}
}

class Tree{
	 TreeNode root = null;
	 public void indert(int val){
		   if(root == null){
			   root =new TreeNode(val);
			   return;
		   }
		   TreeNode cur = root;
		   TreeNode pre = root;
		   while(cur != null){
			   pre = cur;
			   if(val < cur.val){
				   cur = cur.left;
			   }
			   else{
				   cur = cur.right;
			   }
		   }
		   cur =new TreeNode(val);
		   if(pre.val > val){
			   pre.left = cur;
		   }else{
			   pre.right = cur;
		   }
	 }

}
	 
//参考马士兵的第三章面向对象的内存解析

public class ConverTreeToLink { 
	TreeNode LastNode = null ;
	 public void ConvertMethod(TreeNode pCur){
		 
	        if(pCur == null) return;
	        if(pCur.left != null){
	            ConvertMethod(pCur.left);//执行完后应该是
	        }
	        
	        pCur.left = LastNode;
	        if(LastNode != null){
	           LastNode.right = pCur;
	        }
	        LastNode = pCur;//涉及到内存的引用值的修改
	        // 接着对右子树进行处理
	        if(pCur.right != null){
	            ConvertMethod(pCur.right);
	        }
	    }
	 
	 public TreeNode Convert(TreeNode pRootOfTree) {
		 	TreeNode LastNode = null;
	        ConvertMethod(pRootOfTree);
	        //左边节点不为空时，对其调用这个，调用完应该是左子树的最大节点作为LastNode
	        TreeNode Phead =  LastNode;
	        while(pRootOfTree.left != null){
	            pRootOfTree = pRootOfTree.left;
	        }
	        return pRootOfTree;
	    }
	 public static void main(String[] args) {
			// TODO Auto-generated method stub
			//构造一棵二叉搜索树
			Tree t = new Tree();
			int [] tree = new int[]{10,6,14,4,8,12,16};
			for(int i=0; i < tree.length; i++){
				t.indert(tree[i]);
			}
			ConverTreeToLink test = new ConverTreeToLink();
			test.Convert(t.root);
		}
}
