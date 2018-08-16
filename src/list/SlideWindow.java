package list;
import java.util.*;
public class SlideWindow {
    public static ArrayList<Integer> maxInWindows(int [] num, int size){
        
         ArrayList <Integer> list = new ArrayList<>();
        if(num.length==0|| size<=0) return list;
         LinkedList <Integer> deque = new LinkedList<>();
        //首先把index存入
        for(int i =0; i < size; i++){//构造的双端队列里面不是存的最大值和可能成为最大值得元素，而是存的最大值的索引
           while(deque.size()!=0&& num[i]>= num[deque.getLast()]){
               deque.pollLast();
           }
           deque.addLast(i);
        }
        list.add(num[deque.getFirst()]);
        //接着依次判断每次的最大值
        
        for(int i=size; i< num.length; i++){
            if(deque.getFirst()<=(i-size)){
                deque.pollFirst();
            }//没进来一个新元素，检查最大值队列里面的元素是不是已经移出
            while(deque.size()!=0 && num[i]> num[deque.getLast()]){
                deque.pollLast();
            }
            deque.addLast(i);//已更新完当前的最大值
            list.add(num[deque.getFirst()]);
        }
        return list;
    }
    
    
    public static void main(String args[]){
    	 maxInWindows(new int[]{2,3,4,2,6,2,5,1},3);
    }
    
}