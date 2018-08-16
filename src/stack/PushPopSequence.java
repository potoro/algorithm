package stack;
import java.util.*;
public class PushPopSequence {
	Stack <Integer> s = new Stack<>();
	 public boolean IsPopOrder(int [] pushA,int [] popA) {
         int pushPos = 0;
         int popPos = 0;
        while(popPos < popA.length){//δ������popǰ������
           // while(pushPos < pushA.length && s.peek()!= popA[popPos]){//����д�������⣬һ��ʼs.peek()Ϊ�յ�ʱ����һ����ָ���һ����ֵ��Ȼ���ִ���
            while( s.empty() || s.peek()!= popA[popPos]){//���Դ�������һ��ʼsΪ�յ��������s.push(),��ʼ��Ԫ��
            	if(pushPos >= pushA.length){
                	break;//�������ò�ѭ��
                } // s.peek()!= popA[popPos]��ʱ���һֱװ�������������ָ��������������Դ���һ�±߽�
                s.push(pushA[pushPos]);
                pushPos++;
            }      //����Ԫ�ص�ѹ��
            if(s.peek()!=popA[popPos]){//���ﰴ����˵Ӧ���ǲ��ȵ�
                break;
            }//�˳�ʱ���޷������Ӧ����Ϣ��
            s.pop();//Ȼ���ջ����ȵ�Ԫ��pop��ȥ��pop��ȥ֮��popPos��++��
            popPos++;
        }
        
        if(s.empty() && (popPos == popA.length)){
            return true;
        }
         return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PushPopSequence test = new PushPopSequence();
		int [] pushA = new int[]{1,2,3,4,5};
		int [] popA = new int[]{4,5,3,2,1};
//		Stack <Integer> s = new Stack<>();
//		System.out.println(s.peek()==1);
		System.out.println(test.IsPopOrder(pushA,popA));
	}
	
}
