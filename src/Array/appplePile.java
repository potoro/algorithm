package Array;

public class appplePile {
    public static int[] belongTo(int[]EveryHeapnums, int hnum, int[]ques){
        int []temp = new int[hnum];
        int []res = new int[ques.length];
        if(EveryHeapnums==null||EveryHeapnums.length==0||ques==null||ques.length==0) return res;
        temp[0] = EveryHeapnums[0];
        for(int i=0; i<hnum-1; i++){
            temp[i+1]=temp[i]+EveryHeapnums[i+1];
        }
        for(int j=0; j<ques.length; j++){
            for(int i=0; i<hnum; i++){
                if(ques[j]<=temp[0]){res[j]=1; break;}
                if(ques[j]>temp[i])continue;
                if(i>0 && ques[j]<=temp[i] &&ques[j]>temp[i-1]){
                    res[j]=i+1;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[]EveryHeapnums = new int[]{2,7,3,4,9};
        int hnum =5;
        int[]ques = new int[]{1,25,11};
        int []res = belongTo(EveryHeapnums,hnum,ques);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}
