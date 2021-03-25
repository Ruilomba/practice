public class InBoth {
    public static void inBothSortedWithN(int[] sorted1, int sorted2[]) {
        int index1 = 0;
        int index2 = 0;
        int length = sorted1.length; // both have same length
        while(index1 < length && index2 < length){
            if(sorted1[index1] < sorted2[index2]) index1++;
            else if(sorted1[index1] > sorted2[index2]) index2++;
            else {
                System.out.println(sorted1[index1]);
                index1++;
                index2++;
            }
        }
        System.out.println("-------------------------------");
    }


    public static void main(String[] args)   {
        inBothSortedWithN(
                new int[]{1,2,3,4,5,6},
                new int[]{1,2,3,4,5,6}
        );

        inBothSortedWithN(
                new int[]{4,6,7,8,9,10},
                new int[]{1,2,3,4,5,6}
        );
    }
}
 