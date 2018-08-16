package sort;

public class InversePairs {
	public int InversePairs(int [] data) {
		if(data.length==0) return 0;
        int copy[] = new int [data.length];
        int start = 0;
        int end = data.length-1;
        return numOfInversPair(data,copy,start,end);
    }
	public int numOfInversPair(int data[],int copy[],int start,int end){
		
		if(end==start) return 0;
		int index = (start+end)/2;
		int left = numOfInversPair(data,copy,start,index);
		int right = numOfInversPair(data,copy,index+1,end);
		int count = 0;
		int indEnd = end;
		//合并计数的过程
		int index1 = index;
		int index2 = end;
		while(index1>=start && index2 >=(index+1)){
			if(data[index1] > data[index2]){
				copy[indEnd--]=data[index1--];
				count += index2-index;
			}else{
				copy[indEnd--]=data[index2--];
				count += index1-start+1;
			}
		}
		for(;index1>=start;){
			copy[indEnd--]=data[index1--];
		}
		for(;index2>=(index+1);){
			copy[indEnd--]=data[index2--];
		}
		for(int i = start; i <= end; i++){
			data[i] = copy[i];
		}
		return left+right+count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InversePairs test = new InversePairs();
		int result = test.InversePairs(new int[]{7,5,6,4,32});
		System.out.println(result);
	}
}
