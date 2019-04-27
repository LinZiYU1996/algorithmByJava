package sword_offer_01;

/**
 * @Author: Mr.Lin
 * @Description:
 *      输入一个二叉树，将它变换为它的镜像。
 *
 * 样例
 * 输入树：
 *       8
 *      / \
 *     6  10
 *    / \ / \
 *   5  7 9 11
 *
 *  [8,6,10,5,7,9,11,null,null,null,null,null,null,null,null]
 * 输出树：
 *       8
 *      / \
 *     10  6
 *    / \ / \
 *   11 9 7  5
 *
 *  [8,10,6,11,9,7,5,null,null,null,null,null,null,null,null]
 * @Date: Create in 16:32 2019/4/27
 */

public class Mirror_P {

    //先前序遍历二叉树的每个节点，如果遍历到的节点有子节点，就交换他的两个子节点
    //
    //当交换完所有非叶节点的左右子节点之后，就得到了镜像



    public void mirror(TreeNode root) {
        if(root==null)
            return;
        if(root.left==null&&root.right==null)
            return;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        if(root.left!=null)
            mirror(root.left);
        if(root.right!=null)
            mirror(root.right);



    }







}
