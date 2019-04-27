package sword_offer_01;

/**
 * @Author: Mr.Lin
 * @Description:
 *      请实现一个函数，用来判断一棵二叉树是不是对称的。
 *
 * 如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 样例
 * 如下图所示二叉树[1,2,2,3,4,4,3,null,null,null,null,null,null,null,null]为对称二叉树：
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 如下图所示二叉树[1,2,2,null,4,4,3,null,null,null,null,null,null]不是对称二叉树：
 *     1
 *    / \
 *   2   2
 *    \ / \
 *    4 4  3
 * @Date: Create in 16:48 2019/4/27
 */
public class IsSymmetric_P {

    //递归判断两个子树是否互为镜像。
    //
    //两个子树互为镜像当且仅当：
    //
    //两个子树的根节点值相等；
    //第一棵子树的左子树和第二棵子树的右子树互为镜像，且第一棵子树的右子树和第二棵子树的左子树互为镜像




    public boolean isSymmetric(TreeNode root) {
        if (root==null)
            return true;
        return Symmetric(root.left,root.right);
    }
    public boolean Symmetric(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null)
            return true;
        if(root1==null||root2==null)
            return false;
        if (root1.val == root2.val){
            return (Symmetric(root1.left, root2.right) && Symmetric(root2.left, root1.right));
        }
        return false;
    }






}
