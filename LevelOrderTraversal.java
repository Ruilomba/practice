import Model.TreeNode;

import java.util.*;

public class LevelOrderTraversal {

    public static List<List<Integer>> levelOrderFill(TreeNode root) {
        Map<Integer, HashSet<Integer>> levelNodes = new HashMap<>();
        levelOrderFill(root, levelNodes,1);
        List<List<Integer>> lists = new ArrayList<>();

        for(Integer value : levelNodes.keySet()){
            List<Integer> list = new ArrayList<>(levelNodes.get(value));
            lists.add(list);
        }

        return lists;
    }

    public static void levelOrderFill(TreeNode root, Map<Integer, HashSet<Integer>> levelNodes, int level){
        if(root == null) return;

        if(!levelNodes.containsKey(level)) levelNodes.put(level, new HashSet<Integer>(){{add(root.val);}});
        else levelNodes.get(level).add(root.val);
        level += 1;
        levelOrderFill(root.left, levelNodes, level);
        levelOrderFill(root.right, levelNodes, level);
    }

    public static boolean isValid(TreeNode root){
        if(root == null) return false;
        return isValidRec(root.left, root.right);
    }

    public static boolean isValidRec(TreeNode q, TreeNode p){
        if(q == null && p == null) return true;
        if(q != null && p != null && q.val == p.val)
            return isValidRec(q.left, p.right) && isValidRec(q.right, p.left);
        return false;
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        queue.offer(null);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();

            if(current == null){
                levels.add(new ArrayList<>(level));
                level = new ArrayList<>();
                if(!queue.isEmpty()) queue.offer(null);
            }else {
                level.add(current.val);
                if(current.left != null){
                    queue.offer(current.left);
                }
                if(current.right != null){
                    queue.offer(current.right);
                }
            }
        }

        return levels;
    }

    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        while(!queue.isEmpty()){
            TreeNode currentNode = queue.poll();

            if(currentNode == null){
                levels.add(new ArrayList<>(level));
                level = new ArrayList<>();
                queue.offer(null);
            }else {
                level.add(currentNode.val);
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
        }

        return levels;
    }

    public static void main(String[] args)   {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        List<List<Integer>> val = levelOrderFill(root);
    }
}
