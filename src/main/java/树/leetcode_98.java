package 树;

public class leetcode_98 {
    /**
     *
     * 验证二叉搜索树  BST
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     *
     * 假设一个二叉搜索树具有如下特征：
     *
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * 示例 1:
     *
     * 输入:
     *     2
     *    / \
     *   1   3
     * 输出: true
     * 示例 2:
     *
     * 输入:
     *     5
     *    / \
     *   1   4
     *      / \
     *     3   6
     * 输出: false
     * 解释: 输入为: [5,1,4,null,null,3,6]。
     *      根节点的值为 5 ，但是其右子节点值为 4 。
     *
     *      *     4
     *      *    / \
     *      *   1   6
     *      *      / \
     *      *     5   7
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    //递归
    public boolean isvalidBST(TreeNode node, Integer low, Integer up) {
        if (node == null) {
            return true; // 空节点是二叉搜索树
        }
        int val = node.val;
        if (low != null && low > val) {  // 判断节点的值 是否在其上下界
            return false;
        }
        if (up != null && up < val) {
            return false;
        }
        if(!isvalidBST(node.right,val,up)){ return false;}  //  将当前节点的值替换为下届 继续检查右边的子节点 是二叉树 则 !isBST(node.right,val,up)=false
        if(!isvalidBST(node.left,low,val)){ return false;} // left <val  left> low (上级节点)
        return true;
    }
    // 中序遍历


}
