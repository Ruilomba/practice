import Model.TreeNode;

import java.util.*;

public class SortedArrayToBST {

    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;

        return helper(nums, 0, nums.length - 1);
    }

    private static TreeNode helper(int[] nums, int lo, int hi){
        if(lo > hi) return null;

        int mid = (lo + hi) / 2;
        TreeNode newNode = new TreeNode(nums[mid]);
        newNode.left = helper(nums, lo, mid - 1);
        newNode.right = helper(nums, mid + 1, hi);

        return newNode;
    }

    public static void main(String[] args)   {

    }
}
