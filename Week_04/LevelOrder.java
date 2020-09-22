package algorithm015.Week_04;

import algorithm015.TreeNode;

import java.util.*;

public class LevelOrder {
    /**
     * dfs + 递归
     * TC: O(n)
     * SC: O(n)
     * 解题关键：
     * 1. 运用深度优先搜索 dfs;
     * 2. dfs 遍历在未折回之前的节点数题与当前层次相对应
     */
    public List<List<Integer>> levelOrder_1(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        travel(root, 0, list);
        return list;
    }

    private void travel(TreeNode root, int level, List<List<Integer>> list) {
        if (list.size() == level) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);
        System.out.println(root.val);
        if (root.left != null) {
            travel(root.left, level + 1, list);
        }
        if (root.right != null) {
            travel(root.right, level + 1, list);
        }
    }

    /**
     * bfs + 队列
     *
     */
    public List<List<Integer>> levelOrder_2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                nums.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

            }
            list.add(nums);
        }

        return list;
    }

    public static void main(String[] args) {
        LevelOrder dfs = new LevelOrder();
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);


        List list = dfs.levelOrder_2(root);
        System.out.println(list.toString());
    }

}

