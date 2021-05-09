import Model.TreeNode;

import java.util.*;

public class LowestCommonAncestor {

    public static int lowestCommonAncestor(int[] nums) {
        if(nums.length <= 1) return -1;
        return lowestCommonAncestor(nums,0, nums.length - 1);
    }

    public static boolean findPath(TreeNode root, ArrayList<TreeNode> path, int val){
        if(root == null){
            return false;
        }

        path.add(root);
        if(val < root.val) findPath(root.left, path, val);
        else findPath(root.right, path, val);

        return true;
    }

    private static int lowestCommonAncestor(int[] nums, int lo, int hi) {
        int middle = (lo + hi) / 2;
        if (middle == 0)               return nums[middle] < nums[middle + 1] ? nums[middle] : -1;
        if (middle == nums.length - 1) return nums[middle] < nums[middle - 1] ? nums[middle] : -1;
        if(nums[middle - 1] > nums[middle] && nums[middle + 1] > nums[middle]) return nums[middle];
        if(nums[middle - 1] <= nums[middle]) return lowestCommonAncestor(nums, lo, middle - 1);
        else return lowestCommonAncestor(nums, middle + 1, hi);
    }


    public static void main(String[] args)   {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        ArrayList<TreeNode> list = new ArrayList<>();
        findPath(root, list, 4);
        System.out.println(lowestCommonAncestor(new int[]{1,2,3,4,4,4,4,4,5,6,7,6,7,6,7,6,7,6,7,6,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7}));
    }
}
