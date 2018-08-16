package tree;
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class TreeToString {
   // LinkedList<Character> list = new LinkedList<>();
    String s = null;
    
    String Serialize(TreeNode root) {
        if(root==null) s+="$";
        if(root!=null) s+= root.val;
        Serialize(root.left);
        Serialize(root.left);
        return s;
  }
    TreeNode Deserialize(String str) {
        TreeNode root = null;
        if(str.length()==0) return root;
       String[] ch = str.split(",");
        return method(ch);
  }
    int index=0;
    public TreeNode method(String []ch){
    	 
        if(!ch[index].equals("$")){
        	TreeNode root = new TreeNode(0);
            root.val = Integer.parseInt(ch[index]);
            root.left = method(ch);
            root.right = method(ch);
            return root;
        }
        index++;
        return null;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	
	}
    /*
     * int index=-1;
     public TreeNode method(String []ch){
        index++;
         if(index < ch.length &&!ch[index].equals("$")){
             TreeNode root = new TreeNode(0);
             root.val = Integer.parseInt(ch[index]);
             root.left = method(ch);
             root.right = method(ch);
             return root;
         }
         return null;
    }
     */
}

