public class TwoSumUsingTwoPointerPattern {

    public static int[] findTwoSum(int[] array,int sum){

        if(array.length==0)
            return array;
        int i=0,j=array.length-1;
        while(i<j){
            int check=array[i]+array[j];
            if(check==sum){
                return new int[]{i,j};
            }
            else if(check<sum){
                i++;
            }else{
                j--;
            }
        }
        return new int[]{};
    }
    public static void main(String[] args) {
        int[] array={10,20,35,50,75,80};
        int sum=70;
        int[] posArray=findTwoSum(array,sum);
        System.out.println("Array sum index are: "+posArray[0]+","+posArray[1]);

    }
}
