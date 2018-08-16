package list;
import java.util.*;
public class SlideWindow {
    public static ArrayList<Integer> maxInWindows(int [] num, int size){
        
         ArrayList <Integer> list = new ArrayList<>();
        if(num.length==0|| size<=0) return list;
         LinkedList <Integer> deque = new LinkedList<>();
        //���Ȱ�index����
        for(int i =0; i < size; i++){//�����˫�˶������治�Ǵ�����ֵ�Ϳ��ܳ�Ϊ���ֵ��Ԫ�أ����Ǵ�����ֵ������
           while(deque.size()!=0&& num[i]>= num[deque.getLast()]){
               deque.pollLast();
           }
           deque.addLast(i);
        }
        list.add(num[deque.getFirst()]);
        //���������ж�ÿ�ε����ֵ
        
        for(int i=size; i< num.length; i++){
            if(deque.getFirst()<=(i-size)){
                deque.pollFirst();
            }//û����һ����Ԫ�أ�������ֵ���������Ԫ���ǲ����Ѿ��Ƴ�
            while(deque.size()!=0 && num[i]> num[deque.getLast()]){
                deque.pollLast();
            }
            deque.addLast(i);//�Ѹ����굱ǰ�����ֵ
            list.add(num[deque.getFirst()]);
        }
        return list;
    }
    
    
    public static void main(String args[]){
    	 maxInWindows(new int[]{2,3,4,2,6,2,5,1},3);
    }
    
}