package Interview_3;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //求二叉树的最大深度
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);
    }
    //判断一棵二叉树是否是平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if(leftDepth - rightDepth > 1
            || rightDepth - leftDepth > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    //判断一棵树是否是对称二叉树
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null) {
            return true;
        }
        return isMirror(root.left,root.right);
    }

    //判断两棵树是否是镜像
    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null){
            return true;
        }
        if(t1 == null || t2 == null){
            return false;
        }
        //两棵非空树
        if(t1.val != t2.val){
            return false;
        }
        return isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left);
    }
}
