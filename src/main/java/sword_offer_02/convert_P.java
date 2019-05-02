package sword_offer_02;

/**
 * @Author: Mr.Lin
 * @Description:
 *
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 *
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * 注意：
 *
 * 需要返回双向链表最左侧的节点。
 * 例如，输入下图中左边的二叉搜索树，则输出右边的排序双向链表。
 *
 *
 *
 * @Date: Create in 21:23 2019/5/2
 */
public class convert_P {


    public TreeNode convert(TreeNode root) {
        if(root==null)
            return null;

        if(root.left==null&&root.right==null)
            return root;

        TreeNode left = convert(root.left);
        TreeNode node = left;

        while(node!=null&&node.right!=null){
            node = node.right;
        }

        if(left!=null){
            node.right = root;
            root.left = node;
        }

        TreeNode right=convert(root.right);

        if(right!=null)
        {
            root.right=right;
            right.left=root;
        }

        return left!=null?left:root;

    }
}
