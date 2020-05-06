package 树;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DeepOfBST {
    /**
     * 常见的 DFS ： 先序遍历、中序遍历、后序遍历；
     * 常见的 BFS ： 层序遍历（即按层遍历）。
     */

//    树的后序遍历 / 深度优先搜索往往利用 递归 或 栈 实现
//    o(n) o(n)
    public int maxdeep(TreeNode root) {
        if (root != null) return 0; // 终止条件
        return Math.max(maxdeep(root.left), maxdeep(root.right));
    }


    //    树的层序遍历 / 广度优先搜索往往利用 队列 实现。
    // 变形的层序遍历

    public int maxdeep2(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }}, tmp;
        int res = 0;
        while (!queue.isEmpty()) {
            tmp = new LinkedList<>();
            for (TreeNode node : queue) {
                if (node.left != null) tmp.add(node.left);
                if (node.right != null) tmp.add(node.right);
            }
            queue = tmp; //替换
            res++;
        }
        return res;
    }

    // 迭代 队列
    public int maxdeep3(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root != null) {
            stack.add(new Pair(root, 1));
        }

        int depth = 0;
        while (!stack.isEmpty()) { // 边界条件
            Pair<TreeNode, Integer> current = stack.poll();
            root = current.getKey();
            int current_depth = current.getValue();
            if (root != null) {
                depth = Math.max(depth, current_depth);
                stack.add(new Pair(root.left, current_depth + 1));
                stack.add(new Pair(root.right, current_depth + 1));
            }
        }
        return depth;
    }

}
