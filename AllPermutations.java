import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPermutations {
    public static List<int[]> allPermutations(int[] nums) {
        List<int[]> permutations = new ArrayList<>();
        calculatePermutations(nums,0,permutations);
        return permutations;
    }

    public static void calculatePermutations(int[] nums, int startingIndex, List<int[]> permutations){
        if(startingIndex >= nums.length){
            permutations.add(nums);
            return;
        }

        for(int i = startingIndex; i < nums.length; i++){
                int[] permutation = Arrays.copyOf(nums, nums.length);
                int temp = permutation[startingIndex];
                permutation[startingIndex] = permutation[i];
                permutation[i] = temp;
                calculatePermutations(permutation, startingIndex + 1, permutations);
        }
    }

    public static void main(String[] args)   {
        allPermutations(new int[]{1,2,3,4});
    }
}
 