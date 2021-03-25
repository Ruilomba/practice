public class HowMany {
    public static int howMany(int[] sorted1, int key) {
        int count = 0;
        if(sorted1 == null || sorted1.length == 0){
            return count;
        }

        int lo = 0;
        int hi = sorted1.length - 1;
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(sorted1[mid] > key) hi = mid - 1;
            else if(sorted1[mid] < key) lo = mid + 1;
            else {
                int pointerToLeft = mid - 1;
                int pointerToRight = mid + 1;
                count = 1;
                while(pointerToLeft >= 0 && sorted1[pointerToLeft] == key) {
                    count++;
                    pointerToLeft--;
                }
                while(pointerToRight <= sorted1.length && sorted1[pointerToRight] == key){
                    count++;
                    pointerToRight++;
                }

                return count;
            }
        }

        return count;
    }

    public static void main(String[] args)   {
        int[] a = {0, 1, 2, 3, 3, 3, 4, 5};
        System.out.println(howMany(a, 2));
        System.out.println(howMany(a, 3));
        System.out.println(howMany(a, 6));
    }
}
 