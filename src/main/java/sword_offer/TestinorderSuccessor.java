package sword_offer;


/*
*
 * @Author Mr.Lin
 * @Description //
 *
 *
 * 给定一棵二叉树的其中一个节点，请找出中序遍历序列的下一个节点。

注意：
*
* 先序遍历：中左右
* 中序遍历：左中右

如果给定的节点是中序遍历序列的最后一个，则返回空节点;
二叉树一定不为空，且给定的节点一定不是空节点；
样例
假定二叉树是：[2, 1, 3, null, null, null, null]， 给出的是值等于2的节点。

则应返回值等于3的节点。

解释：该二叉树的结构如下，2的后继节点是3。
  2
 / \
1   3
 *
 *
 *
 * 思路
　　首先自己在草稿纸上画图，进行分析（不再展开）。可以发现下一个结点的规律为：

　　1.若当前结点有右子树时，其下一个结点为右子树中最左子结点；

　　2.若当前结点无右子树时，

　　　　（1）若当前结点为其父结点的左子结点时，其下一个结点为其父结点；

　　　　（2）若当前结点为其父结点的右子结点时，继续向上遍历父结点的父结点，
* 直到找到一个结点是其父结点的左子结点（与（1）中判断相同），该结点即为下一结点。
 * @Date 15:31 2019/4/17
 **/
public class TestinorderSuccessor {


    //AC
    public TreeNode inorderSuccessor(TreeNode p) {
        if (p == null) {
            System.out.print("结点为null ");
            return null;
        }
        if (p.right != null) {
            p = p.right;
            while(p.left!=null)
                p=p.left;
            return p;
        }
        while(p.father !=null){
            if(p==p.father .left)
                return p.father;
            p=p.father;
        }
        return null;
    }


}



class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode father;
      TreeNode(int x) { val = x; }
  }

