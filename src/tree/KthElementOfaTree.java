package tree;
import tree.TreeNode;
public class KthElementOfaTree {
	
	
/*
	 TreeNode KthNode(TreeNode pRoot, int k){//��Ҫk�������ˣ�ͨ�����øı䲻��k��ֵ
	        //�������������
		int []count = new int[1];
		TreeNode [] target = new TreeNode[1];
		find(pRoot, count,k, target);
		return target[0];
	}
	public void find(TreeNode pRoot, int[]count,int k, TreeNode[]target){//��Ҫ�ı�target��ֵ��������������ͺøı�
		//��Ϊ����û�취�ı����ֵ�������һ����СΪ1������������
		if(pRoot==null) return;
		find(pRoot.left, count,k, target);
		count[0]++;
		if(count[0]==k){
			target[0] = pRoot;//
		}
		find(pRoot.right,count,k,target);
	}
	 //�������ַ����������һ������
	
	*/
	
	
	/*TreeNode KthNode(TreeNode pRoot, int k){//��Ҫk�������ˣ�ͨ�����øı䲻��k��ֵ
        //�������������
	int []count = new int[1];
	TreeNode [] target = new TreeNode[1];
	count[0] = k;
     find(pRoot, count,target);
     return target[0];
}
public void find(TreeNode pRoot, int[]count, TreeNode[]target){//��Ҫ�ı�target��ֵ��������������ͺøı�
	
	if(pRoot==null) return;
	find(pRoot.left, count, target);
	count[0]--;
	if(count[0]==0){
		target[0] = pRoot;//
	}
	find(pRoot.right,count,target);
}
 */
	//ֻ������ߵķ���
	
	 TreeNode KthNode(TreeNode pRoot, int k){//��Ҫk�������ˣ�ͨ�����øı䲻��k��ֵ
	        //�������������
		int []count = new int[1];
		TreeNode [] target = new TreeNode[1];
		target[0] = find(pRoot, count,k, target);
		return target[0];
	}
	public TreeNode find(TreeNode pRoot, int[]count,int k, TreeNode[]target){//��Ҫ�ı�target��ֵ��������������ͺøı�
		//��Ϊ����û�취�ı����ֵ�������һ����СΪ1������������
		if(pRoot==null) return pRoot;
		TreeNode node = find(pRoot.left,count,k, target);
		if(node!=null) return node;
		count[0]++;
		if(count[0]==k){
			return pRoot;
		}
		node = find(pRoot.right, count,k, target);//�ж�һ���ұ��ҵ�û��
		if(node!=null)return node;
		else return node;
	}
	
	
	
	
	
}
