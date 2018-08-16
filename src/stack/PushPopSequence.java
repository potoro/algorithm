package stack;
import java.util.*;
public class PushPopSequence {
	Stack <Integer> s = new Stack<>();
	 public boolean IsPopOrder(int [] pushA,int [] popA) {
         int pushPos = 0;
         int popPos = 0;
        while(popPos < popA.length){//未遍历完pop前都进行
           // while(pushPos < pushA.length && s.peek()!= popA[popPos]){//这种写法有问题，一开始s.peek()为空的时候，用一个空指针和一个数值相比会出现错误，
            while( s.empty() || s.peek()!= popA[popPos]){//所以处理这种一开始s为空的情况就让s.push(),开始堆元素
            	if(pushPos >= pushA.length){
                	break;//就跳出该层循环
                } // s.peek()!= popA[popPos]的时候就一直装，这里会有数组指针过界的情况，所以处理一下边界
                s.push(pushA[pushPos]);
                pushPos++;
            }      //进行元素的压入
            if(s.peek()!=popA[popPos]){//这里按理来说应该是不等的
                break;
            }//退出时是无法获得相应的信息的
            s.pop();//然后把栈顶相等的元素pop出去，pop出去之后，popPos就++；
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
