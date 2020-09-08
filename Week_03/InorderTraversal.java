package algorithm015.Week_03;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        // 方法一：递归解法
        /*
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
        */

        // 方法二：迭代解法
        List<Integer> list = new ArrayList<>();
        return null;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root != null) {
            helper(root.left, list);
            list.add(root.val);
            helper(root.right, list);
        }
    }

    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            this.val = x;
        }
    }
}
