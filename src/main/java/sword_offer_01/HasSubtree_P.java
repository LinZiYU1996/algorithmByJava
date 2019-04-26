package sword_offer_01;




/*
*
 * @Author Mr.Lin
 * @Description //
 *
 *
 *
 * 输入两棵二叉树A，B，判断B是不是A的子结构。

我们规定空树不是任何树的子结构。

样例
树A：

     8
    / \
   8   7
  / \
 9   2
    / \
   4   7
树B：

   8
  / \
 9   2
返回 true ,因为B是A的子结构。
*
*
*
 * @Date 20:47 2019/4/26
 **/
public class HasSubtree_P {


    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        boolean res=false;

        if(root1!=null && root2!=null){
            if(root1.val == root2.val){//当前节点相同，继续深入比较
                res = helpHasSubtree(root1,root2);
            }
            if(!res){ //当前节点不同，转移到A的左子树根节点来进行比较
                res = hasSubtree(root1.left,root2);
            }
            if(!res){ //当前节点不同，转移到A的右子树根节点来进行比较
                res = hasSubtree(root1.right,root2);
            }
        }

        return res;
    }

    public boolean helpHasSubtree(TreeNode root1, TreeNode root2){
        if(root2==null)
            return true;

        if(root1==null)
            return false;

        if(root1.val!=root2.val)
            return false;

        return helpHasSubtree(root1.left,root2.left)&&helpHasSubtree(root1.right,root2.right);
    }





}
