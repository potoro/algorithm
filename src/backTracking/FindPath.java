package backTracking;

public class FindPath {
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str)//�����������ʽ��ʾ����ͨ��row*col��ֵ��������ص�Ԫ��
    {   //����������������matrix.size = cols*rows;
		boolean hasPath = false;
		/*if(matrix == null || rows<1 || cols<1 || str==null){
			return false;//�����жϵı߽�����������ȫͨ��
		}*/
		
		 if(matrix==null || matrix.length==0 || str==null || str.length==0 || matrix.length!=rows*cols || rows<=0 || cols<=0 || rows*cols < str.length) {
	            return false ;//�߽�����ֵҪ������ϸ
	        }
		
        boolean []visted = new boolean[rows*cols];
        for(int i=0; i< rows*cols; i++){
		}
        
        //ÿһ��Ԫ�ض�������Ϊ��ʼ
        int pathLength = 0;
        for(int row=0; row < rows; row++){
        	for(int col=0; col < cols; col++){
        		hasPath = hasPathCore(matrix,rows,cols, row, col, pathLength, str, visted);
        		if(hasPath){//�����һ��Ԫ��Ϊ��ʼ���·���Ƿ����������ֵ���о�ֱ�ӷ���true,
        			return true;
        		}
        	}
        }
        return false;
    }
	
	public boolean hasPathCore(char[] matrix,int rows,int cols, int row, int col,int pathLength,char[] str,boolean[]visted){
		//
		if(pathLength==str.length){
			return true;
		}
		boolean hasPath = false;
		if(row >=rows || row<0 || col<0|| col>=cols){//��鳬�������λ�õ�ֵʱ�����ڵģ�ֱ�ӷ���false;
			return false;
		}
		
		if(matrix[row*cols+col]==str[pathLength] && visted[row*cols+col] == false){//Ҫ����Ԫ�ر�����֮ǰû�о�����·��
			pathLength++;
			hasPath = true;
		}
		
		visted[row*cols+col] = true;//�Ѿ������˲�Ϊ0
		
		if(hasPath){
			hasPath = hasPathCore(matrix,rows,cols, row-1, col, pathLength, str,visted)
					|| hasPathCore(matrix,rows,cols, row, col-1, pathLength, str,visted)
					|| hasPathCore(matrix,rows,cols, row, col+1, pathLength,str,visted)
					|| hasPathCore(matrix,rows,cols, row+1, col, pathLength,str,visted);
		}
		if(!hasPath){
			pathLength--;//
			visted[row*cols+col] = false;
		}
		return hasPath;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindPath test = new FindPath();
		String toSearch = "abcesfcsadee";
		char[] str = "bcced".toCharArray();
		char[] matrix = toSearch.toCharArray();
		System.out.println(test.hasPath(matrix,3,4,str));
	}

}
