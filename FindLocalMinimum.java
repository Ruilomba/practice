public class FindLocalMinimum {
    public static int findLocalMinimum(int[] nums) {
        if(nums.length <= 1) return -1;
        return findLocalMinimum(nums,0, nums.length - 1);
    }

    private static int findLocalMinimum(int[] nums, int lo, int hi) {
        int middle = (lo + hi) / 2;
        if (middle == 0)               return nums[middle] < nums[middle + 1] ? nums[middle] : -1;
        if (middle == nums.length - 1) return nums[middle] < nums[middle - 1] ? nums[middle] : -1;
        if(nums[middle - 1] > nums[middle] && nums[middle + 1] > nums[middle]) return nums[middle];
        if(nums[middle - 1] <= nums[middle]) return findLocalMinimum(nums, lo, middle - 1);
        else return findLocalMinimum(nums, middle + 1, hi);
    }


    public static void main(String[] args)   {
        System.out.println(findLocalMinimum(new int[]{1,2,3,4,4,4,4,4,5,6,7,6,7,6,7,6,7,6,7,6,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7}));
    }
}
 