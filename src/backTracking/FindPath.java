package backTracking;

public class FindPath {
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str)//这里数组的形式表示矩阵，通过row*col的值来访问相关的元素
    {   //给了行数和列数，matrix.size = cols*rows;
		boolean hasPath = false;
		/*if(matrix == null || rows<1 || cols<1 || str==null){
			return false;//这种判断的边界条件不能完全通过
		}*/
		
		 if(matrix==null || matrix.length==0 || str==null || str.length==0 || matrix.length!=rows*cols || rows<=0 || cols<=0 || rows*cols < str.length) {
	            return false ;//边界条件值要考虑详细
	        }
		
        boolean []visted = new boolean[rows*cols];
        for(int i=0; i< rows*cols; i++){
		}
        
        //每一个元素都可能作为开始
        int pathLength = 0;
        for(int row=0; row < rows; row++){
        	for(int col=0; col < cols; col++){
        		hasPath = hasPathCore(matrix,rows,cols, row, col, pathLength, str, visted);
        		if(hasPath){//检查以一个元素为起始点的路径是否存在这样的值，有就直接返回true,
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
		if(row >=rows || row<0 || col<0|| col>=cols){//检查超过矩阵的位置的值时不存在的，直接返回false;
			return false;
		}
		
		if(matrix[row*cols+col]==str[pathLength] && visted[row*cols+col] == false){//要检查的元素必须是之前没有经过的路径
			pathLength++;
			hasPath = true;
		}
		
		visted[row*cols+col] = true;//已经检查过了不为0
		
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
