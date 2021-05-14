import java.util.*;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> remainings = new HashMap<Integer,Integer>();

        for(int i = 0; i < nums.length; i++){
            if(remainings.containsKey(nums[i])){
                return new int[]{i, remainings.get(nums[i])};
            }

            int remaining = target - nums[i];
            remainings.put(remaining, i);
        }

        return null;
    }

    public static void main(String[] args) {
        int[] cenas = new int[]{2,7,11,15};
        twoSum(cenas, 9);
    }
}
 