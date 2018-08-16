package list;

import java.util.*;
public class MidOfdataStream {
    LinkedList<Integer> list  = new LinkedList<>();
    
    public void Insert(Integer num) {
        if(list.size()==0||num<list.getFirst()) list.addFirst(num);
        else{
            boolean insert = false;
            for(Integer i : list){//找到比它大的为止
                if(i > num){
                    insert = true;
                    int index = list. indexOf(i);
                    list.add(index,num);
                    
                    //LinkedList<Character> list = new LinkedList<>();
                    break;
                }
            }
            //遍历完了发现是最大的一个的话，就插入最后一个
            if(insert==false) list.addLast(num);
        }
    }

    public Double GetMedian() {
        double mid = 0;
        if(list.size()==0) return (double) -1;
        int index1;
		if(list.size()%2==0) {
			index1 = list.size()/2;
			double sum = Double.valueOf(list.get(index1)+list.get(index1-1));
            mid =sum/2;
		}else{
            mid = list.get(list.size()/2);
        }
        return mid;
    }
    
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	MidOfdataStream test = new MidOfdataStream();
    	test.Insert(5);
    	test.Insert(2);
    	test.Insert(3);
    	double result = test.GetMedian();
    	System.out.println();
    }

}

