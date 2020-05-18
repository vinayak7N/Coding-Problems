public class ClosestPairFromTwoSortedArrayThatFormASum {

    public static int[] closetPairSum(int[] first,int[] second,int sum){

        int diff=sum-first[0]+second[0];
        int[] pair=new int[2];
        for(int i=0;i<first.length;i++){
            for(int j=1;j<second.length;j++){
                int x=sum-(first[i]+second[j]);
                if(x>0 && x<diff) {
                    diff = x;
                    pair[0]=first[i];
                    pair[1]=second[j];
                }
            }
        }
        return pair;
    }
    public static void main(String[] args) {
        int[] first={1,4,5,7};
        int[] second={10,20,30,40};
        int[] array=closetPairSum(first,second,50);
        System.out.println("Closet pairs: "+array[0]+" and "+array[1]);
    }
}
