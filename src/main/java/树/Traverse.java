package 树;

import java.util.LinkedList;
import java.util.Queue;

public class Traverse {
    
    //递归实现前序遍历
    public void preOrderRecur(TreeNode head) {
        if (head == null)
            return;
        System.out.println(head.val + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    //递归实现中序遍历
    public void inOrderRecur(TreeNode head) {
        if (head == null)
            return;
        inOrderRecur(head.left);
        System.out.println(head.val + " ");
        inOrderRecur(head.right);
    }

    //递归实现后续遍历
    public void posOrderRecur(TreeNode head) {
        if (head == null)
            return;
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.println(head.val + " ");
    }
    
    //层序遍历 队列
    public void levelOrder1(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>(); // 实现了 队列的接口
        queue.add(root);   //将指定元素加入此队列的尾部。

        while (!queue.isEmpty()) {
            TreeNode front = queue.poll();
            System.out.println(front.val); // 输出层 利用队列
            if (front.left != null) {
                queue.add(front.left); //存储层 left
            }
            if (front.right != null) {
                queue.add(front.right); //存储层
            }
        }
    }

    //不用递归实现前序遍历 栈
    public void preOrderUnRecur(TreeNode head) {
        System.out.print("前序遍历：");
        if (head != null) {

            java.util.Stack<TreeNode> stack = new java.util.Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop(); // 输出
                System.out.print(head.val + " ");
                if (head.right != null) {
                    stack.push(head.right); //存储 right
                }
                if (head.left != null) {
                    stack.push(head.left); //存储 left
                }
            }
        }
        System.out.println();
    }

    //不用递归实现中序遍历 栈
    public void inOrderUnrecur(TreeNode head) {
        System.out.println("in-Order：");
        if (head != null) {

            java.util.Stack<TreeNode> stack = new java.util.Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head); // 遍历存储 left
                    head = head.left;
                } else {
                    head = stack.pop(); // 输出
                    System.out.print(head.val + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    /**
     * add，push都可以向stack中添加元素。
     * 不同点：
     * add是继承自Vector的方法，且返回值类型是boolean。
     * push是Stack自身的方法，返回值类型是参数类类型。
     * stack.push("o");
     * System.out.println(stack.search("o"));//返回一个对象，从栈顶向下数第一个位置
     * System.out.println(stack.peek());//查看此堆栈顶部的对象，而不从堆栈中删除它
     * System.out.println(stack.empty());//查看栈是否为空，flase不是空，true是空
     * System.out.println(stack.pop());//删除栈顶部的对象，并将该对象作为此函数的值返回
     * System.out.println(stack);
     *
     * @param head
     */
    //不用递归实现后续遍历 2 栈
    public void posOrderUnRecur(TreeNode head) {
        System.out.println("pos-order: ");
        if (head != null) {
//            Stack<TreeNode> s1 = new Stack<>();
            java.util.Stack<TreeNode> s1 = new java.util.Stack<>();
//            Stack<TreeNode> s2 = new Stack<>();
            java.util.Stack<TreeNode> s2 = new java.util.Stack<>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop(); //s1 父输出
                s2.push(head);   // s2 父存储
                if (head.left != null) {
                    s1.push(head.left); // s1 子存储
                }
                if (head.right != null) {
                    s1.push(head.right);// s2 子存储
                }
            }
            while (!s2.isEmpty()) {
                System.out.print(s2.pop().val + " ");
            }
        }
        System.out.println();
    }
}
