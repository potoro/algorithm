package stack;

public class SquenceOfBST {
	public boolean VerifySquenceOfBST(int [] sequence) {//想要传递index的值
        //将数组分成两个部分，比根大的地方
		if(sequence == null) return false;
        return Verify(sequence,0,sequence.length-1);
    }
	
    public boolean Verify(int [] sequence, int start, int end) {//int start 和 int end可以判断一棵树的子树是否为空
        if(end <= start) return true;
        int index = start;
        while(index < end && sequence[index] < sequence[end]){
            index++;
        }//退出循环时所对应的元素应该是右子树部分的第一个元素,保证了这里的左子树都是比根要小的，还需检查一下右子树是不是所有元素都大于等于跟
        for(int i = index; i < end; i++){//如果含有小于根的元素的话就返回false,否则就继续往下判断
            if(sequence[i] < sequence[end]) return false;
        }
        return Verify(sequence,start,index-1) && Verify(sequence,index,end-1);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SquenceOfBST test = new SquenceOfBST();
		//int [] pushA = new int[]{5,7,6,9,11,10,8};
		//int [] pushA = new int[]{7,4,6,5};
		int [][] pushA = new int[4][2];
		System.out.println(test.VerifySquenceOfBST(pushA[2]));
	}
}
