package tree;
import java.util.*;
public class GivenValuePath {
	int sum = 0;
    Stack <TreeNode> s = new Stack<>();
   // ArrayList <Integer> list = new ArrayList<>();
    //ÿ�ζ�����ArrayList��̫�ã�
  
    //���õ���ǰ������ķ�ʽ��һ·���¼�
    public void Find(TreeNode root,int target, int sum){
        if(root==null){//�����sumֻ��һ������
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
           }//�����е�Ԫ�ظ��Ƶ�������
           System.out.println();
           //return list;
        }
        //���ص�·���϶�Ҫpop();
        
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
		//��������sum������Ӧ�����ԣ�����ÿ�ζ���ס;
	}

}
