package sword_offer;




/*
*
 * @Author Mr.Lin
 * @Description //
 *
 *输入一棵二叉树前序遍历和中序遍历的结果，请重建该二叉树。

注意:

二叉树中每个节点的值都互不相同；
输入的前序遍历和中序遍历一定合法；
*
*
* 给定：
前序遍历是：[3, 9, 20, 15, 7]
中序遍历是：[9, 3, 15, 20, 7]

返回：[3, 9, 20, null, null, 15, 7, null, null, null, null]
返回的二叉树如下所示：
    3
   / \
  9  20
    /  \
   15   7
   *
   *
   *
   * 　前序遍历第一个值就是根结点的值，根据该值在中序遍历的位置，可以轻松找出该根结点左右子树的前序遍历和中序遍历
   * ，之后又可以用同样方法构建左右子树，所以该题可以采用递归的方法完成。

　　刚开始思考的时候，想的是构建一个遍历函数，输入为前序和中序遍历的数组，输出为根结点。
* 但是这样的话每次都需要构建子树的数组，非常麻烦。

　　之后想到，该函数的输入不一定要用数组，因为最初的前序和中序遍历数组已经有了，
* 就直接用该数组的下标来表示子树的数组即可。

　　即构建函数construct(int[] pre, int[] in, int pStart, int pEnd, int iStart, int iEnd)
* ，pre和in始终用最初前序遍历和中序遍历的数组代入，pStart、pEnd代表当前树的前序数组开始和结束位置，
* iStart、iEnd代表中序数组开始和结束位置。
 *
 * @Date 11:27 2019/4/17
 **/
public class TestbuildTree {


    //AC
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || inorder == null || preorder.length <= 0 || inorder.length <= 0 || preorder.length != inorder.length) {
            return null;
        }
        return construct(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }


    /**
     *
     * @Description 由前序遍历序列和中序遍历序列得到根结点
     * pre、in：始终用最初的前序遍历和中序遍历数组代入
     * pStart、pEnd：当前树的前序数组开始和结束位置
     * iStart、iEnd：中序数组开始和结束位置
     */
    public TreeNode construct(int[] pre, int[] in, int pStart, int pEnd, int iStart, int iEnd) {
        TreeNode root = new TreeNode(pre[pStart]);
        if (pStart == pEnd && iStart == iEnd) {
            if (pre[pStart] != in[iStart])
                throw new RuntimeException("数组不符合规范！");
            return root;
        }
        int index = iStart; // 用于记录中序遍历序列中根结点的位置
        while (root.val != in[index] && index <= iEnd) {
            index++;
        }
        if (index > iEnd)
            throw new RuntimeException("数组不符合规范！");
        int leftLength = index - iStart;
        if (leftLength > 0) {
            root.left = construct(pre, in, pStart + 1, pStart + leftLength, iStart, index - 1);
        }
        if (leftLength < iEnd - iStart) {
            root.right = construct(pre, in, pStart + leftLength + 1, pEnd, index + 1, iEnd);
        }
        return root;
    }


    public static void main(String[] args) {

    }
}



//class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode(int x) { val = x; }
//  }

