package tree;
import tree.TreeNode;
public class KthElementOfaTree {
	
	
/*
	 TreeNode KthNode(TreeNode pRoot, int k){//不要k的引用了，通过引用改变不了k的值
	        //用中序须遍历法
		int []count = new int[1];
		TreeNode [] target = new TreeNode[1];
		find(pRoot, count,k, target);
		return target[0];
	}
	public void find(TreeNode pRoot, int[]count,int k, TreeNode[]target){//还要改变target的值，传进来是数组就好改变
		//因为引用没办法改变变量值，因此用一个大小为1的数组来代替
		if(pRoot==null) return;
		find(pRoot.left, count,k, target);
		count[0]++;
		if(count[0]==k){
			target[0] = pRoot;//
		}
		find(pRoot.right,count,k,target);
	}
	 //以上两种方法会遍历完一整棵树
	
	*/
	
	
	/*TreeNode KthNode(TreeNode pRoot, int k){//不要k的引用了，通过引用改变不了k的值
        //用中序须遍历法
	int []count = new int[1];
	TreeNode [] target = new TreeNode[1];
	count[0] = k;
     find(pRoot, count,target);
     return target[0];
}
public void find(TreeNode pRoot, int[]count, TreeNode[]target){//还要改变target的值，传进来是数组就好改变
	
	if(pRoot==null) return;
	find(pRoot.left, count, target);
	count[0]--;
	if(count[0]==0){
		target[0] = pRoot;//
	}
	find(pRoot.right,count,target);
}
 */
	//只遍历半边的方法
	
	 TreeNode KthNode(TreeNode pRoot, int k){//不要k的引用了，通过引用改变不了k的值
	        //用中序须遍历法
		int []count = new int[1];
		TreeNode [] target = new TreeNode[1];
		target[0] = find(pRoot, count,k, target);
		return target[0];
	}
	public TreeNode find(TreeNode pRoot, int[]count,int k, TreeNode[]target){//还要改变target的值，传进来是数组就好改变
		//因为引用没办法改变变量值，因此用一个大小为1的数组来代替
		if(pRoot==null) return pRoot;
		TreeNode node = find(pRoot.left,count,k, target);
		if(node!=null) return node;
		count[0]++;
		if(count[0]==k){
			return pRoot;
		}
		node = find(pRoot.right, count,k, target);//判断一下右边找到没有
		if(node!=null)return node;
		else return node;
	}
	
	
	
	
	
}
