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
	//两个队列应该是成员变量
	LinkedList <Element> date = new LinkedList<>();
	LinkedList <Element> Maximum = new LinkedList<>();
	int index = 0;
	
	//因为不是数组的元素，加进来的元素值是没有下标值的,故建立一个类，包含index和value的两个属性
	public void Insert(int num){
		Element elem = new Element(index++,num);
		//pop出前面更小的元素，因为这个一加进来前面的更小的元素就不可能成为最大的元素
		while(Maximum.size()!=0 && num > Maximum.getLast().value){
			Maximum.pollLast();
		}
		date.addLast(elem);
		Maximum.addLast(elem);//先用后加
	}
	
	public int popElement() throws Exception{//
		if(Maximum.size()==0){
			throw new Exception("queue is empty!");
		}
		if(Maximum.size()!=0 && date.getFirst().index==Maximum.getFirst().index){
			Maximum.pollFirst();//同时更新最大值队列
		}//肯定是不为0的
		return date.pollFirst().value;//获得当前的值得最大
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
