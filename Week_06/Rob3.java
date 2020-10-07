package algorithm015.Week_06;

import java.util.HashMap;
import java.util.Map;

public class Rob3 {
    /**
     * 方法一：暴力递归 - 最优子结构
     * TC: O(2^n)
     * SC: O(1)
     * 解题关键：
     * 1. 单个节点的钱该怎么算？4 个孙子偷的钱 + 爷爷的钱 VS 两个儿子偷的钱 哪个组合钱多，就当做当前节点能偷的最大钱数。这就是动态规划里面的最优子结构
     */
    public int rob_1(TreeNode root) {
        if (root == null) return 0;

        int robIt = root.val;
        if (root.left != null) robIt += rob_1(root.left.left) + rob_1(root.left.right);
        if (root.right != null) robIt += rob_1(root.right.left) + rob_1(root.right.right);

        int noRobIt = rob_1(root.left) + rob_1(root.right);

        return Math.max(robIt, noRobIt);
    }

    /**
     * 方法二：缓存 - 解决重复子问题
     * TC: O(n)
     * SC: O(n)
     * 解题关键：
     * 1. 同解法一；
     * 2. 加上缓存，以空间换时间。
     */
    public int rob_2(TreeNode root) {
        Map<TreeNode, Integer> cache = new HashMap<>();
        return irob(root, cache);
    }

    private int irob(TreeNode root, Map<TreeNode, Integer> cache) {
        if (root == null) return 0;
        if (cache.containsKey(root)) return cache.get(root);

        int robIt = root.val;
        if (root.left != null) robIt += irob(root.left.left, cache) + irob(root.left.right, cache);
        if (root.right != null) robIt += irob(root.right.left, cache) + irob(root.right.right, cache);

        int unRobIt = irob(root.left, cache) + irob(root.right, cache);

        int max = Math.max(robIt, unRobIt);

        cache.put(root, max);
        return max;
    }

    /**
     * 方法三：动态规划
     * TC: O(n)
     * SC: O(1)
     * 解题关键：
     * 1. 每个节点可选择偷或者不偷两种状态，根据题目意思，相连节点不能一起偷
     *    - 当前节点选择偷时，那么两个孩子节点就不能选择偷了
     *    - 当前节点选择不偷时，两个孩子节点只需要拿最多的钱出来就行(两个孩子节点偷不偷没关系)
     * 2. 使用一个大小为 2 的数组来表示 1 代表不偷，0 代表偷。任何一个节点能偷到的最大钱的状态可以定义为：
     *    - 当前节点选择不偷：当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
     *    - 当前节点选择偷：当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数
     */
    public int rob_3(TreeNode root) {
        int[] amounts = irob2(root);
        return Math.max(amounts[0], amounts[1]);
    }

    private int[] irob2(TreeNode root) {
        if (root == null) return new int[]{0, 0};

        int[] left = irob2(root.left);
        int[] right = irob2(root.right);

        int robIt = root.val + left[1] + right[1];
        int unRobIt = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{robIt, unRobIt};
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }

}
