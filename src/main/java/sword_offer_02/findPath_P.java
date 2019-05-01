package sword_offer_02;



import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Mr.Lin
 * @Description:
 *
 * 输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 *
 * 从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *
 * 样例
 * 给出二叉树如下所示，并给出num=22。
 *       5
 *      / \
 *     4   6
 *    /   / \
 *   12  13  6
 *  /  \    / \
 * 9    1  5   1
 *
 * 输出：[[5,4,12,1],[5,6,6,5]]
 *
 *
 * @Date: Create in 20:03 2019/5/1
 */
public class findPath_P {


    public List<List<Integer>> findPath(TreeNode root, int target) {
        List<List<Integer>> arr = new ArrayList<List<Integer>>();
        if(root == null)
            return arr;
        int  sum = 0;
        List<Integer> arr1 = new ArrayList<Integer>();
        pa(root, target, arr, arr1,sum);
        return arr;
    }


    public void pa(TreeNode root,int target,List<List<Integer>> arr, List<Integer> a1,int sum){
        if(root==null)
            return;

        sum += root.val;

        if(root.left==null&&root.right==null){
            if(sum==target){
                a1.add(root.val);
                arr.add(new ArrayList<Integer>(a1));
                a1.remove(a1.size()-1);
            }
            return;
        }

        a1.add(root.val);
        pa(root.left, target, arr, a1,sum);
        pa(root.right, target, arr, a1,sum);
        a1.remove(a1.size()-1);
        return ;
    }


}
