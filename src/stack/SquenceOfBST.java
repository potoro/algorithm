package stack;

public class SquenceOfBST {
	public boolean VerifySquenceOfBST(int [] sequence) {//��Ҫ����index��ֵ
        //������ֳ��������֣��ȸ���ĵط�
		if(sequence == null) return false;
        return Verify(sequence,0,sequence.length-1);
    }
	
    public boolean Verify(int [] sequence, int start, int end) {//int start �� int end�����ж�һ�����������Ƿ�Ϊ��
        if(end <= start) return true;
        int index = start;
        while(index < end && sequence[index] < sequence[end]){
            index++;
        }//�˳�ѭ��ʱ����Ӧ��Ԫ��Ӧ�������������ֵĵ�һ��Ԫ��,��֤����������������Ǳȸ�ҪС�ģ�������һ���������ǲ�������Ԫ�ض����ڵ��ڸ�
        for(int i = index; i < end; i++){//�������С�ڸ���Ԫ�صĻ��ͷ���false,����ͼ��������ж�
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
