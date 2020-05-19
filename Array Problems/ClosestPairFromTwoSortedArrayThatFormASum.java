public class ClosestPairFromTwoSortedArrayThatFormASum {

    public static int[] closetPairSum(int[] first,int[] second,int sum){

        int diff=Integer.MAX_VALUE;
        int[] pair=new int[2];
        for(int i=0;i<first.length;i++){
            for(int j=0;j<second.length;j++){
                int x=Math.abs(sum-(first[i]+second[j]));
                if(x<diff) {
                    diff = x;
                    pair[0]=first[i];
                    pair[1]=second[j];
                }
            }
        }
        return pair;
    }

    public static int[] closetPairSumUsingTwoPointer(int[] first,int[] second,int sum){

        int[] pair=new int[2];
        int diff=Integer.MAX_VALUE;
        int l=0,r=second.length-1;
        while(l<first.length && r>=0){

            int x=Math.abs(sum-(first[l]+second[r]));
            if(x<diff){
                diff=x;
                pair[0]=first[l];
                pair[1]=second[r];
            }
            if(first[l]+second[r]>x)
                r--;
            else
                l++;
        }
        return pair;
    }
    public static void main(String[] args) {
        int[] first={1,3,5,7};
        int[] second={10,20,30,40};
        int[] array=closetPairSum(first,second,32);
        System.out.println("Closet pairs: "+array[0]+" and "+array[1]);
    }
}
