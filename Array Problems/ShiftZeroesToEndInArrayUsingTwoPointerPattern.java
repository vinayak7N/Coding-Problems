public class ShiftZeroesToEndInArrayUsingTwoPointerPattern {

    public static int[] shiftZeroes(int[] array){

        if(array.length==0)
            return array;
        int reader=0;
        int writer=0;
        while(reader<array.length){
            if(array[reader]!=0){
                array[writer]=array[reader];
                writer++;
            }
            reader++;
        }
        while(writer<array.length){
            array[writer]=0;
            writer++;
        }
        return array;
    }
    public static void main(String[] args) {
        int[] array={0,3,0,10,0,9};
        System.out.println("Array before shifting:");
        printArray(array);
        array=shiftZeroes(array);
        System.out.println("Array after shifting:");
        printArray(array);
    }

    private static void printArray(int[] array){
        for(int index=0;index<array.length;index++){
            System.out.print(array[index]+" ");
        }
    }
}
