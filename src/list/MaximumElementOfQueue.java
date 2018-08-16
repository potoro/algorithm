package list;
import java.util.*;
class Element{
	int index;
	int value;
	public Element(int i, int v){
		this.index = i;
		this.value = v;
	}
}
public class MaximumElementOfQueue {
	//��������Ӧ���ǳ�Ա����
	LinkedList <Element> date = new LinkedList<>();
	LinkedList <Element> Maximum = new LinkedList<>();
	int index = 0;
	
	//��Ϊ���������Ԫ�أ��ӽ�����Ԫ��ֵ��û���±�ֵ��,�ʽ���һ���࣬����index��value����������
	public void Insert(int num){
		Element elem = new Element(index++,num);
		//pop��ǰ���С��Ԫ�أ���Ϊ���һ�ӽ���ǰ��ĸ�С��Ԫ�ؾͲ����ܳ�Ϊ����Ԫ��
		while(Maximum.size()!=0 && num > Maximum.getLast().value){
			Maximum.pollLast();
		}
		date.addLast(elem);
		Maximum.addLast(elem);//���ú��
	}
	
	public int popElement() throws Exception{//
		if(Maximum.size()==0){
			throw new Exception("queue is empty!");
		}
		if(Maximum.size()!=0 && date.getFirst().index==Maximum.getFirst().index){
			Maximum.pollFirst();//ͬʱ�������ֵ����
		}//�϶��ǲ�Ϊ0��
		return date.pollFirst().value;//��õ�ǰ��ֵ�����
	}
	
	public int getMaxi() throws Exception{
		if(Maximum.size()==0){
			throw new Exception("queue is empty!");
		}
		return Maximum.getFirst().value;
	}
	
	public static void main(String args[]) throws Exception{
	   	 int [] t = new int[]{2,3,4,2,6,2,5,1};
	   	MaximumElementOfQueue test = new MaximumElementOfQueue();
	   	 for(int i =0 ; i< t.length; i++){
	   		 test.Insert(t[i]);
	   	 }
	   	 
	   	 //System.out.println(test.getMaxi());
	   	 
	   	 for(int i=0; i< 7; i++){
	   		 System.out.println(test.popElement());
	   	 }
	   	System.out.println(test.getMaxi());
	    //System.out.println(test.popMaxi());
   }
}
