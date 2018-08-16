package tree;
import java.util.*;
public class GivenValuePath {
	int sum = 0;
    Stack <TreeNode> s = new Stack<>();
   // ArrayList <Integer> list = new ArrayList<>();
    //每次都返回ArrayList不太好，
  
    //采用的是前序遍历的方式，一路往下加
    public void Find(TreeNode root,int target, int sum){
        if(root==null){//这里的sum只是一个引用
            return;
        }
        
        sum = sum + root.val;
        s.push(root);
        
        boolean isLeaf = (root.left==null) && (root.left==null);
        if(isLeaf && sum == target){
           Iterator <TreeNode> iter = s.iterator();
           for(;iter.hasNext();){
               System.out.print(iter.next().val+" ");
               
              //list.add(i.next().val);
           }//把所有的元素复制到链表当中
           System.out.println();
           //return list;
        }
        //返回的路径上都要pop();
        
        if(root.left!=null){
            Find(root.left ,target,sum);
        }
        
        if(root.right !=null){
            Find(root.right ,target,sum);
        }
        s.pop();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree t = new Tree();
		int [] tree = new int[]{10,5,12,4,7};
		for(int i=0; i < tree.length; i++){
			t.indert(tree[i]);
		}
		GivenValuePath test = new GivenValuePath();             
		test.Find(t.root,22,0);
		//这里用了sum变量的应用特性，不用每次都记住;
	}

}
