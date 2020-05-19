import java.util.HashSet;

public class TripletsWithZeroSum {

    public static void findAllTriplets(int[] array){

        /* Complexity: Time O(n3), space O(1)
        */
        if(array.length==0)
            return;
        for(int i=0;i<array.length-2;i++){
            for(int j=i+1;j<array.length-1;j++){
                for(int k=j+1;k<array.length;k++){
                    if(array[i]+array[j]+array[k]==0)
                        System.out.println("Triplets:"+array[i]+","+array[j]+","+array[k]);
                }
            }
        }
    }

    public static void findAllTripletsUsingHashFunc(int[] array){

        /* Complexity: Time O(n2), space O(n)
         */
        if(array.length==0)
            return;
        HashSet<Integer> numSet=new HashSet<>();

        for(int i=0;i<array.length-1;i++){
            for(int j=i+1;j<array.length;j++){
                int x=-(array[i]+array[j]);
                if(numSet.contains(x)){
                    System.out.println("Triplets: "+array[i]+","+x+","+array[j]);
                }else{
                    numSet.add(array[j]);
                }
            }
            numSet=new HashSet<>();
        }
    }

    public static void findAllTripletsUsingSortAndTwoPointer(int[] array){

        /* Complexity: Time O(n2), space O(1)
         */
        if(array.length==0)
            return;

        for(int i=0;i<array.length-1;i++){

            int l=i+1,r=array.length-1;
            while(l<r){
                int sum=array[i]+array[l]+array[r];
                if(sum==0){
                    System.out.println("Triplets: "+array[i]+","+array[l]+","+array[r]);
                    l++;
                    r--;
                }else if(sum<0){
                    l++;
                }else{
                    r--;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] array={0,-1,2,-3,1};
        findAllTripletsUsingSortAndTwoPointer(array);
    }
}
