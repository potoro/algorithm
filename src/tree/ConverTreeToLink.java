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
	 
//�ο���ʿ���ĵ��������������ڴ����

public class ConverTreeToLink { 
	TreeNode LastNode = null ;
	 public void ConvertMethod(TreeNode pCur){
		 
	        if(pCur == null) return;
	        if(pCur.left != null){
	            ConvertMethod(pCur.left);//ִ�����Ӧ����
	        }
	        
	        pCur.left = LastNode;
	        if(LastNode != null){
	           LastNode.right = pCur;
	        }
	        LastNode = pCur;//�漰���ڴ������ֵ���޸�
	        // ���Ŷ����������д���
	        if(pCur.right != null){
	            ConvertMethod(pCur.right);
	        }
	    }
	 
	 public TreeNode Convert(TreeNode pRootOfTree) {
		 	TreeNode LastNode = null;
	        ConvertMethod(pRootOfTree);
	        //��߽ڵ㲻Ϊ��ʱ��������������������Ӧ���������������ڵ���ΪLastNode
	        TreeNode Phead =  LastNode;
	        while(pRootOfTree.left != null){
	            pRootOfTree = pRootOfTree.left;
	        }
	        return pRootOfTree;
	    }
	 public static void main(String[] args) {
			// TODO Auto-generated method stub
			//����һ�ö���������
			Tree t = new Tree();
			int [] tree = new int[]{10,6,14,4,8,12,16};
			for(int i=0; i < tree.length; i++){
				t.indert(tree[i]);
			}
			ConverTreeToLink test = new ConverTreeToLink();
			test.Convert(t.root);
		}
}
